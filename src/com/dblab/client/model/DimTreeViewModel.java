package com.dblab.client.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.CompositeCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.HasCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.TreeViewModel;

public class DimTreeViewModel implements TreeViewModel {
	static interface Images extends ClientBundle {
		ImageResource dimension();
		ImageResource hierarchy();
	}

	private static class DimensionCell extends AbstractCell<AqlDimension> {
		private final String imageHtml;
		
		public DimensionCell(ImageResource image) {
			this.imageHtml = AbstractImagePrototype.create(image).getHTML();
		}

		@Override
		public void render(Context context,
				AqlDimension value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendHtmlConstant(imageHtml).appendEscaped(" ");
				sb.appendEscaped(value.getName());
			}
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
	
	private static Images images;
	
	private final ListDataProvider<AqlDimension> dimensionList;
	private final Cell<AqlHierarchy> hierarchyCell;
	private final DefaultSelectionEventManager<AqlHierarchy> selectionManager
		= DefaultSelectionEventManager.createCheckboxManager();
	private final SelectionModel<AqlHierarchy> selectionModel;
	
	public DimTreeViewModel(final SelectionModel<AqlHierarchy> selectionModel,
			List<AqlDimension> dimensionList) {
		this.selectionModel = selectionModel;
		this.dimensionList = new ListDataProvider<AqlDimension>(dimensionList);
		if (images == null) {
			images = GWT.create(Images.class);
		}
		
		List<HasCell<AqlHierarchy, ?>> hasCells = new ArrayList<HasCell<AqlHierarchy, ?>>();
		hasCells.add(new HasCell<AqlHierarchy, Boolean>() {
			private CheckboxCell cell = new CheckboxCell(true, false);
			@Override
			public Cell<Boolean> getCell() {
				return cell;
			}

			@Override
			public FieldUpdater<AqlHierarchy, Boolean> getFieldUpdater() {
				return null;
			}

			@Override
			public Boolean getValue(AqlHierarchy object) {
				return selectionModel.isSelected(object);
			}
		});
		hasCells.add(new HasCell<AqlHierarchy, AqlHierarchy>() {
			private HierarchyCell cell = new HierarchyCell(images.hierarchy());
			@Override
			public Cell<AqlHierarchy> getCell() {
				return cell;
			}

			@Override
			public FieldUpdater<AqlHierarchy, AqlHierarchy> getFieldUpdater() {
				return null;
			}

			@Override
			public AqlHierarchy getValue(AqlHierarchy object) {
				return object;
			}
		});
		
		hierarchyCell = new CompositeCell<AqlHierarchy>(hasCells) {
			@Override
			public void render(Context context, AqlHierarchy value, SafeHtmlBuilder sb) {
				sb.appendHtmlConstant("<table><tbody><tr>");
				super.render(context, value, sb);
				sb.appendHtmlConstant("</tr></tbody></table>");
			}
			
			@Override
			protected Element getContainerElement(Element parent) {
				return parent.getFirstChildElement().getFirstChildElement().getFirstChildElement();
			}
			
			@Override
			protected <X> void render(Context context, AqlHierarchy value, SafeHtmlBuilder sb,
					HasCell<AqlHierarchy, X> hasCell) {
				Cell<X> cell = hasCell.getCell();
				sb.appendHtmlConstant("<td>");
				cell.render(context, hasCell.getValue(value), sb);
				sb.appendHtmlConstant("</td>");
			}
		};
	}
	
	@Override
	public <T> NodeInfo<?> getNodeInfo(T value) {
		if (value == null) {
			return new DefaultNodeInfo<AqlDimension>(dimensionList,
					new DimensionCell(images.dimension()));
		} else if (value instanceof AqlDimension) {
			AqlDimension dimension = (AqlDimension) value;
			ListDataProvider<AqlHierarchy> dataProvider = 
					new ListDataProvider<AqlHierarchy>(dimension.getAqlHierarchyList());
			return new DefaultNodeInfo<AqlHierarchy>(dataProvider, hierarchyCell, 
					selectionModel, selectionManager, null);
		} else {
			return null;
		}
	}

	@Override
	public boolean isLeaf(Object value) {
		return value instanceof AqlHierarchy;
	}
}
