package com.android.interfaces;
/*
 * THREE classes implement this Move interface: 
 * + Robot implements and specifies the generic type used.
 * + Vehicle implements and uses it's own generics to supply the type.
 * + Car implements but doesnt specify any type.
 */

public interface Move<T, V>{
	
	//abstract methods for this interface:
	void fly(T t); 
	void walk(T t, V v);

}
