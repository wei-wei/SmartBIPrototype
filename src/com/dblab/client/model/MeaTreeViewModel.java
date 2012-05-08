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
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.TreeViewModel;

public class MeaTreeViewModel implements TreeViewModel {
	static interface Images extends ClientBundle {
		ImageResource dm();
		ImageResource measure();
	}
	
	private static class MeasureCell extends AbstractCell<AqlMeasure> {
		private final String imageHtml;
		
		public MeasureCell(ImageResource image) {
			this.imageHtml = AbstractImagePrototype.create(image).getHTML();
		}

		@Override
		public void render(Context context,
				AqlMeasure value, SafeHtmlBuilder sb) {
			sb.appendHtmlConstant(imageHtml).appendEscaped(" ");
			sb.appendEscaped(value.getName());
		}
	}
	
	public static class MeasureItemCell extends AbstractCell<String> {
		private final String imageHtml;
		
		private MeasureItemCell(ImageResource image) {
			this.imageHtml = AbstractImagePrototype.create(image).getHTML();
		}
		
		@Override
		public void render(Context context,
				String value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendHtmlConstant(imageHtml).appendEscaped(" ");
				sb.appendEscaped(value);
			}
		}
	}
	
	private final SelectionModel<String> selectionModel;
	private ListDataProvider<AqlMeasure> measures;
	private final Cell<String> measureCell;
	private final DefaultSelectionEventManager<String> selectionManager
		= DefaultSelectionEventManager.createCheckboxManager();
	
	private static Images images;
	
	public MeaTreeViewModel(final MultiSelectionModel<String> selectionModel, List<AqlMeasure> measures) {
		this.selectionModel = selectionModel;
		this.measures = new ListDataProvider<AqlMeasure>(measures);
		if (images == null) {
			images = GWT.create(Images.class);
		}
		
		List<HasCell<String, ?>> hasCells = new ArrayList<HasCell<String, ?>>();
		hasCells.add(new HasCell<String, Boolean>() {
			private CheckboxCell cell = new CheckboxCell(true, false);
			@Override
			public Cell<Boolean> getCell() {
				return cell;
			}

			@Override
			public FieldUpdater<String, Boolean> getFieldUpdater() {
				return null;
			}

			@Override
			public Boolean getValue(String object) {
				return selectionModel.isSelected(object);
			}
		});
		hasCells.add(new HasCell<String, String>() {
			/*private Cell<String> cell = new AbstractCell<String>() {
				@Override
				public void render(
						Context context,
						String value, SafeHtmlBuilder sb) {
					sb.appendEscaped(value);
				}
			};*/
			private MeasureItemCell cell = new MeasureItemCell(images.measure());
			@Override
			public Cell<String> getCell() {
				return cell;
			}

			@Override
			public FieldUpdater<String, String> getFieldUpdater() {
				return null;
			}

			@Override
			public String getValue(String object) {
				return object;
			}
		});
		
		measureCell = new CompositeCell<String>(hasCells) {
			@Override
			public void render(Context context, String value, SafeHtmlBuilder sb) {
				sb.appendHtmlConstant("<table><tbody><tr>");
				super.render(context, value, sb);
				sb.appendHtmlConstant("</tr></tbody></table>");
			}
			
			@Override
			protected Element getContainerElement(Element parent) {
				return parent.getFirstChildElement().getFirstChildElement().getFirstChildElement();
			}
			
			@Override
			protected <X> void render(Context context, String value, SafeHtmlBuilder sb,
					HasCell<String, X> hasCell) {
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
			return new DefaultNodeInfo<AqlMeasure>(measures, new MeasureCell(images.dm()));
		} else if (value instanceof AqlMeasure) {
			AqlMeasure measure = (AqlMeasure) value;
			ListDataProvider<String> dataProvider = 
					new ListDataProvider<String>(measure.getAqlMeasureList());
			
			
			return new DefaultNodeInfo<String>(dataProvider, measureCell,
					selectionModel, selectionManager, null);
		}
		
		return null;
		
	}

	@Override
	public boolean isLeaf(Object value) {
		return  value instanceof String;
	}
}
