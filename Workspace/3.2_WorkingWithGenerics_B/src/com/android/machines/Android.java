package com.android.machines;

import com.android.animals.Animal;
import com.android.interfaces.Behaviour;

/*
 * This is a class that has 2 generic types.
 * T will be an Animal or a subclass (Elephant, Zevbra, Cow)
 * V will be either a Whale or Lemur.
 */

public class Android<T extends Animal, V extends Behaviour> { //Behaviour can be lemur or whale
	
	T myT;
	V myV;
	
	public T walk(V myV) {
		System.out.println("Walk method called");
		//behaviour interface methods:
		myV.happy();
		myV.sad();
		return (T) new Animal();
	}
	
	/* ++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * a Method can have it's own type. 
	 * The type supplied only applies to the length of the method, and is not avaliable outside of the method. 
	 */
	
	/*
	 * This generic type ONLY applies to this method.
	 */
	public <S>void talk(S myS){
		System.out.println("Android talking");
		System.out.println("myS is a: " + myS.getClass().getSimpleName());
	}
	
	/*
	 * Java cant tell the difference between this method and the above method, as both can take ANY object
	 * 
	 * public void talk(Object myObj2) {
	}
	 */
	
}
