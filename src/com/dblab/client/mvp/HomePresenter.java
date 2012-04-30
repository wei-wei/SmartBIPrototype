package com.dblab.client.mvp;

import java.util.List;

import com.dblab.client.place.NameTokens;
import com.dblab.client.portal.AqlPortal;
import com.dblab.client.storage.MetadataManager;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class HomePresenter extends
		Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

	private MetadataManager metadataManager;
	
	public interface MyView extends View {
		void setAqlPortalList(List<AqlPortal> list);
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.home)
	public interface MyProxy extends ProxyPlace<HomePresenter> {
	}

	@Inject
	public HomePresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy,
			final MetadataManager metadataManager) {
		super(eventBus, view, proxy);
		this.metadataManager = metadataManager;
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, MainPresenter.TYPE_SetMainContent, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
	
	@Override
	protected void onReveal() {
		super.onReveal();
		getView().setAqlPortalList(metadataManager.getAqlPortalList());
	}
}
