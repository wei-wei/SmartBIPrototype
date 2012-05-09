package com.dblab.client.portal;

import com.dblab.client.storage.VirtualCube;
import com.extjs.gxt.ui.client.event.IconButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.extjs.gxt.ui.client.widget.custom.Portal;

public class AqlPortal extends Portal {
	private static final int columnCount = 3;
	private String name;
	private VirtualCube vCube;
	private AqlUnit aqlUnit;
	private int portletCount;
	
	public AqlPortal(int numColumns) {
		super(numColumns);
		portletCount = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VirtualCube getVirtualCube() {
		return vCube;
	}
	
	public void setVirtualCube(VirtualCube vCube) {
		this.vCube = vCube;
	}
	
	public AqlUnit getAqlUnit() {
		return aqlUnit;
	}

	public void setAqlUnit(AqlUnit aqlUnit) {
		this.aqlUnit = aqlUnit;
	}
	
	public void addListPortlet() {
		ListPortlet portlet = new ListPortlet(aqlUnit);
		configurePortlet(portlet);
		add(portlet, portletCount);
		++portletCount;
		if (portletCount > columnCount - 1) {
			portletCount = 0;
		}
	}
	
	private void configurePortlet(final ListPortlet portlet) {
		portlet.setCollapsible(true);
		portlet.setAnimCollapse(false);
		portlet.getHeader().addTool(new ToolButton("x-tool-gear",
				new ConfigSelectionListener<IconButtonEvent>(vCube, aqlUnit, portlet)));
		portlet.getHeader().addTool(new ToolButton("x-tool-close",
				new SelectionListener<IconButtonEvent>() {
					@Override
					public void componentSelected(IconButtonEvent ce) {
						portlet.removeFromParent();
					}
		}));
	}
}
