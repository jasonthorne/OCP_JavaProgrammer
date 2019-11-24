package com.android;

@FunctionalInterface
public interface Move<T> { 
	
	//this abstract method takes a generic type
	T run(T num);

}
