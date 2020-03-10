package com.android;

import java.util.concurrent.RecursiveAction;

public class Manager extends RecursiveAction {
	
	/**
	 * This has a method - compute, which is the same as a Runnable object. 
	 */
	
	
	//for dealing with our 10 weights:
	private int start; //starting point, which will be 0
	private int end; //end point which will be 10
	private Double[]weights;// array of weights that each manager measures
	
	static int counter = 0;
	static int manageCounter = 0;
	
	
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
	 * The else part is the recursive part, which will keep calling the compute method until it gets down to the base case.  
	 */
	@Override
	protected void compute() {
		
		/*
		 * If a manager can weigh more than 3 animals, 
		 * this manager will not be used to weigh th animals as only managers that weight 3 animals at most will be used. 
		 */
		
		if(end-start <= 3) { //BASE CASE - only 3 at most animals to be weighed.
			manageCounter++;
			System.out.println("manager with id: " + manageCounter);
			for(int i=start;i<end;i++) {
				weights[i]=Math.random()*100;
				System.out.println("animal number is: " + i + " weights is: " + weights[i]);
			}
		}else { //RECURSIVE PART (that works down to the base case)
			
			/*
			 * If a manager can weight more than 3 animals, we split the work into 2 managers,
			 * and keep doing this until we get to managers that can weigh at most 3 managers.
			 * We start off with a manager that has a start point of 0 and an end point of 10.
			 * We then get the middle pint of this manager which will be 5.
			 * We then create a second generation of 2 manager. 
			 * the start point for the first one will be the start point of the first generation manager,
			 * and the end point will be the middle of the first generation,
			 * so this manager will be start 9, end 5.
			 * and the other manager will be middle point of the 1st generation and end point of the first generation,
			 * so this manager will be start 5 and end 10. This manager can weigh 5 animals. 
			 * These 2 managers will have a middle point of 2 and 5, so our two managers wil look like :
			 * Manager 1: start 0, middle 2, end 5.
			 * manager 2 : start 5, middle 7, end 10
			 * So this generation will also create 2 managers for each, so this will create 4 further managers.
			 * manager 3, start 0, end 2 -> 2-0
			 * manager 4 start 2, end 5 -> 5 -2
			 * manager 5, strt 5, end 7 -> 7-5
			 * manager 7, start 7, end 10. ->10-7
			 * 
			 * So each of these 4 animals will NOT enter the else as these managers satisfy the condition.
			 *  
			*/
			
			//[0][1][2][3][4][5][6][7][8][9]
			
			int middle = start+((end - start)/2);
			
			System.out.println("start is: " + start+ " middle is: " + middle + ". end is: " + end);
			
			//this keeps getting called until the if above is hit by each thread
			invokeAll(new Manager(weights,start,middle), //fork a new thread passing in 0 as start, and 5 as end
					new Manager(weights,middle, end)); //fork a new thread, passing in 5 as start, and 10 as end
		}

	}
	


}

