package com.cdnu.baikun.controller.api.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.Notice;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 后台公告数据接口
 */
@Controller
@RequestMapping("/api/admin/notice")
public class BackNoticeDataApi {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/list")
    @ResponseBody
    public ResultVO list(Integer page,Integer limit){
        Page<Notice> noticePage = noticeService.getAllNotice(page,limit);
        return new ResultVO("成功",0, (int) noticePage.getTotal(),noticePage.getRecords());
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO add(Notice notice){
        notice.setNoticeCreateTime(new Date());
        notice.setNoticeUpdataTime(new Date());
        Boolean addNotice = noticeService.addNotice(notice);
        if (addNotice) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }


    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultVO del(@PathVariable("id") Integer id){
        Boolean notice = noticeService.deleteNoticeById(id);
        if (notice) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResultVO update(Notice notice){
        Boolean updateNotice = noticeService.updateNotice(notice);
        if (updateNotice) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping(value = "/setnotice/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResultVO setNotice(@PathVariable("id") Integer noticeId){
        Boolean updateNotice = noticeService.setNotice(noticeId);
        if (updateNotice) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("")
    @ResponseBody
    public ResultVO notice(){
        Notice notice = noticeService.getNotice();
        return new ResultVO("成功",0,notice);
    }
}
