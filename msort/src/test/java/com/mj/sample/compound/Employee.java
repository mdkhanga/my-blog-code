package com.mj.sample.compound;

public class Employee {
	
	private String name ;
	private int		id ;
	
	public Employee(String s, int i) {
		
		name = s ;
		id = i ;
	}

	public void setName(String s) {
		
		name = s ;
	}
	
	public String getName() {
		return name ;
	}
	
	public void setId(int i) {
		
		id = i ;
		
	}
	
	public int getId() {
		
		return id ;
	}
	
	public String toString() {
		
		return name + id ;
	}
}
