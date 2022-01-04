package com.cdnu.baikun.aop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cdnu.baikun.utils.AipContentCensor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 白坤
 * @date 2021/8/16
 * 进行图片审核
 */
@Aspect
@Component
public class CheckImage {
    @Value("${user.filepath}")
    private String filePath;
    @Pointcut("execution( * com.cdnu.baikun.controller.admin.UploadController.image(..))")
    public void checkImage(){}
    @Pointcut("execution( * com.cdnu.baikun.controller.admin.UploadController.cover(..))")
    public void checkCover(){}

    @Around("checkImage()||checkCover()")
    public JSONObject check(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();
        try {
            Object o = proceedingJoinPoint.proceed();
            System.err.println(o.toString());
            JSONObject res= (JSONObject) JSONObject.toJSON(o);
            if (res.get("code").equals(0)){
                Object o1 = res.get("data");
                JSONObject data= (JSONObject) o1;
                Object src = data.get("src");
                //图片路径
                String imgSrc = src.toString();
                System.out.println(imgSrc);
                //绝对路径
                String imgLocalSrc = imgSrc.replace("/file/", filePath);
                org.json.JSONObject jsonObject = AipContentCensor.checkImage(imgLocalSrc);
                if (jsonObject.get("conclusion").equals("不合规")){
                    org.json.JSONObject resdata=new org.json.JSONObject(jsonObject.toString());
                    System.out.println(resdata.toString());
                    org.json.JSONArray resdata1= resdata.getJSONArray("data");
                    res=new JSONObject();
                    res.put("code",1);
                    StringBuffer sb=new StringBuffer();
                    for (Object o2:resdata1){
                        org.json.JSONObject jo= (org.json.JSONObject) o2;
                        sb.append(jo.get("msg")+"/n");
                    }
                    res.put("msg",sb.toString());
                }
            }
            return res;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
