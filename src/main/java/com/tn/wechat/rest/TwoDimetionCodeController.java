package com.tn.wechat.rest;

import com.mybatis.TwoDimentionCode;
import com.mybatis.TwoDimentionCodeExample;
import com.mybatis.cli.TwoDimentionCodeMapper;
import com.tn.wechat.repo.AliOSSImageRepo;
import com.tn.wechat.repo.IImageRepository;
import com.tn.wechat.repo.TempFileImageRepo;
import com.tn.wechat.util.IMyUtils;
import com.tn.wechat.util.WechatUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/2_d_code")
public class TwoDimetionCodeController {

    private IMyUtils utils;
    private IImageRepository repository;

    @Autowired
    public void setUtils(IMyUtils utils){
        this.utils = utils;
    }

    @Autowired
    public void setImageRepository(IImageRepository repository){
        this.repository = repository;
    }


//    @Bean
//    @Profile("production")
//    public  IImageRepository createImgRepository(){
//        return new AliOSSImageRepo();
//    }
//
//
//    @Bean
//    @Profile("dev")
//    public  IImageRepository createImgRepositoryTmp(){
//        return new TempFileImageRepo();
//    }

    private WechatUtils wechatUtils;

    @Autowired
    private void setWechatUtils(WechatUtils wechatUtils){
        this.wechatUtils = wechatUtils;
    }

    private TwoDimentionCodeMapper twoDimentionCodeMapper;

    @Autowired
    public void setTwoDimentionCodeMapper(TwoDimentionCodeMapper twoDimentionCodeMapper){
        this.twoDimentionCodeMapper = twoDimentionCodeMapper;
    }

    private static final Logger logger = LoggerFactory.getLogger(TwoDimetionCodeController.class);

//    //二维码存放目录
//    private String twoDCodeLocation = "/tmp/";

    @PostMapping("")
    public TwoDimentionCode create2dCode(@RequestBody String body){
        TwoDimentionCodeExample twoDimentionCodeExample = new TwoDimentionCodeExample();

        JSONObject bodyObj= new JSONObject(body);
        String scene = bodyObj.getString("scene");
        Integer objectId = bodyObj.getInt("objectId");
        boolean isReNew = false;
        if(!bodyObj.isNull("replace"))
            isReNew = bodyObj.getBoolean("replace");
        TwoDimentionCode twoDimentionCode = null;
        twoDimentionCodeExample.createCriteria().andSceneEqualTo(scene).andObjectIdEqualTo(objectId);

        List<TwoDimentionCode> lst= twoDimentionCodeMapper.selectByExample(twoDimentionCodeExample);


        if(lst!=null && lst.size() >0){
            twoDimentionCode = lst.get(0);
            String fileName = twoDimentionCode.getFileName();
            if(isReNew == true || !repository.isExist(fileName)){
                twoDimentionCode = getTwoDimentionCode(bodyObj, twoDimentionCode.getId(),twoDimentionCode.getFileName());
            }
        }else{
            String fileName = utils.generateFileName(null);
            twoDimentionCode = getTwoDimentionCode(bodyObj, null,fileName);
        }
        return twoDimentionCode;
    }

    @GetMapping("")
    public TwoDimentionCode retrieve2dCode(@RequestParam("scene") String scene, @RequestParam("objectId") Integer objectId){
        TwoDimentionCodeExample twoDimentionCodeExample = new TwoDimentionCodeExample();

//        JSONObject bodyObj= new JSONObject(body);
//        String scene = bodyObj.getString("scene");
//        Integer objectId = bodyObj.getInt("objectId");
        TwoDimentionCode twoDimentionCode = null;
        twoDimentionCodeExample.createCriteria().andSceneEqualTo(scene).andObjectIdEqualTo(objectId);

        List<TwoDimentionCode> lst= twoDimentionCodeMapper.selectByExample(twoDimentionCodeExample);


        if(lst!=null && lst.size() >0){
            twoDimentionCode = lst.get(0);
        }
        return twoDimentionCode;
    }

    private TwoDimentionCode getTwoDimentionCode(JSONObject bodyObj, Integer id,String fileName) {
//        String access_token = userController.getAccess_token();
        String scene = bodyObj.getString("scene");
        Integer objectId = bodyObj.getInt("objectId");
        TwoDimentionCode twoDimentionCode = null;
//        String apiUrl = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=%s";
        byte[] jpg = wechatUtils.get2DCode(bodyObj);
        logger.debug(new String(jpg));
        logger.debug(String.format("file retrieve from backend, size is %d",jpg.length));
        if(repository.addImage(fileName,jpg)){
            twoDimentionCode = new TwoDimentionCode();
            if(id!=null)
                twoDimentionCode.setId(id);
            twoDimentionCode.setFileName(fileName);
            twoDimentionCode.setObjectId(objectId);
            twoDimentionCode.setScene(scene);
            twoDimentionCode.setWechatConf(bodyObj.get("wechatConf").toString());
            if(id!=null)
                twoDimentionCodeMapper.updateByPrimaryKey(twoDimentionCode);
            else
                twoDimentionCodeMapper.insert(twoDimentionCode);
        }
        return twoDimentionCode;
    }




    @GetMapping("/img/{filenName}/")
    public ResponseEntity<byte[]> get2dCode(@PathVariable String filenName) throws IOException {

        byte[] data = repository.getImageById(filenName);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).contentLength(data.length).body(data);

    }
}
