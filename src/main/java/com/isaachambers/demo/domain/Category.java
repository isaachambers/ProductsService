package com.isaachambers.demo.domain;

import java.io.Serializable;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String categoryName;

	public Category(String id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public Category() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
