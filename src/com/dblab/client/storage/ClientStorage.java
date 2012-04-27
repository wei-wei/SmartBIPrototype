package com.dblab.client.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dblab.client.model.Account;

public class ClientStorage {
	private List<Account> accounts;
	private Map<String, AqlPortalStorage> asPSMap;
	private SharedCubeStorage cubeStorage;
	
	public ClientStorage() {
		accounts = new ArrayList<Account>();
		asPSMap = new HashMap<String, AqlPortalStorage>();
		cubeStorage = null;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	boolean isValidAccount(Account account) {
		String userName = account.getUserName();
		String password = account.getPassword();
		
		for (int i = 0; i < accounts.size(); ++i) {
			if (userName.equals(accounts.get(i).getUserName())) {
				if (password.equals(accounts.get(i).getPassword())) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		return false;
	}
	
	public void createAsPortalStorage(String userName) {
		if (!asPSMap.containsKey(userName)) {
			AqlPortalStorage storage = new AqlPortalStorage();
			asPSMap.put(userName, storage);
		}
	}
	
	public AqlPortalStorage getUserAsPortalStorage(String userName) {
		return asPSMap.get(userName);
	}
	
	private void fetchCubeStorage() {
		if (cubeStorage == null) {
			cubeStorage = new SharedCubeStorage();
		}
	}
	
	public void createTestData() {
		fetchCubeStorage();
		
	}
}
