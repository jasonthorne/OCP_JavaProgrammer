package com.android;

@FunctionalInterface
public interface Movement<T> {
	/*
	 * when we create a lambda we will be supplying the type, which
	 * will then become t
	 */
	void walk(T t);

}
/*
 * this implements the Movement interface and type T becomes an
 * Integer
 */
class Mammal implements Movement<Integer>{

	@Override
	public void walk(Integer t) {
		System.out.println("Mammal walk method");
		System.out.println("t is of type "+t.getClass().getSimpleName());
		t=t*t;
		System.out.println(t);
	}
	/*
	 * this method takes a Movement reference and an object
	 * the movement reference and the object t can only be certain 
	 * combinations
	 * a Movement reference to a Mammal object, has to have a Integer
	 * sent with it
	 * * a Movement reference to a Cow object, has to have a Integer
	 * sent with it
	 * * a Movement reference to a Employee object, has to have a Dog
	 * sent with it
	 */
	static void takeMovement(Movement m1,Object t) {
		m1.walk(t);
	}
	
}
/*
 * here we implement the Movement interface, without specifying what
 * type T will be. In that case type T, is inferred to be an Object
 */
class Fish implements Movement{
/*
 * we have not supplied a type, so "t" will be assumed to be an
 * Object
 */
	@Override
	public void walk(Object t) {
		System.out.println("fish Walk method");
		System.out.println("t is of type "+t.getClass().getSimpleName());
		
	}
	
}
/*
 * takes everything from the Mammal class
 */
class Cow extends Mammal{
	
}
/*
 * we are providing type T to be of type Dog
 */
class Employee implements Movement<Dog>{

	@Override
	public void walk(Dog t) {
		System.out.println("employee walk method");
		System.out.println("type t is "+t.getClass().getSimpleName());
		t.bark();
		
	}
	
}
