package com.android.machines;

import com.android.interfaces.Move;


/*
 * If no type information is supplied, both T & V are going to be Objects. 
 * As soon as you put in a diamond operator though, you HAVE TO supply a type for these.
 */

public class Car implements Move{

	@Override
	public void fly(Object t) {
		System.out.println(t.getClass().getSimpleName() + " is flying");
		
	}

	@Override
	public void walk(Object t, Object v) {
		System.out.println(t.getClass().getSimpleName() + " is walking");
		System.out.println(v.getClass().getSimpleName() + " is walking");
		
	}

}
