package com.dblab.client.storage;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.portal.AqlPortal;

public class AqlPortalStorage {
	private List<AqlPortal> asPortalList;
	
	public AqlPortalStorage() {
		asPortalList = new ArrayList<AqlPortal>();
	}
	
	public List<AqlPortal> getAqlPortalList() {
		return asPortalList;
	}
	
	public void addAqlPortal(AqlPortal asPortal) {
		asPortalList.add(asPortal);
	}
	
	public void createTestData() {
		AqlPortal portal;
		portal = new AqlPortal(3);
		portal.setName("My Portal 1");
		addAqlPortal(portal);
		portal = new AqlPortal(3);
		portal.setName("My Portal 2");
		addAqlPortal(portal);
		portal = new AqlPortal(3);
		portal.setName("My Portal 3");
		addAqlPortal(portal);
	}
}
