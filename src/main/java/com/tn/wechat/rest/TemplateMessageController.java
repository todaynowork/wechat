package com.tn.wechat.rest;

import com.tn.wechat.util.WechatUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by chengchao.dong on 1/19/2018.
 */
@RestController
public class TemplateMessageController {

    public static final String TEMPLATE_ID_SUCCESS_BOOK_NOTIFY = "dGW3XRvU7avG-Wbj4MCIgAvYVGl7mvn2IftW7UUL57I";
    private WechatUtils wechatUtils;

    @Autowired
    private void setWechatUtils(WechatUtils wechatUtils){
        this.wechatUtils = wechatUtils;
    }

    @GetMapping("/send_template_message")
    public @ResponseBody
    String access_token(){
        return wechatUtils.sendTemplateMessage();
    }


    @PostMapping("/send_order_success")
    public String send_order_success(@RequestBody String request, HttpSession session){
        return this.sendTemplate(TEMPLATE_ID_SUCCESS_BOOK_NOTIFY,request,session);
    }


    @PostMapping("/send_template/{templateId}")
    public String sendTemplate(@PathVariable String templateId,  @RequestBody String request, HttpSession session){
        JSONObject requestJson =  new JSONObject(request);
//        if(requestJson.has("template_id"))
        String open_id =(String) session.getAttribute(WechatUtils.SESSION_KEY_WECHAT_OPENID);
        requestJson.put("template_id", templateId);
        requestJson.put("touser",open_id);
        System.out.println(requestJson.toString());
        String retValue = wechatUtils.sendTemplate(requestJson.toString());
        return retValue;
    }
}
