package com.android;

import com.android.Dog.Cardiac;
import com.android.Dog.Cardiac.Cells;
import com.android.Dog.Cardiac.Cells.Chemicals;

public class Human {
	/*
	 * Local Inner classes
	 * these are classes that are created inside a method or any
	 * curly bracket structure (besides a class)
	 * they do NOT HAVE an access modifer, as they are the same level
	 * as a local variable and local variables do not have access 
	 * modifers (only final is allowed)
	 * they CANNOT be declared static or have static methods or fields,
	 * regardless of whether they are in a static method or not, however
	 * they can access static members of the enclosing class.
	 * they DO NOT have access to local variables of a method UNLESS
	 * they are FINAL or EFFECTIVELY FINAL
	 * 
	 */
	static int humanCounter;
	String name;
	int age;
	//inside the inner local Cat class this will be incremented to give
	//each cat a unique Cat id
	static int catCounter=0;
	//Human constructor
	/*
	 * if you place a class inside of a body {}, be that a initialiser,
	 * constructor or a method, this is a local inner class
	 */
	Human(){
		System.out.println("Human constructor called");
		/*
		 * placing Cat class inside of the Human constructor so this is
		 * a local inner class
		 */
		/*
		 * you can't create a Cat until AFTER the local class declaration
		 * 
		 */
		//Cat myCat;//will not compile
		//Cat newCat=new Cat();
		class Cat{
			//unique identifer of each Cat
			int catId;
			//Cat no args constructor
			Cat(){
				//cannot create a static inside a local inner class
				//static int statInt;
				/*
				 * you can access static variable of the outer Human
				 * class, catCounter is a static variable in the Human
				 * class
				 */
				catCounter++;
				catId=catCounter;
				/*
				 * you can access instance variables of the outer Human
				 * class in a local inner class. name is a instance
				 * variable of the Human class
				 */
				System.out.println(name+" has a cat with id of "+catId);
			}//end of Cat Constructor
		}//end of Cat class
		/*
		 * from this point onwards, we can create Cats, but only inside the
		 * Human  no arguments constructor, because the Cat class is 
		 * LOCAL to the human no arguements constructor
		 */
		Cat tibbles=new Cat();
		Cat tom=new Cat();
	}//end of Human Constructor
	/*
	 * this will not compile as you can't access a local class outside
	 * of the curly brackets it was defined in. here we can't create
	 * a Cat outside of the Human no arguments constructor as this is
	 * where the local inner Cat class was created
	 */
	//Cat tabby=new Cat();
	/*
	 * we  have an inner Digest local class in this method
	 * whihc means we can only create a Digest object inside of the
	 * eat() method
	 */
	void eat() {
		System.out.println("eat method of the Human class called");
		/*
		 * java 8 introduced the concept of effectively final.
		 * if the code can compile with the word "final" inserted before
		 * the local variable, then the variable is effectively final
		 */
		//this can't be final, so can't be accessed in local class
		int num;
		//this is final, so CAN be accessed in local class
		final int finalNum=78;
		/*
		 * effectively final means, that once given a value, the local
		 * variable CANNOT be assigned a new value anywhere
		 */
		String str;
		str="hello";
		//if i do this i cannot access str in the Local Digestion class
	//	str="another string";
		//this has been given a value and has not been changed
		/*
		 * effectively
		 */
		int number=1000;
		
		StringBuilder sb1=new StringBuilder("noel");
		StringBuilder sb2=sb1;
	//	sb2=new StringBuilder("timmy");
		/*
		 * it all depends on assignement, it does not matter that sb1
		 * is the same object as sb2, what matters is that you
		 * reassigned a value to sb1, so sb1 is no longer effectively
		 * final
		 */
		sb1=sb2;
		String name="tomy";
		String name2="tomy";
		name="tomy";
		/*
		 * inner local class of the eat() method
		 */
		class Digestion{
			
			Digestion(){
				digestFiber();
				digestProtein();
			}//end of Digestion constructor
			/*
			 * we are trying to access the local variables of the 
			 * eat() method can only access final or effectively final
			 * variables
			 */
			private void digestFiber() {
				System.out.println("digestFiber in inner Digestion class");
				/*
				 * number is local variable and it's effectively final
				 * so we can access it in the Local inner digestion class
				 */
				System.out.println("number is "+number);
				/*
				 * finalNum is final, so we can access this local variable
				 */
				System.out.println("finalNum is "+finalNum);
				/*
				 * num has no value, so it CAN'T BE final, so you can't 
				 * access it in a local inner class
				 */
			//	System.out.println("num is "+num);//this will not compile
				System.out.println("str is "+str);
			//	str="new STring";
				/*
				 * sb1 is NOT EFFECTIVELY FINAL so cannot acess it
				 */
			//	System.out.println(sb1);	
			}
			
			void digestProtein() {
				System.out.println("digest protein method called");
			}
		}//end of inner Digestion class
		/*
		 * we can only create a Digestion object inside the eat() method
		 * and only after the Digestion class declaration
		 */
		Digestion digest=new Digestion();
		System.out.println("calling digestFiber method");
		/*
		 * digestFiber is a private method of the Local Digestion
		 * class, however we are in the eat method that encloses this
		 * class so we have access to all of the members of the digestion
		 * class, regardless whether they are private or not
		 */
		digest.digestFiber();
		digest.digestProtein();
		/*
		 * inner local classes can only be ABSTRACT or FINAL
		 * all the rules that pertain to local inner concrete classes
		 * also pertain to these
		 */
		abstract class getNuitrients{
			
		}
		/*
		 * interfaces can't be created inside a method, interfaces
		 * can't be local
		 */
		//interface Mood{}//will not compile
		/*
		 * a local class can also be final
		 */
		final class Deer{
			
		}
		/*
		 * you cannot have a abstract and a Final local class
		 * (as asbstract classes HAVE TO be able to extend and final
		 * classes cannot be extended)
		 */
	}//end of eat method

}
