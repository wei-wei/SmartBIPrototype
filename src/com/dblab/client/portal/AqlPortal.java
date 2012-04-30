package com.dblab.client.portal;

import com.extjs.gxt.ui.client.widget.custom.Portal;

public class AqlPortal extends Portal {
	private String name;
	private AqlUnit aqlUnit;
	
	public AqlPortal(int numColumns) {
		super(numColumns);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AqlUnit getAqlUnit() {
		return aqlUnit;
	}

	public void setAqlUnit(AqlUnit aqlUnit) {
		this.aqlUnit = aqlUnit;
	}
}
