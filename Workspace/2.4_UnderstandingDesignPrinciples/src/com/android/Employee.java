package com.android;

public class Employee {
	


}


class Accountant extends Employee{
	
}

interface Movement{
	void walk();
	void fly();
}



class Astronaut extends Employee implements Movement{

	@Override
	public void walk() {
		System.out.println("Astronaut walk");
		
	}

	@Override
	public void fly() {
		System.out.println("Astronaut fly");
		
	}
	
}