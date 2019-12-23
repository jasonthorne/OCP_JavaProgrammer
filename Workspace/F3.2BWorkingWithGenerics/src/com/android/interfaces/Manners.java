package com.android.interfaces;

import com.android.animals.Animal;
/*
 * T can be a Animal or one of the subclasses of Animal which are
 * Elephant,Zebra,Cow. 
 * V can be a flower or a subclass of flower, Rose. both of these classes implement
 * the Life interface
 */
public interface Manners<T extends Animal,V extends Life> {

	void thankYou(T t);
	void sorry(T t,V v);
}
