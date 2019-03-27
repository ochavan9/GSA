package com.gvr.gsaApp.site;

public class Site {
	
	private int id;
	private String name;
	private String address;
	private int orgId;
	
	public Site() {}

	public Site(int id, String name, String address, int orgId) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.orgId = orgId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

}
