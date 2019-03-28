package com.gvr.gsaApp.device;

import java.util.ArrayList;
import java.util.List;

import com.gvr.gsaApp.device.Device;

public class DeviceManager {
	
	private List<Device> devices;
	
	public DeviceManager() {
		this.devices = new ArrayList<Device>();
	}

	public boolean addDevice(Device device) {
		return devices.add(device);
	}

	public boolean removeDeviceById(int id) {
		boolean removed = false;
		for (Device d : devices) {
			if(d.getId() == id) {
				removed = devices.remove(d);
				break;
			}
		}
		return removed;
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
	
	public boolean removeDevice(Device device) {
		boolean removed = false;
		int id = device.getId();
		for (Device d : devices) {
			if(d.getId() == id) {
				removed = devices.remove(d);
				break;
			}
		}
		return removed;
	}

}
