package com.cdnu.baikun.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台游戏资源管理
 * @author 白坤
 * @date 2021/8/9
 */
@Controller
@RequestMapping("/admin")
public class BackResourceController {
    @Autowired
    private ResourcesService resourcesService;

    @RequestMapping("/resourcePage")
    public String index(){
        return "admin/backresource/index";
    }

    @RequestMapping(value = "/resourceData",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject resourceData(Integer page, Integer limit, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        IPage<Resources> resourcesByPage = resourcesService.getResourceListByUserId(user.getUserId(),page,limit);
        JSONObject jsonObject=new JSONObject();
        if (resourcesByPage!=null) {
            jsonObject.put("msg","成功");
            jsonObject.put("code",0);
            jsonObject.put("count",resourcesByPage.getTotal());
            jsonObject.put("data",resourcesByPage.getRecords());
            return jsonObject;
        }
        System.err.println(resourcesByPage.getCurrent());
        jsonObject.put("msg","失败");
        jsonObject.put("code",1);
        return jsonObject;

    }

    @RequestMapping(value = "/resourceban/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResultVO ban(@PathVariable("id")Integer id){
        if (id==null) return new ResultVO("失败",1);
        Boolean banResource = resourcesService.banResource(id);
        if (banResource) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }

    @RequestMapping("/resourceBanPage")
    public String ban(){
        return "admin/backresource/ban";
    }

    @RequestMapping(value = "/resourceBanData",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject resourceBanData(Integer page,Integer limit){
        IPage<Resources> resourcesByPage = resourcesService.getResourcesBanByPage(page,limit);
        JSONObject jsonObject=new JSONObject();
        if (resourcesByPage!=null) {
            jsonObject.put("msg","成功");
            jsonObject.put("code",0);
            jsonObject.put("count",resourcesByPage.getTotal());
            jsonObject.put("data",resourcesByPage.getRecords());
            return jsonObject;
        }

        System.err.println(resourcesByPage.getCurrent());
        jsonObject.put("msg","失败");
        jsonObject.put("code",1);
        return jsonObject;
    }

    @RequestMapping(value = "/del/resource/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultVO resourceDel(@PathVariable("id") Integer id){
        if (id==null) return new ResultVO("请传入正确的id",1);
        Boolean resource = resourcesService.deleteResourceById(id);
        if (resource) return new ResultVO("成功",0);
        return new ResultVO("失败",1);
    }
}
