package com.tn.wechat.rest;

/**
 * Created by chengchao.dong on 9/1/2017.
 */

import com.tn.wechat.util.IMyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.net.ssl.HttpsURLConnection;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class HttpsUtil {
    private static final Logger logger = LoggerFactory.getLogger(TwoDimetionCodeController.class);

    private IMyUtils utils;

    @Autowired
    public void setUtils(IMyUtils utils){
        this.utils = utils;
    }

    public static String httpsRequestToString(String path, String method, String body) throws IOException {
        if(path == null || method == null){
            return null;
        }
        String response = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        HttpsURLConnection conn = null;
        try{
            URL url = new URL(path);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(method);
            if (null != body) {
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(body.getBytes("UTF-8"));
                outputStream.close();
            }
            inputStream = conn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            response = buffer.toString();
        } catch (IOException e) {
            throw e;
        }
        finally {
            if (conn != null) {
                conn.disconnect();
            }
            try {
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException execption) {
                throw execption;
            }
        }
        return response;
    }


    public static byte[] httpsRequestToImage(String path, String method, String body) throws IOException {
        if(path == null || method == null){
            return null;
        }
        BufferedImage img =null;
        HttpsURLConnection conn = null;
        try{
            URL url = new URL(path);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(method);
            if (null != body) {
                try(OutputStream outputStream = conn.getOutputStream()){
                    outputStream.write(body.getBytes("UTF-8"));
                }

            }

//            System.out.println(conn.getHeaderField("Content-disposition"));
//
//            String fileName = conn.getHeaderField("Content-disposition");
//
//            fileName = fileName.substring(fileName.indexOf("filename=\"")).replace("\"","");

            try(InputStream inputStream = conn.getInputStream();ByteArrayOutputStream baos = new ByteArrayOutputStream()){
                // read from the stream
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int code = conn.getResponseCode();

                logger.debug(String.format("return status code = %d",code));
                if(code == 200){

                }
                byte[] content = new byte[ 2048 ];
                int bytesRead = -1;
                while( ( bytesRead = inputStream.read( content ) ) != -1 ) {
                    baos.write( content, 0, bytesRead );
                } // while
                byte[] ret = baos.toByteArray();

                inputStream.close();
                baos.close();
                return ret;
            }
        }
        finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
