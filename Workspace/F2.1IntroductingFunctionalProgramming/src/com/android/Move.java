package com.android;

@FunctionalInterface
public interface Move<T> {
	//this abstract method takes a int and returns an int
	T run(T num);

}
