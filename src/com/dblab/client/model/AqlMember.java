package com.dblab.client.model;

public class AqlMember {
	public String value;
	public int parentIndex;
	public int childStart;
	public int childEnd;
	
	public int amount;
	public int count; 
	
	public AqlMember(String value, int parentIndex, int childStart, int childEnd, int amount, int count) {
		this.value = value;
		this.parentIndex = parentIndex;
		this.childStart = childStart;
		this.childEnd =childEnd;
		this.amount = amount;
		this.count = count;
	}
}
