package com.gvr.gsaApp.site;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gvr.gsaApp.site.Site;
import com.gvr.gsaApp.device.Device;
import com.gvr.gsaApp.device.DeviceManager;

public class SiteManager {
	private static SiteManager instance = null;
	//private List<Site> sites;
	//Map of Site id and Site
	private HashMap<Integer,Site> siteMap;
	//Map of SiteId and List of DeviceIds for a site
	private HashMap<Integer, List<Device>> devicesInSite;
	
	private SiteManager() {
		this.siteMap = new HashMap<Integer, Site>();
		this.devicesInSite = new HashMap <Integer, List<Device>>();
	}
	
	public static SiteManager getInstance() 
    { 
        if (instance == null) 
        	instance = new SiteManager(); 
  
        return instance; 
    }

	public void addSite(Site site) {
		siteMap.put(site.getId(), site);
		devicesInSite.put(site.getId(), new ArrayList<Device>());
	}
	
	public boolean removeSite(int siteId) {
		boolean removed = false;
		if ( siteMap.remove(siteId) != null && devicesInSite.remove(siteId) != null) {
			removed = true;
			//Should we remove devices of this site from DeviceManager's List as well? 
		}
		return removed;
	}
	
	public boolean addDeviceToSite(int siteId, Device device) {
		boolean deviceAdded = false;
		if(siteMap.containsKey(siteId)) {
			deviceAdded = devicesInSite.get(siteId).add(device);
			DeviceManager.getInstance().addDevice(device);
		}
		return deviceAdded;
	}
	
	public boolean removeDeviceFromSite(int siteId, Device device) {
		boolean deviceRemoved = false;
		if(siteMap.containsKey(siteId)) {
			deviceRemoved = devicesInSite.get(siteId).remove(device);
			//Should we remove from DeviceManager's List as well?
		}
		return deviceRemoved;
	}
	
	public List<Device> getDevicesAtSite(int siteId) {
		if (!devicesInSite.isEmpty()) {
			return devicesInSite.get(siteId);
		}
		return null;
	}
	
	public List<Site> getAllSites() {
		List<Site> sites = null;
		if(!siteMap.isEmpty()) {
			sites = new ArrayList<Site>();
			for (Integer id : siteMap.keySet()) {
				sites.add(siteMap.get(id));
			}
		}
		return sites;
	}
	
	public Site getSiteById(int id) {
		if(siteMap.containsKey(id)) {
			return siteMap.get(id);
		}
		return null;
	}
	
	public List<Site> getSitesInOrganisation(int orgId) {
		List<Site> sites = null;
		if(!siteMap.isEmpty()) {
			sites = new ArrayList<Site>();
			for (Integer id : siteMap.keySet()) {
				if (siteMap.get(id).getOrgId() == orgId) {
					sites.add(siteMap.get(id));
				}
			}
		}
		return sites;
	}
	
	
}