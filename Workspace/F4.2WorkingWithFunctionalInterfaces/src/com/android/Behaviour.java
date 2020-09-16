package com.android;
@FunctionalInterface
public interface Behaviour<T,U,V,R> {
	//only one abstract method allowed for functional interfaces
	/*
	 * lambdas ONLY care about abstract methods and there can only be ONE
	 */
	R happy(T t,U u,V v);
	/*
	 * you can have as many static methods as you want in a functional interface
	 * HOWEVER, you can't use any of the generics in a static method
	 * will not recognise type T
	 */
/*	static String crowd(T t) {
		
	}*/
	static String crowd(String str,Integer num,Integer num2) {
		System.out.println("crowd method takes a String, Integer and Integer");
		return "my String";
	}
	/*
	 * you can have as many default methods as you want and you can use the
	 * generics
	 */
	default int riot(T t,U u) {
		System.out.println("default rioting method");
		return 1;
	}
	
	default double cheer(T t,Integer num) {
		return 1.0;
	}

}
