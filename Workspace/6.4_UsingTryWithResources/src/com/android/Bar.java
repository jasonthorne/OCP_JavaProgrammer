package com.android;

public class Bar  implements AutoCloseable{

	@Override
	public void close() throws BarNoClothesException {
		System.out.println("bar closed");
	
		throw new BarNoClothesException();
	}

}
