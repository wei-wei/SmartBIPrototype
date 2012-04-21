package com.dblab.shared.proxy;

import java.util.List;

import com.dblab.server.model.Dimension;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(Dimension.class)
public interface DimensionProxy extends ValueProxy {
	String getDimensionName();
	String getMdxStr();
	String getCubeName();
	List<HierarchyProxy> getHierarchyList();
}
