package com.android;
/*
 * this class can only be public or package level, and only one public
 * class per file and has to be same name as file
 */
public class Animal {
	/*
	 * a top level class can be either public/default(no keyword for default)
	 * level access. However a member inner class can be any access level
	 * So an inner class can be private,protected,package level and
	 * public
	 * inner classes can be final or abstract
	 * but member inner classes CANNOT HAVE statics variables or methods
	 */
	/*
	 * you can only have ONE top level public class per file, however
	 * you can have as many public INNER classes as you like
	 */
	public class myClass{
		
	}
	public class anotherClass{
		
	}
	private int age;
	protected String name;
	public double weight;
	//these are all package level, but they can be any access level
	/*
	 * this Animal only has one heart
	 */
	Heart myHeart;
	//has one liver
	Liver myLiver;
	//has one lung
	Lungs myLungs;
	//has one kidney
	Kidney myKidney;
	//this uniquely identifies our livers
	static int liverId=0;
	{
		/*
		 * to access an innner classes variable, we have to access it
		 * through an object of the class. in this case the heart 
		 * variable myHeart that every animal has.
		 * so this is how we access the bpm of the heart
		 */
		//System.out.println(myHeart.bpm);
	//	System.out.println(new Heart().bpm);
		
	}
	/*
	 * this variable is avaiable to all of the inner classes, the access
	 * level modifier makes not difference to this. all variables of the
	 * outer class are available to all Inner classes.
	 * 
	 */
	private int myInt=3;
//constructor for animal 
	Animal(int age,String name,double weight){
		this.age=age;
		this.name=name;
		this.weight=weight;
		
		myHeart=new Heart();
		myLiver=new Liver();
		myKidney=new Kidney();
		myLungs=new Lungs();
		System.out.println(myHeart.bpm);
		System.out.println(myLiver.id);
		/*
		 * both Kidney and Lungs implement the Behaviour 
		 * interface, which has a single abstract method 
		 * void alive() (this is a also a functionInterface)
		 */
		myKidney.alive();
		myLungs.alive();
		System.out.println("end of Animal constructor");
	}
	
	Animal(){
		
	}
	/*
	 * this is the inner member class heart, which can only be accessed
	 * inside of the Animal class because it is private
	 */
	private class Heart {
		/*
		 * inner classes can have variables, when you mark something
		 * as private in an inner class, that means it's available in same
		 * class AND its outer class. however we can only access this
		 * variable through a heart or the myHeart variable of
		 * The Animal class can access
		 * the bpm variable
		 */
		private int bpm=0;
		
		{
			/*
			 * this is a variable of the outer class 
			 */
		//	System.out.println(myInt);
		}
		/*
		 * constructor that creates the heart
		 */
		public Heart() {
			System.out.println("heart created and beating");
		}
		//beat method of the heart class
		private void beat() {
			System.out.println("heart beating");
			
			System.out.println(myLiver.id);
		}
			
		
	}
	//this can only be accessed in same package or in a subclass of Animal
	protected class Lungs implements Behaviour{

		@Override
		public void alive() {
			System.out.println("lungs alive");
			
		}
		
	}
	//this can only be accessed in same package
	class Kidney implements Behaviour{

		@Override
		public void alive() {
			System.out.println("kidneys alive");
			
		}
		
	}
	//this can be accessed everywhere
	public class Liver{
		/*
		 * you can't create a static inside an inner member class, however
		 * you CAN access a static of the outer class, in our case
		 * liverId;
		 */
		int id;
		//static int statCount=0;//will not compile
		
		Liver(){
			liverId++;//this is a static variable of the outer class
			id=liverId;
			System.out.println("liver created");
		}
		/*
		 * can access all of the variable of the outer Animal class
		 */
		void cleanse() {
			System.out.println("liver cleansing");
			System.out.println("age is "+age);
			System.out.println("weight is "+weight);
			System.out.println("id is "+id);
			/*
			 * You can access the variables of another inner class while
			 * in an existing inner class. here for instance we are in
			 * the Liver class and we are accessing the bpm variable
			 * of a heart. 
			 */
			System.out.println(myHeart.bpm);
			/*
			 * this variable is a LOCAL heart variable, and its basically
			 * an orphan as it does'nt really belong to any Animal and
			 * will be liable for garbage collection as soon as you 
			 * exit this method
			 */
			System.out.println(new Heart().bpm);
		}//end of cleanse
		
		private void recycle() {
			System.out.println("liver helps with recycling in the body");
		}//end of recycle method
	}//end of inner Liver class
	/*
	 * only classes inside the Animal class can implement the 
	 * Behaviour interface
	 */
	private interface Behaviour{
		/*
		 * this method is public, so we can only implement this interface
		 * from inside the Animal class, however we CAN access the 
		 * the alive method from outside the Animal class
		 */
		void alive();
	}//end of Behaviour interface

	static class Brain implements Behaviour{
		/*
		 * a static inner class CAN have non static memmbers
		 * same rules as static methods, in that we can't access non
		 * static member variables directly
		 */
		int brainNum=10;
		@Override
		public void alive() {
			//will not compile. cannot access member instance variables
			//System.out.println("age of Animal is "+age);
			/*
			 * liverId is a static varaiable of the Animal class, so 
			 * we can access it directly
			 */
			System.out.println("liverId is "+liverId);//will compile
			/*
			 *  the only way to access non static variables here is 
			 *  to create a Animal  object and then access that age
			 */
			System.out.println(new Animal().age);
			
		}
		
	}
}//End of Animal class

class Dog extends Animal{
	int age=10;
	Animal andy=new Animal();
	//liver is public so it's inherited
	Liver dogLiver;
	//Heart is private so it's not inherited
//	Heart dogHeart;//will not compile
	
	Dog(){
		/*
		 * i want to create a Chemicals object, in order to do this
		 * i have to first create a Cardiac object, then a Cells object
		 * then a Chemicals object
		 * I have to create a Chemicals object to get the Chemicals
		 * constructor to run
		 */
		new Cardiac().new Cells().new Chemicals();
	}
	/*
	 * you can have variables of the same name in outer and inner classes
	 * HOWEVER DON'T THIS IN REAL LIFE, as its too confusing
	 */
	class Cardiac{
		int age=20;
		//Cardiac constructor
		Cardiac(){
			System.out.println("Cardiac created");
		}
		class Cells{
			int age=30;
			Cells(){
				System.out.println("Cells created");
			}
		//	Chemicals myChemical=new Chemicals();
			class Chemicals{
				int age=40;
				Chemicals(){
					System.out.println("Chemical Constructor called");
					/*
					 * if we are just accessing "age" it will access
					 * whatever is closest to it, so this will print
					 * 40
					 */
					System.out.println("age of chemicals "+age);//40
					System.out.println("cells age is "+Cells.this.age);//30
					System.out.println("heart age is "+Cardiac.this.age);//20
					System.out.println("dog age is "+Dog.this.age);//10
				}
			}
		}
	}
}
