package com.android;
/*
 * a static class inside a class is a NESTED CLASS.
 * All other types of classes within a class are INNER cLASSES.
 */
public class Doctor {
	
	
	int age = 45;
	String name;
	static int statNum=0;
	/*The outer class CANT access anything from within the inner class. BECASUE ITS STATIC!! (unless you create an object of the inner class) 
	//System.out.println(weekly);
	 */
	
	
	
	
	//constructor:
	Doctor(){
		System.out.println("Blank doctor constructor called");
	}
	
	Doctor(int age, String name){
		this.name = name;
		this.age = age;
		
		//you CAN access all of the members of the static inner class through an object:
		Pay myPay = new Pay();
		
		
		System.out.println(myPay.weekly); //accessing the vars of the inner static class, through creating an object of that static class.
		Pay.payPrsi(); //this is a static method of the nested Pay class ++++++++++++++++++++ Accessing in a STATIC way
		myPay.payPrsi(); //accessing this static method in a NON static way.
	}
	
	//inner static class (NESTED class)
	/*
	 * static classes can ONLY access STATIC variables of the outer class directly. It cannot access the outer class instance variables directly.
	 */
	
	static class Pay{
		double weekly = 4567.90;
		static String payId = "456677";
		//blank pay class constructor:
		Pay(){
			System.out.println("static pay class constructor called");
			//accessing static variables of the outer class:
			System.out.println("accessing statNum: " + statNum);
			
			//System.out.println("age of doctor is: " + age); //cant access this is a static class and so DOESMT belong to any individual object, but belongs to the class as a whole.
			System.out.println(weekly);
			System.out.println(payId);
		
			
		}
		
		/*
		 * The rules about static methods only accessing static variables of its own class directly
		 *  and instance methods being able to access both static and non statics of its own class still apply. 
		 */
		
		void payTax() {
			/*
			 * If you want to access instance variables/methods of the outer Doctor class, you have to first create a Doctor object.
			 */
			
			Doctor doctor = new Doctor();
			System.out.println("age of Doctor is: " + doctor.age);
		}
		
		static void payPrsi() {
			System.out.println("static void payPrsi method");
		}
		
	}//end of static pay class 
	
	
	

} //end of Doctor class
