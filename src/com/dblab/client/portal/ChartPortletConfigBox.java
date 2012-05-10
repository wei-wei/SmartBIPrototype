package com.dblab.client.portal;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.model.AqlHierarchy;
import com.dblab.client.storage.VirtualCube;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.visualization.client.visualizations.corechart.CoreChart;

public class ChartPortletConfigBox extends PortletConfigBox {
	private ListBox tComboBox;
	private ListBox hComboBox;
	private ListBox mComboBox;
//	private ListBox fhComboBox;
	private Button okButton;
	private Button cancelButton;
	private List<AqlHierarchy> hList;
	private AqlHierarchy selH;
	private List<String> mList;
	private String selM;
//	private List<AqlHierarchy> fhList;
//	private AqlHierarchy selFH;
	private CoreChart.Type type;
	
	private static final CoreChart.Type[] types = {CoreChart.Type.AREA, CoreChart.Type.BARS, CoreChart.Type.COLUMNS, CoreChart.Type.PIE};
	
	public ChartPortletConfigBox(HasDisplay display, VirtualCube vCube) {
		super(display, vCube);
		
		initDialogBox();
	}
	
	private void initDialogBox() {
		setSize("300px", "180px");
		setHTML("Widget Configuration");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setWidget(verticalPanel);
		verticalPanel.setSize("300px", "180px");
		
		HorizontalPanel tPanel = new HorizontalPanel();
		tPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		tPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(tPanel);
		tPanel.setSize("300px", "40px");
		
		Label label = new Label("Chart Type");
		label.setSize("50px", "20px");
		tPanel.add(label);
		
		tComboBox = new ListBox(false);
		tPanel.add(tComboBox);
		tComboBox.setSize("200px", "20px");
		initTComboBox();
		
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(hPanel);
		hPanel.setSize("300px", "40px");
		
		label = new Label("Hierarchy");
		label.setSize("50px", "20px");
		hPanel.add(label);
		
		hComboBox = new ListBox(false);
		hPanel.add(hComboBox);
		hComboBox.setSize("200px", "20px");
		initHComboBox();
		
		HorizontalPanel mPanel = new HorizontalPanel();
		mPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		mPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(mPanel);
		mPanel.setSize("300px", "40px");
		
		label = new Label("Measure");
		label.setSize("50px", "20px");
		mPanel.add(label);
		
		mComboBox = new ListBox(false);
		mPanel.add(mComboBox);
		mComboBox.setSize("200px", "20px");
		initMComboBox();
		
/*		HorizontalPanel fhPanel = new HorizontalPanel();
		fhPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		fhPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(fhPanel);
		fhPanel.setSize("300px", "40px");
		
		label = new Label("Hierarchy");
		label.setSize("50px", "20px");
		fhPanel.add(label);
		
		fhComboBox = new ListBox(false);
		fhPanel.add(fhComboBox);
		fhComboBox.setSize("200px", "20px");
		initHComboBox(fhComboBox, fhList, selFH);*/
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(buttonPanel);
		buttonPanel.setSize("300px", "40px");
		
		okButton = new Button("New button");
		okButton.setSize("100px", "20px");
		okButton.setText("OK");
		okButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				configureDisplay();
			}
		});
		buttonPanel.add(okButton);
		
		cancelButton = new Button("New button");
		cancelButton.setSize("100px", "20px");
		cancelButton.setText("Cancel");
		cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		buttonPanel.add(cancelButton);
	}
	
	private void initTComboBox() {
		for (int i = 0; i < types.length; ++i) {
			tComboBox.addItem(types[i].toString());
		}
		
		tComboBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				int i = tComboBox.getSelectedIndex();
				type = types[i];
			}
		});
		
		type = types[0];
	}
	
	private void initHComboBox() {
		hList = new ArrayList<AqlHierarchy>();
		List<AqlHierarchy> list = vCube.getAqlHierarchyList();
		for (int i = 0; i < list.size(); ++i) {
			AqlHierarchy h = list.get(i);
			hList.add(h);
			hComboBox.addItem(h.getName());
		}
		
		hComboBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				int i = hComboBox.getSelectedIndex();
				selH = hList.get(i);
			}
		});
		
		if (hList.size() > 0) {
			selH = hList.get(0);
		}
	}
	
	private void initMComboBox() {
		mList = new ArrayList<String>();
		List<String> list = vCube.getMeasureList();
		for (int i = 0; i < list.size(); ++i) {
			String m = list.get(i);
			mList.add(m);
			mComboBox.addItem(m);
		}
		
		mComboBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				int i = mComboBox.getSelectedIndex();
				selM = mList.get(i);
			}
		});
		
		if (mList.size() > 0) {
			selM = mList.get(0);
		}
	}
	
	private void configureDisplay() {
		display.setDisplayChartType(type);
		display.setDisplayAqlHierarchy(selH);
		display.setDisplayAqlMeasure(selM);
		display.updateDisplay();
		hide();
	}
}
