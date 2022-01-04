package com.cdnu.baikun.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.utils.TimeDto;
import com.cdnu.baikun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * @author 白坤
 * @date 2021/7/19
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    @Value("${user.filepath}")
    private String filePath;
    @Autowired
    private UserService userService;

    /**
     * 更改用户头像
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/avatar")
    @ResponseBody
    public JSONObject avatar(MultipartFile file, HttpServletRequest request) {
        String prefix = "";
        JSONObject jsonObject = new JSONObject();
        try {
            if (file != null) {
                // 获取上传的文件名称，并结合存放路径，构建新的文件名称
                String originalName = file.getOriginalFilename();
                System.out.println(originalName);
                //后缀名
                prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
                String uuid = UUID.randomUUID().toString();
                String filePath00 = filePath + "avatar/" + uuid + "." + prefix;
                System.out.println(filePath00);
                File files = new File(filePath00);
                file.transferTo(files);

                User user = (User) request.getSession().getAttribute("user");
                user.setUserAvatar("/file/avatar/" + uuid + "." + prefix);
                userService.updateById(user);
                jsonObject.put("status", 1);
            }
        } catch (Exception e) {
            jsonObject.put("status", 0);
        } finally {

        }
        return jsonObject;
    }


    @RequestMapping("/image")
    @ResponseBody
    public JSONObject image(MultipartFile file) {
        //文件后缀名
        String prefix = "";
        JSONObject jsonObject = new JSONObject();
        try {
            if (file != null) {
                // 获取上传的文件名称，并结合存放路径，构建新的文件名称
                String originalName = file.getOriginalFilename();
                System.out.println(file.getName());
                prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
                System.out.println(originalName);
                //设置文件夹
                String folder=filePath+"images/"+ TimeDto.getTime(new Date());
                System.out.println(folder);
                File filefolder=new File(folder);
                if (!filefolder.exists()){
                    filefolder.mkdirs();
                }
                //设置文件名
                String uuid = UUID.randomUUID().toString();
                String fileName=uuid+"."+prefix;

                File filePath00=new File(folder+"/"+fileName);
                System.out.println(filePath00);
                file.transferTo(filePath00);

                jsonObject.put("code", 0);
                JSONObject data=new JSONObject();
                String s = folder.replace(filePath, "/file/");
                data.put("src",s+"/"+fileName);
                jsonObject.put("data",data);
            }
        } catch (Exception e) {
            jsonObject.put("code", 1);
            e.printStackTrace();
        } finally {

        }
        return jsonObject;
    }
    @RequestMapping("/cover")
    @ResponseBody
    public JSONObject cover(MultipartFile file) {
        //文件后缀名
        String prefix = "";
        JSONObject jsonObject = new JSONObject();
        try {
            if (file != null) {
                // 获取上传的文件名称，并结合存放路径，构建新的文件名称
                String originalName = file.getOriginalFilename();
                prefix = originalName.substring(originalName.lastIndexOf(".") + 1);

                //设置文件夹
                String folder=filePath+"covers/"+ TimeDto.getTime(new Date());
                System.out.println(folder);
                File filefolder=new File(folder);
                if (!filefolder.exists()){
                    filefolder.mkdirs();
                }
                //设置文件名
                String uuid = UUID.randomUUID().toString();
                String fileName=uuid+"."+prefix;

                File filePath00=new File(folder+"/"+fileName);
                System.out.println(filePath00);

                file.transferTo(filePath00);

                jsonObject.put("code", 0);
                JSONObject data=new JSONObject();
                String s = folder.replace(filePath, "/file/");
                data.put("src",s+"/"+fileName);
                jsonObject.put("data",data);
            }
        } catch (Exception e) {
            jsonObject.put("code", 1);
            e.printStackTrace();
        } finally {

        }
        return jsonObject;
    }



}
