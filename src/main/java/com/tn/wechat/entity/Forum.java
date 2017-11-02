package com.tn.wechat.entity;

public class Forum {
	private String openid;
	private String userName;
	private String topic;
	private String detail;
	private String forum_date;
	private String forum_tag;
	private int id;

	/**
	 * Getter & Setter
	 */
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getForum_tag() {
		return forum_tag;
	}

	public void setForum_tag(String forum_tag) {
		this.forum_tag = forum_tag;
	}

	public String getForum_date() {
		return forum_date;
	}

	public void setForum_date(String forum_date) {
		this.forum_date = forum_date;
	}
	
	// override toString return json string
	// {"openid":"20171031","topic":"java classpath","detail":"how to config
	// java classpath","id":0,"userName":"wechat"}
	@Override
	public String toString() {
		return "{\"openid\":\"" + this.getOpenid() + "\",\"username\":\"" + this.getUserName() + "\",\"topic\":\""
				+ this.getTopic() + "\",\"detail\":\"" + this.getDetail() + "\",\"id\":\"" + this.getId()
				+ "\",\"forum_tag\":\"" + this.getForum_tag()+"\",\"forum_date\":\""+this.getForum_date()+"\"}";
	}

}
