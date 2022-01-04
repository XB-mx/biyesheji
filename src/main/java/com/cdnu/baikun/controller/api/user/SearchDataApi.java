package com.cdnu.baikun.controller.api.user;

import com.cdnu.baikun.dto.CoverVo;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 搜索功能数据接口
 * @author 白坤
 * @date 2021/8/14
 */
@Controller
@RequestMapping("/api")
public class SearchDataApi {
    @Autowired
    private SearchService searchService;

    @RequestMapping("/search")
    @ResponseBody
    public ResultVO search(@RequestParam("keywords") String keywords,
                           @RequestParam("page") Integer page){
        Map<String, Object> map = searchService.listCoverVo(page, keywords);
        if (map.get("list")!=null) return new ResultVO("成功",0,(Integer) map.get("count"),map.get("list"));
        return new ResultVO("失败",1);
    }
}
