package com.dblab.client.model;

import java.util.ArrayList;
import java.util.List;

public class AqlMeasure {
	private List<String> measureList;
	
	public AqlMeasure() {
		measureList = new ArrayList<String>();
	}
	
	public List<String> getAqlMeasureList() {
		return measureList;
	}
	
	public void addAqlMeasure(String measure) {
		measureList.add(measure);
	}
}
