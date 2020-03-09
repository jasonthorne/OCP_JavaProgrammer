package com.android;

import java.util.concurrent.RecursiveAction;

public class Manager extends RecursiveAction {
	
	
	//for dealing with our 10 weights:
	private int start; //starting point, which will be 0
	private int end; //end point which will be 10
	private Double[]weights;// array of weights that each manager measures
	
	static int counter = 0;
	
	public Manager(Double[] weights, int start, int end) {
		counter++;
		this.start = start;
		this.weights = weights;
		this.end = end;
	}

	
	/*
	 * This is your recursion method. 
	 * So you have to have an if statement or similar.
	 * The if part is the BASE CASE we are working down to.
	 * In this case it will be 1 manager weighing 3 animals.
	 * The else part is the recursive part, which will keep calling the compute method untill it gets down to the base case.  
	 */
	@Override
	protected void compute() {
		
		if(end-start <= 3) { //BASE CASE - only 3 at most animals to be weighed.
			for(int i=start;i<end;i++) {
				weights[i]=Math.random()*100;
				System.out.println("animal number is: " + i + " weights is: " + weights[i]);
			}
		}else { //RECURSIVE PART (that works down to the base case)
			
			int middle = start+((end - start)/2);
			
			System.out.println("start is: " + start+ " middle is: " + middle + ". end is: " + end);
			
			invokeAll(new Manager(weights,start,middle), new Manager(weights,middle, end));
		}

	}
	
	
	

}

