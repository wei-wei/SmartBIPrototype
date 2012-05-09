package com.dblab.client.portal;

import java.util.List;

import com.dblab.client.model.AqlHierarchy;
import com.dblab.client.model.AqlLevel;
import com.dblab.client.storage.VirtualCube;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.corechart.CoreChart;
import com.google.gwt.visualization.client.visualizations.corechart.Options;

public class ChartPortlet extends Portlet implements HasDisplay {
	private ContentPanel panel;
	private DataTable data;
	private AqlUnit aqlUnit;
	private VirtualCube vCube;
	private AqlHierarchy h;
	private String measure;
	private AqlHierarchy fh;
	private CoreChart chart;
	private String title;
	
	public ChartPortlet(AqlUnit aqlUnit) {
		super();
		this.aqlUnit = aqlUnit;
		panel = new ContentPanel();
		panel.setHeaderVisible(false);
		add(panel);
		h = null;
		measure = null;
		fh = null;
	}
	
	@Override
	public void updateDisplay(List<Integer> list) {
		// empty for ChartPortlet
	}

	@Override
	public void updateDisplay() {
		String mdx = buildMdx();
	}

	@Override
	public void setDisplayAqlLevel(AqlLevel level) {
		// empty for ChartPortlet
	}

	@Override
	public void setDisplayAqlHierarchy(AqlHierarchy hierarchy) {
		
	}

	@Override
	public void setDisplayAqlMeasure(String measure) {
		
	}

	@Override
	public void setDisplayFilterAqlHierarchy(AqlHierarchy hierarchy) {
		
	}

	@Override
	public void setDisplayTitle(String title) {
		this.title = title;
	}
	
	public void initChartDisplay(CoreChart.Type type) {
		Options options = CoreChart.createOptions();
		options.setTitle(title);
		chart = ChartFactory.createChart(type, chart, data, options);
		panel.add(chart);
		layout(true);
	}
	
	private String buildMdx() {
		String select = "select\n";
		String on0 = " on 0,\n";
		String on1 = " on 1\n";
		String from = "from ";
		String where = "where ";
		if (fh == null) {
			where = "";
		}
		
		String mdx = select + 
					 "[Measures].[" + measure + "]" + on0 +
					 h.getMdxQueryAxixStr() + on1 +
					 from + vCube.getAqlCube().getMdxStr() +
					 where; 
					 	
		return mdx;
	}
}