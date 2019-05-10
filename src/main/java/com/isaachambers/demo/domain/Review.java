package com.isaachambers.demo.domain;

import java.io.Serializable;

public class Review implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String userName;
	private String comment;
	private int rating;

	public Review(String id, String userName, String comment, int rating) {
		super();
		this.id = id;
		this.userName = userName;
		this.comment = comment;
		this.rating = rating;
	}

	public Review() {

	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
