package com.android;

import java.util.Random;
import java.util.concurrent.RecursiveTask;

public class Employee extends RecursiveTask<Double>{
	
	/**
	 * RecursiveTask<Double> is the same as Submit<double>,
	 * as it has a Double Compute() method
	 */
	
	
	private int start; //starting point, which will be 0
	private int end; //end point which will be 10
	private Double[]weights;// array of weights that each manager measures
	static int empCounter=0; //total amount of employees created
	static int empsWeighingAnimalsCounter=0; //total amount of employees used for weighing animals
	
	public Employee(Double[] weights, int start, int end) {
		empCounter++;
		this.start = start;
		this.weights = weights;
		this.end = end;
	}
	
	
	
	

	@Override
	protected Double compute() {
		
		if(end-start<=3) {
			empsWeighingAnimalsCounter++; //keeps count of how many employees do the actual weighing
			
			double sum=0; //this will be the total weight of the animals
			
			for(int i=start;i<end;i++) {
				//this generates random numbers between 1 & 100 and then casts them to be doubles.
				weights[i]=(double) new Random().nextInt(100);
				System.out.println("animal weighed: " + weights[i]);
				sum +=weights[i];
			}
		}
		
		return null;
	}
	

}


