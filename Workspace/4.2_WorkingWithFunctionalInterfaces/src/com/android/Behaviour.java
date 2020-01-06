package com.android;

@FunctionalInterface
public interface Behaviour<T,U,V,R> {
	
	
	//Only one abstract method allowed for functional interfaces:
	R happy(T t, U u, V v); //Lambdas ONLY care about abstract methods and there can ONLY be ONE. ++++++++++++++++++++
	
	
	//static method (can haveas many as you want in a functional interface)
	//HOWEVER you cant use any of the generics inside a static method
	/*
	static String crowd(T t) {
		
	}*/
	
	static String crowd(String str, Integer num, Integer num2) {
		System.out.println("crowd takes a String, Integer and Integer");
		return "myString";
	}
	
	//default method:
	default int riot(T t, U u) {
		System.out.println("default riot method");
		return 1;
	}
	
	//another default method:
	default double cheer(T t, Integer num) {
		return 3.3;
	}

}
