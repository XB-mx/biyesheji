package com.cdnu.baikun.controller.api.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.Comment;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.CommentResourceNewsRefService;
import com.cdnu.baikun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/comment")
public class CommentDataApi {
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentResourceNewsRefService refService;

    @RequestMapping("/resource/{id}")
    @ResponseBody
    public ResultVO resourceComment(@PathVariable("id") Integer id,
                                    @RequestParam("page") Integer page){
        List<Integer> commentIds = refService.listCommentIdsByResourceId(id);
        if (commentIds==null) return new ResultVO("成功，没有评论",0);
        Page<Comment> commentPage = commentService.listCommentPageByIds(0,page, commentIds);
        if (commentPage.getTotal()!=0) return new ResultVO("成功",0,(int)commentPage.getTotal(),commentPage.getRecords());
        return new ResultVO("未知失败",1);
    }
    @RequestMapping("/news/{id}")
    @ResponseBody
    public ResultVO newsComment(@PathVariable("id") Integer id,
                                @RequestParam("page") Integer page){
        List<Integer> commentIds = refService.listCommentIdsByNewsId(id);
        if (commentIds==null) return new ResultVO("成功，没有评论",0);
        Page<Comment> commentPage = commentService.listCommentPageByIds(0,page, commentIds);
        if (commentPage!=null) return new ResultVO("成功",0,(int)commentPage.getTotal(),commentPage.getRecords());
        return new ResultVO("未知失败",1);
    }

    @RequestMapping(value = "/resource/{id}",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO addResourceComment(@PathVariable("id") Integer id, Comment comment, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        comment.setCommentTime(new Date());
        comment.setCommentUserId(user.getUserId());
        comment.setCommentUserAvatar(user.getUserAvatar());
        comment.setCommentUserNickname(user.getUserNickname());
        Boolean comment1 = commentService.addComment(comment,id,null);
        if (comment1) return new ResultVO("成功",0);

        return new ResultVO("失败",1);
    }

    @RequestMapping(value = "/news/{id}",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO addNewsComment(@PathVariable("id") Integer id,Comment comment,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        comment.setCommentTime(new Date());
        comment.setCommentUserId(user.getUserId());
        comment.setCommentUserAvatar(user.getUserAvatar());
        comment.setCommentUserNickname(user.getUserNickname());
        Boolean comment1 = commentService.addComment(comment,null,id);
        if (comment1) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }


}

