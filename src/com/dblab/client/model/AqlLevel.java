package com.dblab.client.model;

public class AqlLevel {
	private AqlMember memberArray[];
	private String name;
	private int hierarchyId;
	private int levelIndex;
	private String mdxStr;
	
	public AqlLevel(int memberCount) {
		memberArray = new AqlMember[memberCount];
		initMemberArray();
	}
	
	public AqlMember[] getAqlMemberArray() {
		return memberArray;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHierarchyId() {
		return hierarchyId;
	}

	public void setHierarchyId(int hierarchyId) {
		this.hierarchyId = hierarchyId;
	}

	public int getLevelIndex() {
		return levelIndex;
	}

	public void setLevelIndex(int levelIndex) {
		this.levelIndex = levelIndex;
	}

	public String getMdxStr() {
		return mdxStr;
	}

	public void setMdxStr(String mdxStr) {
		this.mdxStr = mdxStr;
	}
	
	private void initMemberArray() {
		for (int i = 0; i < memberArray.length; ++i) {
			memberArray[i] = new AqlMember();
		}
	}
}
