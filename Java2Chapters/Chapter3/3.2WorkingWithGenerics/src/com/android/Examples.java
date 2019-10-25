package com.android;

import java.util.ArrayList;
import java.util.List;
import com.android.Human.HumanBuilder;
import static com.android.Cow.*;

public class Examples {
	
	private interface Grow{
		void sprout();
		void pollinate();
	}
	private enum Fruit implements Grow{
		COCONUT(),MANGO(),RASPBERRY(){
			//can't have a constructor inside here as this is effectively an anonymous inner class
			{
				System.out.println("raspberry initialisers");
			}
			//but you can override
			@Override
			public void sprout() {
				
			}
			//can have a inner class inside a enun
			class Seed{
				
			}
			@Override
			public String toString() {
				return "this is a raspberry";
			}
			//implmenting the Grow interface
			Grow myGrow=new Grow() {

				@Override
				public void sprout() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void pollinate() {
					// TODO Auto-generated method stub
					
				}
				
			};
		};//end of raspberry anonymous inner class
		private int name;
		Fruit(){
			System.out.println(this.toString().toLowerCase()+" fruit created");
	//		System.out.println(this);
		}
		@Override
		public void sprout() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void pollinate() {
			// TODO Auto-generated method stub
			
		}
		
		
	}//end of Fruit enum
	
	static void ex1() {
		/*
		 * we can only add Strings to this list, if we attempt to add anything else it will not compile
		 */
		List<String>names=new ArrayList<String>();
		String fruit="banana";
		names.add("apple");//will compile
		names.add(new String("orange"));//will compile
		names.add(fruit);
		//can't add a enum type
	//	names.add(Fruit.COCONUT);
		//can add the toString() of each of the Fruit types
		names.add(Fruit.COCONUT.toString().toLowerCase());
		System.out.println(names);
		//can't add a StringBuilder object
	//	names.add(new StringBuilder("tomato"));
		//can't add an object
		//names.add(new Object());
		//but if that object calls the toString method we can add it
		names.add(new Object().toString());
	
		
	}
	
	static void ex2() {
		/*
		 * we can create a Crate and supply it a generic type of any type of Object, here its elephant
		 * the constructo rin this class takes a object that matches the type on the left hand side
		 */
		Crate<Elephant>crateElephant=new Crate<>(new Elephant());
		crateElephant.returnMe();
		//here we create a Crate with a String
		Crate<String>crateString=new Crate<>("hello there");
		//have to import CowBuilder static class for this to work
		Cow myCow=new CowBuilder().setAge(4).setHeight(2.0).setWeight(123.4).build();
		/*
		 * Box takes a type that is a Animal or sub class of Animal
		 */
		Box<Animal>boxAnimal=new Box<>(new Animal());
		Box<Zebra>boxZebra=new Box<>(new Zebra());
		Box<Cow>boxCow=new Box<>(myCow);
		Box<Cow>boxCow2=new Box<>(new CowBuilder().setAge(4).build());
		/*
		 * Bucket takes as a generic type a class that implements the Behaviour interface, we have two classes that do, the
		 * Whale and Lemur class (in Behaviour file)
		 */
		Bucket<Whale>bucketWhale=new Bucket<Whale>(new Whale());
		Bucket<Lemur>lemurBucket=new Bucket<>(new Lemur());
		Bucket<Lemur>lemurBucket2=new Bucket<>(new Lemur() {
			@Override
			public void sad() {
				System.out.println("overriden lemur sad method in anonymous inner class");
			}
		});
		/*
		 * Pan takes a generic that implements the Life interface, which only has one method, void grow(), so we can 
		 */
		Life myLife=()->{
			System.out.println("grow method of the myLife lambda");
		};
		/*
		 * this can take a lambda or a class that implements the life interface
		 */
		Pan<Life>lifePan=new Pan<Life>(myLife);
		Pan<Life>lifeFlower=new Pan<Life>(new Flower());
		/*
		 * this can only take a flower but not a lambda
		 */
		Pan<Flower>lifeFlower2=new Pan<Flower>(new Flower());
		//even casting this will give a classCastException
		//Pan<Flower>lifeFlower3=new Pan<Flower>(myLife);
		
		Pot<Zebra>potZebra=new Pot<Zebra>(new Zebra());
		//generic types on left and right have to match, but the actual object can be any Animal
		Pot<Animal>animalPot=new Pot<Animal>(new Zebra());
		//type V will now be a Zebra, T will be a Animal
		//monkey class is class Monkey<V>implements Manners<Animal,V>{
		Monkey<Zebra>monty=new Monkey<Zebra>();
	//	monty.
		/*
		 * public interface Manners<T,V> {
	void thankYou(T t);
	void sorry(T t,V v);

}
		 */
		//type T was defined to be a Animal when the Monkey class implemented the Manners interface
		monty.thankYou(myCow);//void thankYou(T t);
		//type V was defined to be a Zebra when we creaed the Monkey monty
		//the first variable can be any Animal and the second variable has to be a Zebra() or subclass of Zebra
		monty.sorry(new Elephant(), new Zebra());
		
		//class Kettle<T extends Animal,V extends Behaviour,E>
		/*
		 * kettle class has three generic types T, V and E, and our constructor takes one of each of those 
		 * generic types, which we have said to be a Elephant, Whale and String
		 */
		Kettle<Elephant,Whale,String>specialKettle=new Kettle<>(new Elephant(),new Whale(),"apple");
		//returns what the Animal name that type T is 
		System.out.println(specialKettle.method().getClass().getSimpleName());
		
		//method signature for this method is <S>void method2(S myS){//this can take any object
		//and will print out the type of object that generic type S becomes
		specialKettle.method2(new Zebra());
		/*
		 * static methods can't use generics that are created when a object of a class is created (as a static method can
		 * run without a object of a class being created), but a static method can have it's own generics
		 * static<S extends Animal,V extends Behaviour, U extends Manners>void method3(S myS,V myV,U myU){
		 */
		Kettle.method3(new Elephant(), new Lemur(), monty);
		//this method can take any Animal or subclass of Animal
		//static<S extends Animal>S method4(S myS){
		//if you cast to be of type S in the method, can cast any animal object to be any other Animal object
		Kettle.method4(new Zebra());
	}
	
	static void ex3() {
		System.out.println("Ex3**");
		/*
		 * creates a field with the type cow and potato
		 * and assigns a cow to the Animal atribute
		 * and assigns potato to the crop atribute
		 * a generic can ONLY BE an object, can't be a primitive
		 * so if want to use numbers you have to use one of the numeric wrappers (Integer, Double, Float, etc)
		 * Field in Crate.java
		 */
		Field<Cow,Potato>myField=new Field<>(new CowBuilder().setHeight(1.2).setWeight(234).build(),new Potato());
		/*
		 * Robot class implements the Move interface that has two generic type T,V
		 * Robot specifies the generic type to be Cow,Zebra
		 */
		Robot robbie=new Robot();
		robbie.walk(new CowBuilder().build(),new Zebra() );
		/*
		 * using the generic class to implement the generic interface. the interface methods will be implemented using Robot and
		 * Elephant 
		 */
		Vehicle<Robot,Elephant>myVehicle=new Vehicle<>();
		myVehicle.walk(robbie, new Elephant());
	}
	
	static void ex4() {
		/*
		 * myType is a static method that has a generic return type and it also takes the same generic type as a parameter
		 * so in this example it's parameter is a monkey and it returns a monkey
		 */
		Rocket.myType(new Monkey());
		Rocket.myType(new HumanBuilder().setAge(56).setName("mary").build());
		/*
		 * you can also call it this way
		 * it's parameter is an elephant and it is returning an Elephant
		 */
		Rocket.<Elephant>myType(new Elephant());
	}
	
	static void ex5() {
		System.out.println("ex5****");
		//use MythicalCreature.java file 
		//we have not specified a type for this list
		List creatures=new ArrayList<>();
		/*
		 * you can add any object to this list because we have not specified a type. this code DOES NOT use Generics
		 */
		//so we can add Unicorns to this list
		creatures.add(new Unicorn());
		//and we can also add dragons
		//creatures.add(new Dragon());
		creatures.add(new Unicorn());
		/*
		 * as this list has no type, if our list contains NOTHING BUT UNICORNS, this will compile and run, but as soon as
		 * we put in any other type of object (String, dragaon, array, etc) this will cause a compilation error
		 */
		takeUnicorns(creatures);
		List<MythicalCreature>mythsC=new ArrayList<>();
		mythsC.add(new Unicorn());
		mythsC.add(new Unicorn());
		/*
		 * if we supply a incompatible type (here this is a list of type super class MythicalCreature) it will not compile
		 */
	//	takeUnicorns(mythsC);
	}
	/*
	 * this can only take a List of Unicorns, if we sent it a list that has anything other than unicorns this compile but
	 * throw a classCastException
	 */
	static void takeUnicorns(List<Unicorn>unicorns) {
		for(Unicorn unicorn:unicorns)
			unicorn.doMagic();
	}
}




