package com.dblab.server.model;

import java.util.ArrayList;
import java.util.List;

public class Level {
	private String levelName;
	private String mdxStr;
	
	List<String> memberList;
	
	public Level() {
		memberList = new ArrayList<String>();
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getMdxStr() {
		return mdxStr;
	}

	public void setMdxStr(String mdxStr) {
		this.mdxStr = mdxStr;
	}
	
	public void addMember(String member) {
		memberList.add(member);
	}
	
	public List<String> getMemberList() {
		return memberList;
	}
}
