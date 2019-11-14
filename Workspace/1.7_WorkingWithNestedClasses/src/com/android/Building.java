package com.android;

class Employee{
	
	//vars:
	int age = 24;
	String name = "samwise";
	private double weight = 2.34;
	
	//constructors:
	Employee(){
		System.out.println("Employee created with no args constructor");
	}
	
	Employee(int age, String name){
		this.age = age;
		this.name = name;
		System.out.println("employee created with constructor in string");
	}
	
	//methods:
	void earnMoney() {
		System.out.println(name + " Employee earing money");
	}
	
	void doWork() {
		System.out.println("Employee working");
	}
	
	double getWeight() {
		return weight;
	}
	
}


//building is a top level class:
public class Building {
	
	Employee eddie;
	int size=400;
	
	Building(){
		int localInt = 6;
		System.out.println("Building constructor called");
		
		/*
		 * An anonymous inner class is a way to redefine a class where we can override methods or even declare new methods and variables
		 */
		
		eddie = new Employee() {
			
			/*
			 * This is an anonymous class implementation eddie the employee object.
			 * Which allows us to tailor the object to be specific to Eddie.
			 */
			
			/*You cant have a constructor inside an anonymous inner class
			However you can have initialisers*/
			{
				System.out.println("You cant have a constructor inside an anonymous inner class. However you can have initialisers");
			}
			
			/*
			 * variables and methods first created inside an anonymous inner class are only avaliable inside the anonymous inner class.
			 */
			int newVar = 90; //only available inside the curly brackets
			
			/*
			 * You can override methods in an anonomous inner class.
			 * Here we are overriding the earnMoney method from the employee class.
			 */
			@Override
			void earnMoney() {
				
				System.out.println("This is eddie's own earnMoney() method");
				System.out.println("new var is: " + newVar);
				payTax();
				doWork();
			}
			
			void payTax() {
				System.out.println("eddie paying tax");
				
				/*
				 * we can access all varaibels of the outer class.
				 * The outer class is Building, so e can access Size & Eddie
				 */
				System.out.println("Size of building is: " + size);
				
				/*
				 * We can access local variables as long as they are effectively final or final.
				 * localInt below is a local var of the constructor, and if changed before use here, then is NO LONGER effectively final, so cant be used.
				 */
				System.out.println("localInt is: " + localInt);
				
				
				/*
				 * we can access all variables of the Employee class.
				 */
				
				System.out.println("name of employee is: " + name);
				System.out.println("age of employee is: " + age);
				
				/*
				 * The anonymous inner class doesnt have access to the private double weight, 
				 * as you can ONLY access this variable inside the Employee class, not the anonymous inner class.
				 * So you can access the weight through the employee class, not directly, as shown below:
				 */
				System.out.println("weight of employee is: " + getWeight());
				/////////System.out.println("weight of employee is: " + weight);
			}
			
			
		};//end of anonymous inner class
		
		//System.out.println(eddie.newVar); //no longer exists so cant be referenced.
		//eddie.payTax();  //no longer exists so can't be referenced.
		eddie.earnMoney(); //referenced outside of the anonymous inner class, so still exists.
		eddie.doWork(); //from the Employee class and not overridden.
		
	}//end of Building constructor
	
	private void live(Employee emp) {
		/*
		 * Whatever type of employee eobj is sent to this method, will call the earnMoney() method.
		 * All employee objects, regardless of whether they are anonymous inner classes, will have a an earnMoney() method. 
		 * We will create another method called callAnon that will send different employee object types to it. 
		 */
		emp.earnMoney();
		
		
	}
	
	//this method is sending different types of employee to the live method.
	void callAnon() {
		System.out.println("Building class callAnon method");
		System.out.println("Sending eddie to live method");
		live(eddie); //eddie anonymous class implementation
		
		System.out.println("Sending an employee obj with NO args constructor to live method");
		live(new Employee()); //Employee class implementation
		System.out.println("Sending an employee obj WITH args constructor to live method");
		live(new Employee(34, "mary")); //Employee class
		System.out.println("Sending an employee with it's own anon inner class to live method");
		live(new Employee(45, "Yvonne") {
			
			//Only available to anonymous inner class
			void leave() {
				System.out.println(name+ " is leaving");
			}
			
			@Override
			void earnMoney(){
				System.out.println("this employee " + name + "is earning money");
				doWork();
				leave();
			}
			
		}); //end of live method
		
		
		//This is the same as sending an Employee with no args constructor:
		live(new Employee() {
			
		});
		
	}//end of callAnon

}//end of building class
