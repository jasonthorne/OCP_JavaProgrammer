package com.android;

import com.android.Flower.FlowerBuilder;

public class Main {

	public static void main(String[] args) {
		
		Flower myFlower = new FlowerBuilder().setAge(12).build();
		System.out.println(myFlower);
		
		Flower myFlower2 = new FlowerBuilder().setAge(30).setHeight(33).build();
		System.out.println(myFlower2);
		
		//------------
		
		System.out.println("Flower with just an age:");
		Flower myFlower3 = new FlowerBuilder().setAge(12).build();
		System.out.println(myFlower3);
		
	}

}
