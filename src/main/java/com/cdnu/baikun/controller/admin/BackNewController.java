package com.cdnu.baikun.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cdnu.baikun.domain.News;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 对游戏新闻的相关controller
 * @author 白坤
 * @date 2021/8/9
 */
@Controller
@RequestMapping("/admin")
public class BackNewController {
    @Autowired
    private NewsService newsService;
    @RequestMapping("/newsPage")
    public String index(){
        return "admin/backnews/index";
    }

    @RequestMapping(value = "/newsData",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO newsData(Integer page, Integer limit, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        IPage<News> newsIPage = newsService.getNewsByPageByUserId(user.getUserId(),page,limit);
        if (newsIPage!=null) return new ResultVO("成功",0,(int) newsIPage.getTotal(),newsIPage.getRecords());
        System.err.println(newsIPage.getCurrent());
        return new ResultVO("失败",1);

    }

    @RequestMapping(value = "/news/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResultVO ban(@PathVariable("id")Integer id){
        if (id==null) return new ResultVO("失败",1);
        Boolean banNews = newsService.banNews(id);
        if (banNews) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/newsBanPage")
    public String ban(){
        return "admin/backnews/ban";
    }

    @RequestMapping(value = "/newsBanData",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO newsBanData(Integer page,Integer limit){
        IPage<News> newsBanByPage = newsService.getNewsBanByPage(page, limit);
        if (newsBanByPage!=null) return new ResultVO("成功",0,(int) newsBanByPage.getTotal(),newsBanByPage.getRecords());
        System.err.println(newsBanByPage.getCurrent());
        return new ResultVO("失败",1);
    }

    @RequestMapping(value = "/del/news/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultVO newsDel(@PathVariable("id") Integer id){
        if (id==null) return new ResultVO("请传入正确的id",1);
        Boolean news = newsService.deleteNewsById(id);
        if (news) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

}
