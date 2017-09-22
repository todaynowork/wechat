package com.tn.wechat.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.wechat.dao.ReplyDao;
import com.tn.wechat.entity.Reply;

@RestController
public class ReplyJson {
	@RequestMapping(path="/replyjson")
	Map<String, Object> returnReply() {
			// return map
			Map<String, Object> replyMap = new HashMap<String, Object>();
			ReplyDao replyDao = new ReplyDao();
			// get repylist
			List<Reply> replyList = new ArrayList<Reply>();
			replyList = replyDao.getReplyInfo();
			// get forum
			for (Reply reply : replyList) {
				replyMap.put(Integer.toString(reply.getId()), reply.toString());
			}
			return replyMap;
		}
}
