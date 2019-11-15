package com.android;

import com.android.Plant.Tree;

/*
 * An inner class CANNOT be a super class of it's outer class.
 * Here we have an inner class called "Life", and if Plant attempts to extend it, it will not compile as it does not recognise it.
 * The inner class is PART OF THE PLANT.
 */
public class Plant /* extends Life */{
	
	boolean flower = true;
	int age = 3;
	
	/*
	 * If you have an instance variable that is an object of the class you are currently in, 
	 * and it is given a value of a new object of that class, you will get a stack overflow error.
	 * Here we have a plant instance variable myPlant inside the plant class. 
	 * If we go: Plant myPlant = new Plant();
	 * The constructor is called to create a new plant, but the first thing that happens is that a new palnt is created inside that plant etc.. 
	 */
	
	//Plant myPlant = new Plant(); //causes stack overflow
	
	Plant(){
		
		//this also results in a stack overflow error:
		//myPlant = new Plant(); //causes stack overflow
		System.out.println("plant constructor called");
		
	}
	
	void aMethod() {
		Plant myPlant = new Plant(); //safe way to create a plant.
	}
	
	void grow() {
		System.out.println("plant grow method");
	}
	
	void reproduce() {
		System.out.println("plant reproduce method");
	}
	
	void germinate() {
		System.out.println("plant germinate method");
	}
	
	
	/*
	 * This is a subclass of the outer class:
	 */
	class Tree extends Plant{
		
		//constructor of tree class:
		Tree(){
			System.out.println("Tree constructor called");
			//grow(); //causes stack overflow
		}
		
		@Override
		void grow() {
			System.out.println("The tree grow method");
			Tree myTree = new Tree();
		}
		
		@Override
		void germinate() {
			
			/*
			 * You can create an anonymous inner class whos class extends the outer class.
			 * Here we are inside the Tree class, and the Tree extends the Plant class, and  we can create an anonymous Inner tree object.
			 */
			Tree myTree = new Tree() {
				
			};
		}
		
	}//end of inner tree class
	
	
	void callInners() {
		Tree myTree = new Tree(); //instance of an inner class inside it's outer class.
		myTree.grow();
		
		Tree anonTree = new Tree() {
			
			@Override
			void grow() {
				System.out.println("anon grow mwethod");
				shedLeaves();
			}
			
			@Override
			void reproduce() {
				System.out.println("anonTree reproduce method");
			}
			
			void shedLeaves() {
				System.out.println("anonTree shedding leaves");
			}
			
			
		};
		
		anonTree.grow();
		
		
	}//end of call inners
	
	
	//inner class 
	class Life{
		
	}

}//end of plant class 
