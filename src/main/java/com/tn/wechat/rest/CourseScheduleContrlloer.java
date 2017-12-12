package com.tn.wechat.rest;

import com.mybatis.CourseSchedule;
import com.mybatis.cli.CourseScheduleMapper;
import com.tn.wechat.util.IMyUtils;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/courseSchedule")
public class CourseScheduleContrlloer {
	
	 private CourseScheduleMapper courseScheduleMapper;

	 
	    private IMyUtils utils;
	    
	    @Autowired
	    public void CourseScheduleMapper(CourseScheduleMapper courseScheduleMapper) {
	        this.courseScheduleMapper = courseScheduleMapper;

	    }

	    @Autowired
	    public void setUtils(IMyUtils utils){
	        this.utils = utils;
	    }
	    
	    @GetMapping("/all")
	    public @ResponseBody
	    List<CourseSchedule> allScheduleCourses() {
	        System.out.println("test dev tool 111");
	        //return courseMapper.selectAllCourses();
	        //return courseScheduleMapper.selectAllScheduledCourses();
	        return courseScheduleMapper.selectAllScheduledCourses();
	    }
	    
	    @GetMapping("/{courseScheduleId}")
	    public @ResponseBody
	    CourseSchedule getCourseScheduleById(@PathVariable Integer courseScheduleId, HttpSession session) {
	    		
	    		//return courseScheduleMapper.selectByPrimaryKey(courseScheduleId);
	    		return courseScheduleMapper.selectByPrimaryKeyWithCourseID(courseScheduleId);
	    		//return courseScheduleMapper.selectByCourseScheduleId(courseScheduleId);
	    		//return courseMapper.selectByPrimaryKey(courseId);
	    }
	    

}
