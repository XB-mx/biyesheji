package com.cdnu.baikun.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cdnu.baikun.domain.Meney;
import com.cdnu.baikun.domain.Tag;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.domain.UserTagRef;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.MeneyService;
import com.cdnu.baikun.service.TagService;
import com.cdnu.baikun.service.UserService;
import com.cdnu.baikun.service.UserTagRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author 白坤
 * @description 用户的控制器
 * @date 2021/7/12
 */
@Controller
@RequestMapping("/account")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MeneyService meneyService;
    @Autowired
    private TagService tagService;
    @Autowired
    private UserTagRefService refService;


    @RequestMapping( value = {"/","/home"})
    public String home(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        //Meney meney=meneyService.getUserMoney(user.getUserId());
        //使用IService的查询方法
        Meney one = meneyService.getOne(Wrappers.<Meney>lambdaQuery().eq(Meney::getUserId, user.getUserId()), false);

        model.addAttribute("user", user);
        return "user/account/home";
    }

    @RequestMapping("/setting")
    public String setting(Model model, HttpServletRequest request) {
        List<Tag> list = tagService.list();
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("list",list);
        return "user/account/setting";
    }

    @RequestMapping("/settingsumbit")
    @ResponseBody
    public ResultVO settingsumbit(String userNickname,Integer userSex ,
                                     String tagId,HttpServletRequest request) {
        User baseUser = (User) request.getSession().getAttribute("user");
        baseUser.setUserNickname(userNickname);
        baseUser.setUserSex(userSex);
        System.err.println(tagId);
        Boolean aBoolean = refService.deleteUserTagRefByUserId(baseUser.getUserId());
        if (tagId!=null&&!tagId.equals("")){
            String[] strings = tagId.split(",");
            for (String s:strings){
                UserTagRef ref=new UserTagRef();
                ref.setUserId(baseUser.getUserId());
                ref.setTagId(Integer.parseInt(s));
                refService.addUserTagRef(ref);
            }
        }
        boolean b = userService.updateById(baseUser);

        if (b) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/avatar")
    public String avatar(HttpServletRequest request, Model model) {
        User baseUser = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",baseUser);
        return "user/account/avatar";
    }

    @RequestMapping("/contribute")
    public String contribute(){
        return "user/account/contribute";
    }

    @RequestMapping("/collection")
    public String collection(){
        return "user/account/collection";
    }
}
