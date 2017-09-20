package com.tn.wechat.entity;

public class Reply {
	private int id;
	private String description;
	private int forumId;

	/**
	 * Getter & Setter
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + this.getId() + "\"," + "\"description\":\"" + this.getDescription() + "\",\"forumid\":\""
				+ this.getForumId() + "\"}";
	}

}
