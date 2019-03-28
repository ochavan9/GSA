package com.gvr.gsaApp;

import com.gvr.gsaApp.organisation.OrganisationManager;
import com.gvr.gsaApp.site.Site;
import com.gvr.gsaApp.device.Device;
import com.gvr.gsaApp.organisation.Organisation;

public class GSAApplication {

	public static void main(String[] args) {
		OrganisationManager organisationManager = new OrganisationManager();
		
		final int bpclOrgId = 100;
		Organisation bpcl = new Organisation(bpclOrgId, "BPCL");
		organisationManager.addOrganisation(bpcl);
		//Add 50 sites to BPCL with 10 devices on each site 
		for(int siteId = 1 ; siteId <= 50 ; ++siteId) {
			String siteName = "BKC_" + siteId; 
			Site site = new Site(siteId, siteName, "Mumbai", bpclOrgId);
			organisationManager.addSite(bpclOrgId, site);
			for (int devId = 1; devId <= 10; ++devId) {
				String deviceName = "CRIND_" + devId;
				Device device = new Device(devId, deviceName, "Gilbarco", "00000000", "Offline", "M7", siteId);
				organisationManager.getSiteManager(bpclOrgId).addDevice(1, device);
			}
		}
		
		System.out.println("Number of Sites of BPCL : " +organisationManager.getNumberOfSites(bpclOrgId));
		System.out.println("All Sites for BPCL : " +organisationManager.getSites(bpclOrgId));
		System.out.println("All Device for BPCL : " +organisationManager.getAllDevices(bpclOrgId));
		
		final int hpclOrgId = 200;
		Organisation hpcl = new Organisation(hpclOrgId, "HPCL");
		organisationManager.addOrganisation(hpcl);
		//Add 50 sites to HPCL with 10 devices on each site 
		for(int siteId = 1 ; siteId <= 50 ; ++siteId) {
			String siteName = "Thane_" + siteId; 
			Site site = new Site(siteId, siteName, "Mumbai", hpclOrgId);
			organisationManager.addSite(hpclOrgId, site);
			for (int devId = 1; devId <= 10; ++devId) {
				String deviceName = "CRIND_" + devId;
				Device device = new Device(devId, deviceName, "Gilbarco", "99999999", "Offline", "M5", siteId);
				organisationManager.getSiteManager(hpclOrgId).addDevice(1, device);
			}
		}
		
		System.out.println("Number of Sites of HPCL : " +organisationManager.getNumberOfSites(hpclOrgId));
		System.out.println("All Sites for HPCL : " +organisationManager.getSites(hpclOrgId));
		//System.out.println("All Device for HPCL : " +organisationManager.getAllDevices(hpclOrgId));
				

	}

}
