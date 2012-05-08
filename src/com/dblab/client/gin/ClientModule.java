package com.dblab.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.dblab.client.place.ClientPlaceManager;
import com.dblab.client.mvp.SignInPresenter;
import com.dblab.client.mvp.SignInView;
import com.dblab.client.place.DefaultPlace;
import com.dblab.client.place.NameTokens;
import com.dblab.client.mvp.MainPresenter;
import com.dblab.client.mvp.MainView;
import com.dblab.client.mvp.HomePresenter;
import com.dblab.client.mvp.HomeView;
import com.dblab.client.mvp.DBBuilderPresenter;
import com.dblab.client.mvp.DBBuilderView;
import com.dblab.client.mvp.QueryBuilderPresenter;
import com.dblab.client.mvp.QueryBuilderView;
import com.dblab.client.mvp.ConfigMashupPresenter;
import com.dblab.client.mvp.ConfigMashupView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(SignInPresenter.class, SignInPresenter.MyView.class,
				SignInView.class, SignInPresenter.MyProxy.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.signin);

		bindPresenter(MainPresenter.class, MainPresenter.MyView.class,
				MainView.class, MainPresenter.MyProxy.class);

		bindPresenter(HomePresenter.class, HomePresenter.MyView.class,
				HomeView.class, HomePresenter.MyProxy.class);

		bindPresenter(DBBuilderPresenter.class,
				DBBuilderPresenter.MyView.class, DBBuilderView.class,
				DBBuilderPresenter.MyProxy.class);

		bindPresenter(QueryBuilderPresenter.class, QueryBuilderPresenter.MyView.class,
				QueryBuilderView.class, QueryBuilderPresenter.MyProxy.class);

		bindPresenter(ConfigMashupPresenter.class,
				ConfigMashupPresenter.MyView.class, ConfigMashupView.class,
				ConfigMashupPresenter.MyProxy.class);
	}
}
