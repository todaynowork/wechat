package com.tn.wechat.req;

public class Login {
    private String code;
    private String avatorUrl;
    private String nickName;
    private String email;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAvatorUrl() {
        return avatorUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setAvatorUrl(String avatorUrl) {
        this.avatorUrl = avatorUrl;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
