package com.dblab.client.mvp;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.inject.Inject;
import com.google.gwt.user.client.ui.Widget;

public class MainView extends ViewImpl implements MainPresenter.MyView {

	@Inject
	public MainView() {
	}

	@Override
	public Widget asWidget() {
		return null;
	}
}
