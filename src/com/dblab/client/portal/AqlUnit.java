package com.dblab.client.portal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.dblab.client.model.AqlHierarchy;
import com.dblab.client.model.AqlLevel;
import com.dblab.client.model.AqlLevelSelectionHandler;
import com.dblab.client.model.AqlMember;
import com.google.gwt.visualization.client.events.SelectHandler;

public class AqlUnit {
	private List<AqlLevelSelectionHandler> handlerList;
	
	private final Map<Integer, AqlHierarchy> hierarchyMap;
	
	public AqlUnit(Map<Integer, AqlHierarchy> hierarchyMap) {
		handlerList = new ArrayList<AqlLevelSelectionHandler>();
		this.hierarchyMap = hierarchyMap;
	}
	
	public SelectHandler bindSelectionHandler(final ListPortlet listPortlet) {
		AqlLevelSelectionHandler handler = new AqlLevelSelectionHandler(listPortlet, this);
		handlerList.add(handler);
		return handler;
	}
	
	public AqlLevel getAqlLevel(int id, int index) {
		return hierarchyMap.get(id).getAqlLevel(index);
	}
	
	public AqlHierarchy getAqlHierarchy(int id) {
		return hierarchyMap.get(id);
	}
	
	public void updateDisplay(int hierarchyId, int levelIndex, List<Integer> list) {
		// not the highest level
		updateQuerySet(hierarchyId, levelIndex, list);
		updateParentLevel(hierarchyId, levelIndex, list);
		updateChildLevel(hierarchyId, levelIndex, list);
	}
	
	private void updateQuerySet(int hierarchyId, int levelIndex, List<Integer> list) {
		
	}
	
	private void updateParentLevel(int hierarchyId, int childIndex, List<Integer> childlist) {
		if (childIndex > 0) {
			AqlLevel childLevel = hierarchyMap.get(hierarchyId).getAqlLevel(childIndex);
			AqlMember[] members = childLevel.getAqlMemberArray();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < childlist.size(); ++i) {
				list.add(members[childlist.get(i)].parentIndex);
			}
			int currentIndex = childIndex - 1;
			AqlLevel currentLevel = hierarchyMap.get(hierarchyId).getAqlLevel(currentIndex);
			currentLevel.updateDisplay(list);
			updateParentLevel(hierarchyId, currentIndex, list);
		}
	}
	
	private void updateChildLevel(int hierarchyId, int parentIndex, List<Integer> parentlist) {
		int lowestIndex = hierarchyMap.get(hierarchyId).getAqlHierarchyDepth() - 1;
		if (parentIndex < lowestIndex) {
			AqlLevel parentLevel = hierarchyMap.get(hierarchyId).getAqlLevel(parentIndex);
			AqlMember[] members = parentLevel.getAqlMemberArray();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < parentlist.size(); ++i) {
				int start = members[parentlist.get(i)].childStart;
				int end = members[parentlist.get(i)].childEnd;
				for (int j = start; j <= end; ++j) {
					list.add(j);
				}
			}
			int currentIndex = parentIndex + 1;
			AqlLevel currentLevel = hierarchyMap.get(hierarchyId).getAqlLevel(currentIndex);
			currentLevel.updateDisplay(list);
			updateChildLevel(hierarchyId, currentIndex, list);
		}
	}
}
