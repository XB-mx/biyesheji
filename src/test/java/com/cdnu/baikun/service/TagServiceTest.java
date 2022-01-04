package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TagServiceTest {
    @Autowired
    private TagService tagService;

    @Test
    public void addTest() {
        Tag tag = new Tag();
        tag.setTagName("测试");

        Boolean aBoolean = tagService.addTag(tag);
        System.out.println(aBoolean);
    }

    @Test
    public void listTest() {
        /*List<Tag> tagList = tagService.getTagList();
        tagList.stream().forEach(System.out::println);*/
    }

    @Test
    public void delete() {
        Boolean aBoolean = tagService.deleteTagByTagId(1);
        System.out.println(aBoolean);
    }

    @Test
    public void updata() {
        Tag tag = new Tag();
        tag.setTagId(2);
        tag.setTagName("测试");
        tagService.updataTag(tag);
    }
}
