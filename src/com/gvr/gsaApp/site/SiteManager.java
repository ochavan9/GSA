package com.gvr.gsaApp.site;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gvr.gsaApp.site.Site;
import com.gvr.gsaApp.device.Device;
import com.gvr.gsaApp.device.DeviceManager;

public class SiteManager {
	private List<Site> sites;
	private HashMap<Integer,DeviceManager> deviceManagerMap = new HashMap<Integer, DeviceManager>();
	
	public SiteManager() {
		this.sites = new ArrayList<Site>();
	}

	public void addSite(Site s) {
		sites.add(s);
		deviceManagerMap.put(s.getId(), new DeviceManager());
	}
	
	public boolean removeSite(int id) {
		boolean removed = false;
		for (Site s : sites) {
			if(s.getId() == id) {
				removed = sites.remove(s);
				break;
			}
		}
		return removed;
	}
	
	public int getNumberOfSites() {
		return sites.size();
	}
	
	public Site getSiteById(int id) {
		for (Site s : sites) {
			if(s.getId() == id) {
				return s;
			}
		}
		return null;
	}
	
	public List<Site> getSites() {
		return sites;
	}
	
	public List<Device> getDevices(int id) {
		return getDeviceManager(id).getDevices();
	}

	public void addDevice(int id, Device device) {
		getDeviceManager(id).addDevice(device);
	}
	
	public boolean removeDevice(int id, Device device) {
		return getDeviceManager(id).removeDevice(device);
	}
	
	private DeviceManager getDeviceManager(int id) {
		return deviceManagerMap.get(id);
	}
	
	public List<List<Device>> getAllDevices() {
		List<List<Device>> allDevices = new ArrayList<List<Device>>();
		for (Site s : sites) {
			allDevices.add(getDeviceManager(s.getId()).getDevices());
		}
		return allDevices;
	}
}
