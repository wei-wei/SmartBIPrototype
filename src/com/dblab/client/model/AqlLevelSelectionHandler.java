package com.dblab.client.model;

import com.dblab.client.portal.AqlLevelPortlet;
import com.dblab.client.portal.AqlUnit;
import com.google.gwt.visualization.client.events.SelectHandler;

public class AqlLevelSelectionHandler extends SelectHandler {
	private final AqlLevelPortlet portlet;
	private final AqlUnit aqlUnit;
	
	public AqlLevelSelectionHandler(AqlLevelPortlet portlet,
			AqlUnit aqlUnit) {
		this.portlet = portlet;
		this.aqlUnit = aqlUnit;
	}
	
	@Override
	public void onSelect(SelectEvent event) {
		
	}
}
