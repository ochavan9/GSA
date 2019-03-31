package com.gvr.gsaApp;

import com.gvr.gsaApp.organisation.OrganisationManager;
import com.gvr.gsaApp.site.Site;
import com.gvr.gsaApp.site.SiteManager;
import com.gvr.gsaApp.utils.BinarySerializer;
import com.gvr.gsaApp.utils.XMLSerializer;
import com.gvr.gsaApp.device.Device;
import com.gvr.gsaApp.device.DeviceManager;
import com.gvr.gsaApp.organisation.Organisation;

public class GSAApplication {

	public static void main(String[] args) {
		OrganisationManager organisationManager = OrganisationManager.getInstance();
		SiteManager siteManager = SiteManager.getInstance();
		DeviceManager deviceManager = DeviceManager.getInstance();
		
		final int bpclId = 1;
		Organisation bpcl = new Organisation(bpclId, "BPCL");
		organisationManager.addOrganisation(bpcl);
		//Add 50 sites to BPCL 
		for(int siteId = 100; siteId <= 149 ; ++siteId) {
			String siteName = "BKC_" + siteId; 
			Site site = new Site(siteId, siteName, "Mumbai", bpclId); 
			organisationManager.addSiteToOrganisation(bpclId, site);
			//Add 10 devices on each site
			for (int i=1, devId = siteId*10; i <= 10; ++i, ++devId) { 
				String deviceName = "CRIND_" + devId;
				Device device = new Device(devId, deviceName, "Gilbarco", "00000000", "Offline", "M7", siteId);
				siteManager.addDeviceToSite(siteId, device);
			}
		}
		

		final int hpclId = 2; 
		Organisation hpcl = new Organisation(hpclId,"HPCL"); 
		organisationManager.addOrganisation(hpcl);
		//Add 50 sites to HPCL
		for(int siteId = 249 ; siteId >= 200 ; --siteId) {
			String siteName = "BKC_" + siteId; 
			Site site = new Site(siteId, siteName, "Mumbai", hpclId); 
			organisationManager.addSiteToOrganisation(hpclId, site);
			//Add 10 devices on each site
			for (int i=1, devId = siteId*10; i <= 10; ++i, ++devId) { 
				String deviceName = "CRIND_" + devId;
				Device device = new Device(devId, deviceName, "Gilbarco", "00000000", "Offline", "M7", siteId); 
				siteManager.addDeviceToSite(siteId, device); 
			} 
		}
		 
		
		//deviceManager.removeDeviceById(3);
		System.out.println("Devices in Organisation:\n" +organisationManager.getDevicesInOrganisation(hpclId));
		organisationManager.sortSites(hpclId);
		System.out.println("Sites in Organisation:\n"+organisationManager.getSitesInOrganisation(hpclId));
		
		BinarySerializer binarySerializer = new BinarySerializer();
		binarySerializer.writeObjectToBinaryFile(organisationManager.getOrganisationById(hpclId));
		Organisation hpclOrg = (Organisation)binarySerializer.readObjectFromBinaryFile();
		System.out.println(hpclOrg);
		
		XMLSerializer xmlSerializer = new XMLSerializer();
		xmlSerializer.writeObjectToXMLFile(organisationManager.getOrganisationById(bpclId));
		Organisation bpclOrg = (Organisation)xmlSerializer.readObjectFromXMLFile();
		System.out.println(bpclOrg);
	}

}