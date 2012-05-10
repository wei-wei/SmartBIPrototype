package com.dblab.client.portal;


import com.dblab.client.storage.VirtualCube;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;

public class ConfigSelectionListener<E extends ComponentEvent> extends SelectionListener<E> {
//	private VirtualCube vCube;
//	private AqlUnit aqlUnit;
//	private HasDisplay display;
	private PortletConfigBox complex;
	
	public ConfigSelectionListener(VirtualCube vCube, AqlUnit aqlUnit, HasDisplay display) {
		super();
		
//		this.vCube = vCube;
//		this.aqlUnit = aqlUnit;
//		this.display = display;
	}

	public void setPortletConfigBox(PortletConfigBox box) {
		complex = box;
	}
	
	@Override
	public void componentSelected(E ce) {
		complex.center();
		complex.show();
	}
}
