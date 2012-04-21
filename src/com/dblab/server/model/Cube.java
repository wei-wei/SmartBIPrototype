package com.dblab.server.model;

import java.util.ArrayList;
import java.util.List;

public class Cube {
	private String cubeName;
	private String mdxStr;
	private List<Dimension> dimensionList;
	private List<Measure> measureList;
	
	public Cube() {
		dimensionList = new ArrayList<Dimension>();
		measureList = new ArrayList<Measure>();
	}

	public String getCubeName() {
		return cubeName;
	}

	public void setCubeName(String cubeName) {
		this.cubeName = cubeName;
	}

	public String getMdxStr() {
		return mdxStr;
	}

	public void setMdxStr(String mdxStr) {
		this.mdxStr = mdxStr;
	}
	
	public void addDimension(Dimension dimension) {
		dimensionList.add(dimension);
	}
	
	public List<Dimension> getDimensionList() {
		return dimensionList;
	}
	
	public List<Measure> getMeasureList() {
		return measureList;
	}
}
