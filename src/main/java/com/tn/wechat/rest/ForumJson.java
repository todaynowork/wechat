package com.tn.wechat.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.wechat.dao.ForumDao;
import com.tn.wechat.entity.Forum;

@RestController
public class ForumJson {
	@RequestMapping(path="/forumjson")
	Map<String, Object> returnForum() {
			// return map
			Map<String, Object> forumMap = new HashMap<String, Object>();
			ForumDao forumDao = new ForumDao();
			// get forumlist
			List<Forum> forumList = new ArrayList<Forum>();
			forumList = forumDao.getForumInfo();
			// get forum
			Forum forum = new Forum();
			forum = forumList.get(0);
			//add attribute to map
			forumMap.put("openid", forum.getOpenid());
			forumMap.put("userName", forum.getUserName());
			forumMap.put("topic", forum.getTopic());
			forumMap.put("detail", forum.getDetail());
			forumMap.put("id", forum.getId());
			return forumMap;
		}
}
