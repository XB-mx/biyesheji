package com.cdnu.baikun.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 所有异常请求
 */
@Controller
public class ErrorController {
    @RequestMapping("/404")
    public String error404() {
        return "user/error/404";
    }
}
