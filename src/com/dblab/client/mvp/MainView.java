package com.dblab.client.mvp;

import com.dblab.client.widget.HeaderPanel;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class MainView extends ViewImpl implements MainPresenter.MyView {

	private Viewport viewport;
	private HeaderPanel headerPanel;
	private Viewport centerPanel;
	
	@Inject
	public MainView() {
		viewport = new Viewport();
		viewport.setLayout(new BorderLayout());
		//viewport.setStyleAttribute("padding", "10px");
		
		createHeaderPanel();
		createCenterPanel();
	}

	@Override
	public Widget asWidget() {
		return viewport;
	}
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == MainPresenter.TYPE_SetMainContent) {
			centerPanel.removeAll();
			centerPanel.add(content);
			centerPanel.layout(true);
		} else {
			super.setInSlot(slot, content);
		}
	}
	
	private void createHeaderPanel() {
		headerPanel = new HeaderPanel();
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.NORTH, 40);
		data.setMargins(new Margins());
		viewport.add(headerPanel, data);
	}
	
	private void createCenterPanel() {
		centerPanel = new Viewport();
		//centerPanel.setScrollMode(Scroll.AUTO);
		//centerPanel.setHeaderVisible(false);
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		data.setMargins(new Margins());
		viewport.add(centerPanel, data);
	}

	@Override
	public HasClickHandlers getHomeButton() {
		return headerPanel.getHomeAnchor();
	}

	@Override
	public HasClickHandlers getDashboardBuilderButton() {
		return headerPanel.getDashboardBuilderAnchor();
	}

	@Override
	public HasClickHandlers getQueryBuilderButton() {
		return headerPanel.getQueryBuilderAnchor();
	}
}
