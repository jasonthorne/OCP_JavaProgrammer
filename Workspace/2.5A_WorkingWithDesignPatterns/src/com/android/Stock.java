package com.android;

public class Stock {
	
	static int counter = 0;
	int stockId;
	
	
	private enum products{
		BREAD(){
			//this.amount = 500;
		}, MILK, BUTTER;
		//static int amount;
		
	}
	
	
	private int bread = 500; //amount of bread in stock
	private int milk = 1000; //amount of milk in stock
	private int butter = 700; //amount of butter in stock
	
	private Stock() {
		System.out.println("stock object created");
		counter++;
		stockId=counter;
	}
	
	//this runs only once, and therefore creates only one Stock object. 
	private static final Stock stockInstance = new Stock();
	
	
	//if this is the first thing done with the class, this will create our stock instance object:
	public static Stock getStock() {
		return stockInstance;
	}

}
