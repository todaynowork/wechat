package com.tn.wechat.rest;

import com.mybatis.User;
import com.mybatis.cli.UserMapper;
import com.tn.wechat.req.Login;
import com.tn.wechat.util.IMyUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private static String Get_Code = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    private final String  APPID = "wxab931d22fde028bc";
    private final String SECRET = "f4dd8605759c076e166ac9681236df28";

    private UserMapper userMapper;

    private String access_token = null;

    private IMyUtils utils;

    @Autowired
    public void setUtils(IMyUtils utils){
        this.utils = utils;
    }

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
        String accessTokenJson = getAccessTokenString();
        extractAccessToken(accessTokenJson);
        return accessTokenJson;
    }

    public String getAccess_token(){
        if(access_token == null || access_token.isEmpty()){
            String accessTokenJson = getAccessTokenString();
            extractAccessToken(accessTokenJson);
        }
        return access_token;
    }

//    @PostMapping("/2_d_code")
//    public Map<String, String> create2dCode(@RequestBody String body){
//        String access_token = this.getAccess_token();
////        String apiUrl = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=%s";
//        String apiUrl = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=%s";
//
//        apiUrl = String.format(apiUrl,access_token);
//        byte[] jpg=null;
//        try {
//            jpg= HttpsUtil.httpsRequestToImage(apiUrl,"POST",body);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String fileName = utils.generateFileName(null);
//        File filePath = new File(twoDCodeLocation + fileName);
//        try(OutputStream out = new BufferedOutputStream(new FileOutputStream(filePath))) {
//            out.write(jpg);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        System.out.println(jpg);
//        Map<String,String> hashMap = new HashMap<String, String>();
//        hashMap.put("file_name",fileName);
//        return hashMap;
//
////        Map<String,String> hashMap = new HashMap<String, String>();
////        hashMap.put("create_2d_code_url",apiUrl);
//    }
//
//
//    @GetMapping ("/2_d_code/{filenName}/")
//    public ResponseEntity<byte[]> get2dCode(@PathVariable String filenName) throws IOException {
//        Path path = Paths.get(twoDCodeLocation + filenName);
//        byte[] data = Files.readAllBytes(path);
//
//        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).contentLength(data.length).body(data);
//
//    }

    private void extractAccessToken(String accessTokenJson) {

        JSONObject json = new JSONObject(accessTokenJson);
        access_token = json.getString("access_token");
    }


    private String getAccessTokenString() {
        String tokenApiUrl = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",APPID,SECRET);
        return HttpsUtil.httpsRequestToString(tokenApiUrl,"GET",null);
    }

}
