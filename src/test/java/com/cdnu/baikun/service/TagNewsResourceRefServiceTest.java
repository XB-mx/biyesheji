package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.TagNewsResourceRef;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TagNewsResourceRefServiceTest {
    @Autowired
    private TagNewsResourceRefService refService;
    @Test
    public void testaddTagNewsResourceRef(){
        TagNewsResourceRef ref=new TagNewsResourceRef();
        ref.setTagId(1);
        ref.setNewsId(1);
        refService.addTagNewsResourceRef(ref);
    }
}
