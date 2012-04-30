package com.dblab.client.storage;

public class IdManager {
	private int id;
	public IdManager() {
		id = 0;
	}
	
	public int getNewId() {
		return id++;
	}
}
