package com.dblab.client.mvp;

import com.dblab.client.place.NameTokens;
import com.dblab.client.storage.MetadataManager;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
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
	
	private final MetadataManager metadataManager;
	private final PlaceManager placeManager;
	private SelectionListener<ButtonEvent> homeListener;
	private SelectionListener<ButtonEvent> dashboardListener;
	//private SelectionListener<ButtonEvent> queryListener;
	private SelectionListener<ButtonEvent> signOutListener;
	
	public interface MyView extends View {
		ToggleButton getHomeButton();
		ToggleButton getDashboardBuilderButton();
	//	ToggleButton getQueryBuilderButton();
		Button getSignOutButton();
		void setUserName(String userName);
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.main)
	public interface MyProxy extends ProxyPlace<MainPresenter> {
	}

	@Inject
	public MainPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy,
			final MetadataManager metadataManager,
			final PlaceManager placeManager) {
		super(eventBus, view, proxy);
		this.metadataManager = metadataManager;
		this.placeManager = placeManager;
		createClickListeners();
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		
		getView().getHomeButton().addSelectionListener(homeListener);
		getView().getDashboardBuilderButton().addSelectionListener(dashboardListener);
		//getView().getQueryBuilderButton().addSelectionListener(queryListener);
		getView().getSignOutButton().addSelectionListener(signOutListener);
	}
	
	@Override
	protected void onUnbind() {
		super.onUnbind();
		
		getView().getHomeButton().removeSelectionListener(homeListener);
		getView().getDashboardBuilderButton().removeSelectionListener(dashboardListener);
		//getView().getQueryBuilderButton().removeSelectionListener(queryListener);
		getView().getSignOutButton().removeSelectionListener(signOutListener);
	}
	
	@Override
	protected void onReveal() {
		super.onReveal();
		getView().setUserName(metadataManager.getCurrentAccount().getUserName());
	}
	
	private void createClickListeners() {
		homeListener =
				new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						placeManager.revealPlace(new PlaceRequest(NameTokens.home));
					}
		};
		
		dashboardListener =
				new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						placeManager.revealPlace(new PlaceRequest(NameTokens.dbbuilder));
					}
		};
		
/*		queryListener =
				new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						placeManager.revealPlace(new PlaceRequest(NameTokens.query));
					}
		};*/
		
		signOutListener =
				new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						placeManager.revealPlace(new PlaceRequest(NameTokens.signin));
					}
		};
	}
}
