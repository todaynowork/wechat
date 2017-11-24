package com.tn.wechat.rest;

import com.mybatis.User;
import com.mybatis.cli.UserMapper;
import com.tn.wechat.req.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private static String Get_Code = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    private final String  APPID = "wxab931d22fde028bc";
    private final String SECRET = "f4dd8605759c076e166ac9681236df28";

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

//    public String getCodeUrl(String code){
//        return String.format(Get_Code,APPID,SECRET,code);
//    }

    @PostMapping("/login")
    public @ResponseBody
    Map<String, Object> loginPostTest(@RequestBody Login login, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 设置session
        String getCodeUrl = String.format(Get_Code,APPID,SECRET,login.getCode());
        String getContent = HttpsUtil.httpsRequestToString(getCodeUrl,"GET",null);
        map = JsonTransfer.readJson2Map(getContent);
        if (!(map.get("errmsg") == null)) {
            map.put("errmessage", map.get("errmsg"));
            return map;
        }

//        User newUser =  new User();
//        newUser.setOpenId((String) map.get("openid"));
//        newUser.setEmail(login.getEmail());
//        newUser.setNickName(login.getNickName());
//        newUser.setAvatorUrl(login.getAvatorUrl());
//        map.put("session_id","123456789");
        String session3ed = session.getId();
        session.setAttribute("WECHAT_OPENID", map.get("openid"));
        session.setAttribute("WECHAT_SESS_ID",map.get("session_key"));
//        map.put("message", session.getAttribute(WebSecurityConfig.SESSION_KEY));
        map.put("sessionid",session3ed);
        map.put("openId",map.get("openid"));
        return map;
    }

    @PostMapping("/user")
    public @ResponseBody
    User createUser(@RequestBody User newUser, HttpSession session) {
        String open_id =(String) session.getAttribute("WECHAT_OPENID");
        User oldUser = userMapper.selectByPrimaryKey(open_id);
//        User oldUser = userMapper.selectByPrimaryKey(newUser.getOpenId());
        newUser.setOpenId(open_id);
        if(oldUser == null){
            userMapper.insert(newUser);
        }else{
            userMapper.updateByPrimaryKey(newUser);
        }
        return newUser;
    }

}
