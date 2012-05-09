package com.dblab.client.portal;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.model.AqlHierarchy;
import com.dblab.client.model.AqlLevel;
import com.dblab.client.storage.VirtualCube;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ListPortletConfigBox extends DialogBox {
	private HasDisplay display;
	private VirtualCube vCube;
	private ListBox comboBox;
	private Button okButton;
	private Button cancelButton;
	private List<AqlLevel> list;
	private AqlLevel sel;
	
	public ListPortletConfigBox(HasDisplay display, VirtualCube vCube) {
		super();
		
		this.display = display;
		this.vCube = vCube;
		
		initDialogBox();
	}
	
	private void initDialogBox() {
		setSize("300px", "100px");
		setHTML("New dialog");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setWidget(verticalPanel);
		verticalPanel.setSize("300px", "100px");
		
		HorizontalPanel levelPanel = new HorizontalPanel();
		levelPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		levelPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(levelPanel);
		levelPanel.setSize("300px", "40px");
		
		Label label = new Label("Level");
		label.setSize("50px", "20px");
		levelPanel.add(label);
		
		comboBox = new ListBox();
		levelPanel.add(comboBox);
		comboBox.setSize("200px", "20px");
		initComboBox();
		
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
	
	private void initComboBox() {
		list = new ArrayList<AqlLevel>();
		for (int i = 0; i < vCube.getAqlHierarchyList().size(); ++i) {
			AqlHierarchy hierarchy = vCube.getAqlHierarchyList().get(i);
			for (int j = 0; j < hierarchy.getAqlLevelArray().length; ++j) {
				AqlLevel level = hierarchy.getAqlLevel(j);
				list.add(level);
				comboBox.addItem(level.getName());
			}
		}
		
		comboBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				int i = comboBox.getSelectedIndex();
				sel = list.get(i);
			}
		});
	}
	
	private void configureDisplay() {
		display.setDisplayAqlLevel(sel);
		hide();
	}
}
