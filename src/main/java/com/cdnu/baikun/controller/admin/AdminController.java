package com.cdnu.baikun.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author 白坤
 * @date 2021/7/11
 * @description 用户登录注册控制器
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    /**
     * 执行登录
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        return "user/login";
    }

    @RequestMapping(value = "/loginSumbit")
    @ResponseBody
    public String loginSumbit(@RequestBody JSONObject params,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        String userName = (String) params.get("userName");
        String userPassword = (String) params.get("userPassword");
        String save = (String) params.get("save");
        if (save == null) save = "off";

        User login = userService.login(userName);

        if (login == null) {
            return JSON.toJSONString(new ResultVO("登录失败，用户名不存在!", 0));
        }
        if (!Objects.equals(userPassword, login.getUserPassword())) {
            return JSON.toJSONString(new ResultVO("登录失败，密码错误!", 0));
        }
        Cookie[] cookies = request.getCookies();
        if (cookies.length >= 1) {
            if (save.equals("on")) {
                Cookie cookie = new Cookie("username", login.getUserName());
                cookie.setMaxAge(604800);
                cookie.setHttpOnly(true);
                cookie.setSecure(true);
                response.addCookie(cookie);
            }
        }
        request.getSession().setAttribute("user", login);
        return JSON.toJSONString(new ResultVO("登录成功", 1));
    }

    /**
     * 响应注册页面
     *
     * @return
     */
    @RequestMapping("/resiger")
    public String resiger() {
        return "user/resiger";
    }

    /**
     * 注册用户提交
     *
     * @param params
     * @return
     */
    @RequestMapping("/resigerSumbit")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JSON resigerSumbit(@RequestBody JSONObject params) {
        JSONObject jsonObject = new JSONObject();

        User user = new User();
        user.setUserName((String) params.get("userName"));
        user.setUserNickname((String) params.get("userNickname"));
        user.setUserPassword((String) params.get("userPassword"));
        user.setUserEmail((String) params.get("email"));
        System.err.println(user.getUserNickname());
        Integer resiger = userService.resiger(user);

        if (resiger == 1) {
            jsonObject.put("status", 1);
            jsonObject.put("msg", "注册成功");
        } else if (resiger == 0) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "用户名已存在");
            return jsonObject;
        } else{
            jsonObject.put("status", 0);
            jsonObject.put("msg", "注册失败");
        }
        return jsonObject;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("username", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "index";
    }
    @RequestMapping("/admin")
    public String index(){
        return "admin/index";
    }

}
