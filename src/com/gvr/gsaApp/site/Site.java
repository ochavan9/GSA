package com.gvr.gsaApp.site;

import java.io.Serializable;

public class Site implements Comparable<Site>, Serializable {

	private static final long serialVersionUID = 1L;
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

	@Override
	public String toString() {
		return "Site [id=" + id + ", name=" + name + ", address=" + address + ", orgId=" + orgId + "]";
	}
	
	@Override
	public int compareTo(Site other) {
		return (this.getId() - other.getId());
	}

}
