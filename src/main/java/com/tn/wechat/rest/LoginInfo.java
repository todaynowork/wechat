package com.tn.wechat.rest;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by chengchao.dong on 9/26/2017.
 */

public class LoginInfo {

    private String openId;
    private String sessionId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
