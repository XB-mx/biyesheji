package com.cdnu.baikun.utils;


import com.baidu.aip.contentcensor.EImgType;
import org.json.JSONObject;

/**
 * 百度智能云内容审核
 * @author 白坤
 * @date 2021/8/16
 * 注意图像审核将于
 */
public class AipContentCensor {
    //设置APPID/AK/SK
    public static final String APP_ID = "24526066";
    public static final String API_KEY = "HjGZwQysgUPwHGaw9YjP2XAL";
    public static final String SECRET_KEY = "XGKnKXGhm5C7V4iWF1vBYjcXbbUQ9PZO";



    private static AipContentCensor aipContentCensor=new AipContentCensor();

    private AipContentCensor() {
    }

    public static AipContentCensor getAipContentCensor() {
        return aipContentCensor;
    }

    public static JSONObject checkText(String text){
        com.baidu.aip.contentcensor.AipContentCensor client=new com.baidu.aip.contentcensor.AipContentCensor(APP_ID,API_KEY,SECRET_KEY);
        JSONObject res=client.textCensorUserDefined(text);
        return res;
    }
    public static JSONObject checkImage(String local) {
        com.baidu.aip.contentcensor.AipContentCensor client=new com.baidu.aip.contentcensor.AipContentCensor(APP_ID,API_KEY,SECRET_KEY);
        JSONObject res = client.imageCensorUserDefined(local, EImgType.FILE,null);
        System.out.println(res.toString());
        return res;
    }
}
