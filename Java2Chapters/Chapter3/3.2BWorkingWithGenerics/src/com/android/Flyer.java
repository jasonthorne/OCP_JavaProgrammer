package com.android;

public interface Flyer {
	void fly();
}

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

class Goose implements Flyer,Glider{

	@Override
	public void fly() {
		System.out.println("Goose flying");
		
	}

	@Override
	public void glide() {
		System.out.println("Goose Flying");
		
	}
	@Override
	public String toString() {
		return "this is a goose";
	}
	
}
//as Glider extends Flyer it also has to implement methods for the Flyer class
class Hanglider implements Glider{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void glide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "this is a Hanglider";
	}
	
}
