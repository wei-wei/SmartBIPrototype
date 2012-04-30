package com.dblab.client.gin;

import com.dblab.client.storage.MetadataManager;
import com.dblab.client.storage.TestMetadataManager;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class SmartBIModule extends AbstractGinModule {
	@Override
	protected void configure() {
		bind(MetadataManager.class).to(TestMetadataManager.class).in(Singleton.class);
	}
}
