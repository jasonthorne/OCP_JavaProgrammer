package com.android;
/*
 * marks this interface as an interface that can be used as a lambda
 */
@FunctionalInterface
public interface Movement<T> {
	
	void walk(T t);

}
/*
 * here we have said type T to be an integer
 */
class Mammal implements Movement<Integer>{

	@Override
	public void walk(Integer t) {
		System.out.println("mammal walk method");
		
	}
	/*
	 * this method takes a Movemetn reference and a Object that will be sent to the walk method
	 * (Integer for Mammals and cows, Dog for employee)
	 */
	static void takeMovement(Movement m1,Object t) {
		m1.walk(t);
	}

	
	
}

class Cow extends Mammal{
	
}

class Employee implements Movement<Dog>{

	@Override
	public void walk(Dog t) {
		System.out.println("employee walking with my Dog");
		t.bark();
		
	}
	
}
/*
 * we do not provide a type for T, so type T then is assumed to be an object
 */
class Horse implements Movement{

	/*
	 * not given a type so Type t for this method is assumed to be an object
	 */
	@Override
	public void walk(Object t) {
		System.out.println("horse walking method");
		
	}
	
}
