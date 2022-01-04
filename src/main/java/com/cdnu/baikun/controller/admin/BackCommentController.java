package com.cdnu.baikun.controller.admin;

import com.cdnu.baikun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台评论管理
 */
@Controller
@RequestMapping("/admin/comment")
public class BackCommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("")
    public String index(){
        return "admin/backcomment/index";
    }
    @RequestMapping("/ban")
    public String ban(){
        return "admin/backcomment/ban";
    }
}
