package com.android;

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
	
	{
		//To access an inner classe's var, we have to acces it through an object of the class. I this case the heart variable myHeart that every Animal has.
		System.out.println(myHeart.bpm);
	}
	
	private int myInt = 3; //This var is available to all of the inner classes, the access level modifier makes no difference. 
	
	
	
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
	
	protected class Lungs{ //this can only be accessed in the same package or in a subclass of animal.
		
	}
	
	class Kidney{ //this can only be accessed in the same package
		
	}
	
	public class Liver{ //this can be accessed everywhere
		
		
		
	}
	
	
	
	
	
	

}


