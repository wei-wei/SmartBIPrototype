package com.dblab.client.portal;


import com.dblab.client.storage.VirtualCube;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.google.gwt.user.client.ui.DialogBox;

public class ConfigSelectionListener<E extends ComponentEvent> extends SelectionListener<E> {
	private VirtualCube vCube;
	private AqlUnit aqlUnit;
	private HasDisplay display;
	private DialogBox complex;
	
	public ConfigSelectionListener(VirtualCube vCube, AqlUnit aqlUnit, HasDisplay display) {
		super();
		
		this.vCube = vCube;
		this.aqlUnit = aqlUnit;
		this.display = display;
		
		complex = new ListPortletConfigBox(display, vCube);
	}

	
	@Override
	public void componentSelected(E ce) {
		complex.center();
		complex.show();
	}
}
