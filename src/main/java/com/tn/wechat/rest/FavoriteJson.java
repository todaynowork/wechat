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

import com.tn.wechat.dao.UserDao;
import com.tn.wechat.entity.User;

@RestController
public class FavoriteJson extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String openid;
	
	//get openid through servlet
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		openid = request.getParameter(openid);
	}
	//return favorite json
	@RequestMapping(path="/favoritejson")
	Map<String, Object> returnReply() {
			// return map
			Map<String, Object> favoriteMap = new HashMap<String, Object>();
			UserDao userDao = new UserDao();
			// get favorite list
			List<User> userList = new ArrayList<User>();
			userList = userDao.getUserFavorite(openid);
			// get forum
			for (User user : userList) {
				favoriteMap.put("favorite",user.getFavorite());
			}
			return favoriteMap;
		}
}
