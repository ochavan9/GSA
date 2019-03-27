package com.gvr.gsaApp;

import com.gvr.gsaApp.organisation.OrgManager;
import com.gvr.gsaApp.organisation.Organisation;

public class GSAApplication {

	public static void main(String[] args) {
		OrgManager orgMan = new OrgManager();
		Organisation org = new Organisation(100, "BKC");
		orgMan.addOrganisation(org);
		
		System.out.println(orgMan.getNumberOfOrganisations());
		System.out.println(orgMan.getOrgById(100));
		
	}

}
