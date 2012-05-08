package com.dblab.client.mvp;


import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ConfigMashupView extends ViewImpl implements
		ConfigMashupPresenter.MyView {

	private Viewport viewport;
	private ContentPanel westPanel;
	private ContentPanel centerPanel;
	
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
		viewport.add(westPanel, data);
	}
	
	private void createCenterPanel() {
		centerPanel = new ContentPanel();
		centerPanel.setScrollMode(Scroll.AUTO);
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		data.setMargins(new Margins());
		viewport.add(centerPanel, data);
	}
}
