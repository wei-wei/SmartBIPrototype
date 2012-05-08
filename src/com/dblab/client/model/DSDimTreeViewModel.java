package com.dblab.client.model;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.TreeViewModel;

public class DSDimTreeViewModel implements TreeViewModel {

	static interface Images extends ClientBundle {
		ImageResource hierarchy();
		ImageResource level();
	}
	
	private final SelectionModel<AqlMember> selectionModel;
	private final ListDataProvider<AqlHierarchy> hierarchyList;
	private static Images images;
	
	public DSDimTreeViewModel(final SelectionModel<AqlMember> selectionModel,
			List<AqlHierarchy> hierarchyList) {
		this.selectionModel = selectionModel;
		this.hierarchyList = new ListDataProvider<AqlHierarchy>(hierarchyList);
		if (images == null) {
			images = GWT.create(Images.class);
		}
	}
	
	public static class HierarchyCell extends AbstractCell<AqlHierarchy> {
		private final String imageHtml;
		
		public HierarchyCell(ImageResource image) {
			this.imageHtml = AbstractImagePrototype.create(image).getHTML();
		}

		@Override
		public void render(Context context,
				AqlHierarchy value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendHtmlConstant(imageHtml).appendEscaped(" ");
				sb.appendEscaped(value.getName());
			}
		}
	}
	
	public static class LevelCell extends AbstractCell<AqlLevel> {
		private final String imageHtml;
		
		public LevelCell(ImageResource image) {
			this.imageHtml = AbstractImagePrototype.create(image).getHTML();
		}

		@Override
		public void render(Context context,
				AqlLevel value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendHtmlConstant(imageHtml).appendEscaped(" ");
				sb.appendEscaped(value.getName());
			}
		}
	}
	
	@Override
	public <T> NodeInfo<?> getNodeInfo(T value) {
		if (value == null) {
			return new DefaultNodeInfo<AqlHierarchy>(hierarchyList,
					new HierarchyCell(images.hierarchy()));
		} else if (value instanceof AqlHierarchy) {
			AqlHierarchy hierarchy = (AqlHierarchy) value;
			ListDataProvider<AqlLevel> dataProvider = 
					new ListDataProvider<AqlLevel>(Arrays.asList(hierarchy.getAqlLevelArray()));
			return new DefaultNodeInfo<AqlLevel>(dataProvider, 
					new LevelCell(images.level()));
		} else if (value instanceof AqlLevel) {
			AqlLevel level = (AqlLevel) value;
			ListDataProvider<AqlMember> dataProvider = 
					new ListDataProvider<AqlMember>(Arrays.asList(level.getAqlMemberArray()));
			Cell<AqlMember> cell = new AbstractCell<AqlMember>() {
				@Override
				public void render(Context context,
						AqlMember value, SafeHtmlBuilder sb) {
					sb.appendEscaped(value.value);
				}
			};
			return new DefaultNodeInfo<AqlMember>(dataProvider, cell, selectionModel, null);
		} else {
			return null;
		}
	}

	@Override
	public boolean isLeaf(Object value) {
		return value instanceof String;
	}
}
