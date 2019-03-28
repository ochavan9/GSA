package com.gvr.gsaApp.organisation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gvr.gsaApp.device.Device;
import com.gvr.gsaApp.site.Site;
import com.gvr.gsaApp.site.SiteManager;

public class OrganisationManager {
	private List<Organisation> orgs;
	// Map of organisation id and site manager for that organisation
	private HashMap<Integer,SiteManager> siteManagerMap = new HashMap<Integer, SiteManager>();
	
	public OrganisationManager() {
		this.orgs = new ArrayList<Organisation>();
	}
	
	public void addOrganisation(Organisation o) {
		orgs.add(o);
		siteManagerMap.put(o.getId(), new SiteManager());
	}
	
	public void removeOrg(int id) {
		for (Organisation o : orgs) {
			if(o.getId() == id) {
				orgs.remove(o);
				break;
			}
		}
	}
	
	public int getNumberOfOrganisations() {
		return orgs.size();
	}
	
	public Organisation getOrgById(int id) {
		for (Organisation o : orgs) {
			if(o.getId() == id) {
				return o;
			}
		}
		return null;
	}
	
	public int getNumberOfSites(int id) {
		return getSiteManager(id).getNumberOfSites();
	}
	
	public List<List<Device>> getAllDevices(int orgId) {
		return getSiteManager(orgId).getAllDevices();
	}
	
	public void addSite(int orgId, Site site) {
		getSiteManager(orgId).addSite(site);
	}
	
	public List<Site> getSites(int id) {
		return siteManagerMap.get(id).getSites();
	}
	
	public SiteManager getSiteManager(int id) {
		return siteManagerMap.get(id);
	}
}
