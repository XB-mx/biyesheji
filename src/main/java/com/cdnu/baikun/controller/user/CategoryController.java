package com.cdnu.baikun.controller.user;

import com.alibaba.druid.sql.visitor.functions.If;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cdnu.baikun.domain.Category;
import com.cdnu.baikun.domain.Image;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.dto.CoverVo;
import com.cdnu.baikun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 白坤
 * @date 2021/8/12
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ResourceCategoryRefService rcRefService;
    @Autowired
    private ResourcesService resourcesService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CoverService coverService;

    @RequestMapping(value = {"/resource/category/{name}/{page}","/resource/category/{name}"})
    public String getResourceByCategoryName(@PathVariable("name") String categoryName,
                                            @PathVariable(value = "page",required = false) Integer page,
                                            Model model){
        if (categoryName==null) return "user/error/404";
        if (page==null) page=1;

        List<Category> categoryList = categoryService.categoryList();
        List<Category> collect = categoryList.stream()
                .filter(category -> category.getCategoryName().equals(categoryName)).collect(Collectors.toList());
        if (collect.size()!=1){
            return "user/error/404";
        }
        Category category= collect.get(0);
        List<Integer> ids = rcRefService.getResourceIdListByCategoryId(category.getCategoryId());
        IPage<Resources> iPage = resourcesService.getResourceListByResourceIds(ids, page, 10);

        List<Resources> records = iPage.getRecords();
        long total = iPage.getTotal();

        List<Image> images = imageService.getImageListByIds(records);
        List<CoverVo> list = coverService.coverVoList(records, null, images);

        model.addAttribute("list",list);
        model.addAttribute("total",total);
        model.addAttribute("page",page);
        model.addAttribute("categoryName",categoryName);
        model.addAttribute("categoryList",categoryList);

        return "user/category/index";
    }
}
