package com.gvr.gsaApp.device;

import java.io.Serializable;

//class Device{}
public class Device implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String manufactureName;
	private String serialNumber;
	private String status;
	private String type;
	private int siteId;
	
	public Device() {} // Required by XML Serializer
	public Device(int id, String name, String manufactureName, String serialNumber, String status, String type, int siteId) {	
		this.id = id;
		this.name = name;
		this.manufactureName = manufactureName;
		this.serialNumber = serialNumber;
		this.status = status;
		this.type = type;
		this.siteId = siteId;
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

	public String getManufactureName() {
		return manufactureName;
	}

	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", manufactureName=" + manufactureName + ", serialNumber="
				+ serialNumber + ", status=" + status + ", type=" + type + ", siteId=" + siteId + "]";
	}
	

}
