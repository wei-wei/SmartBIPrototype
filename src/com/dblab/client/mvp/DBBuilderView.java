package com.dblab.client.mvp;

import java.util.Arrays;
import java.util.List;

import com.dblab.client.model.AqlCube;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.BoxLayout.BoxLayoutPack;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class DBBuilderView extends ViewImpl implements
		DBBuilderPresenter.MyView {

	private Viewport viewport;
	private ContentPanel westPanel;
	private ContentPanel centerPanel;
	private ContentPanel dimPanel;
	private ContentPanel selDimPanel;
	private ContentPanel meaPanel;
	private ContentPanel selMeaPanel;
	private Button cancelButton;
	private Button nextButton;
	
	@Inject
	public DBBuilderView() {
		viewport = new Viewport();
		viewport.setLayout(new BorderLayout());
		
		createWestPanel();
		createCenterPanel();
	}

	@Override
	public Widget asWidget() {
		return viewport;
	}
	
	private void createWestPanel() {
		westPanel = new ContentPanel();
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.WEST, 250);
		data.setSplit(true);
		data.setCollapsible(true);
		data.setMargins(new Margins(0, 5, 0, 0));
		viewport.add(westPanel, data);
	}
	
	private void createCenterPanel() {
		centerPanel = new ContentPanel();
		centerPanel.setScrollMode(Scroll.AUTO);
	
		//=============================================================
		ContentPanel panel = centerPanel;
		panel.setLayout(new RowLayout(Orientation.VERTICAL));
		
		ContentPanel addDimPanel = new ContentPanel();
		addDimPanel.setHeaderVisible(false);
		addDimPanel.setLayout(new RowLayout(Orientation.HORIZONTAL));
		dimPanel = new ContentPanel();
		dimPanel.setScrollMode(Scroll.AUTO);
		dimPanel.setHeading("Dimensions");
		/*dimPanel.setAutoHeight(true);
		dimPanel.setAutoWidth(true);*/
		selDimPanel = new ContentPanel();
		selDimPanel.setScrollMode(Scroll.AUTO);
		selDimPanel.setHeading("Selected Dimensions");
		/*selDimPanel.setAutoHeight(true);
		selDimPanel.setAutoWidth(true);*/
		addDimPanel.add(dimPanel, new RowData(0.50, 1, new Margins(4)));
		addDimPanel.add(selDimPanel, new RowData(0.50, 1, new Margins(4)));
		
		ContentPanel addMeaPanel = new ContentPanel();
		addMeaPanel.setHeaderVisible(false);
		addMeaPanel.setLayout(new RowLayout(Orientation.HORIZONTAL));
		meaPanel = new ContentPanel();
		meaPanel.setScrollMode(Scroll.AUTO);
		meaPanel.setHeading("Measures");
		/*meaPanel.setAutoHeight(true);
		meaPanel.setAutoWidth(true);*/
		selMeaPanel = new ContentPanel();
		selMeaPanel.setScrollMode(Scroll.AUTO);
		selMeaPanel.setHeading("Selected Measures");
		/*selMeaPanel.setAutoHeight(true);
		selMeaPanel.setAutoWidth(true);*/
		addMeaPanel.add(meaPanel, new RowData(0.50, 1, new Margins(4)));
		addMeaPanel.add(selMeaPanel, new RowData(0.50, 1, new Margins(4)));
		
		ContentPanel buttonPanel = new ContentPanel();
		buttonPanel.setHeaderVisible(false);
		HBoxLayout layout = new HBoxLayout();
		layout.setPadding(new Padding(5));
		layout.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);
		layout.setPack(BoxLayoutPack.CENTER);
		buttonPanel.setLayout(layout);
		cancelButton = new Button();
		cancelButton.setText("Cancel");
		nextButton = new Button();
		nextButton.setText("Next");
		buttonPanel.add(cancelButton);
		buttonPanel.add(nextButton);
		
		panel.add(addDimPanel, new RowData(1, 0.40, new Margins(4)));
		panel.add(addMeaPanel, new RowData(1, 0.40, new Margins(4)));
		panel.add(buttonPanel, new RowData(1, 0.10, new Margins(4)));
		//=============================================================
		
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		data.setMargins(new Margins());
		viewport.add(centerPanel, data);
	}

	@Override
	public void setAqlCubeList(CellList<AqlCube> cellList) {
		westPanel.removeAll();
		westPanel.add(cellList);
		viewport.layout(true);
	}

	private void setAddDimPanel(AqlCube cube) {
		
	}
	
	private void setAddMeaPanel(AqlCube cube) {
		
	}

	@Override
	public void setAqlDimView(CellTree cellTree) {
		dimPanel.removeAll();
		dimPanel.add(cellTree);
		viewport.layout(true);
	}

	@Override
	public void setAqlMeaView(CellTree cellTree) {
		meaPanel.removeAll();
		meaPanel.add(cellTree);
		viewport.layout(true);
	}

	@Override
	public void setSelAqlDimView(CellTree cellTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelAqlMeaView(CellTree cellTree) {
		// TODO Auto-generated method stub
		
	}
}
