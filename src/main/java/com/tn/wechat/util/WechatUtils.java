package com.tn.wechat.util;

import com.tn.wechat.rest.HttpsUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;

@Component
public class WechatUtils {

    public static final String TWO_DIM_CODE_CREATE = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=%s";

    @Value("{wx.url.openid}")
    private static String OPEN_ID_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    /*send template message*/
    public static final String TEMPLATE_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=%s";

    @Value( "${wx.appId}" )
    private String  APPID = null;
    @Value("${wx.secret}")
    private String SECRET = null;
    @Value("${wx.signature.token}")
    private String  tooken = "jredu100"; //开发者自行定义Tooken

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

    /*send template message*/
    public String sendTemplateMessage(){
        String access_token =  this.getAccess_token();
        String templateMessageUrl = String.format(TEMPLATE_MESSAGE_URL,access_token);
        JSONObject body = new JSONObject();
        body.put("touser","openId");
        body.put("template_id","templateId");
        body.put("form_id","formId");
        body.put("value","message");
        /*not necessary*/
//        body.put("color","");
//        body.put("page","点击模版卡片的跳转页面");
//        body.put("emphasis_keyword","DATA");
        return HttpsUtil.httpsRequestToString(templateMessageUrl,"POST",body.toString());
//        return body.toString();
    }


    public boolean checkSignature(String signature,String timestamp,String nonce){

        //1.定义数组存放tooken，timestamp,nonce

        String[] arr = {tooken,timestamp,nonce};

        //2.对数组进行排序

        Arrays.sort(arr);

        //3.生成字符串

        StringBuffer sb = new StringBuffer();

        for(String s : arr){

            sb.append(s);

        }

        //4.sha1加密,网上均有现成代码

        String temp = getSha1(sb.toString());

        //5.将加密后的字符串，与微信传来的加密签名比较，返回结果

        return temp.equals(signature);

    }



    public String getSha1(String str){

        if(str==null||str.length()==0){

            return null;

        }

        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',

                'a','b','c','d','e','f'};

        try {

            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");

            mdTemp.update(str.getBytes("UTF-8"));



            byte[] md = mdTemp.digest();

            int j = md.length;

            char buf[] = new char[j*2];

            int k = 0;

            for (int i = 0; i < j; i++) {

                byte byte0 = md[i];

                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];

                buf[k++] = hexDigits[byte0 & 0xf];

            }

            return new String(buf);

        } catch (Exception e) {

            // TODO: handle exception

            return null;

        }

    }
}
