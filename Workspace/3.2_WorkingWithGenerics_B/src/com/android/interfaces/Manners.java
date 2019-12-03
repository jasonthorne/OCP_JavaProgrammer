package com.android.interfaces;

import com.android.animals.Animal;

//interface who's first data type is Animal. Life is a FUCTIONAL interface which Flower implements/

/*
 * T can be an Animal or one of the subclasses of Animal, which are: Elephant, Zebra or Cow.
 * V can be a Flower or a subclass of Flower (Rose). Both of these classes implement the Life interface.
 */
public interface Manners<T extends Animal, V extends Life>{ 

	void thankYou(T t); //an Animal
	
	void sorry(T t, V v); //An Animal and something that extends Life interface
}
