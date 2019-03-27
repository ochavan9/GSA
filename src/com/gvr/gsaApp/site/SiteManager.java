package com.gvr.gsaApp.site;

import java.util.ArrayList;
import java.util.List;

import com.gvr.gsaApp.site.Site;
import com.gvr.gsaApp.device.Device;
import com.gvr.gsaApp.device.DeviceManager;

public class SiteManager {
	private List<Site> sites;
	private DeviceManager devMan;
	
	public SiteManager() {
		this.sites = new ArrayList<Site>();
		this.devMan = new DeviceManager();
	}

	public void addSite(Site s) {
		//Site s = new Site(10, "Pheonix", "BKC", 100);
		sites.add(s);
	}
	
	public void removeSite(int id) {
		for (Site s : sites) {
			if(s.getId() == id) {
				sites.remove(s);
				break;
			}
		}
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
	
	public List<Device> getDevices() {
		return devMan.getDevices();
	}

	
	
	
}
