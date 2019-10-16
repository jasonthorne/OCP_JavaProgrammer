package com.android;

import java.io.Serializable;

public class Animal {
	/*
	 * a top level class can be either public or package/default(no keyword) level access. however a member inner
	 * class can be any access level
	 * so they can be private,protected, package level and public
	 * inner classes can be final or abstract
	 * but member inner class CANNOT have static fields or methods
	 * can access members from the outer class including variables and methods
	 */
	private int age;
	protected String  name;
	public double weight;
	/*
	 * static members can be access in inner classes, but you can only create static members in a static inner 
	 * class
	 */
	static int liverId=0;
	Heart myHeart;
	Liver myLiver;
	Lungs myLungs;
	Kidney myKidney;
	int myBpm;
	
	Animal(){
		
	}
	Animal(int age,String name,double weight){
		this.age=age;
		this.name=name;
		this.weight=weight;
		/*
		 * private methods, variables and constructors of the member inner classes can be accessed from the 
		 * outer classes.
		 * we can access the private no arguement constructor in the Heart class, even though it was declare
		 * private (we cannot however create a heart outside of the Animal class as no access to heart as it is a
		 * class that is private to the Animal class).
		 * we access the private members of the inner class through a object of the inner class, in this case through
		 * the existing heart object, myHeart
		 */
		myHeart=new Heart();
		myLiver=new Liver();
		myLungs=new Lungs();
		myKidney=new Kidney();
		myBpm=myHeart.bpm;
		//or can access it through an new heart
		myBpm=new Heart().bpm;
		/*
		 * can access ALL members of a the liver class regardless of access level, 
		 * recycle() is a private method of the inner Liver class
		 */
		myLiver.recycle();
	}
	/*
	 * this is the inner member class Heart, which can only be accessed inside of the Animal class because this
	 * is a private inner member class
	 */
	private class Heart{
		//the outer class has access to the inner private int bpm, but you c
		private int bpm;
		//constructor to create a Heart
		private Heart() {
			System.out.println("heart created and beating");
		}
		//beat method of the Heart class
		private void beat() {
			System.out.println("heart beating");
		}
	}
	protected class Lungs{
		Lungs(){
			System.out.println("lungs created");
		}
	}
	
	public class Liver {
		
		int id;
		private int pnum;
		
		Liver(){
			liverId++;
			id=liverId;
			System.out.println("liver created ");
		}
		/*
		 * can access all variables of the outer class, regardsless of the access leve type (private, public,etc)
		 */
		void cleanse() {
			System.out.println("liver cleasing ");
			System.out.println("age is "+age);
			System.out.println("weight is "+weight);
			System.out.println("id of liver is "+id);
		}
		
		private void recycle() {
			System.out.println("liver helps with recycling in the body");
		}
	}
	/*
	 * only classes inside the Animal class can implement the Behaviour interface
	 */
	private interface Behaviour{
		void alive();
	}
	
	class Kidney implements Behaviour{

		@Override
		public void alive() {
			System.out.println("my Kidney is alive");
			
		}
		/*
		 * can't have a static member inside of a inner non static class (as a inner member class is tied to
		 * a individual object, and a static is tied to the whole class). so this WILL NOT compile
		 */
		/*
		static void noMethod() {
			
		}*/
		//static int count;//will not compile as static variable
		
	}
	/*
	 * only a STATIC INNER class can create a static member
	 * */
	static class Brain implements Behaviour{
		/*
		 * a static class can have non static members
		 */
		int num;//will compile
		/*
		 * but it cannot access the outer non static members of the outer class (in our case the Animal class)
		 */
		static int statNum;//will compile
		@Override
		public void alive() {
			System.out.println("can access statics "+liverId);
		//	System.out.println("but cannot access non statics "+age);
			System.out.println("only way to access non static members of an outer class is through a "
					+ " object of that class");
			System.out.println(new Animal().age);
			
		}
		
	}

}
/*
 * never do this in real life as too confusing, but you can do it
 */
class Dog{
	int age=10;
	Dog(){
		new Heart().new Cells().new Chemicals();
	}
	class Heart {
		int age=20;
		class Cells{
			int age=30;
			class Chemicals{
				int age=40;
				Chemicals(){
					System.out.println("chemical constructor called");
					System.out.println("Age of Chemicals is "+age);//ages of chemicals
					System.out.println("Ages of Cells is "+Cells.this.age);//age of cells
					System.out.println("Age of heart is "+Heart.this.age);//age of heart
					System.out.println("Age of Dog is "+Dog.this.age);//age of Dog
				}
			}
		}
	
	}
}
