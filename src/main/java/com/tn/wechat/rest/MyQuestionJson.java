package com.tn.wechat.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.wechat.dao.ForumDao;
import com.tn.wechat.dao.ReplyDao;
import com.tn.wechat.dao.UserDao;
import com.tn.wechat.entity.Forum;
import com.tn.wechat.entity.User;

@RestController
public class MyQuestionJson extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String openid;
	
	//get openid through servlet
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		openid = request.getParameter("openid");
	}
	
	//return my question json
	@RequestMapping(path="/myquestionjson")
	Map<String, Object> returnReply() {
		// return map
		Map<String, Object> myQuestionMap = new HashMap<String, Object>();
		ForumDao forumDao = new ForumDao();
		// get favorite list
		List<Forum> forumList = new ArrayList<Forum>();
		forumList = forumDao.getMyQuestion(openid);
		// get forum
		for (Forum forum : forumList) {
			myQuestionMap.put("topic",forum.getTopic());
			myQuestionMap.put("date",forum.getForum_date());
		}
		return myQuestionMap;
	}

}
