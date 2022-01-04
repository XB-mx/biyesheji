package com.cdnu.baikun.controller.admin;

import com.cdnu.baikun.domain.Image;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.soap.Addressing;

/**
 * @author 白坤
 * @date 2021/8/10
 */
@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;


    @RequestMapping("/news/{id}")
    @ResponseBody
    public ResultVO getImageByNewsId(@PathVariable(value = "id") Integer id){
        Image image = imageService.getImageBynewsId(id);
        if (image!=null) new ResultVO("成功",1,image.getImgSrc());
        return new ResultVO("失败",0);
    }

    @RequestMapping("/resource/{id}")
    @ResponseBody
    public ResultVO getImageByResourceId(@PathVariable(value = "id") Integer id){
        Image image = imageService.getImageByResourceId(id);
        if (image!=null) new ResultVO("成功",1,image.getImgSrc());
        return new ResultVO("失败",0);
    }
}
