package com.dblab.client.storage;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.model.AqlCube;
import com.dblab.client.model.AqlHierarchy;

public class VirtualCube {
	private List<AqlHierarchy> hierarchyList;
	private List<String> measureList;
	private AqlCube cube;
	
	public VirtualCube() {
		hierarchyList = new ArrayList<AqlHierarchy>();
		measureList = new ArrayList<String>();
	}
	
	public List<AqlHierarchy> getAqlHierarchyList() {
		return hierarchyList;
	}
	
	public List<String> getMeasureList() {
		return measureList;
	}
	
	public void setAqlHierarchyList(List<AqlHierarchy> list) {
		hierarchyList.clear();
		hierarchyList.addAll(list);
	}
	
	public void setMeasureList(List<String> list) {
		measureList.clear();
		measureList.addAll(list);
	}
	
	public AqlCube getAqlCube() {
		return cube;
	}
	
	public void setAqlCube(AqlCube cube) {
		this.cube = cube;
	}
}
