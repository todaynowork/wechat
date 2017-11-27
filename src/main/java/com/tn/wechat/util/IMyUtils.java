package com.tn.wechat.util;

import java.util.Date;

public interface IMyUtils {
    Date getCurrentTimeStamp();

    String generateFileName(String contentDisposition);
}
