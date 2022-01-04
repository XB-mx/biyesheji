package com.cdnu.baikun.controller.api.user;

import com.cdnu.baikun.domain.Category;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/category/")
public class CategoryDateApi {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
    @ResponseBody
    public ResultVO category(){
        List<Category> categories = categoryService.categoryList();
        return new ResultVO("成功",0,categories);
    }
}
