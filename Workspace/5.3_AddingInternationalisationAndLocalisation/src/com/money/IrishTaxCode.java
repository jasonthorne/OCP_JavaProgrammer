package com.money;

public class IrishTaxCode {
	
	double rate;
	String band;
	
	IrishTaxCode(){
		rate= 22.5;
		band = "xyz";
	}
	
	public String toString() {
		return "rate is: " + rate + "band is: " + band;
	}

}
