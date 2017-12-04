package com.tn.wechat.rest;

import com.mybatis.CourseParticipant;
import com.mybatis.CourseParticipantKey;
import com.mybatis.User;
import com.mybatis.cli.CourseMapper;
import com.mybatis.cli.CourseParticipantMapper;
import com.mybatis.cli.UserMapper;
import com.tn.wechat.req.Login;
import com.tn.wechat.util.IMyUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * Created by chengchao.dong on 11/30/2017.
 */
@RestController
@RequestMapping("/courseParticipant")
public class CourseParticipantController {
    private CourseParticipantMapper courseParticipantMapper;
    private UserMapper userMapper;

    private IMyUtils utils;

    @Autowired
    public void CourseParticipantMapper(CourseParticipantMapper courseParticipantMapper) {
        this.courseParticipantMapper = courseParticipantMapper;
    }

    @Autowired
    public void UserMapper (UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUtils(IMyUtils utils){
        this.utils = utils;
    }

    public void updateMailByUser(Integer userId, String mail){
        User user = null;
        user = userMapper.selectByPrimaryKey(userId);
        user.setEmail(mail);
        userMapper.updateByPrimaryKey(user);
    }

    @GetMapping("/allParticipant")
    public @ResponseBody
    List<CourseParticipant> allParticipant() {
        System.out.println("test dev tool 111");
        return courseParticipantMapper.selectAllCourseParticipant();
    }

    @GetMapping()

    @PostMapping("/getParticipant")
    //input {"courseScheduleId":5,"participantId":1};
    public @ResponseBody
    CourseParticipant getParticipant(@RequestBody CourseParticipantKey courseParticipantKey) {
        System.out.println(courseParticipantKey);
        System.out.println(courseParticipantKey.getCourseScheduleId());
        //user id
        System.out.println(courseParticipantKey.getParticipantId());
        CourseParticipant courseParticipant = new CourseParticipant();

        courseParticipant = courseParticipantMapper.selectByPrimaryKey(courseParticipantKey);
        return courseParticipant;
    }

    @PostMapping("/checkin")
    public @ResponseBody
    Map<String, Object> loginPostTest(@RequestBody InputParmForCheckIn inputParmForCheckIn, HttpSession session){
        //input format {"courseParticipantKey":{"courseScheduleId":5,"participantId":1},"mail":"1234@1234.com"}
        System.out.println(inputParmForCheckIn.getCourseParticipantKey().getParticipantId());
        System.out.println(inputParmForCheckIn.getCourseParticipantKey().getCourseScheduleId());
        System.out.println(inputParmForCheckIn.getMail());
        CourseParticipant courseParticipant = new CourseParticipant();
        User user = new User();
        Map<String, Object> map = new HashMap<>();
        if(inputParmForCheckIn.getMail() == null){
            map.put("message","Please add mail ID");
            return map;
        }

        updateMailByUser(inputParmForCheckIn.getCourseParticipantKey().getParticipantId(),inputParmForCheckIn.getMail());

        courseParticipant.setCheckIn(1);
        courseParticipant.setParticipantId(inputParmForCheckIn.getCourseParticipantKey().getParticipantId());
        courseParticipant.setCourseScheduleId(inputParmForCheckIn.getCourseParticipantKey().getCourseScheduleId());
        courseParticipant.setUpdateTime(new Date());
        courseParticipantMapper.updateByPrimaryKey(courseParticipant);
        map.put("message","successful");

//        courseParticipantMapper.updateByPrimaryKey(courseParticipantKey);
//        List<CourseParticipant> list = null;
//        list = allParticipant();
//        CourseParticipantKey courseParticipantKey = null;
//        courseParticipantKey.setParticipantId(body.get("participantId"));
//        map.put("message",list);
        return map;
    }


//    @GetMapping("/{courseId}")
//    public @ResponseBody
//    Course getCourseById(@PathVariable Integer courseId, HttpSession session) {
//        return courseParticipantMapper.selectByPrimaryKey(courseId);
//    }
}

class InputParmForCheckIn{
    private CourseParticipantKey courseParticipantKey;
    private String mail;
    public CourseParticipantKey getCourseParticipantKey() {
        return courseParticipantKey;
    }

    public void setCourseParticipantKey(CourseParticipantKey courseParticipantKey) {
        this.courseParticipantKey = courseParticipantKey;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
