package com.dblab.client.model;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.portal.AqlUnit;
import com.dblab.client.portal.ListPortlet;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.events.SelectHandler;
import com.google.gwt.visualization.client.visualizations.Table;

public class AqlLevelSelectionHandler extends SelectHandler {
	private final ListPortlet portlet;
	private final AqlUnit aqlUnit;
	
	public AqlLevelSelectionHandler(ListPortlet portlet,
			AqlUnit aqlUnit) {
		this.portlet = portlet;
		this.aqlUnit = aqlUnit;
	}
	
	@Override
	public void onSelect(SelectEvent event) {
		Table table = portlet.getTable();
		int id = portlet.gethId();
		int index = portlet.getlIndex();
		List<Integer> list = new ArrayList<Integer>();
		JsArray<Selection> selections = table.getSelections();
		for (int i = 0; i < selections.length(); ++i) {
			int row = selections.get(i).getRow();
			list.add(row);
		}
		aqlUnit.updateDisplay(id, index, list);
	}
}
