package com.cdnu.baikun.controller.admin;

import com.cdnu.baikun.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台公告管理
 * @author 白坤
 * @date 2021/8/14
 */
@Controller
@RequestMapping("/admin")
public class BackNoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/notice")
    public String index(){
        return "admin/backnotice/index";
    }
}
