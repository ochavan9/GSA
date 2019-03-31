package com.gvr.gsaApp.organisation;

import java.io.Serializable;

public class Organisation implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	
	public Organisation() {}	//Required for XML Serializer
	public Organisation(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Organisation [id=" + id + ", name=" + name + "]";
	}

}
