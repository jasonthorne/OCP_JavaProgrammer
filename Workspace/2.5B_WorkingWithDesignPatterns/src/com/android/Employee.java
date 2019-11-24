package com.android;

public class Employee {
	
	double weight;
	int pps;
	
	
	public Employee(double weight, int pps) {
		super();
		this.weight = weight;
		this.pps = pps;
	}


	@Override
	public String toString() {
		return "Employee [weight=" + weight + ", pps=" + pps + "]";
	}
	


}
