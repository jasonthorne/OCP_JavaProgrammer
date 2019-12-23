package com.android;

public class Employee implements Cloneable {
	double weight;
	int pps;
	
	Employee(double weight,int pps){
		this.weight=weight;
		this.pps=pps;
	//	Employee emp1=this.clone();
	}
	
/*	Employee shallowCopy() {
		Object newEmployee=this.clone();
		Employee emp1=(Employee) newEmployee;
	//	return (Employee) this.clone();
	}*/
	
	

}
