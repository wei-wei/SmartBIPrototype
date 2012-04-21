package com.dblab.shared.proxy;

import java.util.List;

import com.dblab.server.model.Cube;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(Cube.class)
public interface CubeProxy extends ValueProxy {
	String getCubeName();
	String getMdxStr();
	List<DimensionProxy> getDimensionList();
	List<MeasureProxy> getMeasureList();
}
