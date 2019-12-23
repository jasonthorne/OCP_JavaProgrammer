package com.android;
@FunctionalInterface
public interface Flyer {
	void fly();
}
/*
 * Glider is NOT a functional interface as it inherites the void fly() method, so
 * this interface actually contains two abstract methods
 */
//@FunctionalInterface
interface Glider extends Flyer{
	void glide();
}


class Plane implements Flyer{

	@Override
	public void fly() {
		System.out.println("plane flying");
		
	}
	@Override
	public String toString() {
		return "this is a plane";
	}
	
}

class Goose implements Glider{

	@Override
	public void fly() {
		System.out.println("goose flying");
		
	}

	@Override
	public void glide() {
		System.out.println("goose gliding");
		
	}
	
	@Override
	public String toString() {
		return "this is a goose";
	}
	
}

class Hanglider implements Glider{

	@Override
	public void fly() {
		System.out.println("hanglider flying");
		
	}

	@Override
	public void glide() {
		System.out.println("hanglider gliding");
		
	}
	
	@Override
	public String toString() {
		return "this is a hanglider";
	}
	
}
