package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void resige() {
        User user = new User();
        user.setUserName("test0724-1");
        user.setUserPassword("123");
        user.setUserEmail("1912929095@qq.com");
        user.setUserNickname("白坤");
        Integer resiger = userService.resiger(user);
        System.out.println(resiger);
    }

    @Test
    public void testselectAllList() {

    }
}
