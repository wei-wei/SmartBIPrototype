package com.dblab.client.portal;

import java.util.List;

import com.dblab.client.model.AqlHierarchy;
import com.dblab.client.model.AqlLevel;
import com.dblab.client.model.AqlMember;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.corechart.CoreChart.Type;

public class ListPortlet extends Portlet implements HasDisplay {
	private ContentPanel panel;
	private Table table;
	private DataTable data;
	private final AqlUnit aqlUnit;
	private int hId;
	private int lIndex;
	
	public ListPortlet(AqlUnit aqlUnit) {
		super();
		this.aqlUnit = aqlUnit;
		panel = new ContentPanel();
		panel.setHeaderVisible(false);
		add(panel);
	}
	
	public void setAqlLevel(AqlLevel level) {
		hId = level.getAqlHierarchyId();
		lIndex = level.getLevelIndex();
		updateDisplay();
	}
	
	public int gethId() {
		return hId;
	}



	public void sethId(int hId) {
		this.hId = hId;
	}



	public int getlIndex() {
		return lIndex;
	}



	public void setlIndex(int lIndex) {
		this.lIndex = lIndex;
	}

	public Table getTable() {
		return table;
	}

	@Override
	public void updateDisplay(List<Integer> list) {
		JsArray<Selection> selection = JavaScriptObject.createArray().cast();
		for (int i = 0; i < list.size(); ++i) {
			Selection sel = Selection.createRowSelection(list.get(i));
			selection.push(sel);
		}
		table.setSelections(selection);
	}

	@Override
	public void updateDisplay() {
		data = DataTable.create();
		data.addColumn(ColumnType.STRING, aqlUnit.getAqlLevel(hId, lIndex).getName());
		fillDataTable();
		Table.Options options = Table.Options.create();
		table = new Table(data, options);
		table.addSelectHandler(aqlUnit.bindSelectionHandler(this));
		panel.removeAll();
		panel.add(table);
		aqlUnit.getAqlHierarchy(hId).getAqlLevel(lIndex).addDisplay(this);
		layout(true);
	}
	
	private void fillDataTable() {
		AqlMember[] members = aqlUnit.getAqlLevel(hId, lIndex).getAqlMemberArray();
		data.addRows(members.length);
		for (int i = 0; i < members.length; ++i) {
			data.setValue(i, 0, members[i].value);
		}
	}

	@Override
	public void setDisplayAqlLevel(AqlLevel level) {
		hId = level.getAqlHierarchyId();
		lIndex = level.getLevelIndex();
		updateDisplay();
	}

	@Override
	public void setDisplayAqlHierarchy(AqlHierarchy hierarchy) {
		// empty for ListPortlet
	}

	@Override
	public void setDisplayAqlMeasure(String measure) {
		// empty for ListPortlet
	}

	@Override
	public void setDisplayFilterAqlHierarchy(AqlHierarchy hierarchy) {
		// empty for ListPortlet
	}

	@Override
	public void setDisplayTitle(String title) {
		// empty for ListPortlet
	}

	@Override
	public void setDisplayChartType(Type type) {
		// empty for ListPortlet
	}
}
