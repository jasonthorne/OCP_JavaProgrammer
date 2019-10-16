package com.android;

import java.util.function.Predicate;

import com.android.Building.Apartment;
/*
 * for  usage with the Building classes
 */

class Employee{
	int age;
	String name;
	
	Employee(int age,String name){
		this.age=age;
		this.name=name;
		System.out.println("Employee created with constructor that takes a int and string");
	}
	Employee(){
		System.out.println("Employee created with blank constructor");
	}
	
	void earnMoney() {
		System.out.println("employee earning money");
	}
	void doWork() {
		System.out.println("Employee working");
	}
}

public class Building {
	Employee eddie;
	int size=400;
	
	/*
	 * An anonymous inner class is a way to redefine a class where we can override methods or
	 * even declare new methods
	 */
	Building(){
		/*
		 * this is an anonymous class implemenation of the eddie the employee object, which allows us to
		 * tailor the object to be specific to eddie
		 */
		eddie=new Employee() {
			/*
			 * can't have a constructor inside a anonymous inner class, but you can have initialisers
			 */
			{
				System.out.println("we are inside the inner anonymous Employee class");
			}
			/*
			 * we can override methods of the Employee class
			 */
			@Override
			void earnMoney() {
				System.out.println("anonymous inner employee class earning money");
				doWork();
				payTax();
			}
			/*
			 * we can also create new methods only avaliable to this object
			 * but these methods are only available inside this object. we can access variables and methods
			 * of the outer class, in this case the Building class
			 */
			void payTax() {
				System.out.println("payTax method avaiable only inside anonymous inner class");
				System.out.println(name+" is paying tax");
				System.out.println(age+" is the age of the person");
				System.out.println("size of building is "+size);//variable of the outer building class
			}
			{
				/*
				 * can call any methods of the Employee class, even ones not overriden or defined in the 
				 * anonymous inner class. the doWork() method is not defined here, but it is defined in the 
				 * Employee class, so we have access to the method here
				 */
			//	doWork();
			}
		};//end of anonymous inner class
		
	//	eddie.doWork();
		eddie.earnMoney();
		/*
		 * payTax() method is not avaliable outside of the anonymous inner class
		 */
		//eddie.payTax()
	}//end of Building Constructor
	
	void live(Employee emp) {
		/*
		 * whatever type of employee object is sent to this it will call the doWork() method
		 * this could be a ordinary reference to a Employee object
		 * or could be a anonymous inner class that we create when we call the callAnon method, what we would
		 * be passing in this circumstance is a anonymous inner class implmenation of the Employee class
		 */
		emp.doWork();
	}
	
	void callAnon() {
		//sending the anonymous inner class eddie to this method
		System.out.println("callAnon method with eddie");
		live(eddie);
		//sends a anonymous inner class to the live method
		System.out.println("callAnon method with an anonymous inner class");
		/*
		 * this is taking an anonymous inner class (anonymous means we can't directly refer to this object through
		 * a direct reference
		 * the whole class is an argument that is sent to the live() method
		 */
		live(new Employee(45,"mary") {
			@Override
			void earnMoney() {
				System.out.println(name+" is earning money");
				/*
				 * can access variables of the enclosing class anywhere if you are currently in an 
				 * anonymous inner class
				 */
				System.out.println("size of building is "+size);
				
			}
			
			void doWork() {
				System.out.println("this employee is "+age+" years of age");
				earnMoney();
				leave();
			}
			
			void leave() {
				System.out.println("leave method only avaliable in this inner class");
			}
		}
				);//end of code line live(new Employee(){}); is a simplified version of what we just did
		live(new Employee() {
			
		});//this is another simplified version
	}//end of callAnon method
	
	abstract class Bungalow{
		abstract int heatMe();
	}
	/*
	 * the only places where you can use the keyword "new" with an abstract class is an anonymous class object
	 * that implments the abstract methods contained within the Bungalow class
	 */
	Bungalow myBungalow=new Bungalow() {
		{
			System.out.println("Bungalow is created");
		//	myBungalow.heatMe();
		}
		/*
		 * if you are using anonymous class implmentation of an abstract class
		 * then you HAVE to override the abstract methods contained with that abstract class. here Bungalow is an
		 * abstract class that has the abstract method heatMe(), so we HAVE to override the heatMe() in this
		 * anonymous class implementation
		 */
		@Override
		int heatMe() {
			System.out.println("bungalow is heated to 10 degrees");
			liveIn();
			return 0;
		}
		
		void liveIn() {
			System.out.println("living in a Bungalow");
		}	
	};
	
	void callBungalow() {
		System.out.println("callBungalow method called");
		myBungalow.heatMe();
	}
	/*
	 * an inner class CAN extend an outer class
	 * however an outer class CANNOT extend an inner class
	 * class Flower extends Plant{
			class Plant{}
		}//this will not compile
		if an inner class extends it's outer class, you CANNOT create an anonymous class inner class implementation
		/*
 * as in order to first create a Apartment we have to create a Building, but we are currently inside the Building class, and in the building class
 * we are tyring to create a Apartement, which you can't do without createing a building, and on and on it goes
 * you can create a object of an inner class in the body of the outer class, just not an anonymous one
 */
	class Apartment extends Building{
		/*
		 * whereas you can do this, it is very difficult to actually create an object of this class (i have still
		 * not managed to do it so it is debateable if you can actually do it)
		 */
		
	}
	/*
	 * can't now go, will create a StackOverFlowError
	 */
/*	Apartment myApartment=new Apartment() {
		
	};*/
	
	//Apartment myApartment=new Apartment();
	
	interface Behaviour{
		void sad();
		void mad();
	}
	
	void callBehaviour(){
		/*
		 * you can have an interface referece to a anonymous class implemnation of that interface
		 * or in this case a Behavoiur interface reference and a anonymous class that implments both of the
		 * abstract methods in the Behaviour
		 * we can do this with the predicate interface but more usually we use a lambda when using a predicate
		 * functional programming (which is really all about lambdas) is all about dealing with interfaces, 
		 * which will be dealt with in later chapters
		 */
		Behaviour behave1=new Behaviour() {
			@Override
			public void sad() {
				System.out.println("behave1 sad method");
				
			}
			@Override
			public void mad() {
				System.out.println("behave1 mad method");				
			}			
		};
		/*
		 * calling the sad() and mad() method from above
		 */
		behave1.sad();
		behave1.mad();
		/*
		 * a predicate interface can also use anonymous class implementation
		 */
		Predicate<Integer> pred=(a)->a>10?true:false;
		Predicate<Integer> myPred= new Predicate(){
			@Override
			public boolean test(Object t) {
				Integer num=(Integer)t;
				System.out.println(t.getClass().getSimpleName());
				return false;
			}		
		};
		myPred.test(23);
	}//end of callBehaviour() method
	
	void callSkyScraper() {
		/*
		 * you can create a derived call anonymous class object inside the parent class, as long as this class
		 * is not FIRST created as an inner class, i.e Skyscraper is first defined as a top level class
		 * the constructor in the outer Skyscraper class will call this sway() method
		 */
		Skyscraper mySkyscraper=new Skyscraper() {
			
			void sway() {
				System.out.println("skyscraper swaying inside anonymous class implementation");
			}
		};
		System.out.println("********");
		mySkyscraper.knockItDown();
		System.out.println("**********");
		/*
		 * calling the takeSkyscraper method using a anonymous inner class
		 */
		takeSkyscraper(new Skyscraper() {
			@Override
			void sway() {
				System.out.println("skyscraper swaying and starting to wobble");
				wobble();
				knockItDown();
				
			}
			void wobble() {
				System.out.println("Skyscraper wobbles and will fall down soon");
			}
		});
		
	}
	
	void takeSkyscraper(Skyscraper skySc) {
		System.out.println("takeSkyscraper method called");
		skySc.sway();
	}
	
	

}//end of Building class

class Skyscraper extends Building{
	//Skyscraper constructor
	Skyscraper(){
		System.out.println("SkyScraper created");
		
		sway();
	}
		void sway() {
			System.out.println("swaying Skyscraper original");
		}
		
		void knockItDown() {
			System.out.println("syscraper knocked down");
		}
	}//end of Skyscraper class

class MyClass{
	int num;
	Skyscraper skyScr=new Skyscraper() {
		
		void sway() {
			buildIt();
			System.out.println("building starts to sway after being built");
			System.out.println(num);
		}
		
		void buildIt() {
			System.out.println("buliding skyscraper");
		}
		
	};
	/*
	 * we can access the sway() method of the Skyscraper class as it was first defined in the original skyscraper
	 * class (you only have access to methods you are  overriding with the anonymous class.
	 * so we have no direct access to the buildIt() method, you will have to access it through one of the overriden
	 * methods, in our case the sway() method
	 */
}


