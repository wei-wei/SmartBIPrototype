package com.dblab.shared.proxy;

import java.util.List;

import com.dblab.server.model.Hierarchy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(Hierarchy.class)
public interface HierarchyProxy extends ValueProxy {
	String getHierarchyName();
	String getMdxStr();
	List<LevelProxy> getLevelList();
}
