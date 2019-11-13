package com.android;

public class Human {
	
	/*
	 * Local inner classes
	 * These are classes that are create inside a method. Or any curly bracket structure inside a class. (anything other than a class)
	 * they do NOT have an access modifier. As they are the same level as a local variable. And local variables do not have access modifiers.
	 * EXCEPT - final is allowed (as below).
	 * 
	 * They cannot be declared as static or have static methods or fields, regardless of whether they ar in a static method or not. 
	 *However they can access static members of the enclosing class. 
	 *
	 *They do NOT have access to local variables of a method UNLESS they are FINAL or EFFECTIVELY FINAL. 
	 */
	
	/*
	void eat() {
		final eat num;
	}
	*/
	
	static int HumanCounter;
	String name;
	int age;
	//inside the inner local Cat class this will be implemented to give each cat a unique Cat id:
	static int catCounter=0;
	
	//Human constructor
	/*
	 * If you place a class inside of a body {}, be that an initialiser, a constructor or a method, this is a local inner class. 
	 */
	Human(){
		System.out.println("Human constructor called");
		
		//placing Cat class inside of the human constructor so this is a local inner class:
		class Cat{
			
			int catId; //unique identifier of each Cat
			
			/*
			 * You cant create a Cat until AFTER the local class declaration:
			 * Cat newCat = new Cat(); //wont complie
			 */
			
			Cat(){ //No args blank constructor
				
				//CANT create a static inside a local inner class:
				//static int test = 0; - wont compile
				
				catCounter++; //you can access static variables of the outer Human class. This is a static var in the Human class. +++++++++++++++++++++++++++
				catId=catCounter; 
				System.out.println(name+ " has a cat with id of: " + catId); //name in instance variable of the human class. It can be accessed in this local inner class.
			}
			
			
			/*
			 * This will not compile as you cant access a local class outside of the curly brackets it was defined in.
			 * Here we cant create a Cat outside of the Human no args consrructor.
			 */
		}
		
		Cat tibbles = new Cat();
		Cat tom = new Cat();
			
	}
	
	/*
	 * We have an inner digest, local class in this method. Which means we can only create a Digest object inside of the eat() method.
	 */
	void eat() {
		System.out.println("eat method of the Human class called");
		
		/*
		 * java 8 introduced the concept of effectively final. 
		 * 
		 * If the code can compile wit the word "final" inserted before the local variable, then the variable is effectively final.  
		 */
		
		int num; //no value so not effectively final.
		
		final int finalNum=78; //final so CAN be accessed in local class. 
		String str; 
		str="hello";
		
		//str="x";
		
		int number = 1000;
		
		//inner local class of the eat method.
		class Digestion{
			
			//constructor:
			Digestion(){
				digestFiber();
				digestProtein();
			}
			
			/*
			 * We are trying to access the local variables of the eat() method can only access final or effectively final variables.
			 */
			
			private void digestFiber() {
				
				System.out.println("digestFiber in inner Digestion class");
				System.out.println("number is: " + number); //number is a local var, and effectively final, so we can access it in the local Digestion class.
				System.out.println("finalNum is: " + finalNum);
				//System.out.println("num is: " + num); - not effectively final, so cant be accessed here.
				System.out.println("str is: " + str); //effectively final, so all good (except when changed in the examples above & below).
			}
			
			void digestProtein() {
				//str="new String"; //changing string here, prevents it from being 'effectively final'.
				System.out.println("digestProtein method called.");
			}
			
		}//end of digestion class
		
		
		//We can only create a digestion object inside the eat method, and only after the digestion class declaration: 
		Digestion digest = new Digestion();
		System.out.println("Calling digestFiber method:");
		/*
		 * digestFiber is a private method of the local digestion class. 
		 * However we are in the eat method that encloses this class, so we have access to all members of the digestion class,
		 * regardless of whether they are private or not.
		 */
		digest.digestFiber();
		
		System.out.println("Calling digestProtein method:");
		digest.digestProtein();
		
		/*
		 * inner local classes can only be ABSTRACT or FINAL
		 */
		
		abstract class getNutrients{
			
		}
		
		/*
		 * interfaces can't be created inside a method. Interfaces cant be local.
		 * 
		 * interface Mood{} //will not compile.
		 */
		
		
		//A local class can also be final:
		final class Deer{
			
		}
		
	}//end of eat method
	
	
	
	
	
	
	
	
	
	
	
	
	

}
