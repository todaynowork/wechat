package com.tn.wechat.util;

import java.util.Date;

public class MyUtils implements IMyUtils {
    @Override
    public Date getCurrentTimeStamp() {
        return new Date();
    }
}
