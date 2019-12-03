package com.android;

@FunctionalInterface
public interface Flyer {

	void fly();
}


interface Glider extends Flyer{
	
	void glide();
}

class Plane implements Flyer{

	@Override
	public void fly() {
	System.out.println("Plane fly method");
		
	}

	@Override
	public String toString() {
		return "This is a Plane";
	}
	
}


class Goose implements Glider{ //implementing Glider means it ALSO implements Flyer (as glider imlements flyer)

	@Override
	public void fly() {
		System.out.println("Goose fly method");
		
	}

	@Override
	public void glide() {
		System.out.println("Goose glide method");
		
	}
	
	@Override
	public String toString() {
		return "This is a Goose";
	}
	
}




class Handlider implements Glider{ //implementing Glider means it ALSO implements Flyer (as glider imlements flyer)

	@Override
	public void fly() {
		System.out.println("Handlider fly method");
		
	}

	@Override
	public void glide() {
		System.out.println("Handlider glide method");
		
	}
	
	@Override
	public String toString() {
		return "This is a Handlider";
	}
	
}














