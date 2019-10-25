package com.android;

/*
 * there are three ways to implement an interface with generics
 */
public interface Move<T,V> {
	void fly(T t);
	void walk(T t,V v);

}
/*
 * first way to specify the generic type in the class as below
 */
class Robot implements Move<Cow,Zebra>{

	@Override
	public void fly(Cow t) {
		System.out.println("Robot flying");
		System.out.println("type t is "+t.getClass().getSimpleName());
		t.eat();
		t.sleep();
		t.stampede();
		
	}

	@Override
	public void walk(Cow t, Zebra v) {
		System.out.println("robot walking");
		System.out.println("type t is "+t.getClass().getSimpleName());
		System.out.println("type v is "+v.getClass().getSimpleName());
		
	}
	
}
/*
 * second way is to create a generic class and use that generic with the interface
 * the Move interface will then take whatever generics are used to create the Vehicle object
 * the parameters in this case be any object
 */
class Vehicle<U,X>implements Move<U,X>{

	@Override
	public void fly(U t) {
		System.out.println("vehicle Moving");
		
	}

	@Override
	public void walk(U t, X v) {
		System.out.println("Vehicle walking");
		System.out.println("U is "+t.getClass().getSimpleName());
		System.out.println(" X is "+v.getClass().getSimpleName());
		
	}
	
}
/*
 * third way is not to use generics at all and T and V will be given the value Object
 */
class Car implements Move{

	@Override
	public void fly(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walk(Object t, Object v) {
		// TODO Auto-generated method stub
		
	}
	
}
