package com.android;

public class Examples {
	
	static void ex1() {
		
		/*
		 * This polymorphic method takes any object with a Behaviour reference. 
		 * This can be an object of a class that implements the interface or an anommymous inner class. 
		 */
		System.out.println("animal calling takeAny");
		Animal.takeAny(new Animal());
		
		System.out.println("Anonymus inner class sent to takeAny:");
		Animal.takeAny(new Behaviour() {

			//we are overriding the sad and mad methods of the behaviour interface, inside this anonymous inner class
			@Override
			public void sad() {
				System.out.println("anonymous sad method");
			}

			@Override
			public void mad() {
				System.out.println("anonymous mad method");
			}
			
		});//end of takeAny()
		
		
		//==========================
		
		//Mammal.takeMovement(new Mammal(), 45);
		/*
		 * You dont have to provide a generic type here, as movement has the following class definition: class Mammal implements Movement<Integer>
		 * This means that type t inside the method: void walk(Integer t), t of type Integer
		 */
		Movement moveMammal = new Mammal();
		moveMammal.walk(12);
		
		//generic type doesnt need to be declared (but isnt harmful to give). BUt if you do, make sure it's right!!! :P
		//i.e Integer works for cow and Mammal.
		Movement<Integer>moveCow = new Cow(); 
		
		Movement<Dog>moveEmployee= new Employee();
		
		//Movement<Integer>moveIntEmp=new Employee(); //wont compile as generic type is set to be Dog
		
		
		Movement<Integer>moveFish = new Fish();
		moveFish.walk(3);
		
		//===================
		
		Movement<Integer>moveLambda=(t)->{
			System.out.println("Walk method in lambda called");
			System.out.println("t is of type: " + t.getClass().getSimpleName());
			t=t*3*3*3;
			System.out.println("t is: " + t);
		};
		
		moveLambda.walk(333);
		
		//these wont compile if you send the wrong object type as a parameter.
		Mammal.takeMovement(moveCow, 12);	
		Mammal.takeMovement(moveMammal, 100);	
		Mammal.takeMovement(moveEmployee, new Dog());	
	}
	
	
	static void ex2() {
		
		
		System.out.println("Interface reference to a class object");
		
		Transport<Integer>transCar = new Car(); //interface reference to a Car object
		
		//ONLY methods of the interface 'transport' and the object class are avalaible to this object.
		transCar.drive(333);
		
		//transCar.commute(); //wont compile as its only accessible to CAR references.
		
		//------
		
		Transport<String>transBoat = new Boat(); //interface reference to a Car object
		transBoat.drive("Bob");
		//transBoat.sail(); //wont compile as its only accessible to BOAT references.
		Boat myBoat = new Boat(); //Boat reference to a boat object and has access to ALL of the Boat class methods.
		myBoat.sail(); //access granted :P
		//------
		
		Transport boatTrans = new Boat(); //++++++++++++++++++++No data type given, but still recognises it as a string as the interface is defined as such.
		boatTrans.drive("sally");
	
		//Transport<Integer>noTrans = new Boat(); //WONT COMPILE - as it needs a string
		
		//------
		
		Human myHuman = new Human();
		myHuman.name = "harry";
		
		/*
		 * Transport refernce to an aeroplane object ,and only has access to the drive(Human t) method
		 */
		Transport<Human>aeroTrans=new Aeroplane();
		aeroTrans.drive(myHuman);
		
		//aeroTrans.fly(); - only aeroplane reference objects have access to the Areoplane fly() method. This will not compile.
		
		//==========================================
		
		System.out.println("Interface reference to a lambda");
		
		/*
		 * A lambda ONLY compiles for a functional Interface. So only interfaces with ONE abstract methods can be lambdas.
		 */
		
		System.out.println("long form lambda");
		Transport <Integer>transLamb1=(Integer i)->{ //implementing the drive method
			System.out.println("transLamb1 drive method called:");
			System.out.println("i is: " + i.getClass().getSimpleName());
		};
		
		transLamb1.drive(3); //calling the lambdas implemented drive method. (It can also call all methods of the object class)
		
		//-----------------------
		System.out.println("Medium form lambda");
		
		Transport <String>transLamb2=(s)->System.out.println("transLamb2 drive method called:" + s);
		
		transLamb2.drive("banana"); //calling the transLamb2 drive
		
		//-----------------------
		System.out.println("Long form lambda");
		
		//dont have to put in brackets for d as it knows that d is a double. And dont have to put in curly brackets for body.
		Transport<Double>transLamb3=d->System.out.println("transLamb3 drive method called:" + d);
		transLamb3.drive(3.3); //calling transLamb3 drive
		
		/*
		 * If there is no parameter in the method the lambda s implementing you have to have a blank set of braces. 
		 * i.e void eat()
		 * ()-> sysout("yo");
		 * 
		 * if you have more than 1 param, you HAVE to have a blank set of braces:
		 * abstract void drink(Integer age, String name):
		 * (a,n) -> sysout("stuff");
		 */
		
		//--
		
		Needs<String, Double>needLamb=(s,d)->System.out.println(s + " s." + d + "d"); //implementing the drink method from the needs interface. 
		
		takeTransport(transCar,  33); //call takeTransport below, passing in drive implemented car lambda and int of 33
		takeTransport(aeroTrans,  myHuman); //call takeTransport below, passing in drive implemented aeroplane lambda and human object
		takeTransport(transLamb3,  3.3); //call takeTransport below, passing in drive implemented transLamb3 lambda and a double
		
		//this is a car reference to a car object, and the cr class does implement Transport. Which means we can send this object to this method
		//This method can take ANY OBJECt that IMPLEMENTS the Transport interface, regardless of it's reference.
		//Because it implements the Drive reference.
		
		Car myCar = new Car();
		takeTransport(myCar, 45);
		
	}
	
	
	
	//========================================================
	static void takeTransport(Transport t1, Object t) { //method that takes a transport referenced obj, and a generic obj
		t1.drive(t); //passing t into t1's .drive method
	}
	
	
	static void ex3() {
		
		/*
		 * Human is in Animal file and does not extend anything except Object.
		 */
		
		Human myHuman = new Human(); 
		
		/*this is a human reference to a Human object. When casting it's NOT the OBJECT you are changing, its the reference.
		 * With a human reference, you have access to all of the human methods in the human class. 
		 */
		
		myHuman.mad();
		myHuman.sad();
		myHuman.hashCode();
		
		/*
		 * This object is STILL a human object, HOWEVER it only has access to object class methods or any object class methods that were overriden in the Human class. +++++++++++++++++
		 */
		Object humanObj = new Human(); 
		
		//humanObj.mad(); //defined in Human, so no access here
		
		
		//----
	
		/*
		 * below is an object reference to an existing human object. Again we can only access methods first defined in the object class. 
		 */
		Object objHuman = myHuman;
		
		//---
		
		/*
		 * Below is a behaviour reference to an existing object. (As Human implements Behaviour)
		 */
		Behaviour behaveHuman = myHuman;
		
		behaveHuman.sad(); //defined in behaviour interface, so we can target this.
		
		
		/*
		 * This is an object reference to a Human object, which means you can cast this object to a Human reference.
		 * this object has no access to sad(), mad() or talk()
		 */
		System.out.println(humanObj);
		
		
		/*
		 * newHuman below is a human reference to a human object. 
		 */
		Human newHuman=(Human)humanObj; 
		newHuman.sad();
		newHuman.mad();
		newHuman.talk();
		
		
		
		//-------------------
		//CASTING DOGS:
		
		System.out.println("Casting Dogs");
		Dog spot = new Dog(); //in Animal class, has own bark() method.
		
		/*
		 * spot is a Dog reference to a Dog object, so has access to all methods of the Dog class.
		 */
		
		spot.bark();
		
		/*
		 * Below is a superclass Animal reference to a subclass Dog object.
		 * This doesnt have access to bark (as it was created in the Dog class).
		 */
		Animal anDog = new Dog();
		anDog.mad();
		anDog.sad();
		//anDog.bark(); - no access a this was defined in Dog 
		
		//Dog myDog = anDog(); - doesnt work as anDog is an ANIMAL reference, and so this is a subclass reference to a superclass object.
		Dog myDog=(Dog)anDog; //this works as anDog's reference is cast to a Dog first.
		
		
		try {
			spot = (Dog) new Animal(); //cant cast a super to a sub
		}catch(Exception e) {
			System.out.println("The exception is: " + e.getClass().getSimpleName());
		}
		
	}
	

}
