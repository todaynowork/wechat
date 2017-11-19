package com.tn.wechat.rest;

        import com.mybatis.cli.AnswerMapper;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    AnswerMapper answer;

    @RequestMapping(path = "/json")
    String helloJson(){
        answer.selectByPrimaryKey( new Integer(1));
        return "{\"msg\":\"hello\"}";
    }
}
