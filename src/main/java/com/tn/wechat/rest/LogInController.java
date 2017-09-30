package com.tn.wechat.rest;


//import com.fasterxml.jackson.databind.util.JSONPObject;

//import org.json.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LogInController extends HttpServlet{

    @Value("${wx.url}")
    private String Get_Code = "";
    @Value("${wx.appId}")
    private String  APPID = "";
    @Value("${wx.secret}")
    private String SECRET = "";

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

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, HttpSession session) {
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
    public @ResponseBody Map<String, Object> loginPost(@RequestBody String code, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        // 设置session
        String getCodeUrl = getCodeUrl(code);
        String getContent = HttpsUtil.httpsRequestToString(getCodeUrl,"GET",null);
        map = JsonTransfer.readJson2Map(getContent);
        if (!(map.get("errmsg") == null)) {
            map.put("errmessage:", map.get("errmsg"));
            return map;
        }
//        map.put("session_id","123456789");
        String session3ed = session.getId();
        session.setAttribute(WebSecurityConfig.SESSION_KEY, map.get("openid"));
        session.setAttribute(session3ed,map.get("session_id"));
        map.put("message:", session.getAttribute(WebSecurityConfig.SESSION_KEY));
        map.put("sessionid:",session3ed);
        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
