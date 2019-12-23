package com.android.machines;

import com.android.animals.Cow;
import com.android.animals.Zebra;
import com.android.interfaces.Move;
/*
 * first method we specify the types for T,V in the interface Move
 * interface Move<T,V>{
 * to be a Cow and a Zebra
 */
public class Robot implements Move<Cow,Zebra> {

	@Override
	public void fly(Cow t) {
		System.out.println("robot fly method");
		System.out.println(t.getClass().getSimpleName()+ "is flying");
		
	}

	@Override
	public void walk(Cow t, Zebra v) {
		System.out.println("robot walk method");
		System.out.println(t.getClass().getSimpleName()+" is walking");
		System.out.println(v.getClass().getSimpleName()+" is walking");
		
	}
	/*
	 * a method can have its own type, the type supplied only applies to the length of
	 * the method and is not avaiable outside of the method
	 */

}
