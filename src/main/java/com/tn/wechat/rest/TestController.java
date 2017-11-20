package com.tn.wechat.rest;

import com.mybatis.Question;
import com.mybatis.User;
import com.mybatis.cli.AnswerMapper;
import com.mybatis.cli.QuestionMapper;
import com.mybatis.cli.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    AnswerMapper answer;

    @Autowired
    QuestionMapper questionsMapper;

    @Autowired
    UserMapper usersMapper;


    @RequestMapping(path = "/json")
    String helloJson(){

        User user = new User();
        user.setOpenId("123456");
        user.setEmail("ddddd");
        user.setNickName("dddddddccc");
        user.setAvatorUrl("dddddddccc");

        usersMapper.insert(user);

        Question ques= new Question();

        ques.setDesc("ddddesc");
        ques.setOwner("123456");

        questionsMapper.insert(ques);
        answer.selectByPrimaryKey( new Integer(1));
        return "{\"msg\":\"hello\"}";
    }
}
