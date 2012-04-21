package com.dblab.shared.proxy;

import java.util.List;

import com.dblab.server.model.Level;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(Level.class)
public interface LevelProxy extends ValueProxy {
	String getLevelName();
	String getMdxStr();
	List<String> getMemberList();
}
