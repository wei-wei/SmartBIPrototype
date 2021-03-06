package com.dblab.client.model;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.portal.HasDisplay;

public class AqlLevel {
	private AqlMember memberArray[];
	private String name;
	private int hierarchyId;
	private int levelIndex;
	private String mdxStr;
	
	//=====================================
	
	//private 
	
	//=====================================
	
	private List<HasDisplay> displays;
	private List<Integer> selectedMember;
	
	public AqlLevel() {
		//memberArray = new AqlMember[memberCount];
		displays = new ArrayList<HasDisplay>();
		selectedMember = new ArrayList<Integer>();
		initMemberArray();
	}
	
	public void clearSelected() {
		selectedMember.clear();
	}
	
	public void addSelected(int i) {
		selectedMember.add(i);
	}
	
	public void addSelected(List<Integer> list) {
		selectedMember.addAll(list);
	}
	
	public List<Integer> getSelectedMember() {
		return selectedMember;
	}
	
	public void setMemberArray(AqlMember[] memberArray) {
		this.memberArray = memberArray;
		for (int i = 0; i < memberArray.length; ++i) {
			selectedMember.add(i);
		}
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
	
	public void addDisplay(HasDisplay display) {
		displays.add(display);
	}
	
/*	public void updateDisplay(List<Integer> list) {
		for (int i = 0; i < displays.size(); ++i) {
			displays.get(i).updateDisplay(list);
		}
	}*/
	
	public void updateDisplay() {
		for (int i = 0; i < displays.size(); ++i) {
			displays.get(i).updateDisplay(selectedMember);
		}
	}
}
