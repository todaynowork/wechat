package com.tn.wechat.rest;

import com.mybatis.Course;
import com.mybatis.CourseSchedule;
import com.mybatis.User;
import com.mybatis.cli.CourseMapper;
import com.mybatis.cli.CourseScheduleMapper;
import com.mybatis.cli.UserMapper;
import com.tn.wechat.util.IMyUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/coursemanage")
public class CourseAddContrlloer {
	
	 private CourseMapper courseMapper;
	 private UserMapper userMapper;
	 private IMyUtils utils;
	 
	 @Autowired
	    private CourseScheduleMapper courseScheduleMapper;
	    
	  @Autowired
	    public void CourseMapper(CourseMapper courseMapper) {
	        this.courseMapper = courseMapper;

	    }
	    
	    @Autowired
	    public void UserMapper(UserMapper userMapper) {
	        this.userMapper = userMapper;

	    }

	    @Autowired
	    public void setUtils(IMyUtils utils){
	        this.utils = utils;
	    }

	    @RequestMapping("/addcourse")
        public String homePage1(Model model){
			List<User> userInfo = userMapper.selectAllUsers();
			model.addAttribute("userInfo",userInfo);
			for (int i = 0; i < userInfo.size(); i++) {
				System.out.println("userInfo list is "+userInfo.get(i).getNickName());
			}
            return "courseInfo";
        }
	    
		
		@PostMapping("/homepage")
        public String homePage(HttpServletRequest request, HttpServletResponse response,Course course) throws IOException{
			/*
			 * @RequestParam("title") String title,@RequestParam("desc") String desc, 
	    		@RequestParam("memo") String memo, @RequestParam("creatorid") int creatorId
			 */
			String title = request.getParameter("coursetitle");
			String desc = request.getParameter("coursedesc");
			String memo = request.getParameter("coursememo");
			String id = request.getParameter("teacherName");
			int tearcherId = Integer.valueOf(id).intValue();
			
			course.setTitle(title);
    			course.setDesc(desc);
    			course.setMemo(memo);
    			course.setUpdateTime(new Date());
    			course.setCreatorId(tearcherId);
    			
    			courseMapper.insert(course);	
            
            return "successPage";
        }
		
		 @RequestMapping(path = "/showCourseSchedule")
		 public String showCourseSchedule(Model model) {
		     List<Course> courseInfo = courseMapper.selectAllCourses();
		     model.addAttribute("courseInfo",courseInfo);	     
//		     CourseSchedule courseSchedule = new CourseSchedule();
//		     courseSchedule.setId(1);
//		     courseSchedule.setStartTime(new Date());
//		     courseSchedule.setEndEndtime(new Date());
//		     courseSchedule.setUpdateTime(new Date());
//		     courseSchedule.setCourseId(course.getId());
		         
		       // Course course = new Course();
		      //  course.setTitle("C++ Foundation");
		       // course.setDesc("I like C++ Program very much.");
		       // course.setMemo("This is C++ foundation course, welcome to join this training and pls attend it on time.");
		       // course.setCreatorId(user.getId());
		       // course.setUpdateTime(new Date());
		       // course.setId(2);

		        //courseScheduleMapper.insert(courseSchedule);
		     	return "courseScheduleInfo";
		    }
		 
			
		 @RequestMapping(path = "/addCourseSchedule")
		 public String addCourseSchedule(HttpServletRequest request, HttpServletResponse response,CourseSchedule courseSchedule, Course course) {
			 
			
			 
			 String courseId = request.getParameter("courseName");
				String location = request.getParameter("location");
				int id = Integer.valueOf(courseId).intValue();
				
				 course = courseMapper.selectByCourseId(id);
				 
				System.out.println("course name is "+courseId);
				System.out.println("location is "+location);
				System.out.println("111111111111111111111111111111111111");
				System.out.println("course get id is "+course.getId());
				courseSchedule.setCourseId(course.getId());
			     courseSchedule.setStartTime(new Date());
			     courseSchedule.setEndEndtime(new Date());
			     courseSchedule.setUpdateTime(new Date());
				courseSchedule.setLocation(location);
				
				
//				String memo = request.getParameter("coursememo");
//				String id = request.getParameter("teacherName");
//				int tearcherId = Integer.valueOf(id).intValue();


//		     courseSchedule.setUpdateTime(new Date());
//		     courseSchedule.setCourseId(course.getId());
		         
		       // Course course = new Course();
		      //  course.setTitle("C++ Foundation");
		       // course.setDesc("I like C++ Program very much.");
		       // course.setMemo("This is C++ foundation course, welcome to join this training and pls attend it on time.");
		       // course.setCreatorId(user.getId());
		       // course.setUpdateTime(new Date());
		       // course.setId(2);

		        courseScheduleMapper.insert(courseSchedule);
		     	return "courseScheduleInfo";
		    }
	 
}
