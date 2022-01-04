package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/24
 */
public interface CategoryService extends IService<Category> {
    /**
     * 添加分类
     *
     * @param category
     * @return
     */
    Boolean addCategory(Category category);

    /**
     * 更改分类
     *
     * @param category
     * @return
     */
    Boolean updateCategory(Category category);

    /**
     * 获取分类列表
     *
     * @return
     */
    List<Category> categoryList();

    /**
     * 根据分类id获取分类
     * @param categoryId
     * @return
     */
    Category getCategoryByCategoryId(Integer categoryId);

    /**
     * 根据分类id集合获取分类集合
     * @param categoryIds
     * @return
     */
    List<Category> listCategoryByCategoryIds(List<Integer> categoryIds);

    /**
     * 根据分类名获取分类
     * @param categoryName 分类名
     * @return
     */
    Category getCategoryByCategoryName(String categoryName);

    /**
     * 根据分类id删除分类
     *
     * @param cgId
     * @return
     */
    Boolean deleteCategoryById(Integer cgId);


}
