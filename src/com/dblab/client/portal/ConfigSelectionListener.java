package com.dblab.client.portal;


import com.dblab.client.storage.VirtualCube;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;

public class ConfigSelectionListener<E extends ComponentEvent> extends SelectionListener<E> {
	private VirtualCube vCube;
	private AqlUnit aqlUnit;
	private HasDisplay display;
	private Dialog complex;
	
	public ConfigSelectionListener(VirtualCube vCube, AqlUnit aqlUnit, HasDisplay display) {
		super();
		
		this.vCube = vCube;
		this.aqlUnit = aqlUnit;
		this.display = display;
	
		complex = new Dialog();
		complex.setBodyBorder(false);  
    //complex.setIcon(Resources.ICONS.side_list());  
		complex.setHeading("BorderLayout Dialog");  
		complex.setWidth(400);  
		complex.setHeight(225);  
		complex.setHideOnButtonClick(true);  
  
		BorderLayout layout = new BorderLayout();  
		complex.setLayout(layout);  
  
    // west  
		ContentPanel panel = new ContentPanel();  
		panel.setHeading("West");  
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.WEST, 150, 100, 250);  
		data.setMargins(new Margins(0, 5, 0, 0));  
		data.setSplit(true);  
		data.setCollapsible(true);  
		complex.add(panel, data);  
  
    // center  
		panel = new ContentPanel();  
		panel.setHeading("Center");  
		data = new BorderLayoutData(LayoutRegion.CENTER);  
		complex.add(panel, data);
	}

	
	@Override
	public void componentSelected(E ce) {
		complex.show();
	}
}
