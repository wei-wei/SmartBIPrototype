package com.dblab.client.model;

import java.util.ArrayList;
import java.util.List;

public class AqlDimension {
	private String name;
	private List<AqlHierarchy> hierarchyList;
	
	public AqlDimension(String name) {
		this.name = name;
		hierarchyList = new ArrayList<AqlHierarchy>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addAqlHierarchy(AqlHierarchy hierarchy) {
		hierarchyList.add(hierarchy);
	}
	
	public List<AqlHierarchy> getAqlHierarchyList() {
		return hierarchyList;
	}
}
