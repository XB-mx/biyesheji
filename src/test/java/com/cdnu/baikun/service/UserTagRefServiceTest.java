package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.Tag;
import com.cdnu.baikun.domain.UserTagRef;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 测试UserTagRefService
 *
 * @author 白坤
 * @date 2021/7/24
 */
@SpringBootTest
public class UserTagRefServiceTest {
    @Autowired
    private UserTagRefService userTagRefService;

    @Test
    public void addUserTagRefTest() {
        UserTagRef userTagRef = new UserTagRef();
        userTagRef.setUserId(1);
        userTagRef.setTagId(2);

        Boolean aBoolean = userTagRefService.addUserTagRef(userTagRef);
        System.out.println(aBoolean);
    }

    @Test
    public void getUserTagList() {
        List<Tag> userTag = userTagRefService.getUserTag(1);
        userTag.stream().forEach(System.out::println);
    }
}
