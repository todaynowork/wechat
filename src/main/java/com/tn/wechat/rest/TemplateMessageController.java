package com.tn.wechat.rest;

import com.tn.wechat.util.WechatUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chengchao.dong on 1/19/2018.
 */
@RestController
public class TemplateMessageController {

    private WechatUtils wechatUtils;

    @Autowired
    private void setWechatUtils(WechatUtils wechatUtils){
        this.wechatUtils = wechatUtils;
    }

    @GetMapping("/send_template_message")
    public String access_token(){
        return wechatUtils.sendTemplateMessage();
    }
}
