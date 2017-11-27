package com.tn.wechat.util;

import java.util.Date;

public class MyUtils implements IMyUtils {
    @Override
    public Date getCurrentTimeStamp() {
        return new Date();
    }

    @Override
    public String generateFileName(String contentDisposition){

        return new StringBuilder().append(java.util.UUID.randomUUID().toString()).append(".jpg").toString();
//        return contentDisposition.substring(contentDisposition.indexOf("filename=\"")).replace("\"","");
    }

    public static void main(String[] args){
        String fileName = "attachment; filename=\"_app_pages/index/index?index=12345.jpg\"";

        fileName = fileName.substring(fileName.indexOf("filename=\"")).replace("\"","");

        System.out.println(fileName);

    }
}
