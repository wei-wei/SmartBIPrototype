package com.dblab.server.model;

import java.util.ArrayList;
import java.util.List;

public class Dimension {
	private String dimensionName;
	private String mdxStr;
	private String cubeName;
	private List<Hierarchy> hierarchyList;
	
	public Dimension() {
		hierarchyList = new ArrayList<Hierarchy>();
	}

	public String getDimensionName() {
		return dimensionName;
	}

	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}

	public String getMdxStr() {
		return mdxStr;
	}

	public void setMdxStr(String mdxStr) {
		this.mdxStr = mdxStr;
	}

	public String getCubeName() {
		return cubeName;
	}

	public void setCubeName(String cubeName) {
		this.cubeName = cubeName;
	}
	
	public void addHierarchy(Hierarchy hierarchy) {
		hierarchyList.add(hierarchy);
	}
	
	public List<Hierarchy> getHierarchyList() {
		return hierarchyList;
	}
}
