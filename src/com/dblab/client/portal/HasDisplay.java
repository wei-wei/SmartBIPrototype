package com.dblab.client.portal;

import java.util.List;

import com.dblab.client.model.AqlHierarchy;
import com.dblab.client.model.AqlLevel;
import com.google.gwt.visualization.client.visualizations.corechart.CoreChart;

public interface HasDisplay {
	void updateDisplay(List<Integer> list);
	void updateDisplay();
	void setDisplayAqlLevel(AqlLevel level);
	void setDisplayChartType(CoreChart.Type type);
	void setDisplayAqlHierarchy(AqlHierarchy hierarchy);
	void setDisplayAqlMeasure(String measure);
	void setDisplayFilterAqlHierarchy(AqlHierarchy hierarchy);
	void setDisplayTitle(String title);
}
