package com.android.interfaces;

@FunctionalInterface
public interface Life {
	
	//an interface with ONLY one abstract method is a FUBNCTIONAL interface, and can then be used in a lambda
	void grow();
	
	
	//still a functional interface regardless of how many static or defaults are in this interface:
	default void defaultMethod() {
		
	}
	
	static void staticMethod() {
		
	}

}
