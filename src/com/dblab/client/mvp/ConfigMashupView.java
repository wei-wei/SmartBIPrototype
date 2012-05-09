package com.dblab.client.mvp;


import com.dblab.client.portal.AqlPortal;
import com.dblab.client.portal.AqlUnit;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class ConfigMashupView extends ViewImpl implements
		ConfigMashupPresenter.MyView {

	private Viewport viewport;
	private ContentPanel westPanel;
	private ContentPanel centerPanel;
	private AqlPortal portal;
	private Button addListButton;
	private Button addChartButton;
	
	@Inject
	public ConfigMashupView() {
		viewport = new Viewport();
		viewport.setLayout(new BorderLayout());
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
		addListButton = new Button("Add List");
		addChartButton = new Button("Add Chart");
		westPanel.add(addListButton);
		westPanel.add(addChartButton);
		viewport.add(westPanel, data);
	}
	
	private void createCenterPanel() {
		centerPanel = new ContentPanel();
		centerPanel.setScrollMode(Scroll.AUTO);
		
		portal = new AqlPortal(3);
		portal.setBorders(true);
		portal.setStyleAttribute("backgroundColor", "white");
		
		portal.setColumnWidth(0, 0.33);
		portal.setColumnWidth(1, 0.33);
		portal.setColumnWidth(2, 0.33);
		
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		data.setMargins(new Margins(5));
		viewport.add(portal, data);
	}

	@Override
	public Button getAddListButton() {
		return addListButton;
	}

	@Override
	public Button getAddChartButton() {
		return addChartButton;
	}

	@Override
	public void initPortal(AqlUnit aqlUnit) {
		portal.setAqlUnit(aqlUnit);
	}

	@Override
	public void addListPortlet() {
		portal.addListPortlet();
	}
}
