package com.tn.wechat.rest.comm;


import com.tn.wechat.util.WechatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comm")
public class HandShakeController {

    private WechatUtils wechatUtils;

    private boolean isConfirmed =false;

    @Autowired
    private void setWechatUtils(WechatUtils wechatUtils){
        this.wechatUtils = wechatUtils;
    }

    @GetMapping("/handshake")
    public String handshake(@RequestParam("signature") String signature,
                            @RequestParam("timestamp") String timestamp,
                            @RequestParam("nonce") String nonce,
                            @RequestParam("echostr") String echoStr){
        isConfirmed =false;
        if( wechatUtils.checkSignature(signature,timestamp,nonce)){
            isConfirmed =true;
            return echoStr;
        }
        return null;
    }

    @PostMapping("/handshake")
    public String handle(@RequestBody String content){

        return content;
    }

}
