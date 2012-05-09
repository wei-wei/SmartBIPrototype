package com.dblab.client.storage;

import java.util.ArrayList;
import java.util.List;

import com.dblab.client.model.AqlCube;
import com.dblab.client.model.AqlDimension;
import com.dblab.client.model.AqlHierarchy;
import com.dblab.client.model.AqlLevel;
import com.dblab.client.model.AqlMeasure;

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
		IdManager idManager = new IdManager();
		TestData data = new TestData();
		AqlCube cube = new AqlCube("Sales");
		cube.setMdxStr("[Sales]");
		AqlDimension dim;
		AqlHierarchy hie;
		AqlLevel level;
		
		dim = new AqlDimension("Customers");	// create a dimension
		
		hie = new AqlHierarchy(3);				// create a hierarchy with 3 level
		hie.setAqlHierarchyId(idManager.getNewId());	// set hierarchy id
		hie.setName("Geography"); 				// set hierarchy name
		
		level = new AqlLevel();					// create new level
		level.setName("Region");				// set level name
		level.setAqlHierarchyId(hie.getAqlHierarchyId());	// set hierarchy id
		level.setLevelIndex(0);							// set level index
		level.setMdxStr("[Customers].[Gegorphy]");		// set basic mdx str
		level.setMemberArray(data.getRegionMember());	// set member array
		
		hie.addAqlLevel(level, 0);
		
		level = new AqlLevel();					// create new level
		level.setName("Country");				// set level name
		level.setAqlHierarchyId(hie.getAqlHierarchyId());	// set hierarchy id
		level.setLevelIndex(1);							// set level index
		level.setMdxStr("[Customers].[Gegorphy]");		// set basic mdx str
		level.setMemberArray(data.getCountryMember());	// set member array
		
		hie.addAqlLevel(level, 1);
		
		level = new AqlLevel();					// create new level
		level.setName("City");				// set level name
		level.setAqlHierarchyId(hie.getAqlHierarchyId());	// set hierarchy id
		level.setLevelIndex(2);							// set level index
		level.setMdxStr("[Customers].[Geography]");		// set basic mdx str
		level.setMemberArray(data.getCityMember());	// set member array
		
		hie.addAqlLevel(level, 2);
		
		dim.addAqlHierarchy(hie);
		cube.addAqlDimension(dim);
		cube.addAqlHierarchy(hie);
		
		dim = new AqlDimension("Product");	// create a dimension
		
		hie = new AqlHierarchy(3);				// create a hierarchy with 3 level
		hie.setAqlHierarchyId(idManager.getNewId());	// set hierarchy id
		hie.setName("Product"); 				// set hierarchy name
		
		level = new AqlLevel();					// create new level
		level.setName("Company");				// set level name
		level.setAqlHierarchyId(hie.getAqlHierarchyId());	// set hierarchy id
		level.setLevelIndex(0);							// set level index
		level.setMdxStr("[Product].[Product]");		// set basic mdx str
		level.setMemberArray(data.getCompanyMember());	// set member array
		
		hie.addAqlLevel(level, 0);
		
		level = new AqlLevel();					// create new level
		level.setName("Category");				// set level name
		level.setAqlHierarchyId(hie.getAqlHierarchyId());	// set hierarchy id
		level.setLevelIndex(1);							// set level index
		level.setMdxStr("[Product].[Product]");		// set basic mdx str
		level.setMemberArray(data.getCategoryMember());	// set member array
		
		hie.addAqlLevel(level, 1);
		
		level = new AqlLevel();					// create new level
		level.setName("Article");				// set level name
		level.setAqlHierarchyId(hie.getAqlHierarchyId());	// set hierarchy id
		level.setLevelIndex(2);							// set level index
		level.setMdxStr("[Product].[Product]");		// set basic mdx str
		level.setMemberArray(data.getArticleMember());	// set member array
		
		hie.addAqlLevel(level, 2);
		
		dim.addAqlHierarchy(hie);
		cube.addAqlDimension(dim);
		cube.addAqlHierarchy(hie);
		
/*		dim = new AqlDimension("Time");	// create a dimension
		
		hie = new AqlHierarchy(3);				// create a hierarchy with 3 level
		hie.setAqlHierarchyId(idManager.getNewId());	// set hierarchy id
		hie.setName("Calendar"); 				// set hierarchy name
		
		level = new AqlLevel();					// create new level
		level.setName("Year");				// set level name
		level.setAqlHierarchyId(hie.getAqlHierarchyId());	// set hierarchy id
		level.setLevelIndex(0);							// set level index
		level.setMdxStr("[Time].[Calendar]");		// set basic mdx str
		level.setMemberArray(data.getCompanyMember());	// set member array
		
		hie.addAqlLevel(level, 0);
		
		level = new AqlLevel();					// create new level
		level.setName("Quarter");				// set level name
		level.setAqlHierarchyId(hie.getAqlHierarchyId());	// set hierarchy id
		level.setLevelIndex(1);							// set level index
		level.setMdxStr("[Time].[Calendar]");		// set basic mdx str
		level.setMemberArray(data.getCategoryMember());	// set member array
		
		hie.addAqlLevel(level, 1);
		
		level = new AqlLevel();					// create new level
		level.setName("Month");				// set level name
		level.setAqlHierarchyId(hie.getAqlHierarchyId());	// set hierarchy id
		level.setLevelIndex(2);							// set level index
		level.setMdxStr("[Time].[Calendar]");		// set basic mdx str
		level.setMemberArray(data.getArticleMember());	// set member array
		
		hie.addAqlLevel(level, 2);
		
		dim.addAqlHierarchy(hie);
		cube.addAqlDimension(dim);
		cube.addAqlHierarchy(hie);*/
		
		AqlMeasure measure = new AqlMeasure();
		measure.setName("Measures");
		measure.addAqlMeasure("Amount");
		measure.addAqlMeasure("Count");
		measure.setMdxStr("[Measures]");
		cube.addAqlMeasure(measure);
		
		cubeList.add(cube);
	}
}
