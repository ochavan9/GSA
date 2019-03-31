package com.gvr.gsaApp.device;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gvr.gsaApp.device.Device;

public class DeviceManager {
	
	private static DeviceManager instance = null;
	//private List<Device> devices;
	//Map of Device id and Device
	private HashMap<Integer,Device> deviceMap = new HashMap<Integer, Device>();
	
	private DeviceManager() {}
	
	public static DeviceManager getInstance() 
    { 
        if (instance == null) 
        	instance = new DeviceManager(); 
  
        return instance; 
    }

	public void addDevice(Device device) {
		deviceMap.put(device.getId(), device);
	}
	
	public boolean removeDevice(Device device) {
		boolean removed = false;
		int id = device.getId();
		if(deviceMap.containsKey(id)) {
			if(deviceMap.remove(id) != null) {
				removed = true;
			}
		}
		return removed;
	}
	
	public boolean removeDeviceById(int id) {
		boolean removed = false;
		if(deviceMap.containsKey(id)) {
			if(deviceMap.remove(id) != null) {
				removed = true;
			}
		}
		return removed;
	}
	
	public Device getDeviceById(int id) {
		if(deviceMap.containsKey(id)) {
			return deviceMap.get(id);
		}
		return null;
	}
	
	public List<Device> getDevicesBySite(int siteId) {
		List<Device> devices = null;
		if(!deviceMap.isEmpty()) {
			devices = new ArrayList<Device>();
			for (Integer id : deviceMap.keySet()) {
				if (deviceMap.get(id).getSiteId() == siteId) {
					devices.add(deviceMap.get(id));
				}
			}
		}
		return devices;
	}
	
	public List<Device> getAllDevices() {
		List<Device> devices = null;
		if(!deviceMap.isEmpty()) {
			devices = new ArrayList<Device>();
			for (Integer id : deviceMap.keySet()) {
				devices.add(deviceMap.get(id));
			}
		}
		return devices;
	}
	
	
}
