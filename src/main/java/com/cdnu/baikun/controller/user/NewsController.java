package com.cdnu.baikun.controller.user;

import com.cdnu.baikun.domain.*;
import com.cdnu.baikun.dto.CoverVo;
import com.cdnu.baikun.service.CoverService;
import com.cdnu.baikun.service.ImageService;
import com.cdnu.baikun.service.NewsService;
import com.cdnu.baikun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/8/13
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CoverService coverService;
    @Autowired
    private UserService userService;
    /**
     * 路由跳转
     * @return
     */
    @RequestMapping("/page")
    public String page(){
        return "user/news/index";
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id") Integer id, Model model){
        if (id==null&&id.equals("")) return "redirect:/404";
        News news = newsService.getById(id);
        if (news==null) return "redirect:/404";
        Image image = imageService.getImageBynewsId(id);
        CoverVo cover = coverService.cover(null, news, image);

        User author = userService.getById(news.getNewsUserId());

        model.addAttribute("cover",cover);
        model.addAttribute("author",author);
        model.addAttribute("news",news);
        return "user/news/detail";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id){
        return "user/news/update";
    }
}
