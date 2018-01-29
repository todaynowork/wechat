package com.tn.wechat.repo;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Profile("production")
@Component
public class AliOSSImageRepo implements IImageRepository {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        ossClient.shutdown();
    }

    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
    @Value( "${ali.oss.access.key.id}" )
    String accessKeyId = "";
    @Value( "${ali.oss.access.key.secret}" )
    String accessKeySecret = "";

    @Value( "${ali.oss.2d.code.bucket.name}" )
    String defaultBucketName = "wechat-2dcode";
    // 华北2 endpoint以杭州为例，其它region请按实际情况填写 //oss-cn-beijing-internal.aliyuncs.com https://help.aliyun.com/document_detail/31837.html?spm=5176.doc31839.6.581.sm2Dl4
    @Value( "${ali.oss.endpoint}" )
    String endpoint = "http://oss-cn-beijing.aliyuncs.com";

    OSSClient ossClient = null;
    public AliOSSImageRepo(){

        // 创建OSSClient实例
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 使用访问OSS

    }

    @Override
    public boolean addImage(String key, byte[] content, String... attributes) {

        PutObjectResult putObjectResult = ossClient.putObject(defaultBucketName, key, new ByteArrayInputStream(content));
        return putObjectResult.getRequestId()!=null && !putObjectResult.getRequestId().isEmpty();
    }

    @Override
    public boolean delImage(String key, String... attributes) {
        ossClient.deleteObject(defaultBucketName,key);
        return true;
    }

    @Override
    public boolean isExist(String id, String... attributes) {
        return ossClient.doesObjectExist(defaultBucketName,id);
    }

    @Override
    public byte[] getImageById(String key, String... attributes) {
        OSSObject ossObject = ossClient.getObject(defaultBucketName, key);
        int nRead;
        byte[] data = new byte[1024];
        byte[] image = null;
        try (InputStream is =  ossObject.getObjectContent();ByteArrayOutputStream buffer = new ByteArrayOutputStream();){
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            buffer.flush();
            image = buffer.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static void main(String[] args){
        AliOSSImageRepo aliOSSImageRepo = new AliOSSImageRepo();

        aliOSSImageRepo.addImage("test","abcd".getBytes());

    }
}
