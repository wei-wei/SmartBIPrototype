package com.dblab.client.storage;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.portal.AqlPortal;

public class AqlPortalStorage {
	private List<AqlPortal> asPortalList;
	
	public AqlPortalStorage() {
		asPortalList = new ArrayList<AqlPortal>();
	}
	
	public List<AqlPortal> getAsPortalList() {
		return asPortalList;
	}
	
	public void addAsPortal(AqlPortal asPortal) {
		asPortalList.add(asPortal);
	}
}
