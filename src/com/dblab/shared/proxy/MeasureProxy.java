package com.dblab.shared.proxy;

import java.util.List;

import com.dblab.server.model.Measure;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(Measure.class)
public interface MeasureProxy extends ValueProxy {
	String getMeasureName();
	String getMdxStr();
	String getCubeName();
	List<String> getMeasureList();
}
