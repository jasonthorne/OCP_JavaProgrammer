package com.android;

/*
 * marks this interface as a functional interface, which can then be used in a lambda if you want. 
 */
public interface Transport<T> { //interface that uses a generic type (T)
	
	void drive(T t);
	
}


//type t is an integer
class Car implements Transport<Integer>{

	@Override
	public void drive(Integer t) {
		System.out.println("You are driving your car");
		System.out.println("your speed is: " + t);
	}
	
	//only avaliable to a CAR reference:
	public void commute() {
		System.out.println("car commute");
	}
}

//type t is a string
class Boat implements Transport<String>{

	@Override
	public void drive(String t) {
		System.out.println("You are driving your boat");
		System.out.println("your name is: " + t);
		
	}
	
	public void sail() {
		System.out.println("You are sailing your boat");
	}
	
}

//type t is a human. Human is a class we created ourselves (in the Animal class)
class Aeroplane implements Transport<Human>{

	@Override
	public void drive(Human t) {
		System.out.println("You are flying your areoplane");
		System.out.println(t + "is flying your areoplane");
	}
	
	
}










