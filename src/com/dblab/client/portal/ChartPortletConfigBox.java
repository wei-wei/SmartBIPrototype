package com.dblab.client.portal;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.model.AqlHierarchy;
import com.dblab.client.storage.VirtualCube;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChartPortletConfigBox extends PortletConfigBox {
	private ListBox hComboBox;
	private ListBox mComboBox;
	private ListBox fhComboBox;
	private Button okButton;
	private Button cancelButton;
	private List<AqlHierarchy> hList;
	private AqlHierarchy selH;
	private List<String> mList;
	private String selM;
	private List<AqlHierarchy> fhList;
	private AqlHierarchy selFH;
	
	
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
		
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(hPanel);
		hPanel.setSize("300px", "40px");
		
		Label label = new Label("Hierarchy");
		label.setSize("50px", "20px");
		hPanel.add(label);
		
		hComboBox = new ListBox(false);
		hPanel.add(hComboBox);
		hComboBox.setSize("200px", "20px");
		initHComboBox(hComboBox, hList, selH);
		
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
		initMComboBox(mComboBox, mList, selM);
		
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
	
	private void initHComboBox(ListBox comboBox, List<AqlHierarchy> hList, AqlHierarchy sel) {
		hList = new ArrayList<AqlHierarchy>();
		List<AqlHierarchy> list = vCube.getAqlHierarchyList();
		for (int i = 0; i < list.size(); ++i) {
			AqlHierarchy h = list.get(i);
			hList.add(h);
			comboBox.addItem(h.getName());
		}

		if (hList.size() > 0) {
			sel = hList.get(0);
		}
	}
	
	private void initMComboBox(ListBox comboBox, List<String> mList, String sel) {
		mList = new ArrayList<String>();
		List<String> list = vCube.getMeasureList();
		for (int i = 0; i < list.size(); ++i) {
			String m = list.get(i);
			mList.add(m);
			comboBox.addItem(m);
		}
		
		if (mList.size() > 0) {
			sel = mList.get(0);
		}
	}
	
	private void configureDisplay() {
		hide();
	}
}
