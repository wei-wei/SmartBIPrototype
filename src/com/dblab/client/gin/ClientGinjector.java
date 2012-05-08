package com.dblab.client.gin;

import com.dblab.client.mvp.DBBuilderPresenter;
import com.dblab.client.mvp.HomePresenter;
import com.dblab.client.mvp.MainPresenter;
import com.dblab.client.mvp.QueryBuilderPresenter;
import com.dblab.client.mvp.SignInPresenter;
import com.dblab.client.storage.MetadataManager;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.dblab.client.mvp.ConfigMashupPresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class, SmartBIModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	AsyncProvider<SignInPresenter> getSignInPresenter();

	AsyncProvider<MainPresenter> getMainPresenter();

	AsyncProvider<HomePresenter> getHomePresenter();

	AsyncProvider<DBBuilderPresenter> getDBBuilderPresenter();

	AsyncProvider<QueryBuilderPresenter> getQueryPresenter();
	
	MetadataManager getMetadataManager();

	AsyncProvider<ConfigMashupPresenter> getConfigMashupPresenter();
}
