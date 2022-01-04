package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Category;
import com.cdnu.baikun.domain.Image;
import com.cdnu.baikun.domain.ResourceCategoryRef;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.utils.GetImgSrc;
import com.cdnu.baikun.service.CategoryService;
import com.cdnu.baikun.service.ImageService;
import com.cdnu.baikun.service.ResourceCategoryRefService;
import com.cdnu.baikun.service.ResourcesService;
import com.cdnu.baikun.mapper.ResourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 白坤
 * @date 2021/7/24
 * @description 对资源内容的相关服务
 */
@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesMapper, Resources>
        implements ResourcesService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ResourceCategoryRefService refService;
    @Autowired
    private ResourcesMapper resourcesMapper;
    @Autowired
    private ImageService imageService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addResources(Resources resources) {

        resources.setResourcesCreateTime(new Date());
        resources.setResourcesLastUpdataTime(new Date());
        boolean save = save(resources);
        //添加分类
        List<Category> categorieList = resources.getCategorieList();
        if (categorieList==null) {
            ResourceCategoryRef ref=new ResourceCategoryRef();
            ref.setResourcesId(resources.getResourcesId());
            ref.setCategoryId(0);
            Boolean ref1 = refService.addResourceCategoryRef(ref);
            return save&&ref1;
        }
        Integer id = resources.getResourcesId();
        categorieList.parallelStream().forEach(category -> {
            ResourceCategoryRef ref=new ResourceCategoryRef();
            ref.setResourcesId(resources.getResourcesId());
            ref.setCategoryId(category.getCategoryId());
            Boolean ref123 = refService.addResourceCategoryRef(ref);
            System.out.println(ref123);
        });
        System.out.println("后续执行");
        return save;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addResources(Resources resources, String src) {
        if ("".equals(src)){
            src= GetImgSrc.getFirstImgSrc(resources.getResourcesContent());
        }

        Boolean addResourceBool = addResources(resources);

        if (src!=null){
            Boolean imageBool = imageService.addImage(new Image(null, resources.getResourcesId(), null, src));
            return addResourceBool&&imageBool;
        }

        return addResourceBool;
    }

    @Override
    public IPage<Resources> getResourcesByPage(Integer page,Integer pageSize) {

        IPage<Resources> iPage = new Page<>(page,pageSize);
        //后续优化
        QueryWrapper<Resources> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Resources::getResourcesStatus,1)
                .orderByDesc(Resources::getResourcesCreateTime);

        return page(iPage, queryWrapper);
    }

    @Override
    public IPage<Resources> getResourcesBanByPage(Integer page, Integer pageSize) {
        IPage<Resources> iPage = new Page<>(page,pageSize);
        //后续优化
        QueryWrapper<Resources> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Resources::getResourcesStatus,0)
                .orderByDesc(Resources::getResourcesCreateTime);

        return page(iPage, queryWrapper);
    }

    @Override
    public Boolean updateResource(Resources resources) {
        resources.setResourcesLastUpdataTime(new Date());

        //更改资源
        UpdateWrapper<Resources> updateWrapper = new UpdateWrapper<Resources>();
        updateWrapper.lambda()
                .eq(Resources::getResourcesId, resources.getResourcesId())
                .set(Resources::getResourcesLastUpdataTime, resources.getResourcesLastUpdataTime())
                .set(Resources::getResourcesTitle, resources.getResourcesTitle())
                .set(Resources::getResourcesContent, resources.getResourcesContent())
                .set(Resources::getResourcesViewsCount,resources.getResourcesViewsCount())
                .set(Resources::getResourcesLikeCount,resources.getResourcesLikeCount());

        return this.update(updateWrapper);
    }

    @Override
    public Boolean deleteResourceById(Integer resourceId) {
        return removeById(resourceId);
    }

    @Override
    public Resources getResourceByResourceId(Integer resourceId) {
        if (resourceId==null) return null;
        Resources resources = getById(resourceId);

        //获取分类
        List<Integer> resourceCategoryIds = refService.getCategoryIdListByResourceId(resourceId);
        //使用并发stream
        List<Category> categoryList = resourceCategoryIds.parallelStream()
                .map(categoryId -> categoryService.getCategoryByCategoryId(categoryId))
                .collect(Collectors.toList());

        resources.setCategorieList(categoryList);

        return resources;
    }

    @Override
    public IPage<Resources> getResourceListByResourceIds(List<Integer> ids,Integer page,Integer pageSize) {
        if (ids==null||ids.size()==0) return new Page<>();
        IPage<Resources> iPage=new Page<>(page,pageSize);
        QueryWrapper<Resources> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .in(Resources::getResourcesId,ids)
                .eq(Resources::getResourcesStatus,1)
                .orderByDesc(Resources::getResourcesCreateTime);
        IPage<Resources> resourcesIPage = this.page(iPage,queryWrapper);
        return resourcesIPage;
    }

    @Override
    public IPage<Resources> getResourceListByUserId(int userId, Integer page, Integer pageSize) {
        IPage<Resources> iPage=new Page<>(page,pageSize);
        QueryWrapper<Resources> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Resources::getResourcesUserId,userId)
                .orderByDesc(Resources::getResourcesCreateTime);
        IPage<Resources> resourcesIPage = this.page(iPage,queryWrapper);
        return resourcesIPage;
    }

    @Override
    public Boolean addResourceLike(Integer resourceId) {
        Resources resource = getResourceByResourceId(resourceId);
        Integer resourceLike = resourcesMapper.getResourceLike(resourceId);

        resourceLike=resourceLike+1;
        resource.setResourcesLikeCount(resourceLike);

        return updateResource(resource);
    }

    @Override
    public Boolean addResourceView(Integer resourceId) {
        Resources resource = getResourceByResourceId(resourceId);
        int resourceView = resourcesMapper.getResourceView(resourceId);

        resourceView=resourceView+1;
        resource.setResourcesViewsCount(resourceView);

        return updateResource(resource);
    }

    @Override
    public Boolean banResource(Integer id) {
        Resources resources = this.getById(id);
        UpdateWrapper<Resources> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("resources_id",id);
        switch (resources.getResourcesStatus()){
            case 0:
                //封禁
                updateWrapper.set("resources_status",1);
                break;
            case 1:
                //解禁
                updateWrapper.set("resources_status",0);
                break;
        }
        return this.update(updateWrapper);
    }

    @Override
    public Page<Resources> search(Integer page,String keyword) {
        if (keyword==null||"".equals(keyword)) return null;
        QueryWrapper<Resources> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .like(Resources::getResourcesTitle,keyword)
                .orderByDesc(Resources::getResourcesCreateTime);
        Page<Resources> resourcesPage = page(new Page<Resources>(page, 5), queryWrapper);
        return resourcesPage;
    }
}




