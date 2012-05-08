package com.dblab.client.storage;

import java.util.List;

import com.dblab.client.model.Account;
import com.dblab.client.model.AqlCube;
import com.dblab.client.portal.AqlPortal;

public class TestMetadataManager implements MetadataManager {
	private AqlPortalStorage portalStorage;
	private SharedCubeStorage cubeStorage;
	private Account account;
	private VirtualCube cube;
	
	public TestMetadataManager() {
		portalStorage = new AqlPortalStorage();
		portalStorage.createTestData();
		cubeStorage = new SharedCubeStorage();
		cubeStorage.createTestData();
		account = new Account();
		cube = new VirtualCube();
	}
	
	@Override
	public boolean userSignIn(Account account) {
		Account demoAccount = new Account();
		demoAccount.setUserName("demo");
		demoAccount.setPassword("demo");
		return account.isEqual(demoAccount);
	}
	
	@Override
	public void setCurrentAccount(Account account) {
		this.account.setUserName(account.getUserName());
		this.account.setPassword(account.getPassword());
	}
	
	@Override
	public Account getCurrentAccount() {
		return account;
	}

	@Override
	public List<AqlCube> getAqlCubeList() {
		return cubeStorage.getAqlCubeList();
	}

	@Override
	public List<AqlPortal> getAqlPortalList() {
		return portalStorage.getAqlPortalList();
	}

	@Override
	public void addAqlPortal(AqlPortal portal) {
		portalStorage.addAqlPortal(portal);
	}
	
	@Override
	public VirtualCube getVirtualCube() {
		return cube;
	}
}
