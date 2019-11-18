package com.android;

import java.util.function.Predicate;

public class Examples {
	
	static void ex1() {
		
		
		/*
		 *ALL installation s of java come with a pre-packaged inteface called predicate. 
		 *Which hhas one abstract method inside it call 'test'.
		 *As this interface only has one abstract method, this means this predicate is a FUNCTIONAL INTERFACE and can be used with lambdas. 
		 *
		 * public interface Predicate<T>{
		 * 	public boolean test(T t);
		 * }
		 * 
		 */
		
		Predicate<Integer>myPred; //with this predicate, the test method becomes: public boolean test(Integer t)
		Predicate<String>strPred; //with this predicate, the test method becomes: public boolean test(String t)

		Predicate objPred; //If you odnt supply it with a type, it becomes an object: public boolean test(Object t)
		
		//------------
		
		//anonymous class implementation of Predicate interface: 
		Predicate<Integer>intPred = new Predicate() {

			/*
			 * The problem here is that t is an object class reference to an Integer object. So if we want this object to behave like an Integer
			 * ie multiplication., division etc) we have to cast this object to be an Integer
			 */
			@Override
			public boolean test(Object t) {
				
				Integer myInt = (Integer)t; //cast t to an Integer
				
				if(myInt>=18) //do stuff with integer
						return true;
				return false;
				
			}//end of test method
			
		}; //end of anonymous inner class
		
		
		
		System.out.println("greater than or equal to 18? " + intPred.test(19));
		
		/*
		 * We will replace the above anonymous class with a lambda, as Predicate is a Functional Interface and has only 1 abstract method inside it. 
		 */
		
		
		//-----------------------Long form lambda:
		
		Predicate<Integer>intPred2=(Integer a)->{
			/*
			 * If more than one statement in a lambda, you HAVE to have curly braces.
			 */
			System.out.println("Long form lambda implementation of test method");
			
			//NO NEED TO CAST as it's being passed an integer NOT an onbject.
			if(a<=18) { //do stuff with integer
				System.out.println("You're a child");
				return true;
			}else {
				System.out.println("You're an adult");
				return false;
			}
			
		};
		
		intPred2.test(12);
		
		
		//-----------------------Medium form lambda:
		/*
		 * when you give a type on the left hand side, you dont need one one the right, as it knows a is an Integer.
		 * If you DONT GIVE A TYPE then the type is assumed to be object.
		 */
		Predicate<Integer>intPred3 = (a)->{
			
			if(a>=18)
				return true;
			return false;
		};
		
		//-----------------------Short form lambda:
		/*
		 * when you have only one line of code in your lambda body, you dont need curly braces on the right hand side. 
		 */
		
		Predicate<Integer>shortPred = a->a>18?true:false; 
	}
	
	
	static void ex2() {
		
		System.out.println("creating our two Animals");
		Animal rabbit = new Animal("rabbit", true, false); //can hop but can't swim
		Animal fish=new Animal("fish", false, true); //can swim, can't hop
		
		
		//calling the static print method that takes an Animal and a predicate Animal object.
		
		/*
		 * This method takes an Animal object and predicate, which is a meothd that implements test(Object obj) of the predicte interface.
		 */
		
		Animal.print(rabbit, a->a.canHop()); //'a' is the rabbit object being passed. and were implementing it whilst calling the 'canHop' on it, whilst passing it as a param
		Animal.print(rabbit, (Animal a)->{ //long form version of above
			return a.canSwim();
		}); 
		
		
		//You can have a predicate as a variable:
		
		Predicate<Animal>hopPred=a->a.canHop();
		Predicate<Animal>swimPred=a->a.canSwim(); //predicate variable
		System.out.println("\nfish predicate test:"); //predicate variable
		Animal.print(fish, hopPred);
		Animal.print(fish, swimPred);
		
		
	
		
		
		//redefining hopPred:
		//hopPred can only take an Animal and return a boolean.
		hopPred=a->a.canSwim(); //redefining the implementation of hopPred
		
		hopPred=(s)->true;
		
		//hopPred=(String s)->true; ++++++++++++++++++++++++++++++++++POSSIBLE EXAM QUESTION +++++++++++++++++++++++++++++++
		/*
		 * Above wont compile as hopPred was created with the generic type of Animal, so the parameteer has to be an Animal, if you say what type it is.
		 */
		
		
		/*
		 * You can declare a predicate without a data type but you will have issues with this.
		 * If you dont define a type of the left hand sise, a will be the object of type object, and we'll only have access to methods of the object class.
		 */
		
		Predicate objPred=obj->obj.equals(rabbit);  //using the object equals method to check if object is a rabbit
		
		/*
		 * You have no access to any methods of the Animal class as this was created with no generic type, so is given the type of object.
		 */
		//objPred=obj->obj.canHop(); //cant be done without casting this to an Animal (shown below), as objPred is an object.
		objPred=obj->((Animal) obj).canHop(); //casting to Animal, to call animal's canHop
		
		/*
		 * If you dont give a type to the predicate lambda upon creation, then you are implementing the test method with the following signiature:
		 * 
		 * public boolean test(Object obj);
		 * 
		 * so that means it only has access0s to the methods of the Object class, and no access to any of the method a of the Animal class. 
		 * By giving out predicate a data type we will know what class obj is I(in this case Animal), and can then call the methods of the Animal class.
		 */
		
		//This predicate lambda has access ot all methods of Animal class.
		Predicate<Animal>animalPred; 
		animalPred=(a)->{
			a.canHop();
			a.canSwim();
			return true;
		};
		
		/*
		 * Behaviour is a functional interface and has one abstract method. Which is void sad();
		 * This has no generic in it as this method doesnt return or take any variable.
		 */
		Behaviour myBehave=()->{
			System.out.println("behaviour sad lambda");
		};
		
		
		//-------------
		Move<Integer>intMove=a->a*2;
		System.out.println(intMove.run(12));
		
		Move<String>strMove=s->s+" is our string";
		System.out.println(strMove.run("Jay"));
		
	
		Behaviour behaveHuman = new Human();
		behaveHuman.happy();
		Move moveHuman = new Human();
		moveHuman.run("hello");
		
		//++++++++++++++++++++++++++++++++++++
		/*
		 * You can have an interface refeence to 3 different things:
		 * 
		 * + An interface reference to an anonymous class implementation of the interface. This works for all types of interface.
		 * + An interface reference to a lambda implementing the interface. (Only works for functional interfaces)
		 * + An inteeface reference to an anonymus class implementing that interface. This works for all types of interface.
		 */
		
	}
	
	

}
