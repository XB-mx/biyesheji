package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.enums.UserRoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResourcesServiceTest {
    @Autowired
    private ResourcesService resourcesService;
    @Test
    public void testaddResources(){
        Resources resources=new Resources();
        resources.setResourcesTitle("111");
        resources.setResourcesContent("23123");
        resources.setResourcesUserId(1);
        resources.setResourcesStatus(1);
        resources.setResourcesUserGroup(UserRoleEnum.USER.getRole());
        resourcesService.addResources(resources);
    }
    @Test
    public void testaddResourceLike(){
        resourcesService.addResourceLike(1);
    }
}
