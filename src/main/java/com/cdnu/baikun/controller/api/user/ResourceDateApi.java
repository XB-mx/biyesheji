package com.cdnu.baikun.controller.api.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cdnu.baikun.domain.Category;
import com.cdnu.baikun.domain.Image;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.dto.CoverVo;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/8/13
 */
@Controller
@RequestMapping("/api/resource")
public class ResourceDateApi {
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

    @RequestMapping("/like/{id}")
    @ResponseBody
    public ResultVO like(@PathVariable("id") Integer id){
        if (id==null) return new ResultVO("请输入正确的id",1);
        Boolean like = resourcesService.addResourceLike(id);
        if (like) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/view/{id}")
    @ResponseBody
    public ResultVO view(@PathVariable("id") Integer id){
        if (id==null) return new ResultVO("请输入正确的id",1);
        Boolean like = resourcesService.addResourceView(id);
        if (like) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public ResultVO get(@PathVariable("id") Integer id){
        if (id==null) return new ResultVO("请输入正确的id",1);
        Resources resource = resourcesService.getResourceByResourceId(id);
        if (resource!=null) return new ResultVO("成功",0,resource);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public ResultVO update(@PathVariable("id")Integer id, Resources resources){
        resources.setResourcesId(id);
        Boolean aBoolean = resourcesService.updateResource(resources);
        if (aBoolean) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/category/{name}")
    @ResponseBody
    public ResultVO getListByCategory(@PathVariable("name")String name){
        Category categoryName = categoryService.getCategoryByCategoryName(name);
        List<Integer> resourceIds = refService.getResourceIdListByCategoryId(categoryName.getCategoryId());
        IPage<Resources> page = resourcesService.getResourceListByResourceIds(resourceIds, 1, 8);
        List<Resources> records = page.getRecords();
        List<Image> images = imageService.getImageListByIds(records);
        List<CoverVo> list = coverService.coverVoList(records, null, images);
        return new ResultVO("成功",0,list);
    }
}
