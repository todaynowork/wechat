package com.tn.wechat.rest;

import com.mybatis.TwoDimentionCode;
import com.mybatis.TwoDimentionCodeExample;
import com.mybatis.cli.TwoDimentionCodeMapper;
import com.tn.wechat.util.IMyUtils;
import com.tn.wechat.util.WechatUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public void setUtils(IMyUtils utils){
        this.utils = utils;
    }


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


    //二维码存放目录
    private String twoDCodeLocation = "/tmp/";

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
            if(isReNew == true){
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

        JSONObject bodyObj= new JSONObject(body);
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

//        String fileName = utils.generateFileName(null);
        File filePath = new File(twoDCodeLocation + fileName);
        try(OutputStream out = new BufferedOutputStream(new FileOutputStream(filePath))) {
            out.write(jpg);
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return twoDimentionCode;
    }




    @GetMapping("/{filenName}/")
    public ResponseEntity<byte[]> get2dCode(@PathVariable String filenName) throws IOException {
        Path path = Paths.get(twoDCodeLocation + filenName);
        byte[] data = Files.readAllBytes(path);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).contentLength(data.length).body(data);

    }
}
