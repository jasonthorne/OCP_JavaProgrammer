package com.android;

import com.android.Animal.Liver;
import com.android.Doctor.Pay;

public class Examples {

	static void memberInner() {
		Animal andy=new Animal(12,"andy",2.3);
		/*
		 * the inner instance class Liver is a public class, so we have access any members of a class
		 * depending on the access leve (can access all public members, can access package level members if
		 * in same package, can access protected members if in a derived class or in same package
		 * cleanse() is a public method of the Liver class so we can access this method
		 */
		andy.myLiver.cleanse();
		/*
		 * we cannot access the recycle method as this is a private method so not available outside of the class
		 */
	//	andy.myLiver.recycle();
		/*
		 * can't access any of the methods or variables of the Heart object myHeart
		 */
	//	andy.myHeart.
		/*
		 * you can create an instance of an inner class if you have access to the inner class, the inner
		 * member class Liver is Public so we can create an instance of this class
		 */
		//System.out.println(andy.myLiver.id);
		/*
		 * this creates a new Liver through the Animal object andy, however this is NOT andy's liver, this
		 * is a independant liver that is not connected to any Animal
		 */
		Liver myLiver=andy.new Liver();
		System.out.println("independent liver is "+myLiver.id);//has a id of 2
		/*
		 * this is andys' liver which has a id of 1, so we can see these are two different livers
		 */
		System.out.println("andy's liver is "+andy.myLiver.id);//has id of 1
		/*
		 * can also create a liver by creating a new Animal(), the new Animal() is liable for garbage collection
		 * as soon as it is created as it not referenced by anything
		 */
		myLiver=new Animal().new Liver();
		/*
		 * calling alive() method of a new Kidney created inside a new Animal
		 */
		System.out.println("calling alive method of a new Kidney");
		new Animal().new Kidney().alive();
		/*
		 * inner classes with same variable names (age), but don't this type of coding in real life
		 */
		Dog spot=new Dog();
	}
	
	static void localInner() {
		Human harry=new Human();
		harry.eat();
	}
	
	static void anonymousInner() {
		Building myBuilding=new Building();
		myBuilding.callAnon();
		myBuilding.callBungalow();
		myBuilding.callBehaviour();
		myBuilding.callSkyScraper();
		
	}
	
	static void staticInner() {
		/*
		 * use the Doctor class
		 */
		Doctor dr=new Doctor();
		/*
		 * you can create a instance of an inner class like the following
		 */
		new Animal().new Liver();
		/*
		 * however you can't create a static NESTED class object like the following
		 */
	//	new Doctor().new Pay();
		/*
		 * you can access the static class directly, provided you have the correct access level on the 
		 * class
		 */
		Pay myPay=new Pay();
		/*
		 * or you can access it a static way through it's enclosing class name
		 */
		Doctor.Pay myPay2=new Pay();
		/*
		 * or even this way
		 */
		Doctor.Pay myPay3=new Doctor.Pay();
		/*
		 * can access static variables of the class via a object (non static way to access static variables)
		 */
		System.out.println(myPay3.statId);
		/*
		 * can access instance variables of the Pay class in the normal way
		 */
		System.out.println(myPay3.weekly);
		/*
		 * or in a static way
		 */
		System.out.println(Pay.statId);
		System.out.println(Doctor.Pay.statId);
	//	
	}
}
