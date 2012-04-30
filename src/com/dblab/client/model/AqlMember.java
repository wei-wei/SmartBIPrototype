package com.dblab.client.model;

public class AqlMember {
	public String value;
	public int parentIndex;
	public int childStart;
	public int childEnd;
	
	public AqlMember(String value, int parentIndex, int childStart, int childEnd) {
		this.value = value;
		this.parentIndex = parentIndex;
		this.childEnd =childEnd;
	}
}
