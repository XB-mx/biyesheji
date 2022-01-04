package com.cdnu.baikun.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class GetImgSrc {

    /**
     * 获取第一张图的src
     * @param text
     * @return
     */
    public static String getFirstImgSrc(String text){
        String patternImg="<img.*?>";

        String pattern = "\".*?\"";
        Pattern pattern0=Pattern.compile(patternImg);
        Pattern pattern1=Pattern.compile(pattern);
        Matcher m = pattern0.matcher(text);
        if (m.find()){
            Matcher matcher = pattern1.matcher(m.group());
            if (matcher.find()) return matcher.group().replace("\"", "");
        }
        return null;
    }
}
