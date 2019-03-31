package com.gvr.gsaApp.organisation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.gvr.gsaApp.device.Device;
import com.gvr.gsaApp.site.Site;
import com.gvr.gsaApp.site.SiteManager;

public class OrganisationManager {
	
	private static OrganisationManager instance = null;
	//private List<Organisation> orgs;
	// Map of organisation id and organisation
	private HashMap<Integer,Organisation> organisationMap = new HashMap<Integer, Organisation>();
	private HashMap<Integer, List<Site>> sitesInOrganisation = new HashMap <Integer, List<Site>>();
	
	private OrganisationManager() {}
	
	public static OrganisationManager getInstance() 
    { 
        if (instance == null) 
        	instance = new OrganisationManager(); 
  
        return instance; 
    }
	
	public void addOrganisation(Organisation org) {
		organisationMap.put(org.getId(), org);
		sitesInOrganisation.put(org.getId(), new ArrayList<Site>());
	}
	
	public boolean removeOrganisation(int orgId) {
		boolean removed = false;
		if ( organisationMap.remove(orgId) != null && sitesInOrganisation.remove(orgId) != null) {
			removed = true;
			//Should we remove sites of this organisation from siteManager List as well? 
		}
		return removed;
	}
	
	public boolean addSiteToOrganisation(int orgId, Site site) {
		boolean siteAdded = false;
		if(organisationMap.containsKey(orgId)) {
			siteAdded = sitesInOrganisation.get(orgId).add(site);
			SiteManager.getInstance().addSite(site);
		}
		return siteAdded;
	}
	
	public boolean removeSiteFromOrganisation(int orgId, Site site) {
		boolean siteRemoved = false;
		if(organisationMap.containsKey(orgId)) {
			siteRemoved = sitesInOrganisation.get(orgId).remove(site);
			//Should we remove sites of this organisation from siteManager List as well? 
		}
		return siteRemoved;
	}
	public Organisation getOrganisationById(int id) {
		if(organisationMap.containsKey(id)) {
			return organisationMap.get(id);
		}
		return null;
	}
	
	public List<Organisation> getAllOrganisations() {
		List<Organisation> organisations = null;
		if(!organisationMap.isEmpty()) {
			organisations = new ArrayList<Organisation>();
			for (Integer id : organisationMap.keySet()) {
				organisations.add(organisationMap.get(id));
			}
		}
		return organisations;
	}
	
	public List<Site> getSitesInOrganisation(int orgId) {
		if(!sitesInOrganisation.isEmpty()) {
			return sitesInOrganisation.get(orgId);
		}
		return null;
	}
	
	public List<Device> getDevicesInOrganisation(int orgId) {
		List<Device> devicesInOrganisation = null;
		if(!sitesInOrganisation.isEmpty()) {
			devicesInOrganisation = new ArrayList<Device>();
			List<Site> sites = sitesInOrganisation.get(orgId);
			for(Site s : sites)
			{
				devicesInOrganisation.addAll(SiteManager.getInstance().getDevicesAtSite(s.getId()));
			}
		}
		return devicesInOrganisation;
	}

	public void sortSites(int orgId)
	{
		Collections.sort(getSitesInOrganisation(orgId));	
		
		//System.out.println(getSitesInOrganisation(orgId));
	}
	

}
