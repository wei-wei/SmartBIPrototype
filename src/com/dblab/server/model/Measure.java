package com.dblab.server.model;

import java.util.ArrayList;
import java.util.List;

public class Measure {
	private String measureName;
	private String mdxStr;
	private String cubeName;
	private List<String> measureList;
	
	public Measure() {
		measureList = new ArrayList<String>();
	}

	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(String measureName) {
		this.measureName = measureName;
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
	
	public void addMeasure(String measure) {
		measureList.add(measure);
	}
	
	public List<String> getMeasureList() {
		return measureList;
	}
}
