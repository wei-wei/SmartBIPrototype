package com.dblab.client.data;

import java.util.List;

public class AcLevel {
	private int levelId;
	private int hierarchyId;
	private String name;
	private String mdxStr;
	private boolean isLoweast;
	
	private AcLevelMember memberList[];
	
	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public int getHierarchyId() {
		return hierarchyId;
	}

	public void setHierarchyId(int hierarchyId) {
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

	public boolean isLoweast() {
		return isLoweast;
	}

	public void setLoweast(boolean isLoweast) {
		this.isLoweast = isLoweast;
	}

	public AcLevelMember[] getMemberList() {
		return memberList;
	}

	public void setMemberList(AcLevelMember[] memberList) {
		this.memberList = memberList;
	}
	
	public void setSelected(int index) {
		memberList[index].selected = true;
	}
}
