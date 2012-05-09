package com.dblab.client.portal;

import com.dblab.client.storage.VirtualCube;
import com.google.gwt.user.client.ui.DialogBox;

public class PortletConfigBox extends DialogBox {
	protected HasDisplay display;
	protected VirtualCube vCube;
	
	public PortletConfigBox(HasDisplay display, VirtualCube vCube) {
		super();
		this.display = display;
		this.vCube = vCube;
	}
	
	
}
