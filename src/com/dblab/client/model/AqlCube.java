package com.dblab.client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AqlCube {
	private String name;
	private List<AqlDimension> dimensionList;
	private int id;
	private Map<Integer, AqlHierarchy> hierarchyMap;
	
	public AqlCube(String name) {
		this.name = name;
		dimensionList = new ArrayList<AqlDimension>();
		id = 0;
		hierarchyMap = new HashMap<Integer, AqlHierarchy>();
	}
	
	public List<AqlDimension> getAqlDimensionList() {
		return dimensionList;
	}
	
	public void addAqlDimension(AqlDimension dimension) {
		dimensionList.add(dimension);
	}
	
	public int getNewId() {
		return id++;
	}
	
	public AqlHierarchy getAqlHierarchy(int id) {
		return hierarchyMap.get(id);
	}
	
	public void addAqlHierarchy(AqlHierarchy hierarchy) {
		hierarchyMap.put(getNewId(), hierarchy);
	}
	
	public Map<Integer, AqlHierarchy> getAqlHierarchyMap() {
		return hierarchyMap;
	}
}
