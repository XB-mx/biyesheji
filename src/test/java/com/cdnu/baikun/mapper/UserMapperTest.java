package com.cdnu.baikun.mapper;

import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.enums.UserStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void UserResigerTest() {
        User user = new User();
        user.setUserName("test0712-3");
        user.setUserPassword("123");
        user.setUserEmail("1912929095@qq.com");
        user.setUserNickname("白坤");
        int insert = userMapper.resiger(user);
        System.out.println(user.getUserId());
    }

    @Test
    public void UserDeleteTest() {
        User user = new User();
        user.setUserId(2);
        int i = userMapper.deleteById(2);
        System.out.println(i);
    }

    @Test
    public void UserLoginTest() {
        User user1 = userMapper.selectByUserName("admin");
        System.out.println(user1.toString());
    }

    @Test
    public void UserListTest() {
        List<User> userList = userMapper.selectList(UserStatusEnum.NORMAL.getInteger());
        userList.stream().forEach(System.out::println);
    }

    @Test
    public void UserdisableTest() {
        User user = new User();
        user.setUserId(3);
        user.setUserStatus(0);
        int i = userMapper.disableById(user.getUserId());
        System.out.println(i);
    }
}
