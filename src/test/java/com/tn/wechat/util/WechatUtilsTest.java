package com.tn.wechat.util;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="file:src/main/profile/prod/application.properties")
public class WechatUtilsTest {

    @Autowired
    WechatUtils wechatUtils;

    @Test
    public void getTemplateList() throws Exception {

        String config= "{" +
                "\"offset\":0," +
                "\"count\":1" +
                "}";
        String tempLst = wechatUtils.getTemplateList(config);
        System.out.println(tempLst);
    }

    @Test
    public void delTemplateById() throws Exception {
        String config = "{\n" +
                "\"template_id\":\"wDYzYZVxobJivW9oMpSCpuvACOfJXQIoKUm0PY397Tc\"\n" +
                "}";
//
        String returnValue = wechatUtils.delTemplateById(config);
        System.out.println(returnValue);

    }

    @Test
    public void sendTemplate() throws Exception {
        //{"errcode":0,"errmsg":"ok","template_id":"dGW3XRvU7avG-Wbj4MCIgAvYVGl7mvn2IftW7UUL57I"}

        String config = "{\n" +
                "  \"touser\": \"OPENID\",  \n" +
                "  \"template_id\": \"TEMPLATE_ID\", \n" +
                "  \"page\": \"index\",          \n" +
                "  \"form_id\": \"FORMID\",         \n" +
                "  \"data\": {\n" +
                "      \"keyword5\": {\n" +
                "          \"value\": \"2015年01月05日 12:30\", \n" +
                "          \"color\": \"#173177\"\n" +
                "      }, \n" +
                "      \"keyword3\": {\n" +
                "          \"value\": \"粤海喜来登酒店\", \n" +
                "          \"color\": \"#173177\"\n" +
                "      } , \n" +
                "      \"keyword4\": {\n" +
                "          \"value\": \"广州市天河区天河路208号\", \n" +
                "          \"color\": \"#173177\"\n" +
                "      } \n" +
                "  },\n" +
                "  \"emphasis_keyword\": \"keyword1.DATA\" \n" +
                "}";
        String strOpenId = "";
        String strTemplateId = "dGW3XRvU7avG-Wbj4MCIgAvYVGl7mvn2IftW7UUL57I";
        String strPageUrl = "index/index";
        String strFormId = "formid";
        Map<String, Map<String,String>> keyWordsMap = new HashMap<>();
        Map<String,String> keyword = new HashMap<>();
        keyword.put("value","");

        keyWordsMap.put("",keyword);
        JSONObject sendMessage = new JSONObject();
        sendMessage.put("touser", strOpenId);
        sendMessage.put("template_id", strTemplateId);
        if(strPageUrl != null && !strPageUrl.isEmpty())
            sendMessage.put("page", strPageUrl);
        sendMessage.put("form_id",strFormId);

        sendMessage.put("data",keyWordsMap);
        String returnValue = wechatUtils.sendTemplate(config);
        System.out.println(returnValue);

    }

    @Test
    public void addTemplate() throws Exception {
        String config ="{\n" +
                "\"id\":\"AT0002\", \n" +
                "\"keyword_id_list\":[3,4,5] \n" +
                "}";

        String returnValue = wechatUtils.addTemplate(config);
        System.out.println(returnValue);

    }

    @Test
    public void templateLibGet() throws Exception {
        String config = "{" +
                "\"id\":\"AT0002\"" +
                "}";
        String tempLibItem = wechatUtils.templateLibGet(config);
        System.out.println(tempLibItem);
    }

    @Test
    public void templateLibList() throws Exception {

        String config = "{" +
                "\"offset\":0," +
                "\"count\":5" +
                "}";
        String tempLibLst = wechatUtils.templateLibList(config);
        System.out.println(tempLibLst);
    }

}