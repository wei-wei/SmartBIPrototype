package com.dblab.client.mvp;

import com.extjs.gxt.ui.client.widget.Viewport;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class DBBuilderView extends ViewImpl implements
		DBBuilderPresenter.MyView {

	private Viewport viewport;
	
	@Inject
	public DBBuilderView() {
		viewport = new Viewport();
	}

	@Override
	public Widget asWidget() {
		return viewport;
	}
}
