package com.dblab.client.storage;

import java.util.List;

import com.dblab.client.model.Account;
import com.dblab.client.model.AqlCube;
import com.dblab.client.portal.AqlPortal;


public interface MetadataManager {
	public boolean userSignIn(Account account);
	public void setCurrentAccount(Account account);
	public Account getCurrentAccount();
	public List<AqlCube> getAqlCubeList();
	public List<AqlPortal> getAqlPortalList();
	public void addAqlPortal(AqlPortal portal);
}
