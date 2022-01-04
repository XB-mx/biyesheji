package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;


    @Test
    public void testaddComment() {
        Comment comment = new Comment();
        comment.setCommentContent("内容");
        Boolean aBoolean = commentService.addComment(comment,null,null);
        System.out.println(aBoolean);
    }

    @Test
    public void testupdateComment() {
        Comment comment = new Comment();
        comment.setCommentContent("内容1111");
        comment.setCommentId(1);
        Boolean aBoolean = commentService.updateComment(comment);
        System.out.println(aBoolean);
    }

    @Test
    public void testdeleteCommentByCommentId() {
        Boolean aBoolean = commentService.deleteCommentByCommentId(1);
        System.out.println(aBoolean);
    }

    @Test
    public void testgetComment() {
        /*List<Comment> commentList = commentService.getCommentList();
        commentList.stream().forEach(System.out::println);*/
    }

}
