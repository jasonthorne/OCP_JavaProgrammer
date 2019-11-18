package com.android;


@FunctionalInterface
public interface Movement<T> {
	
	/*
	 * When we create a lambda, we will be supplying the type which will then become t. 
	 */
	void walk(T t);

}

/*
 * This implements the Movement interface and type T becomes an integer
 */
class Mammal implements Movement<Integer>{

	@Override
	public void walk(Integer t) {
		System.out.println("Mammal walk method");
		System.out.println("t is of type: " + t.getClass().getSimpleName());
		t=t*t;
		System.out.println(t);
	}
	
	/*
	 * This method takes a movement reference and an object:
	 */
	static void takeMovement(Movement m1, Object t) {
		m1.walk(t); //this can be an Integer, an Object, a Dog 
	}
	
}

/*
 * Here we implement the movement interface without spcifiying what type t will be. 
 * In that case, type t is inferred to be an object:
 */
class Fish implements Movement{

	//We haven't supplied a type, so t will be assumed to be an Object.
	@Override
	public void walk(Object t) {
		System.out.println("fish walk method");
		System.out.println("t is of type: " + t.getClass().getSimpleName());
	}
	
}

/*
 * This takes everything from the Mammal class:
 */
class Cow extends Mammal{
	
}



/*
 * We are providing type t to be of type Dog:
 */
class Employee implements Movement<Dog>{

	@Override
	public void walk(Dog t) {
		
		System.out.println("Employee walk method");
		System.out.println("t is of type: " + t.getClass().getSimpleName());
		t.bark();
	}
	
}








