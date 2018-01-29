package com.tn.wechat.repo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Profile("dev")
@Component
public class TempFileImageRepo implements IImageRepository{

    //二维码存放目录
    private String twoDCodeLocation = "/tmp/";

    @Override
    public boolean addImage(String fileName, byte[] content, String... attributes) {
        boolean isSuccess =false;
        File filePath = new File(twoDCodeLocation + fileName);
        try(OutputStream out = new BufferedOutputStream(new FileOutputStream(filePath))) {
            out.write(content);
            out.flush();
            out.close();
            isSuccess = true;
        }catch (IOException io){
            io.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean delImage(String fileName, String... attributes) {
        boolean isSuccess =false;
        try {
            Files.delete(Paths.get(twoDCodeLocation + fileName));
            isSuccess = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean isExist(String fileName, String... attributes) {
        return Files.exists(Paths.get(twoDCodeLocation + fileName));
    }

    @Override
    public byte[] getImageById(String filenName, String... attributes) {

        Path path = Paths.get(twoDCodeLocation + filenName);
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
