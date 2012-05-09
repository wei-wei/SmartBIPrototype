package com.dblab.client.model;



public class AqlHierarchy {
	private int hierarchyId;
	private String name;
	private String mdxStr;
	private AqlLevel[] levelArray;
	
	//private List<ChartPortlet> displays;
	private int selectedLevelIndex;
	
	public AqlHierarchy(int levelCount) {
		levelArray = new AqlLevel[levelCount];
		//displays = new ArrayList<ChartPortlet>();
		selectedLevelIndex = 0;
	}

	public void setSelectedLevelIndex(int index) {
		selectedLevelIndex = index;
	}
	
	public AqlLevel getSelectedLevel() {
		return levelArray[selectedLevelIndex];
	}
	/*public void addDisplay(ChartPortlet portlet) {
		displays.add(portlet);
	}*/
	
	/*public void updateDisplay() {
		for (int i = 0; i < displays.size(); ++i) {
			displays.get(i).updateDisplay();
		}
	}*/
	
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
	
	public String getMdxQueryAxixStr() {
		String mdx = "";
		return mdx;
	}
}
