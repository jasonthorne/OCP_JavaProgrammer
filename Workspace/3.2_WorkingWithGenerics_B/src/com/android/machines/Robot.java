package com.android.machines;

import com.android.animals.*;
import com.android.interfaces.Move;

/*
 * first we specify the types for T & V in the interface Move to be a Cow & a Zebra.
 */
public class Robot implements Move <Cow, Zebra> { 

	@Override
	public void fly(Cow t) {
		System.out.println("Robot fly method");	
		System.out.println(t.getClass().getSimpleName() + " is flying");
	}

	@Override
	public void walk(Cow t, Zebra v) {
		System.out.println("Robot walk method");	
		System.out.println(t.getClass().getSimpleName() + " is walking");
		System.out.println(v.getClass().getSimpleName() + " is walking");
	}
	
	
	
}
