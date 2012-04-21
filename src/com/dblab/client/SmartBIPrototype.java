package com.dblab.client;

import com.google.gwt.core.client.EntryPoint;
import com.dblab.client.gin.ClientGinjector;
import com.google.gwt.core.client.GWT;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine;
import com.google.gwt.visualization.client.visualizations.Gauge;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.corechart.CoreChart;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

public class SmartBIPrototype implements EntryPoint {

	private final ClientGinjector ginjector = GWT.create(ClientGinjector.class);

	@Override
	public void onModuleLoad() {
		VisualizationUtils.loadVisualizationApi(
				new Runnable() {
					@Override
					public void run() {
						DelayedBindRegistry.bind(ginjector);
						ginjector.getPlaceManager().revealCurrentPlace();
					}
				}, AnnotatedTimeLine.PACKAGE, CoreChart.PACKAGE,
				Gauge.PACKAGE, 
			    Table.PACKAGE);
	}
}
