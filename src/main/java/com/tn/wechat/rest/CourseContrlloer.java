package com.tn.wechat.rest;

import com.mybatis.Course;
import com.mybatis.cli.CourseMapper;
import com.tn.wechat.util.IMyUtils;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/course")
public class CourseContrlloer {
	
	 private CourseMapper courseMapper;

	 
	    private IMyUtils utils;
	    
	    @Autowired
	    public void CourseMapper(CourseMapper courseMapper) {
	        this.courseMapper = courseMapper;

	    }

	    @Autowired
	    public void setUtils(IMyUtils utils){
	        this.utils = utils;
	    }
	    
	    @GetMapping("/all")
	    public @ResponseBody
	    List<Course> allCourses() {
	        System.out.println("test dev tool 111");
	        return courseMapper.selectAllCourses();
	    }
	    
	    @GetMapping("/{courseId}")
	    public @ResponseBody
	    Course getCourseById(@PathVariable Integer courseId, HttpSession session) {
	    		return courseMapper.selectByPrimaryKey(courseId);
	    }
	    
	//    @PostMapping("/create")
	//    public @ResponseBody
	//    Course createCourse(@RequestBody Course course) {
	//    		course.setUpdateTime(utils.getCurrentTimeStamp());
	//    		courseMapper.insert(course);
//	        if(course.getId()==null){
//	        		System.out.println("there is no course in the db.");
//	           // this.questionMapper.insert(question);
//	        }else {
//	        		System.out.println("there are some courses in the db.");
//	            //this.questionMapper.updateByPrimaryKey(question);
//	        }

	  //      return null;
	    //}
	    
	  //  @PostMapping("")
	   // public @ResponseBody
//	    Course createCourse(@RequestBody Course course) {
//	    		course.setUpdateTime(utils.getCurrentTimeStamp());
//	        if(course.getId()==null){
//	        		System.out.println("there is no course in the db.");
//	           // this.questionMapper.insert(question);
//	        }else {
//	        		System.out.println("there are some courses in the db.");
//	            //this.questionMapper.updateByPrimaryKey(question);
//	        }
//
//	        return null;
//	    }

}
