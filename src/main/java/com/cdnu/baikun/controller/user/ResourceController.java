package com.cdnu.baikun.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cdnu.baikun.domain.Category;
import com.cdnu.baikun.domain.Image;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.dto.CoverVo;
import com.cdnu.baikun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/24
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourcesService resourcesService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CoverService coverService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ResourceCategoryRefService refService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/page/{page}","/page"},method = RequestMethod.GET)
    public String index(@PathVariable(value = "page",required = false) Integer page,Model model) {
        if (page==null) page=1;

        IPage<Resources> resourcesByPage = resourcesService.getResourcesByPage(page,10);
        List<Resources> records = resourcesByPage.getRecords();
        List<Image> images = imageService.getImageListByIds(records);
        long total = resourcesByPage.getTotal();
        List<CoverVo> list = coverService.coverVoList(records, null, images);

        List<Category> categoryList = categoryService.categoryList();
        
        model.addAttribute("list",list);
        model.addAttribute("total",total);
        model.addAttribute("page",page);
        model.addAttribute("categoryList",categoryList);

        if (resourcesByPage!=null) return "user/resources/index";
        return "user/error/404";
    }


    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id") Integer id,Model model){
        if (id==null&&id.equals("")) return "redirect:/404";
        Resources resource = resourcesService.getResourceByResourceId(id);
        List<Integer> categpryIds = refService.getCategoryIdListByResourceId(id);
        List<Category> categorys = categoryService.listCategoryByCategoryIds(categpryIds);
        Image image = imageService.getImageByResourceId(resource.getResourcesId());
        CoverVo cover = coverService.cover(resource, null, image);

        User author = userService.getById(resource.getResourcesUserId());

        model.addAttribute("cover",cover);
        model.addAttribute("author",author);
        model.addAttribute("resource",resource);
        model.addAttribute("categorys",categorys);
        return "user/resources/detail";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id")Integer id,Model model){
        List<Category> categoryList = categoryService.categoryList();
        model.addAttribute("categories",categoryList);
        return "user/resources/update";
    }

}
