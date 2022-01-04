package com.cdnu.baikun.controller.api.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.Tag;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 白坤
 * @date 2021/8/16
 */
@Controller
@RequestMapping("/api/admin/tag")
public class BackTagDataApi {
    @Autowired
    private TagService tagService;

    @RequestMapping("/list")
    @ResponseBody
    public ResultVO get(Integer page,Integer limit){
        Page<Tag> tagPage = tagService.getTagList(page,limit);
        return new ResultVO("成功",0,(int)tagPage.getTotal(),tagPage.getRecords());
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultVO del(@PathVariable("id") Integer id){
        Boolean tagByTagId = tagService.deleteTagByTagId(id);
        if (tagByTagId) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO add(Tag tag){
        Boolean tagByTagId = tagService.addTag(tag);
        if (tagByTagId) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }
}
