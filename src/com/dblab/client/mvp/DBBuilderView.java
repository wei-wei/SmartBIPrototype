package com.dblab.client.mvp;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.inject.Inject;
import com.google.gwt.user.client.ui.Widget;

public class DBBuilderView extends ViewImpl implements
		DBBuilderPresenter.MyView {

	@Inject
	public DBBuilderView() {
	}

	@Override
	public Widget asWidget() {
		return null;
	}
}
