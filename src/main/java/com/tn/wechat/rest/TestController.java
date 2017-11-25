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

    private AnswerMapper answer;

    @Autowired
    public void setAnswer(AnswerMapper answer){
        this.answer = answer;
    }

    @Autowired
    public void setQuestionsMapper(QuestionMapper questionsMapper){
        this.questionsMapper = questionsMapper;
    }

    private QuestionMapper questionsMapper;

    @Autowired
    public void setUsersMapper(UserMapper usersMapper){
        this.usersMapper = usersMapper;

    }

    private UserMapper usersMapper;


    @RequestMapping(path = "/json")
    Question helloJson(){
        User user = null;
        try{
            user = new User();
            user.setOpenId("123456");
            user.setEmail("ddddd");
            user.setNickName("dddddddccc");
            user.setAvatarUrl("dddddddccc");

            usersMapper.insert(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        user = usersMapper.selectByOpenId("123456");

        Question ques= new Question();

        ques.setDesc("ddddesc");
        ques.setOwner(user.getId());

        questionsMapper.insert(ques);
        return questionsMapper.selectByPrimaryKeyWithAnswer( ques.getId());
    }
}
