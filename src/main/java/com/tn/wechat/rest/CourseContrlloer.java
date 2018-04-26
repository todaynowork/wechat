package com.tn.wechat.rest;

import com.mybatis.Course;
import com.mybatis.User;
import com.mybatis.cli.CourseMapper;
import com.mybatis.cli.UserMapper;
import com.tn.wechat.util.IMyUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/course")
public class CourseContrlloer {
	
	 private CourseMapper courseMapper;
	 private UserMapper userMapper;
	
	// @Autowired
	// Course course = new Course();

	 
	    private IMyUtils utils;
	    
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
	    
	    @RequestMapping(value="/add", method=RequestMethod.POST)
	    public int addCourses(Course course, @RequestParam("title") String title,@RequestParam("desc") String desc, 
	    		@RequestParam("memo") String memo, @RequestParam("creatorid") int creatorId) {
	    		System.out.println("Good good study, Day day up"+title);
	    		System.out.println("Good good study, Day day up"+desc);
	    		System.out.println("Good good study, Day day up"+memo);
	    		System.out.println("Good good study, Day day up"+creatorId);
	    		System.out.println("Good good study, Day day up"+course.toString()+"Day day up,Good good study");
	    		course.setTitle(title);
	    		course.setDesc(desc);
	    		course.setMemo(memo);
	    		course.setUpdateTime(new Date());
	    		course.setCreatorId(creatorId);
//	    		course.setCreatorId(88);
	    		return courseMapper.insert(course);
	    		//return 0;
	    }
	    
	    @RequestMapping("/index")  
	    public ModelAndView index(HttpServletRequest request, @RequestParam(value = "name", required = false, defaultValue = "springboot-thymeleaf") String name) {  
	    		System.out.println("sssssssssssssss");
	    		ModelAndView mav = new ModelAndView();
	    		request.setAttribute("name", name);
	    		mav.setViewName("test");
			return mav;
	    }  
	    
		@RequestMapping("/index1")
		public ModelAndView virtualProjectForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
				ModelAndView mav = new ModelAndView();
				mav.setViewName("test");
				return mav;


		}
		
		@PostMapping("/home")
        public String homePage(HttpServletRequest request, HttpServletResponse response) throws IOException{
			String coursetitle = request.getParameter("coursetitle");
			String coursedesc = request.getParameter("coursedesc");
			System.out.println("course title is " + coursetitle);
			System.out.println("course desc is " + coursedesc);
            return "test2";
        }
		
		@RequestMapping("/home1")
        public String homePage1(Model model){
			List<User> userInfo = userMapper.selectAllUsers();
			model.addAttribute("userInfo",userInfo);
			for (int i = 0; i < userInfo.size(); i++) {
				System.out.println("userInfo list is "+userInfo.get(i).getNickName());
			}
            return "test";
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
