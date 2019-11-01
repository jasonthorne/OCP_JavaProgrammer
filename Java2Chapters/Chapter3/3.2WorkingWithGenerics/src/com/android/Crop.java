package com.android;

public class Crop {

	Crop(){
		System.out.println("crop created");
	}
}

class Wheat extends Crop{
	Wheat(){
		System.out.println("Wheat created");
	}
}

class Potato extends Crop{
	Potato(){
		System.out.println("potato created");
	}
}
