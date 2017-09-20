package com.tn.wechat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoUtil {
    private static String Get_Code = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    private final String  APPID = "wxab931d22fde028bc";
    private final String SECRET = "00991f0e10eba1fab3996c1736e3f1ca";
//    private final String code = "111";
//    private final String grant_type = "authorization_code";
    public String getCode(String code){
        return String.format(Get_Code,APPID,SECRET,code);
    }
    @RequestMapping(path = "/getInfo")
    String getInfo(){
        String getCodeUrl = getCode("2121");
//        String response =
        return getCodeUrl;
    }
}
