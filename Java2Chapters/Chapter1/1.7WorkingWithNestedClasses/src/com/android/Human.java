package com.android;

public class Human {
	/*
	 * Local inner classes
	 * these are Classes that are created inside a method or any curly bracket structure (besides a class)
	 * they do NOT hava an access modifier, as they are the same as a local variable and local variable do not
	 * allow access modifier (only final is allowed).
	 * they CANNOT be declared static or have static methods or fields, regardless of whether they are in a 
	 * static method or not, however they can access static members of the enclosing class
	 * they have access to all the fields and methods of the enclosing class
	 * they DO NOT have access to the local variables of a method unless those variables are final or
	 * effectively final
	 * 
	 */
	static int dogId=0;
	static int catId=0;
	String name;
	
	{//initialiser block
		/*
		 * can create a class inside a initialiser block
		 * so a two Dogs will be created before the Human object is created
		 */
		final class Dog{
			int id;
			Dog(){
				dogId++;
				id=dogId;
				System.out.println("new Dog created with id of "+id);
			}
			
		}//end of inner local Class Dog
		Dog spot=new Dog();
		Dog rex=new Dog();
	}//end of initialiser block
	
	//constructor of Human class
	Human(){
		System.out.println("human created");
		/*
		 * can create a class inside a constructor
		 * can't create an instance of local class before the class declaration
		 */
		//Cat sysvester=new Cat();//will not compile
		class Cat{
			//unique identifer for a cat
			int id;
			//Cat constructor 
			Cat(){
				catId++;
				id=catId;
				System.out.println("cat with "+id+" created");
			}
		}//end of local inner Cat class
		/*
		 * can't create a Cat until AFTER the class Cat declaration
		 */
		Cat tibbles=new Cat();
		Cat tom=new Cat();
		
		
	}
	
	void drink() {
		System.out.println("human drinking");
	}
	
	void eat() {
		System.out.println("eat method of human class called");
		int num;
		/*
		 * Java 8 introduced the concept of effectively final
		 * if the code can compile with the word "final" inserted before the local varaible, then the 
		 * variable is effectively final
		 */
		final int finalNum=78;
		/*
		 * you could not put final before this variable so any inner local class would not be able to access
		 * this variable
		 */
		String str;
		/*
		 * you could put final before this variable so any inner local class would be able to access this variable
		 */
		int number=1000;
		/*
		 * even if the method you are declaring the class in is static you still can't declare a local inner
		 * class as static
		 */
		class Digestion{
			//constructor for inner class Digestion
			Digestion(){
				System.out.println("digestion object created");
				digestFiber();
				digestProtein();
				
			}
			
			private void digestFiber() {
				System.out.println("digestfiber method in inner digestion class");
				System.out.println("finalnum is "+finalNum);
				/*
				 * number is effectively final, so we can access it
				 */
				System.out.println("number is "+number);
				/*
				 * can't access num as it's not final or effectively final
				 */
				//System.out.println("num is "+num);//will not compile
				/*
				 * you can access variables of the enclosing class, this is the name of the Human
				 */
				System.out.println("name of person is "+name);
				/*
				 * can access methods of the Enclosing class
				 */
				drink();
				/*
				 * can also create objects of the enclosing class
				 */
		//		System.out.println("name of human is "+drink());
				Human harry=new Human();
			}
			
			void digestProtein() {
				System.out.println("digest Protein method called");
			}
		}//end of local inner class Digestion
		/*
		 * we can only create a Digestion object inside the eat() method and only after the class
		 * declaration
		 */
		Digestion myDigestion=new Digestion();
		System.out.println("calling digestFiber and digestProtein through Digestion object");
		myDigestion.digestFiber();
		myDigestion.digestProtein();
		/*
		 * inner classes can only be abstract or final
		 */
		abstract class getNuitrients{
			
		}
		/*
		 * this class CANNOT be extended
		 */
		final class Excrete{
			
		}
		/*
		 * but they CANNOT be abstract and final
		 * (as abstract classes HAVE TO be able to be extending so any abstract methods contained within can
		 * be overriden in a concrete class)
		 */	
/*		final abstract NoClass{
			
		}*/
		
	}
}
