package com.cdnu.baikun.controller.api.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.Comment;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 后台评论数据接口
 */
@Controller
@RequestMapping("/api/admin/comment")
public class BackCommentDataApi {
    @Autowired
    private CommentService commentService;


    @RequestMapping("/list")
    @ResponseBody
    public ResultVO list(Integer page,Integer limit){
        Page<Comment> commentPage = commentService.getCommentList(0,page, limit);
        if (commentPage!=null) return new ResultVO("成功",0, (int) commentPage.getTotal(),commentPage.getRecords());
        return new ResultVO("失败",1);
    }

    @RequestMapping("/ban")
    @ResponseBody
    public ResultVO ban(Integer page,Integer limit){
        Page<Comment> commentPage = commentService.getCommentList(1,page, limit);
        if (commentPage!=null) return new ResultVO("成功",0, (int) commentPage.getTotal(),commentPage.getRecords());
        return new ResultVO("失败",1);
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultVO del(@PathVariable("id") Integer id){
        Boolean comment = commentService.deleteCommentByCommentId(id);
        if (comment) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }
    @RequestMapping(value = "/ban/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResultVO ban(@PathVariable("id") Integer id){
        Boolean ban = commentService.ban(id);
        if (ban) return new ResultVO("成功",0);
        return new ResultVO("失败",0);
    }
}
