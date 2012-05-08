package com.dblab.client.mvp;

import java.util.List;

import com.dblab.client.portal.AqlPortal;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class HomeView extends ViewImpl implements HomePresenter.MyView {

	private Viewport viewport;
	private ContentPanel westPanel;
	private ContentPanel centerPanel;
	
	@Inject
	public HomeView() {
		viewport = new Viewport();
		viewport.setLayout(new BorderLayout());
		//viewport.setStyleAttribute("padding", "10px");
		
		createWestPanel();
		createCenterPanel();
	}

	@Override
	public Widget asWidget() {
		return viewport;
	}

	private void createWestPanel() {
		westPanel = new ContentPanel();
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.WEST, 250);
		viewport.add(westPanel, data);
	}
	
	private void createCenterPanel() {
		centerPanel = new ContentPanel();
		centerPanel.setScrollMode(Scroll.AUTO);
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		data.setMargins(new Margins());
		viewport.add(centerPanel, data);
	}

	@Override
	public void setAqlPortalList(List<AqlPortal> list) {
		westPanel.removeAll();
		
		AbstractCell<AqlPortal> cell = new AbstractCell<AqlPortal>() {
			@Override
			public void render(com.google.gwt.cell.client.Cell.Context context,
					AqlPortal value, SafeHtmlBuilder sb) {
				if (value == null) {
					return;
				}
				
				sb.appendHtmlConstant("<div>");
				sb.appendEscaped(value.getName());
				sb.appendHtmlConstant("</div>");
			}
		};
		
		CellList<AqlPortal> cellList = new CellList<AqlPortal>(cell);
		cellList.setRowCount(list.size(), true);
		cellList.setRowData(0, list);
		
		final SingleSelectionModel<AqlPortal> selectionModel =
				new SingleSelectionModel<AqlPortal>();
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				centerPanel.removeAll();
				centerPanel.add(selectionModel.getSelectedObject());
				viewport.layout(true);
			}
		});
		
		westPanel.add(cellList);
		viewport.layout(true);
	}
}
