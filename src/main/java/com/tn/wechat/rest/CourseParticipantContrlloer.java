package com.tn.wechat.rest;

import com.mybatis.CourseSchedule;
import com.mybatis.CourseParticipant;
import com.mybatis.cli.CourseParticipantMapper;
import com.mybatis.cli.CourseScheduleMapper;
import com.tn.wechat.util.IMyUtils;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/courseParticipant")
public class CourseParticipantContrlloer {
	
	 private CourseParticipantMapper courseParticipantMapper;

	 
	    private IMyUtils utils;
	    
	    @Autowired
	    public void CourseParticipantMapper(CourseParticipantMapper courseParticipantMapper) {
	        this.courseParticipantMapper = courseParticipantMapper;

	    }

	    @Autowired
	    public void setUtils(IMyUtils utils){
	        this.utils = utils;
	    }
	    
	    @GetMapping("/all")
	    public @ResponseBody
	    List<CourseParticipant> allParticipantCourses() {
	        System.out.println("test dev tool 111");
	        //return courseMapper.selectAllCourses();
	       // return courseScheduleMapper.selectAllScheduledCourses();
	        return courseParticipantMapper.selectAllParticipatedCourses();
	    }
	    
	    @GetMapping("/{courseParticipantId}")
	    public @ResponseBody
	    CourseParticipant getCourseParticipantById(@PathVariable Integer courseParticipantId, HttpSession session) {
	    		
	    		return courseParticipantMapper.selectByCourseParticipateId(courseParticipantId);
	    		
	    }

}
