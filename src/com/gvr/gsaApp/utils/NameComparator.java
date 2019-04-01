package com.gvr.gsaApp.utils;
import java.util.Comparator;

import com.gvr.gsaApp.site.Site;

public class NameComparator implements Comparator<Site>{
	public int compare(Site lhs,Site rhs){  

		return lhs.getName().compareTo(rhs.getName());  
	} 
}
