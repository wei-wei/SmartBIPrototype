package com.dblab.client.mvp;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.HtmlContainer;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class MainView extends ViewImpl implements MainPresenter.MyView {

	private Viewport viewport;
	private Viewport centerPanel;
	private ToggleButton homeButton;
	private ToggleButton dashboardBuilderButton;
	private ToggleButton queryBuilderButton;
	private Button signOutButton;
	
	@Inject
	public MainView() {
		viewport = new Viewport();
		viewport.setLayout(new BorderLayout());
		
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
		String str = 
				"<div id='app-header' class='x-small-editor'>" +
						"<div id='app-theme'></div>" +
						"<div id=app-title>Smart BI Prototype</div>" +
				"</div>"; 
		HtmlContainer titlePanel = new HtmlContainer(str);
		titlePanel.setStateful(false);
		
		LayoutContainer headerPanel = new LayoutContainer();
		
		ToolBar toolBar = new ToolBar();
		homeButton = new ToggleButton("Home");
		homeButton.setToggleGroup("navigation");
		dashboardBuilderButton = new ToggleButton("Dashboard Builder");
		dashboardBuilderButton.setToggleGroup("navigation");
		queryBuilderButton = new ToggleButton("Query Builder");
		queryBuilderButton.setToggleGroup("navigation");
		toolBar.add(homeButton);
		toolBar.add(dashboardBuilderButton);
		toolBar.add(queryBuilderButton);
		toolBar.add(new FillToolItem());
		signOutButton = new Button("Sign Out");
		toolBar.add(signOutButton);
		
		headerPanel.add(titlePanel);
		headerPanel.add(toolBar);
		
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.NORTH, 60);
		data.setMargins(new Margins());
		viewport.add(headerPanel, data);
		
	}
	
	private void createCenterPanel() {
		centerPanel = new Viewport();
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		data.setMargins(new Margins());
		viewport.add(centerPanel, data);
	}

	@Override
	public ToggleButton getHomeButton() {
		return homeButton;
	}

	@Override
	public ToggleButton getDashboardBuilderButton() {
		return dashboardBuilderButton;
	}

	@Override
	public ToggleButton getQueryBuilderButton() {
		return queryBuilderButton;
	}

	@Override
	public Button getSignOutButton() {
		return signOutButton;
	}
}
