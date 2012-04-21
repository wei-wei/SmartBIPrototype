package com.dblab.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HeaderPanel extends Composite {

	private static HeaderPanelUiBinder uiBinder = GWT
			.create(HeaderPanelUiBinder.class);

	interface HeaderPanelUiBinder extends UiBinder<Widget, HeaderPanel> {
	}

	public HeaderPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField Anchor homeAnchor;
	@UiField Anchor dashboardBuilderAnchor;
	@UiField Anchor queryBuilderAnchor;
	@UiField Anchor signOutAnchor;

	public HeaderPanel(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public HasClickHandlers getHomeAnchor() {
		return homeAnchor;
	}
	
	public HasClickHandlers getDashboardBuilderAnchor() {
		return dashboardBuilderAnchor;
	}
	
	public HasClickHandlers getQueryBuilderAnchor() {
		return queryBuilderAnchor;
	}
	
	public HasClickHandlers getSignOutAnchor() {
		return signOutAnchor;
	}
}
