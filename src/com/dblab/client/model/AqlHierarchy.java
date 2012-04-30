package com.dblab.client.model;

public class AqlHierarchy {
	private int hierarchyId;
	private String name;
	private String mdxStr;
	private AqlLevel[] levelArray;
	
	public AqlHierarchy(int levelCount) {
		levelArray = new AqlLevel[levelCount];
	}

	public int getAqlHierarchyId() {
		return hierarchyId;
	}

	public void setAqlHierarchyId(int hierarchyId) {
		this.hierarchyId = hierarchyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMdxStr() {
		return mdxStr;
	}

	public void setMdxStr(String mdxStr) {
		this.mdxStr = mdxStr;
	}
	
	public void addAqlLevel(AqlLevel level, int index) {
		levelArray[index] = level;
	}
	
	public AqlLevel getAqlLevel(int index) {
		return levelArray[index];
	}
	
	public AqlLevel[] getAqlLevelArray() {
		return levelArray;
	}
	
	public int getAqlHierarchyDepth() {
		return levelArray.length;
	}
}
