package com.tn.wechat.rest;

import com.mybatis.Answer;
import com.mybatis.Course;
import com.mybatis.CourseSchedule;
import com.mybatis.Question;
import com.mybatis.User;
import com.mybatis.cli.AnswerMapper;
import com.mybatis.cli.CourseScheduleMapper;
import com.mybatis.cli.CourseMapper;
import com.mybatis.cli.QuestionMapper;
import com.mybatis.cli.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;

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
    private CourseMapper courseMapper;
    @Autowired
    private CourseScheduleMapper courseScheduleMapper;

    @Autowired
    public void setUsersMapper(UserMapper usersMapper){
        this.usersMapper = usersMapper;

    }
    @Autowired
    private AnswerMapper answerMapper;

    private UserMapper usersMapper;


    @RequestMapping(path = "/json")
    Question helloJson(){
        User user = null;
        user = usersMapper.selectByOpenId("123456");
        try{
            if(user==null){
                user = new User();
                user.setOpenId("123456");
                user.setEmail("ddddd");
                user.setNickName("dddddddccc");
                user.setAvatarUrl("dddddddccc");
                user.setUpdateTime(new Date());
                usersMapper.insert(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        Question ques= new Question();

        ques.setDesc("ddddesc");
        ques.setOwner(user.getId());
        ques.setUpdateTime(new Date());

        questionsMapper.insert(ques);

        Answer answer = new Answer();
        answer.setDesc("bbbb");
        answer.setUserId(user.getId());
        answer.setQuestionId(ques.getId());
        answer.setUpdateTime(new Date());
        answerMapper.insert(answer);

        return questionsMapper.selectByPrimaryKeyWithAnswer( ques.getId());
    }
    
    
    @RequestMapping(path = "/add")
   	void addCourseJson(){
    	 User user = null;
    	 
    	 Course course = null;
 
    	 
     user = usersMapper.selectByOpenId("123456");
     course = courseMapper.selectByCourseId(5);
     
     CourseSchedule courseSchedule = new CourseSchedule();
     courseSchedule.setId(1);
     courseSchedule.setStartTime(new Date());
     courseSchedule.setEndEndtime(new Date());
     courseSchedule.setUpdateTime(new Date());
     courseSchedule.setCourseId(course.getId());
         
       // Course course = new Course();
      //  course.setTitle("C++ Foundation");
       // course.setDesc("I like C++ Program very much.");
       // course.setMemo("This is C++ foundation course, welcome to join this training and pls attend it on time.");
       // course.setCreatorId(user.getId());
       // course.setUpdateTime(new Date());
       // course.setId(2);


        courseScheduleMapper.insert(courseSchedule);

    }
}
