package com.dblab.client.mvp;

import com.dblab.client.place.NameTokens;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class MainPresenter extends
		Presenter<MainPresenter.MyView, MainPresenter.MyProxy> {

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_SetMainContent
		= new Type<RevealContentHandler<?>>();
	
	private final PlaceManager placeManager;
	
	public interface MyView extends View {
		HasClickHandlers getHomeButton();
		HasClickHandlers getDashboardBuilderButton();
		HasClickHandlers getQueryBuilderButton();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.main)
	public interface MyProxy extends ProxyPlace<MainPresenter> {
	}

	@Inject
	public MainPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy,
			final PlaceManager placeManager) {
		super(eventBus, view, proxy);
		this.placeManager = placeManager;
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		
		ClickHandler home = new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				placeManager.revealPlace(new PlaceRequest(NameTokens.home));
			}
		};
		registerHandler(getView().getHomeButton().addClickHandler(home));
		
		ClickHandler dashboard = new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//placeManager.revealPlace(new PlaceRequest(NameTokens.home));
			}
		};
		registerHandler(getView().getHomeButton().addClickHandler(dashboard));
		
		ClickHandler query = new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//placeManager.revealPlace(new PlaceRequest(NameTokens.home));
			}
		};
		registerHandler(getView().getHomeButton().addClickHandler(query));
	}
}
