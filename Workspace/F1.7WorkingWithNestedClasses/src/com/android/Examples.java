package com.android;

import com.android.Animal.Liver;
import com.android.Doctor.Pay;

public class Examples {
	
	static void ex1() {
		System.out.println("local member classes");
		Animal andy=new Animal(12,"andy",2.3);
		
		/*
		 * the inner instance class Liver is a public class, so we have
		 * access to any members of this class as long as they are
		 * public, protected or package leve.
		 * cleanse() is a public method of the liver class so we can 
		 * access this method
		 */
		andy.myLiver.cleanse();
		//does not have access to this method as this is private
		//andy.myLiver.recycle();//private
		
		/*
		 * this cannot be accessed as the Heart class is private
		 * and you can't access any members of the Heart class outside
		 * of the Heart class or the Animal class
		 */
		//andy.myHeart.beat();
		/*
		 * the inner heart class is private, however the myHeart variable
		 * is NOT private, so it's really only the internals of the 
		 * Heart class we cannot access (can't access any methods or
		 * variables contained within the Heart class)
		 */
		System.out.println(andy.myHeart);
		//id of andy's liver is 1
		System.out.println("id of andys liver is "+andy.myLiver.id);
		//this is the same liver
		Liver liver1=andy.myLiver;
		System.out.println(liver1.id);//1
		System.out.println(andy.myLiver.id);//1
		System.out.println(andy.myLiver.equals(liver1));//true
		//you can't create a new liver, without an Animal
		Liver liver2=new Animal().new Liver();
		System.out.println("id of liver2 is "+liver2.id);
		//you can also create a  new Liver by using an existing Animal object
		/*
		 * this is  using andy to create a new Liver, but its NOT andy'd 
		 * liver, this is a standalone liver existing outside of an 
		 * Animal
		 */
		Liver liver3=andy.new Liver();
		//this is how we assign a new liver to andy
		//andy.myLiver=liver3;
		System.out.println("id of andy's liver is "+andy.myLiver.id);
		System.out.println(liver3.id);
		/*
		 * when you have a public inner class, you can create a standalone
		 * object that can exist without its outer class.
		 * i.e we can create a Liver, that does not belong to a particular
		 * Animal, because it is a public inner class
		 * we CAN'T create a standalone heart, as it is a private class,
		 * we can't create a Heart outside of the Animal class
		 */
		andy.myLungs.alive();
		
		//spot has inner inside inner classes and same variable age for each inner class
		Dog spot=new Dog();	
	}
	
	static void ex2() {
		System.out.println("local inner classes");
		Human harry=new Human();
		harry.eat();
	}
	
	static void ex3() {
		Building myBuilding=new Building();
		Employee etna=new Employee();
		etna.doWork();
		myBuilding.callAnon();
		myBuilding.callBungalow();
		myBuilding.callBuildings();
		//creating a Plant, that has a itself a Plant variable
		Plant myPlant=new Plant();
		myPlant.aMethod();
		myPlant.callInners();	
	}
	
	static void ex4() {
		Doctor dr=new Doctor(50,"john");
		//this creates a stand alone liver
		Liver myLiver=new Animal().new Liver();
		/*
		 * you can't create a nested object the same way
		 */
		//new Doctor().new Pay();
		/*
		 * you can access the static class directly, provided you have the
		 * correct access levels
		 */
		Pay myPay=new Pay();
		/*
		 * or you can access the nested class in a static way through it's 
		 * enclosing class name
		 */
		Doctor.Pay myPay2=new Pay();
		/*
		 * or even this way
		 */
		Doctor.Pay myPay3=new Doctor.Pay();
		/*
		 * accessing non statics of a the nested static class
		 */
		System.out.println("weekly is "+myPay3.weekly);
		//accessing static string payId
		System.out.println("payId is "+myPay3.payId);
		//these are all statics and can be accessed in a static way
		System.out.println(Pay.payId);
		System.out.println(Doctor.Pay.payId);
		Pay.payPrsi();
		/*
		 * cannot access weekly in a static way because this is a non 
		 * static variable, even it is inside a nested static class
		 */
	//	Pay.weekly;	
	}

}
