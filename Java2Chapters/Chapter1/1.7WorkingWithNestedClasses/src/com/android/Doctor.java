package com.android;
/*
 * a static class inside a class is a 
 * NESTED CLASS
 * all other types of classes withing a class are
 * INNER CLASSES
 */

public class Doctor {
	/*
	 * a nested inner static class is not really an inner class at all as it can be created without an object
	 * of the enclosing class. It can be made private or use one of the other access modifiers to encapsulate it.
	 * the enclosing class can refer to the fields and methods of the static nested class
	 */
	int age;//age of doctor
	String name;//name of doctor
	static int staticNum=0;
	/*
	 * this is a object of the inner static class pay
	 */
	Pay myPay=new Pay();
	//constructor for Doctor class
	Doctor(){
		System.out.println("Doctor created with blank constructor");
	}
	
	Doctor(int age,String name){
		this.name=name;
		this.age=age;
	}
	int empId=4;
	
	static class Pay{
		double weekly=4567.89;
		static int statId=56;
		Pay(){
			System.out.println("object of inner static pay class created");
			/*
			 * can access statics of outer class directly
			 */
			System.out.println(staticNum);
			/*
			 * however cannot access instance variables unless you first create a instance of the enclosing class
			 */
		//	System.out.println(empId);
			System.out.println("weekpay is "+weekly);
		
		}
		
		void payTax() {
			/*
			 * if you want to access instance variables/methods of the outer Doctor class you have to first 
			 * create a Doctor object
			 */
			Doctor dr=new Doctor();
			System.out.println("id of doctor is "+dr.empId);
		}
		
		
		
	}

}//end of Doctor class
