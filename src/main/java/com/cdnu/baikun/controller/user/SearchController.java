package com.cdnu.baikun.controller.user;

import com.cdnu.baikun.dto.CoverVo;
import com.cdnu.baikun.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/8/14
 */
@Controller
public class SearchController {

    @RequestMapping("/search")
    public String search(){
        return "user/search/search";
    }

}
