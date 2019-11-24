package com.android;

import com.android.Dog.Cardiac.Cells.Chemicals;

/*
 * This class can only be public or package level, and only ONE public class per file. And has to be the same name as file. 
 */

public class Animal {
	
	/*
	 * A top level class can be either: public/default(no keyword) level access. 
	 * However a member inner class can be ANY access level.
	 * So an inner class can be private, protected, package level and public. 
	 * 
	 * Inner classes can be FINAL or ABSTRACT. But member inner class CANNONT HAVE static variables or methods.
	 */
	
	//---------------
	/*
	 * You can only have 1 top level public class per file. However you can have as many public member inner classes as you like. 
	 */
	public class myClass{ }
	
	public class anotherClass{	}
	//---------------
	
	
	//MEMBER PROPERTIES:
	private int age;
	protected String name;
	public double weight;
	
	Heart myHeart;
	Liver myLiver;
	Lungs myLungs;
	Kidney myKidney;
	static int liverId=0; //this uniquely ids our livers
	
	{
		//To access an inner classe's var, we have to acces it through an object of the class. I this case the heart variable myHeart that every Animal has.
		//System.out.println(myHeart.bpm);
	}
	
	private int myInt = 3; //This var is available to all of the inner classes, the access level modifier makes no difference. 
	
	
	//CONSTRUCTOR:
	Animal(int age, String name, double weight){
		this.age = age;
		this.name = name;
		this.weight = weight;
		
		//make objects:
		myHeart = new Heart();
		myLiver = new Liver();
		myKidney = new Kidney();
		myLungs = new Lungs();
		
		System.out.println(myHeart.bpm);
		System.out.println(myLiver.id);
		System.out.println("end of Animal constructor");
		
		myKidney.alive(); //accessing the alive method from the local Beghaviour interface that this implements.
		myLungs.alive();
		
	}
	
	Animal(){
		
	}
	
	
	private class Heart{ //the inner member class, which can ONLY be accessed inside the member class.
		//inner classes can have variables, and when you mark something as PRIVATE in an inner class, that means its available in the same class AND it's parent:
		private int bpm;
		
		{
			System.out.println(myInt); //This can be seen by the inner classes
		}
		
		
		//CONSTRUCTOR:
		public Heart() {
			System.out.println("Heart created and beating");
		}
		
		//Beat method of the Heart class:
		private void beat() {
			System.out.println("Heart beating");
		}
	}
	
	//this can only be accessed in the same package or in a subclass of animal:
	protected class Lungs implements Behaviour{

		@Override
		public void alive() {
			System.out.println("lungs alive");
			
		} 
		
	}
	
	 //this can only be accessed in the same package
	class Kidney implements Behaviour{

		@Override
		public void alive() {
			System.out.println("lungs alive");
			
		}
		
	}
	
	public class Liver{ //this can be accessed everywhere
		
		//You CANT create a static inside an inner member class. However you CAN access a static of the outer class. 
		//static int someInt; //wont compile! 
		
		int id;
		
		Liver(){
			liverId++; //accessing this static var of the outer class.
			id=liverId;
			System.out.println("liver created");
			//System.out.println(myHeart.bpm); /////////////Accessing the bpm of the Heart object. ++++++++++++++++++++++++++++++++++++++++
		}
		
		
		//this method can access all of the vars of the outer Animal class: 
		void cleanse() {
			System.out.println("liver cleansing");
			System.out.println("age is: " + age);
			System.out.println("weight is: " + weight);
			System.out.println("id is: " + id);
			
		}
		
		private void recycle() {
			System.out.println("liver helps with recycling the body");
		}
		
	}//end of inner liver class
	
	
	//-----------------------------------------------------------------------
	//only classes inside the Animal class can implement the behaviour interface
	private interface Behaviour{
		/*
		 * This method is public so we can only implement this interface from inside the Animal class
		 */
		void alive();
	}
	
	
	static class Brain implements Behaviour{
		
		/*
		 * A static inner class CAN have non static members.
		 * Uses the same rules as static methods in that you cant access NON static member variables directly. 
		 */
		
		int brainNum = 10;

		@Override
		public void alive() {
			//System.out.println("age of Animal is: " + age); //You cant access member instance variables
			System.out.println("liverId is: " + liverId); //liver id is a static variable of the Liver class, so we CAN access it directly. 
			System.out.println(new Animal().age); //Just like a static method, the only way to access NON static vars here is to create an animal object, then access that age..
		} 
		
	}
	

} //end of Animal class


class Dog extends Animal{
	
	int age=10;
	Animal andy = new Animal();
	Liver dogLiver; //liver is public so its inherited
	
	
	
	Dog(){
		
		//I want to create a chemicals object. Inorder to do this, I have to first create a Cardiac obj, then a Cells obj, then a Chemicals object.
		//I have to create a Chemicals object, to get a chemicals constructor 
		new Cardiac().new Cells().new Chemicals();
		
	}
	
	/*
	 * You can have variables of the same name in outer and inner classes: 
	 */
	class Cardiac{
		
		int age=20;
		class Cells{
			
			int age=30;
			class Chemicals{
				
				int age=40;
				Chemicals(){
					System.out.println("Chemical Constructor called");
					/*
					 * If we are just accessing 'age', it will access whatever var is closest to it
					 * '40' in this case
					 */
					System.out.println("age of Chemicals is: " + age);
					System.out.println("age of Cells is: " + Cells.this.age);
					System.out.println("age of Cardiac is: " + Cardiac.this.age);
					System.out.println("age of Dog is: " + Dog.this.age);
				}
			}
		}
	}
}















