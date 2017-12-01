package com.tn.wechat.security;

import com.tn.wechat.util.WechatUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
@Profile("security")
public class WechatAuthenticationProvider implements AuthenticationProvider {


    private WechatUtils wechatUtils;

    @Autowired
    private void setWechatUtils(WechatUtils wechatUtils){
        this.wechatUtils = wechatUtils;
    }
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        //store code of wechat in password
        String password = authentication.getCredentials().toString();

        logger.info("Name = " + name + " ,Password = " + password);
        //retrive open id and session id
        String openIdStr = wechatUtils.getOpenId(password);

        JSONObject json = new JSONObject(openIdStr);

        if(json.isNull("errmsg")){
            logger.info("Succesful authentication!");
            Map<String,String> detail = new HashMap<String,String>();
            detail.put("WECHAT_OPENID",json.getString("openid"));
            detail.put("WECHAT_SESS_ID",json.getString("session_key"));
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
            auth.setDetails(detail);
            return auth;
        }
        logger.info("Login fail!");
        logger.info(json.getString("errmsg"));
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
