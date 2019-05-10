package com.isaachambers.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private List<Address> address;

	public Supplier() {
		this.address = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Supplier(String id, String name, List<Address> address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
