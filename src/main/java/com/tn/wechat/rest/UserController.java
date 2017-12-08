package com.tn.wechat.rest;

import com.mybatis.User;
import com.mybatis.cli.UserMapper;
import com.tn.wechat.req.Login;
import com.tn.wechat.util.IMyUtils;
import com.tn.wechat.util.WechatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.security.core.context.SecurityContextHolder;

@RestController
public class UserController {


    private UserMapper userMapper;



    private IMyUtils utils;

    @Autowired
    public void setUtils(IMyUtils utils){
        this.utils = utils;
    }

    private WechatUtils wechatUtils;

    @Autowired
    private void setWechatUtils(WechatUtils wechatUtils){
        this.wechatUtils = wechatUtils;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }


    @PostMapping("/login")
    public @ResponseBody
    Map<String, Object> loginPost(@RequestBody Login login, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();

        String openIdStr = wechatUtils.getOpenId(login.getCode());
        map = JsonTransfer.readJson2Map(openIdStr);
        if (!(map.get("errmsg") == null)) {
            map.put("errmessage", map.get("errmsg"));
            return map;
        }
        String session3ed = session.getId();
        session.setAttribute("WECHAT_OPENID", map.get("openid"));
        session.setAttribute("WECHAT_SESS_ID",map.get("session_key"));
        map.put("sessionid",session3ed);
        map.put("openId",map.get("openid"));
        return map;
    }

    @GetMapping("/403")
    public @ResponseBody
    String loginFail(HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "{ message:\" authenticated failed\"}");
        return "403";
    }

    @PostMapping("/logintest")
    public @ResponseBody
    String loginPostTest(HttpSession session,HttpServletRequest request,Principal principal) {
//        principal.getName()
//        SecurityContextHolder.getContext().getAuthentication().get;

        String session3ed = session.getId();

        return session3ed;
    }

    @PostMapping("/user")
    public @ResponseBody
    User createUser(@RequestBody User newUser, HttpSession session) {

//        Map<String,String> hashMap = (Map<String,String>) SecurityContextHolder.getContext().getAuthentication().getDetails();
//
//        System.out.println(hashMap.get("WECHAT_OPENID"));
        String open_id =(String) session.getAttribute("WECHAT_OPENID");
        User oldUser = userMapper.selectByOpenId(open_id);
//        User oldUser = userMapper.selectByPrimaryKey(newUser.getOpenId());

        if(oldUser == null){
            newUser.setOpenId(open_id);
            newUser.setUpdateTime(utils.getCurrentTimeStamp());
            userMapper.insert(newUser);
            oldUser = newUser;
        }else {
            oldUser.setAvatarUrl(newUser.getAvatarUrl());
            oldUser.setNickName(newUser.getNickName());
            oldUser.setUpdateTime(utils.getCurrentTimeStamp());
            userMapper.updateByPrimaryKey(oldUser);
//            oldUser = newUser;
        }
        return oldUser;
    }

    @PostMapping("/user/update")
    public @ResponseBody
    User updateUser(@RequestBody User newUser) {
        newUser.setUpdateTime(utils.getCurrentTimeStamp());
        userMapper.updateByPrimaryKey(newUser);
        return newUser;
    }


    @GetMapping("/user/{userId}")
    public @ResponseBody
    User updateUser(@PathVariable Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @DeleteMapping("/user/{userId}")
    public @ResponseBody
    void delUser(@PathVariable Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @GetMapping("/access_token")
    public String access_token(){
        String accessTokenJson = wechatUtils.getAccessTokenString();
        wechatUtils.extractAccessToken(accessTokenJson);
        return accessTokenJson;
    }

    @GetMapping("/user/all")
    public List<User> allUsers(){
        return userMapper.selectByExample(null);
    }

}
