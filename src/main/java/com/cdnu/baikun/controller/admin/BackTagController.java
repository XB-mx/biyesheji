package com.cdnu.baikun.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 白坤
 * @date 2021/8/16
 */
@Controller
public class BackTagController {
    @RequestMapping("/admin/tag")
    public String tag(){
        return "admin/backtag/index";
    }
}
