package com.dblab.client.model;

public class AqlLevel {
	private AqlMember memberArray[];
	private String name;
	private int hierarchyId;
	private int levelIndex;
	private String mdxStr;
	
	public AqlLevel() {
		//memberArray = new AqlMember[memberCount];
		initMemberArray();
	}
	
	public void setMemberArray(AqlMember[] memberArray) {
		this.memberArray = memberArray;
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

	public int getAqlHierarchyId() {
		return hierarchyId;
	}

	public void setAqlHierarchyId(int hierarchyId) {
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
/*		for (int i = 0; i < memberArray.length; ++i) {
			memberArray[i] = new AqlMember();
		}*/
	}
}
