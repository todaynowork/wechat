package com.tn.wechat.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.wechat.dao.CourseDao;
import com.tn.wechat.entity.Course;

@RestController
public class CourseJson {
	@RequestMapping(path="/coursejson")
	Map<String, Object> returnCourse() {
	//List<Object> returnCourse() {
			// return map
			Map<String, Object> courseMap = new HashMap<String, Object>();
			CourseDao courseDao = new CourseDao();
			// get courselist
			List<Course> courseList = new ArrayList<Course>();
			courseList = courseDao.getCourseInfo();
			
			List<Object> courseList1 = new ArrayList<Object>();
			
			for (Course course : courseList) {
//				courseMap.put("id", course.getId());
//				courseMap.put("courseName", course.getCourseName());
//				courseMap.put("courseRate", course.getCourseRate());
//				courseMap.put("courseDetail", course.getCourseDetail());
//				courseList1.add(courseMap);
				courseMap.put(Integer.toString(course.getId()), course);
				
			}
			return courseMap;
		}
}
