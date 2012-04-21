package com.dblab.server.model;

import java.util.ArrayList;
import java.util.List;

public class Hierarchy {
	private String hierarchyName;
	private String mdxStr;
	private List<Level> levelList;
	
	public Hierarchy() {
		levelList = new ArrayList<Level>();
	}

	public String getHierarchyName() {
		return hierarchyName;
	}

	public void setHierarchyName(String hierarchyName) {
		this.hierarchyName = hierarchyName;
	}

	public String getMdxStr() {
		return mdxStr;
	}

	public void setMdxStr(String mdxStr) {
		this.mdxStr = mdxStr;
	}
	
	public void addLevel(Level level) {
		levelList.add(level);
	}
	
	public List<Level> getLevelList() {
		return levelList;
	}
}
