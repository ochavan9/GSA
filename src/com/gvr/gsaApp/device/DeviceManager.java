package com.gvr.gsaApp.device;

import java.util.ArrayList;
import java.util.List;

import com.gvr.gsaApp.device.Device;

public class DeviceManager {
	
	private List<Device> devices;
	
	public DeviceManager() {
		this.devices = new ArrayList<Device>();
	}

	public void addDevice() {
		Device crind = new Device(1, "Crind", "GVR", "12345678", "Offline", "M7", 1);
		devices.add(crind);
	}

	public void removeDevice(int id) {
		for (Device d : devices) {
			if(d.getId() == id) {
				devices.remove(d);
				break;
			}
		}
	}
	
	public int getNumberOfDevices() {
		return devices.size();
	}
	
	public Device getDeviceById(int id) {
		for (Device d : devices) {
			if(d.getId() == id) {
				return d;
			}
		}
		return null;
	}
	
	public List<Device> getDevices() {
		return devices;
	}

}
