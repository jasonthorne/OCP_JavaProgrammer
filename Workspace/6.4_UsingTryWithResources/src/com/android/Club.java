package com.android;

public class Club implements AutoCloseable{

	@Override
	public void close() throws ClubNoClothesException {
		System.out.println("club closed");
		
		throw new ClubNoClothesException();
	}

}
