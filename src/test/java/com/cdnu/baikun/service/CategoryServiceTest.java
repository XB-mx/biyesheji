package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 测试
 */
@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void testaddCategory() {
        Category category = new Category();
        category.setCategoryName("test");
        category.setCategoryPid(0);
        category.setCategoryDescription("test");

        Boolean aBoolean = categoryService.addCategory(category);
        System.out.println(aBoolean);
    }

    @Test
    public void testupdateCategory() {
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("test213");
        category.setCategoryPid(0);
        category.setCategoryDescription("test123");

        Boolean aBoolean = categoryService.updateCategory(category);
        System.out.println(aBoolean);
    }

    @Test
    public void testcategoryList() {
        List<Category> categories = categoryService.categoryList();
        categories.stream().forEach(System.out::println);
    }

    @Test
    public void testdeleteCategoryById() {
        Boolean aBoolean = categoryService.deleteCategoryById(1);
        System.out.println(aBoolean);
    }
}
