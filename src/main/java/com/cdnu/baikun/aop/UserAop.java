package com.cdnu.baikun.aop;

import com.cdnu.baikun.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * 已作废
 *
 * @author 白坤
 * @date 2021/7/23
 * @deprecated 对公共变量得提取（之前写的代码太多，不改了）
 */
@Aspect
public class UserAop {
    @Pointcut("execution( * com.cdnu.baikun.controller.user.IndexController.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        User user = null;

        for (Object arg : args
        ) {
            if (arg instanceof HttpServletRequest) {
                user = (User) ((HttpServletRequest) arg).getSession().getAttribute("user");
            }
        }
        for (Object arg : args
        ) {
            if (arg instanceof Model) {
                Model model = (Model) arg;
                model.addAttribute("user", user);
                System.out.println("123123123----------------------");
            }
        }
    }
}
