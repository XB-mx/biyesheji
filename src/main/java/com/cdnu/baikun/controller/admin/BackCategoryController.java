package com.cdnu.baikun.controller.admin;

import com.cdnu.baikun.domain.Category;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/8/6
 */
@Controller
@RequestMapping("/admin")
public class BackCategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category")
    public String category(Model model){
        List<Category> categories = categoryService.categoryList();
        categories.stream().forEach(System.out::println);
        model.addAttribute("categories",categories);
        return "admin/backcategory/index";
    }

    /**
     * 获取分类列表
     * @param category
     * @return
     */
    @RequestMapping(value = "/addCategory",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO addCategory(Category category){
        Boolean aBoolean = categoryService.addCategory(category);

        if (aBoolean){
            return new ResultVO("成功",0);
        }
        return new ResultVO("失败",1);
    }

    @RequestMapping(value = "/del/category/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultVO delCategory(@PathVariable("id") Integer id){
        Boolean aBoolean = categoryService.deleteCategoryById(id);
        if (aBoolean){
            return new ResultVO("成功",1);
        }
        return new ResultVO("失败",0);
    }
}
