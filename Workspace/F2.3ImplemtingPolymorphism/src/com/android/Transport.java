package com.android;
/*
 * marks this interface as a functional interface which then can be used
 * in a lambda if you want
 */
@FunctionalInterface
public interface Transport<T> {

	void drive(T t);
}
//type t is an Integer
class Car implements Transport<Integer>{

	@Override
	public void drive(Integer t) {
		System.out.println("your are driving your car");
		System.out.println("your speed is "+t);
		
	}	
	//this is not available to a Transport reference
	public void commute() {
		
	}
}
//type t is a String
class Boat implements Transport<String>{

	@Override
	public void drive(String t) {
		System.out.println("you are driving your boat");
		System.out.println("your name is "+t);
		System.out.println("length of name is "+t.length());
		
	}
	/*
	 *this method is OVERLOADED and is a totally different method to 
	 *drive(String t) and is not related to it in any way reall
	 */
	public void drive(int t) {
		
	}
	
	public void sail() {
		System.out.println("boat sailing");
	}
	
}
/*
 * type t is is a Human, Human is a class we created ourself which is
 * in the Animal class
 */
class Aeroplane implements Transport<Human>{

	@Override
	public void drive(Human t) {
		System.out.println("you are driving your aeroplane");
		System.out.println(t+" is driving the aeroplane");
		
	}
	
	void fly() {
		System.out.println("aeroplane flying");
	}
	
}