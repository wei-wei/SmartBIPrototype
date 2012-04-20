package com.dblab.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.dblab.client.gin.ClientModule;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.gwt.inject.client.AsyncProvider;
import com.dblab.client.mvp.SignInPresenter;
import com.dblab.client.mvp.MainPresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	AsyncProvider<SignInPresenter> getSignInPresenter();

	AsyncProvider<MainPresenter> getMainPresenter();
}
