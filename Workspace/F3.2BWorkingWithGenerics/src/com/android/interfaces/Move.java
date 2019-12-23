package com.android.interfaces;
/*
 * three classes implement the Move interface
 * Robot implements and specifies the generic type to be used 
 * Vehicle implements and uses it's own generics to supply a type
 * Car implments but does not specify any type
 */
public interface Move<T,V> {
	void fly(T t);
	void walk(T t,V v);

}
