package com.android;

public class Examples {
	
	static void ex1() {
		/*
		 * this polymorphic method takes Behaviour intereface reference. this can be a object of a class that
		 * implements the interface(Animal and its subclass Dog and the Human class implement the Behaviour
		 * interface). 
		 */
		Animal.takeAny(new Animal());
		Animal.takeAny(new Dog());
		Animal.takeAny(new Human());
		
		Movement<Integer>moveMammal=new Mammal();
		Movement<Integer>moveCow=new Cow();
		Movement<Dog>moveDog=new Employee();
		/*
		 * this method can take Movement reference of any type
		 * so that can be a object of class that implements the Movement interface (Mammal,Cow, Employee)
		 * (both Mammal and cow implement the interface with the type Integer, which means that type T for both
		 * these classes is an Integer, Employee class implments the interface with the type Dog, which means that
		 * type T for employee is Dog.
		 * or a lambda that implements this functional interface
		 */
		Mammal.takeMovement(new Mammal(), 45);//calls the Mammal walke method
		Mammal.takeMovement(new Employee(), new Dog());//calls the Employee walk method
		Mammal.takeMovement(moveMammal, 78);//calls the Mammal walk method
		/*
		 * lambda of the function interface that implements the walk() method
		 * in this case t will be of type object
		 * if we went Movement<String>moveLambda, this t would be of type String
		 */
		Movement moveLambda=(t)->{
			System.out.println("walk method in lambda called");
			System.out.println("t is of type "+t.getClass().getSimpleName());
		};
		/*
		 * send the above lambda and a Integer wrapper object
		 * the 45 is a OBJECT reference to a Integer object, as when creating the lambda we did not specify a
		 * type for t. so 45 would not be able to call any of the methods of the Integer class
		 */
		Mammal.takeMovement(moveLambda,45);
		/*
		 * here we have specified a type for t, Dog, so then in the lambda we can call the methods of
		 * the Dog class
		 */
		Movement<Dog>moveDogLambda=(t)->{
			System.out.println("walk method in lambda with a Dog called");
			t.bark();
		};
		/*
		 * this it taking a Movement lambda with type T defined as being a Dog and sending a dog to the method
		 */
		Mammal.takeMovement(moveDogLambda, new Dog());
		
	}
	
	static void ex2() {
		Human myHuman=new Human();
		/*
		 * this is a human reference to a Human object and the object does not change, its the reference that 
		 * can change. If you change the reference this will affect what methods will be available to it. 
		 * With a human reference we have access to ALL of the methods in the Human class
		 */
		myHuman.sad();
		myHuman.mad();
		/*
		 * this object is still a Human object, however it only has to access to methods of the Object class or 
		 * any class Object methods that are overriden in the Human class.
		 * the toString() method of the object class is overriden in the human class, so it will take it's 
		 * implementation form the Human class
		 */
		Object humanObject=new Human();
		System.out.println(humanObject);
		/*
		 * this is the same, this is a still the same Human object created at the beginning of this method but 
		 * here we are accessing this object through the Object reference "objHuman", so no access to the methods
		 * of the Human class
		 */
		Object ojbHuman=myHuman;
		System.out.println(ojbHuman);
		/*
		 * casting
		 */
		Dog spot=new Dog();
		/*
		 * spot is a Dog refrence to a Dog object, so has access to all  methods of the Dog class
		 */
		spot.bark();
		/*
		 * this object does nto have access to the bark() method
		 */
		Animal anDog=new Dog();
		/*
		 * will not compile as no access to bark() method
		 */
		//anDog.bark();
		//we also cannot go
		//Dog myDog=anDog;
		/*
		 * as you can' have a subclass reference to a super class referenced object which anDog is
		 * however we CAN cast this object to be a Dog, as it is still a Dog Object
		 * you can only cast something if it is an instance of that class, in this case anDog is Dog so we can
		 * cast it
		 */
		Dog myDog=(Dog)anDog;
		myDog.bark();
		/*
		 * will give a compilation error as can't have a sub class reference to a super class object
		 */
		//spot=new Animal();
		/*
		 * you can cast it and it will compile however it will throw classCastException
		 */
		try {
			spot=(Dog)new Animal();
		}
		catch(Exception e) {
			System.out.println("the exception is "+e.getClass().getSimpleName());
		}
		
	}

}
