package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Category;
import com.cdnu.baikun.service.CategoryService;
import com.cdnu.baikun.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {

    @Override
    public Boolean addCategory(Category category) {
        return save(category);
    }

    @Override
    public Boolean updateCategory(Category category) {
        //此处是条件构造器的update
        LambdaUpdateWrapper<Category> update = new LambdaUpdateWrapper<Category>();
        update.eq(Category::getCategoryId, category.getCategoryId())
                .set(Category::getCategoryName, category.getCategoryName())
                .set(Category::getCategoryPid, category.getCategoryPid())
                .set(Category::getCategoryDescription, category.getCategoryDescription());

        return update(update);
    }

    @Override
    public List<Category> categoryList() {
        return query().isNull("category_pid").list();
    }

    @Override
    public Category getCategoryByCategoryId(Integer categoryId) {
        if (categoryId==null) return null;
        return getById(categoryId);
    }

    @Override
    public List<Category> listCategoryByCategoryIds(List<Integer> categoryIds) {
        return query().in("category_id", categoryIds).list();
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        return query().eq("category_name",categoryName).one();
    }

    @Override
    public Boolean deleteCategoryById(Integer cgId) {
        return removeById(cgId);
    }
}




