package com.dblab.client.mvp;

import com.dblab.client.model.Account;
import com.dblab.client.place.NameTokens;
import com.dblab.client.storage.MetadataManager;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
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
	
	private final MetadataManager metadataManager;
	private final PlaceManager placeManager;
	private SelectionListener<ButtonEvent> listener;
	
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
			final MetadataManager metadataManager,
			final PlaceManager placeManager) {
		super(eventBus, view, proxy);
		this.metadataManager = metadataManager;
		this.placeManager = placeManager;
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		
		listener =	new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Account account = new Account();
				account.setUserName(getView().getUserName());
				account.setPassword(getView().getPassword());
				if (metadataManager.userSignIn(account)) {
					metadataManager.setCurrentAccount(account);
					placeManager.revealPlace(new PlaceRequest(NameTokens.home));
				} else {
					Window.alert("User Name or Password Error!");
				}
			}
		};
		getView().getSignInButton().addSelectionListener(listener);
	}
	
	@Override
	protected void onUnbind() {
		super.onUnbind();
		getView().getSignInButton().removeSelectionListener(listener);
	}
}
