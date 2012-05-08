package com.dblab.client.model;

import java.util.ArrayList;
import java.util.List;

public class AqlMeasure {
	private List<String> measureList;
	private String name;
	private String mdxStr;
	
	public AqlMeasure() {
		measureList = new ArrayList<String>();
	}
	
	public List<String> getAqlMeasureList() {
		return measureList;
	}
	
	public void addAqlMeasure(String measure) {
		measureList.add(measure);
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
}
