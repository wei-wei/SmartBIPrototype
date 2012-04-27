package com.dblab.client.storage;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.model.AqlCube;

public class SharedCubeStorage {
	private List<AqlCube> cubeList;
	
	public SharedCubeStorage() {
		cubeList = new ArrayList<AqlCube>();
	}
	
	public List<AqlCube> getAqlCubeList() {
		return cubeList;
	}
	
	public void addAqlCube(AqlCube cube) {
		cubeList.add(cube);
	}
	
	public void createTestData() {
		
	}
}
