package com.tn.wechat.rest;

import com.mybatis.CourseParticipantKey;
import com.mybatis.CourseSchedule;
import com.mybatis.CourseParticipant;
import com.mybatis.User;
import com.mybatis.cli.CourseParticipantMapper;
import com.mybatis.cli.CourseScheduleMapper;
import com.mybatis.cli.UserMapper;
import com.tn.wechat.util.IMyUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/courseParticipant")
public class CourseParticipantContrlloer {
	
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

	@PostMapping("/checkin")
	public @ResponseBody
	Map<String, Object> loginPostTest(@RequestBody String inputParmForCheckIn, HttpSession session){
		//input format {"userId":1,"courseScheduleId":5,"mail":"1234@1234.com"}
//        session.setAttribute("WECHAT_OPENID","123456");
		JSONObject inputParmObj= new JSONObject(inputParmForCheckIn);
//		String open_id = (String) session.getAttribute("WECHAT_OPENID");
		User user = userMapper.selectByPrimaryKey((Integer) inputParmObj.get("userId"));
		Map<String, Object> map = new HashMap<>();
		String email = (String) inputParmObj.get("mail");
		if(email == null || email.equals("")){
			if (user.getEmail() == null){
				map.put("message","Please add mail ID");
				return map;
			}
			email = user.getEmail();
		}
		if (!email.equals(user.getEmail())){
			user.setEmail(email);
			user.setUpdateTime(new Date());
			userMapper.updateByPrimaryKey(user);
		}
//		CourseParticipant courseParticipant = null;
		CourseParticipantKey courseParticipantKey = new CourseParticipantKey();
		courseParticipantKey.setParticipantId(user.getId());
		courseParticipantKey.setCourseScheduleId((Integer) inputParmObj.get("courseScheduleId"));
		CourseParticipant courseParticipant = courseParticipantMapper.selectByPrimaryKey(courseParticipantKey);
		if (courseParticipant == null){
			map.put("message","Course not register");
			return map;
		}
		courseParticipant.setCheckIn(1);
		courseParticipant.setParticipantId(user.getId());
		courseParticipant.setCourseScheduleId((Integer) inputParmObj.get("courseScheduleId"));
		courseParticipant.setUpdateTime(new Date());
		courseParticipantMapper.updateByPrimaryKey(courseParticipant);
		map.put("message","checkin successful");
		return map;
	}

	@GetMapping("/getCheckedin")
	public @ResponseBody
	List<CourseParticipant> participantCoursesByCheckin() {
		return courseParticipantMapper.selectParticipatedCoursesByCheckin(1);
	}

//	@GetMapping("/getTeacher")
//	public @ResponseBody
//	List<CourseParticipant> participantCoursesByType() {
//		return courseParticipantMapper.selectParticipatedCoursesByType('T');
//	}

//	@GetMapping("/getTeacherBySheduleId/{scheduleId}")
//	public @ResponseBody
//	List<CourseParticipant> getTeacherBySheduleId(@PathVariable Integer scheduleId) {
//		System.out.println(scheduleId);
//		char type = 'T';
//		return courseParticipantMapper.selectParticipatedCoursesByTypeAndId(type,scheduleId);
//	}




//    @PostMapping("/checkin")
//    public @ResponseBody
//    Map<String, Object> loginPostTest(@RequestBody InputParmForCheckIn inputParmForCheckIn, HttpSession session){
//        //input format {"courseParticipantKey":{"courseScheduleId":5,"participantId":1},"mail":"1234@1234.com"}
//        System.out.println(inputParmForCheckIn.getCourseParticipantKey().getParticipantId());
//        System.out.println(inputParmForCheckIn.getCourseParticipantKey().getCourseScheduleId());
//        System.out.println(inputParmForCheckIn.getMail());
//        CourseParticipant courseParticipant = new CourseParticipant();
//        User user = new User();
//        Map<String, Object> map = new HashMap<>();
//        if(inputParmForCheckIn.getMail() == null){
//
//            map.put("message","Please add mail ID");
//            return map;
//        }
//
//        updateMailByUser(inputParmForCheckIn.getCourseParticipantKey().getParticipantId(),inputParmForCheckIn.getMail());
//
//        courseParticipant.setCheckIn(1);
//        courseParticipant.setParticipantId(inputParmForCheckIn.getCourseParticipantKey().getParticipantId());
//        courseParticipant.setCourseScheduleId(inputParmForCheckIn.getCourseParticipantKey().getCourseScheduleId());
//        courseParticipant.setUpdateTime(new Date());
//        courseParticipantMapper.updateByPrimaryKey(courseParticipant);
//        map.put("message","successful");
//
////        courseParticipantMapper.updateByPrimaryKey(courseParticipantKey);
////        List<CourseParticipant> list = null;
////        list = allParticipant();
////        CourseParticipantKey courseParticipantKey = null;
////        courseParticipantKey.setParticipantId(body.get("participantId"));
////        map.put("message",list);
//        return map;
//    }
//
//
////    @GetMapping("/{courseId}")
////    public @ResponseBody
////    Course getCourseById(@PathVariable Integer courseId, HttpSession session) {
////        return courseParticipantMapper.selectByPrimaryKey(courseId);
////    }
}

//class InputParmForCheckIn{
//	private Integer courseScheduleId;
//	private String mail;
//	public Integer getCourseScheduleId() {
//		return courseScheduleId;
//	}
//
//	public void setCourseScheduleId(Integer courseScheduleId) {
//		this.courseScheduleId = courseScheduleId;
//	}
//
//	public String getMail() {
//		return mail;
//	}
//
//	public void setMail(String mail) {
//		this.mail = mail;
//	}
//
//class InputParmForCheckIn{
//    private CourseParticipantKey courseParticipantKey;
//    private String mail;
//    public CourseParticipantKey getCourseParticipantKey() {
//        return courseParticipantKey;
//    }
//
//    public void setCourseParticipantKey(CourseParticipantKey courseParticipantKey) {
//        this.courseParticipantKey = courseParticipantKey;
//    }
//
//    public String getMail() {
//        return mail;
//    }
//
//    public void setMail(String mail) {
//        this.mail = mail;
//    }
//}


//}
