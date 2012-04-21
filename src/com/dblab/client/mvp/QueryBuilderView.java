package com.dblab.client.mvp;

import com.extjs.gxt.ui.client.widget.Viewport;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class QueryBuilderView extends ViewImpl implements QueryBuilderPresenter.MyView {

	private Viewport viewport;
	
	@Inject
	public QueryBuilderView() {
		viewport = new Viewport();
	}

	@Override
	public Widget asWidget() {
		return viewport;
	}
}
