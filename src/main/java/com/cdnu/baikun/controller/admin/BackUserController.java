package com.cdnu.baikun.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.Meney;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.enums.UserStatusEnum;
import com.cdnu.baikun.service.MeneyService;
import com.cdnu.baikun.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台用户
 * @author 白坤
 * @date 2021/8/1
 */
@Controller
@RequestMapping("/admin")
public class BackUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MeneyService meneyService;

    @RequestMapping("/user")
    public String userlist(){
        return "admin/backuser/userlist";
    }

    @RequestMapping("/userlist")
    @ResponseBody
    public JSONObject getUserList(@RequestParam("page") Integer page,@RequestParam("limit") Integer pageSize){
        return getJsonObject(page, pageSize);
    }

    @RequestMapping("/users")
    public String users(){
        return "admin/backuser/users";
    }

    @RequestMapping("/userslist")
    @ResponseBody
    public JSONObject getUsersList(@RequestParam("page") Integer page,@RequestParam("limit") Integer pageSize){
        return getJsonObject(page, pageSize,UserStatusEnum.NORMAL.getInteger());
    }


    @RequestMapping("/deusers")
    public String deusers(){
        return "admin/backuser/deusers";
    }

    @RequestMapping("/deuserlist")
    @ResponseBody
    public JSONObject getDeUserList(@RequestParam("page") Integer page,@RequestParam("limit") Integer pageSize){
        return getJsonObject(page, pageSize, UserStatusEnum.DISABLE.getInteger());
    }

    /**
     * 用于获取结果对象
     * @param page
     * @param pageSize
     * @return
     */
    @NotNull
    private JSONObject getJsonObject(Integer page,Integer pageSize) {
        JSONObject jsonObject=new JSONObject();
        Page<User> userPage = userService.selectAllList(page, pageSize);
        jsonObject.put("count",userPage.getTotal());
        jsonObject.put("data",userPage.getRecords());
        jsonObject.put("code",0);
        return jsonObject;
    }

    /**
     * 用于获取结果对象
     * @param page
     * @param pageSize
     * @param status
     * @return
     */
    private JSONObject getJsonObject(Integer page,Integer pageSize,Integer status) {
        JSONObject jsonObject=new JSONObject();
        Page<User> userPage = userService.selectList(page, pageSize,status);
        jsonObject.put("count",userPage.getTotal());
        jsonObject.put("data",userPage.getRecords());
        jsonObject.put("code",0);
        return jsonObject;
    }

    /**
     * 禁用用户
     * @param userId
     * @return
     */
    @RequestMapping("/disa/{id}")
    @ResponseBody
    public ResultVO disauser(@PathVariable("id") Integer userId){
        Boolean aBoolean = userService.disaOrenUser(userId);
        if (aBoolean){
            return new ResultVO("success",1);
        }

        return new ResultVO("fail",0);
    }

    /**
     * 根据id获取积分
     * @param userId
     * @return
     */
    @RequestMapping("/money/{id}")
    @ResponseBody
    public ResultVO money(@PathVariable("id") Integer userId){
        Meney userMoney = meneyService.getUserMoney(userId);
        if (userMoney!=null){
            return new ResultVO("success",1,userMoney.getUserNum());
        }

        return new ResultVO("fail",0);
    }

    /**
     * 根据id获取积分
     * @param userId
     * @return
     */
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public ResultVO delete(@PathVariable("id") Integer userId){
        boolean b = userService.removeById(userId);
        if (b){
            return new ResultVO("success",1);
        }
        return new ResultVO("fail",0);
    }
}
