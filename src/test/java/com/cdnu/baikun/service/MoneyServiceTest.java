package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MoneyServiceTest {
    @Autowired
    private MeneyService meneyService;

    @Test
    public void testuserTrade() {
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserMoney(100);
        User user2 = new User();
        user2.setUserId(11);
        user2.setUserMoney(0);
        Boolean aBoolean = meneyService.userTrade(user1, user2, 10);
        System.err.println(aBoolean);
    }
}
