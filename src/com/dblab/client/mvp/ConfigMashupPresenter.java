package com.dblab.client.mvp;

import com.dblab.client.place.NameTokens;
import com.dblab.client.portal.AqlUnit;
import com.dblab.client.storage.MetadataManager;
import com.dblab.client.storage.VirtualCube;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class ConfigMashupPresenter extends
		Presenter<ConfigMashupPresenter.MyView, ConfigMashupPresenter.MyProxy> {

	private MetadataManager metadataManager;
	private VirtualCube vCube;
	private AqlUnit aqlUnit;
	
	public interface MyView extends View {
		Button getAddListButton();
		Button getAddChartButton();
		void initPortal(VirtualCube vCube, AqlUnit aqlUnit);
		void addListPortlet();
		void addChartPortlet();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.configmashup)
	public interface MyProxy extends ProxyPlace<ConfigMashupPresenter> {
	}

	@Inject
	public ConfigMashupPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy,
			MetadataManager metadataManager) {
		super(eventBus, view, proxy);
		this.metadataManager = metadataManager;
		vCube = metadataManager.getVirtualCube();
		aqlUnit = new AqlUnit(metadataManager.getVirtualCube().getAqlCube().getAqlHierarchyMap());
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, MainPresenter.TYPE_SetMainContent, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		
		getView().getAddListButton().addSelectionListener(
				new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						getView().addListPortlet();
					}
				});
		
		getView().getAddChartButton().addSelectionListener(
				new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						getView().addChartPortlet();
					}
				});
	}

	@Override
	protected void onReveal() {
		super.onReveal();
		getView().initPortal(vCube, aqlUnit);
	}

	@Override
	protected void onUnbind() {
		super.onUnbind();
	}
}
