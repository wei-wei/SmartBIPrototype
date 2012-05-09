package com.dblab.client.portal;

import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.corechart.AreaChart;
import com.google.gwt.visualization.client.visualizations.corechart.BarChart;
import com.google.gwt.visualization.client.visualizations.corechart.ColumnChart;
import com.google.gwt.visualization.client.visualizations.corechart.CoreChart;
import com.google.gwt.visualization.client.visualizations.corechart.LineChart;
import com.google.gwt.visualization.client.visualizations.corechart.Options;
import com.google.gwt.visualization.client.visualizations.corechart.PieChart;
import com.google.gwt.visualization.client.visualizations.corechart.ScatterChart;

public class ChartFactory {
	public static CoreChart createChart(CoreChart.Type type, CoreChart chart, DataTable dataTable, Options options) {
		switch (type) {
		case AREA:
			chart = new AreaChart(dataTable, options);
			break;
		case LINE:
			chart = new LineChart(dataTable, options);
			break;
		case SCATTER:
			chart = new ScatterChart(dataTable, options);
			break;
		case BARS:
			chart = new BarChart(dataTable, options);
			break;
		case COLUMNS:
			chart = new ColumnChart(dataTable, options);
			break;
		case PIE:
			chart = new PieChart(dataTable, options);
			break;
		}
		return chart;
	}
}
