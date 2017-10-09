package com.tn.wechat.rest;


//import com.fasterxml.jackson.databind.util.JSONPObject;

//import org.json.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LogInController extends HttpServlet{
    private static String Get_Code = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    private final String  APPID = "wxab931d22fde028bc";
    private final String SECRET = "00991f0e10eba1fab3996c1736e3f1ca";
    public String getCodeUrl(String code){
        return String.format(Get_Code,APPID,SECRET,code);
    }
    @RequestMapping(value = "/getLogIn/{code}", method = RequestMethod.GET )
    public String getLogIn(@PathVariable("code") String code){
        String getCodeUrl = getCodeUrl(code);
        String getContent = HttpsUtil.httpsRequestToString(getCodeUrl,"GET",null);

        return getContent;
    }
    @RequestMapping(value = "/getCodeUrl/{code}", method = RequestMethod.GET )
    public String getUrl(@PathVariable("code") String code){
        String getCodeUrl = getCodeUrl(code);
        return getCodeUrl;
    }

//    @GetMapping("/")
//    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, HttpSession session) {
//        return session.getId();
//    }

    @GetMapping("/")
    public String index(HttpSession session) {
        return session.getId();
    }

    @GetMapping("/errorlogin")
    public String errorLogin(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException{
        response.setStatus(401);
        return "401";
    }

    @GetMapping("/login")
    public Map<String, Object> login() {
        Map<String, Object> map = new HashMap<>();
        map.put("message:", "test");
        return map;
    }

    @PostMapping("/loginPost")
    public @ResponseBody LoginInfo loginPost(HttpSession session, @RequestHeader HttpHeaders headers) {
        Map<String, Object> map = new HashMap<>();
        LoginInfo loginInfo = new LoginInfo();
        System.out.println("start");
//        System.out.println(headers.get("sessionid"));
        // for test
        String sessionIdFromHeader = headers.getFirst("sessionid");
        if (!(headers.get("sessionid") == null || headers.get("openid") == null)){
            System.out.println(sessionIdFromHeader);
            System.out.println(session.getId());
            if(sessionIdFromHeader.equals(session.getId())){
                loginInfo.setOpenId(headers.getFirst("openid").toString());
                loginInfo.setSessionId(sessionIdFromHeader);
//                loginInfo.setAdditionalProperty("message","logged in");
                System.out.println("logged in");
                return loginInfo;
            }
            System.out.println("session not match");
            return null;
        }
        // 设置session
        if (headers.get("code") == null){
            //miss code in header
            return null;
        }
        String code = headers.get("code").toString();
        String getCodeUrl = getCodeUrl(code);
        String getContent = HttpsUtil.httpsRequestToString(getCodeUrl,"GET",null);
        map = JsonTransfer.readJson2Map(getContent);
        if (!(map.get("errmsg") == null)) {
            map.put("errmessage:", map.get("errmsg"));
            return null;
        }
//        map.put("session_id","123456789");
//        map.put("openid","test1");
        System.out.println(map);
        loginInfo.setOpenId((String)map.get("openid"));
        loginInfo.setSessionId(session.getId());
//        loginInfo.setAdditionalProperty("message","session created");
        String sessionIdFromWechat = (String)map.get("session_id");
        session.setAttribute(loginInfo.getSessionId(),sessionIdFromWechat);
        headers.set("sessionid",loginInfo.getSessionId());
        headers.set("openid",loginInfo.getOpenId());
        System.out.println(headers.toString());
        return loginInfo;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(session.getAttribute(session.getId().toString()).toString());
        return "redirect:/login";
    }
}
