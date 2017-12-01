package com.tn.wechat.util;

import com.tn.wechat.rest.HttpsUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WechatUtils {

    public static final String TWO_DIM_CODE_CREATE = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=%s";

    private final static String OPEN_ID_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    private final String  APPID = "wxab931d22fde028bc";
    private final String SECRET = "f4dd8605759c076e166ac9681236df28";

    /**
     * cache access toke for reuse
     */
    private String access_token = null;

    public String getOpenId(String code){
//        Map<String, String> map = new HashMap<String, String>();
        // 设置session
        String getCodeUrl = String.format(OPEN_ID_URL,APPID,SECRET,code);
        String getContent = HttpsUtil.httpsRequestToString(getCodeUrl,"GET",null);
//        map = JsonTransfer.readJson2Map(getContent);
//        if (!(map.get("errmsg") == null)) {
//            map.put("errmessage", map.get("errmsg"));
//            return map;
//        }
//        String session3ed = session.getId();
//        session.setAttribute("WECHAT_OPENID", map.get("openid"));
//        session.setAttribute("WECHAT_SESS_ID",map.get("session_key"));
        return getContent;
    }

    public String getAccessTokenString() {
        String tokenApiUrl = String.format(ACCESS_TOKEN_URL,APPID,SECRET);
        return HttpsUtil.httpsRequestToString(tokenApiUrl,"GET",null);
    }


    public byte[] get2DCode(JSONObject bodyObj) {
        String apiUrl = TWO_DIM_CODE_CREATE;
        String access_token =  this.getAccess_token();
        apiUrl = String.format(apiUrl,access_token);
        byte[] jpg=null;


        try {
            jpg= HttpsUtil.httpsRequestToImage(apiUrl,"POST",bodyObj.get("wechatConf").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpg;
    }


    public String getAccess_token(){
        if(access_token == null || access_token.isEmpty()){
            String accessTokenJson = this.getAccessTokenString();
            extractAccessToken(accessTokenJson);
        }
        return access_token;
    }

    public void extractAccessToken(String accessTokenJson) {

        JSONObject json = new JSONObject(accessTokenJson);
        access_token = json.getString("access_token");
    }
}
