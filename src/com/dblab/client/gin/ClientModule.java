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

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(SignInPresenter.class, SignInPresenter.MyView.class,
				SignInView.class, SignInPresenter.MyProxy.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.signin);

		bindPresenter(MainPresenter.class, MainPresenter.MyView.class,
				MainView.class, MainPresenter.MyProxy.class);
	}
}
