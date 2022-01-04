package com.cdnu.baikun.interceptor;

import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.utils.GetIpaddress;
import com.cdnu.baikun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author 白坤
 * @date 2021/7/11
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            for (Cookie c : cookies
            ) {
                if (c.getName().equals("username")) {
                    user = userService.login(c.getValue());
                }
                if (user != null) {
                    user.setUserLastIpaddress(GetIpaddress.getIpAddress(request));
                    System.err.println(user.getUserLastIpaddress());
                    userService.updateById(user);
                    request.getSession().setAttribute("user", user);
                } else {
                    response.sendRedirect("/login");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
