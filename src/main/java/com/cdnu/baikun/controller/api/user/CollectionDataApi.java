package com.cdnu.baikun.controller.api.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.Collection;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 收藏数据api
 * @author 白坤
 * @date 2021/8/15
 */
@Controller
@RequestMapping("/api/collection")
public class CollectionDataApi {
    @Autowired
    private CollectionService collectionService;

    @RequestMapping("/add/news/{id}")
    @ResponseBody
    public ResultVO addnews(@PathVariable("id") Integer id, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user==null) return new ResultVO("请先登录",1);
        Collection collection=new Collection();
        collection.setNewsId(id);
        collection.setUserId(user.getUserId());
        Boolean addCollection = collectionService.addCollection(collection);
        if (addCollection) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/add/resource/{id}")
    @ResponseBody
    public ResultVO addresource(@PathVariable("id") Integer id, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user==null) return new ResultVO("请先登录",1);
        Collection collection=new Collection();
        collection.setResourceId(id);
        collection.setUserId(user.getUserId());
        Boolean addCollection = collectionService.addCollection(collection);
        if (addCollection) return new ResultVO("成功",0);
        return new ResultVO("失败,已经收藏",1);
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultVO getCollection(Integer page, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user==null) return new ResultVO("请先登录",1);
        Map<String, Object> collection = collectionService.listCollection(page, user.getUserId());
        if (collection.get("list")!=null) return new ResultVO("成功",0,(Integer) collection.get("pages"),collection.get("list"));
        return new ResultVO("失败",1);
    }

    @RequestMapping("/get/resource/{id}")
    @ResponseBody
    public ResultVO getresource(@PathVariable("id") Integer id, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user==null) return new ResultVO("请先登录",1);
        Collection collection=new Collection();
        collection.setUserId(user.getUserId());
        collection.setResourceId(id);
        collection.setNewsId(0);
        Boolean collection1 = collectionService.getCollection(collection);
        if (collection1) return new ResultVO("成功",0);
        return new ResultVO("失败,已经收藏",1);
    }

    @RequestMapping("/get/news/{id}")
    @ResponseBody
    public ResultVO getnews(@PathVariable("id") Integer id, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user==null) return new ResultVO("请先登录",1);
        Collection collection=new Collection();
        collection.setNewsId(id);
        collection.setResourceId(0);
        Boolean collection1 = collectionService.getCollection(collection);
        if (collection1) return new ResultVO("成功",0);
        return new ResultVO("失败,已经收藏",1);
    }
}
