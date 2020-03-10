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
				weights[i]=(double)new Random().nextInt(100);
				System.out.println("animal weighed: " + weights[i]);
				
				//this provides a running total and final total for compute
				sum +=weights[i];
			}
			System.out.println("This employee has weighed: " + sum + " weights");
			return sum;
		}else {
			
			int middle = start+((end-start)/2); //find middle 
			
			System.out.println("start is: " + start+ " middle is: " + middle + ". end is: " + end);
			
			/*
			 * We can't use invokeAll() as this doesn't return any value.
			 * We are still creating twice the amount of employees as the previous generation of employees (1st gen: 1 emp, 2nd gen: 2 emps etc)
			 * However we use forking and joining instead. 
			 */
			
			RecursiveTask<Double>otherTask=new Employee(weights, start, middle);
			
			/*
			 * This creates another thread, so we will have a thread per Employee
			 */
			otherTask.fork();
			
			/*
			 * This creates our second Employee. 
			 * So instead of creating 2 employees with invokeAll, we are creating 2 Employees with a combination of fork and join. 
			 * Your program will NOT progress onto the next employee/calculation of total weight for employee untill the previous one has been ompleted.
			 * 
			 * This will add up all the totals from each Employee if we didnt include otherTask.join(). As that wqould only retur nthe total weighed by the last employee.
			 * 
			 */
			return new Employee(weights, middle, end).compute() + otherTask.join();
			
		}
		
	
	}
	

}


