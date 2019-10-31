package com.android;

import java.util.function.Predicate;

/*
 * A functional interface is an interface with one abstract method (disregards any default or static methods)
 * and can be used for lambdas and are the basis for everything covered in chapter 4
 */
public class Main {

	public static void main(String[] args) {
		
		Animal rabbit=new Animal("rabbit",true,false);//can hop but not swim
		Animal fish=new Animal("fish",false,true);//can swim but not hop
		/*
		 * this method takes an Animal object and a predicate, which is a method that implements the 
		 * boolean test(object obj) of the Predicate interface
		 * a is a Animal
		 * a.canHop() returns either true or false
		 */
		Animal.print(rabbit, a->a.canHop());//will print out "rabbit can hop"
		Animal.print(rabbit, a->a.canSwim());//will print out "rabbit cannot swim
		/*
		 * can have the lambda predicate stores as a variable
		 */
		Predicate<Animal>hopPred=a->a.canHop();
		Predicate<Animal>swimPred=a->a.canSwim();
		Animal.print(fish, hopPred);
		Animal.print(fish, swimPred);
		/*
		 * you can declare a predicate without a data type, however you uwill get the following issue
		 */
		Predicate myPred=a->a.equals(rabbit);
		/*
		 * if you do not give a type to the predicate lambda, you are then implementing the test method with the
		 * following method signature
		 * public boolean test(Object obj){
		 * so that means that the object a, can only be a object reference and that means "a" only has access to the
		 * methods of the object class. It does not have access to any methods of the Animal class
		 * by giving our predicate a data type, it will know what class we want "a" to be, which will be "Animal" and
		 * then would be able to call the methods canHop() and canSwim() of the Animal class
		 */
		//myPred=a->a.canHop();//will NOT compile
		/*
		 * the method contained within the Predicate interface looks like the following
		 * Public interface Predicate<T>{
		 * 		public boolean test(T t);
		 * }
		 * if we don't supply a type, the type will be inferred to be a object
		 */
		Predicate myPredicate;
		//even this will NOT work as it has already inferred that "a" is a OBJECT and not a ANIMAL
		/*myPredicate=(Animal a)->{
			a.canHop();
			return true;
		};*/
		Predicate<Animal>myPredicate2;
		myPredicate2=(a)->{
			a.canHop();
			a.canSwim();
			return true;
		};
		/*
		 * generic data types are covered in more detail in chapter 3
		 */
		/*
		 * Behaviour is a function interface
		 * we can have a Behaviour reference to a lambda that implements the sad() method in the Behaviour
		 * interface
		 */
		Behaviour myBehaviour=()->{
			System.out.println("Behavoiur sad lambda");
		};
		/*
		 * we can then call the sad method that is implemented in the above lambda
		 */
		myBehaviour.sad();
		/*
		 * we can also assign a object of a class that implements the Behaviour interface to the Behaviour 
		 * reference myBehaviour
		 */
		myBehaviour=new Human();
		/*
		 * we can then call the sad method of the Human class 
		 */
		myBehaviour.sad();
		
		
	}

}
