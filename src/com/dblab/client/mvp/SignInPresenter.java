package com.dblab.client.mvp;

import com.dblab.client.place.NameTokens;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class SignInPresenter extends
		Presenter<SignInPresenter.MyView, SignInPresenter.MyProxy> {
	
	private final PlaceManager placeManager;
	private final SelectionListener<ButtonEvent> listener;
	
	public interface MyView extends View {
		String getUserName();
		String getPassword();
		Button getSignInButton();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.signin)
	public interface MyProxy extends ProxyPlace<SignInPresenter> {
	}

	@Inject
	public SignInPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy,
			final PlaceManager placeManager) {
		super(eventBus, view, proxy);
		this.placeManager = placeManager;
		listener =	new SelectionListener<ButtonEvent>() {
						@Override
						public void componentSelected(ButtonEvent ce) {
							placeManager.revealPlace(new PlaceRequest(NameTokens.main));
						}
					};
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().getSignInButton().addSelectionListener(listener);
	}
	
	@Override
	protected void onUnbind() {
		super.onUnbind();
		getView().getSignInButton().removeSelectionListener(listener);
	}
}
