package com.cdnu.baikun.controller.api.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.*;
import com.cdnu.baikun.dto.CoverVo;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/api/news")
public class NewsDataApi {
    @Autowired
    private NewsService newsService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CoverService coverService;
    @Autowired
    private TagService tagService;
    @Autowired
    private UserTagRefService utrefService;
    @Autowired
    private TagNewsResourceRefService tagNewsResourceRefService;


    @RequestMapping("/list")
    @ResponseBody
    public ResultVO list(@RequestParam(defaultValue = "1") Integer page){
        //获取新闻集合
        IPage<News> news = newsService.getNewsByPage(page, 8);
        if (news==null) return new ResultVO("数据获取失败",1);

        List<News> records = news.getRecords();
        List<Image> images = imageService.getImageListByNewsIds(records);
        List<CoverVo> list = coverService.coverVoList(null, records, images);

        long total = news.getTotal();

        if (records.size()==0) return new ResultVO("数据为0",1);
        return new ResultVO("成功",0, (int) total,list);
    }

    @RequestMapping("/view/{id}")
    @ResponseBody
    public ResultVO view(@PathVariable("id") Integer id){
        if (id==null) return new ResultVO("请输入正确的id",1);
        Boolean like = newsService.addNewsView(id);
        if (like) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/like/{id}")
    @ResponseBody
    public ResultVO like(@PathVariable("id") Integer id){
        if (id==null) return new ResultVO("请输入正确的id",1);
        Boolean like = newsService.addNewsLike(id);
        if (like) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public ResultVO get(@PathVariable("id") Integer id){
        if (id==null) return new ResultVO("请输入正确的id",1);
        News news = newsService.getById(id);
        if (news!=null) return new ResultVO("成功",0,news);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public ResultVO update(@PathVariable("id")Integer id, News news){
        news.setNewsId(id);
        Boolean aBoolean = newsService.updateNews(news);
        if (aBoolean) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/like")
    @ResponseBody
    public ResultVO like(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<Tag> userTag = utrefService.getUserTag(user.getUserId());
        List<News> news = tagNewsResourceRefService.listNewsByTag(userTag);
        if (news.size()==0){
            Page<News> page = newsService.query().eq("news_status",1).orderByDesc("news_view_count").page(new Page<>(1, 8));
            List<News> records = page.getRecords();
            List<Image> images = imageService.getImageListByNewsIds(records);
            List<CoverVo> list = coverService.coverVoList(null, records, images);
            return new ResultVO("成功",0,list);
        }else {
            List<Image> images = imageService.getImageListByNewsIds(news);
            List<CoverVo> list = coverService.coverVoList(null, news, images);
            return new ResultVO("成功",0,list);
        }
    }
}
