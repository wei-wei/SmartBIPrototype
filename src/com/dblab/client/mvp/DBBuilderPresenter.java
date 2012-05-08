package com.dblab.client.mvp;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.model.AqlCube;
import com.dblab.client.model.AqlHierarchy;
import com.dblab.client.model.DSDimTreeViewModel;
import com.dblab.client.model.DimTreeViewModel;
import com.dblab.client.model.MeaTreeViewModel;
import com.dblab.client.place.NameTokens;
import com.dblab.client.storage.MetadataManager;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class DBBuilderPresenter extends
		Presenter<DBBuilderPresenter.MyView, DBBuilderPresenter.MyProxy> {

	private MetadataManager metadataManager;
	private PlaceManager placeManager;
	
	public interface MyView extends View {
		void setAqlCubeList(CellList<AqlCube> cellList);
		void setAqlDimView(CellTree cellTree);
		void setAqlMeaView(CellTree cellTree);
		void setSelAqlDimView(CellTree cellTree);
		void setSelAqlMeaView(CellList<String> cellList);
		Button getCancelButton();
		Button getNextButton();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.dbbuilder)
	public interface MyProxy extends ProxyPlace<DBBuilderPresenter> {
	}

	@Inject
	public DBBuilderPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy,
			MetadataManager metadataManager,
			final PlaceManager placeManager) {
		super(eventBus, view, proxy);
		this.metadataManager = metadataManager;
		this.placeManager = placeManager;
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, MainPresenter.TYPE_SetMainContent, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		
		getView().getCancelButton().addSelectionListener(
				new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
					}
				});
		
		getView().getNextButton().addSelectionListener(
				new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						placeManager.revealPlace(new PlaceRequest(NameTokens.configmashup));
					}
				});
	}
	
	@Override
	protected void onUnbind() {
		super.onUnbind();
		getView().getCancelButton().removeAllListeners();
		getView().getNextButton().removeAllListeners();
	}
	
	@Override
	protected void onReveal() {
		super.onReveal();
		initCubeList();
	}
	
	private void initCubeList() {
		AbstractCell<AqlCube> cell = new AbstractCell<AqlCube>() {
			@Override
			public void render(com.google.gwt.cell.client.Cell.Context context,
					AqlCube value, SafeHtmlBuilder sb) {
				if (value == null) {
					return;
				}
				
				sb.appendHtmlConstant("<div>");
				sb.appendEscaped(value.getName());
				sb.appendHtmlConstant("</div>");
			}
		};
		
		List<AqlCube> list = metadataManager.getAqlCubeList();
		CellList<AqlCube> cellList = new CellList<AqlCube>(cell);
		cellList.setRowCount(list.size(), true);
		cellList.setRowData(0, list);
		
		final SingleSelectionModel<AqlCube> selectionModel =
				new SingleSelectionModel<AqlCube>();
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				selectedAqlCube(selectionModel.getSelectedObject());
			}
		});
		cellList.setSelectionModel(selectionModel);
		getView().setAqlCubeList(cellList);
	}
	
	private void selectedAqlCube(AqlCube cube) {
		metadataManager.getVirtualCube().setAqlCube(cube);
		
		final MultiSelectionModel<AqlHierarchy> dimSelectionModel =
				new MultiSelectionModel<AqlHierarchy>();
		dimSelectionModel.addSelectionChangeHandler(
				new SelectionChangeEvent.Handler() {
					@Override
					public void onSelectionChange(SelectionChangeEvent event) {
						List<AqlHierarchy> selected = 
								new ArrayList<AqlHierarchy>(dimSelectionModel.getSelectedSet());
						updateDimensionDataSet(selected);
					}
		});
		
		CellTree.Resources res = GWT.create(CellTree.BasicResources.class);
		CellTree cellTree = new CellTree(
				new DimTreeViewModel(dimSelectionModel, cube.getAqlDimensionList()), null, res);
		
		getView().setAqlDimView(cellTree);
		
		
		final MultiSelectionModel<String> meaSelectionModel =
				new MultiSelectionModel<String>();
		meaSelectionModel.addSelectionChangeHandler(
				new SelectionChangeEvent.Handler() {			
					@Override
					public void onSelectionChange(SelectionChangeEvent event) {
						List<String> selected =
								new ArrayList<String>(meaSelectionModel.getSelectedSet());
						updateMeasureDataSet(selected);
					}
		});
		
		CellTree.Resources res2 = GWT.create(CellTree.BasicResources.class);
		CellTree cellTree2 = new CellTree(
				new MeaTreeViewModel(meaSelectionModel, cube.getAqlMeasureList()), null, res2);
		
		getView().setAqlMeaView(cellTree2);
	}
	
	private void updateDimensionDataSet(List<AqlHierarchy> list) {
		metadataManager.getVirtualCube().setAqlHierarchyList(list);
		
		CellTree.Resources res = GWT.create(CellTree.BasicResources.class);
		CellTree cellTree = new CellTree(
				new DSDimTreeViewModel(null, list), null, res);
		getView().setSelAqlDimView(cellTree);
	}
	
	private void updateMeasureDataSet(List<String> list) {
		metadataManager.getVirtualCube().setMeasureList(list);
		
		AbstractCell<String> cell = new AbstractCell<String>() {
			@Override
			public void render(Context context,
					String value, SafeHtmlBuilder sb) {
				if (value == null) {
					return;
				}
				
				sb.appendHtmlConstant("<div>");
				sb.appendEscaped(value);
				sb.appendHtmlConstant("</div>");
			}
		};
		
		CellList<String> cellList = new CellList<String>(cell);
		cellList.setRowCount(list.size(), true);
		cellList.setRowData(0, list);
		
		getView().setSelAqlMeaView(cellList);
	}
	
}
