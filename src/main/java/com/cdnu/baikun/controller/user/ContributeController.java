package com.cdnu.baikun.controller.user;

import com.cdnu.baikun.domain.*;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 创作中心controller
 * @author 白坤
 * @date 2021/8/6
 */
@Controller
public class ContributeController {
    @Autowired
    private ResourcesService resourcesService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;
    @Autowired
    private TagNewsResourceRefService tagNewsResourceRefService;

    /**
     * 用户投稿
     *
     * @return
     */
    @RequestMapping("/contribute")
    public String contribute(Model model){
        List<Category> categories = categoryService.categoryList();
        List<Tag> list = tagService.list();
        model.addAttribute("categories",categories);
        model.addAttribute("list",list);
        return "user/contribute/index";
    }

    @RequestMapping("/addResource")
    @ResponseBody
    public ResultVO addResource(Resources resources,Integer resourceParentCategoryId,Integer resourceChildCategoryId,String coverSrc, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        resources.setResourcesUserId(user.getUserId());
        System.out.println(resources.getResourcesContent());
        List<Category> categoryList=new ArrayList<>();
        Category categoryP = categoryService.getCategoryByCategoryId(resourceParentCategoryId);
        if (resourceChildCategoryId!=null){
            Category category = categoryService.getCategoryByCategoryId(resourceChildCategoryId);
            categoryList.add(category);
        }
        categoryList.add(categoryP);
        resources.setCategorieList(categoryList);

        System.out.println(coverSrc);
        Boolean resourcesBool = resourcesService.addResources(resources,coverSrc);
        if (resourcesBool) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/addNews")
    @ResponseBody
    public ResultVO addNews(News news, String coverSrc,String tagId,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        news.setNewsUserId(user.getUserId());
        Boolean res = newsService.addNews(news,coverSrc);
        if (tagId!=null&&!("".equals(tagId))){
            String[] strings = tagId.split(",");
            for (String s:strings){
                TagNewsResourceRef ref=new TagNewsResourceRef();
                ref.setNewsId(news.getNewsId());
                ref.setTagId(Integer.parseInt(s));
                tagNewsResourceRefService.addTagNewsResourceRef(ref);
            }
        }


        if (res) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }
}
