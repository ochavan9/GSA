package com.gvr.gsaApp.organisation;

import java.util.ArrayList;
import java.util.List;

import com.gvr.gsaApp.site.Site;
import com.gvr.gsaApp.site.SiteManager;

public class OrgManager {
	private List<Organisation> orgs;
	private SiteManager siteMan;
	
	public OrgManager() {
		this.orgs = new ArrayList<Organisation>();
		this.siteMan = new SiteManager();
	}
	
	public void addOrganisation(Organisation o) {
		//Organisation o = new Organisation(100, "BPCL");
		orgs.add(o);
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
	
	public List<Site> getSites() {
		return siteMan.getSites();
	}

}
