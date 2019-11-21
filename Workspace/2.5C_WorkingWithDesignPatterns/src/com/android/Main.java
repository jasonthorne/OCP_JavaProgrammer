package com.android;

import com.android.Flower.FlowerBuilder;

public class Main {

	public static void main(String[] args) {
		
		Flower myFlower = new FlowerBuilder().setAge(12).Build();
		System.out.println(myFlower);
		
		Flower myFlower2 = new FlowerBuilder().setAge(30).setHeight(33).Build();
		System.out.println(myFlower2);
	}

}
