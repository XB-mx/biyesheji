package com.cdnu.baikun.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 实现aop编程，打印用户信息
 */
@Aspect
@Component
public class SumbitAop {
    @Pointcut("execution(* com.cdnu.baikun.service.UserService.*(..)))")
    public void pointcut() {
    }

    @Before("pointcut() && args(name)")
    public void before(JoinPoint joinPoint, String name) {
        Object[] obj = joinPoint.getArgs();
        //这是所有参数获取
        Arrays.stream(obj).forEach(System.out::println);
        //判断类型
        for (Object o : obj
        ) {
            if (o instanceof String) System.out.println("用户名：" + o);
        }
        //只获取string
        System.out.println(name);
    }
}
