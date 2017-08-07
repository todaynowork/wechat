package com.tn.wechat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(path = "/json")
    String helloJson(){
        return "{\"msg\":\"hello\"}";
    }
}
