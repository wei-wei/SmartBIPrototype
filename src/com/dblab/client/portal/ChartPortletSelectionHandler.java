package com.dblab.client.portal;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.model.AqlHierarchy;
import com.dblab.client.model.AqlLevel;
import com.dblab.client.model.AqlMember;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.events.SelectHandler;

public class ChartPortletSelectionHandler extends SelectHandler {
	private final ChartPortlet portlet;
	private final AqlUnit aqlUnit;
	
	public ChartPortletSelectionHandler(ChartPortlet portlet,
			AqlUnit aqlUnit) {
		this.portlet = portlet;
		this.aqlUnit = aqlUnit;
	}
	
	@Override
	public void onSelect(SelectEvent event) {
		AqlHierarchy h= portlet.getAqlHierarchy();
		AqlLevel level = h.getSelectedLevel();
		int levelIndex = level.getLevelIndex();
		if (levelIndex < h.getAqlHierarchyDepth() - 1) {
			List<Integer> list = new ArrayList<Integer>();
			JsArray<Selection> selections = portlet.getSelections();
			Selection sel = selections.get(0);
			int i = level.getSelectedMember().get(sel.getRow());
			AqlMember member = level.getAqlMemberArray()[i];
			for (int j = member.childStart; j <= member.childEnd; ++j) {
				list.add(j);
			}
			levelIndex += 1;
			aqlUnit.updateDisplay(h.getAqlHierarchyId(), levelIndex, list);
		}
	}

	
}
