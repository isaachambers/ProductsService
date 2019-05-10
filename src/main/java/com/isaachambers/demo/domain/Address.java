package com.isaachambers.demo.domain;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String streetName;
	private String city;
	private String country;

	public Address() {

	}

	public Address(String id, String streetName, String city, String country) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.city = city;
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
