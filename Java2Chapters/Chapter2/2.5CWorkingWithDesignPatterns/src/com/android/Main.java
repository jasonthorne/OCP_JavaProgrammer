package com.android;

import java.time.LocalDate;
import java.util.Arrays;

import com.android.Employee.EmployeeBuilder;
import com.android.Human.HumanBuilder;

public class Main {

	public static void main(String[] args) {
		System.out.println("****THE BUILDER PATTERN");
		/**
		 * THE BUILDER PATTERN
		 * How to create an object that requires numerous values to be set at the time the object
		 * is instantiated
		 * As applications develop your classes will be getting more atributes so you will need to add these
		 * atributes to the class, which means we have to add to our constructors or create new constructors
		 * if a constructor grows too large this can be referred to as
		 * Telescoping constructor anti-pattern
		 * a anti-pattern is a common solution to reoccuring problem that tends to lead to unmanageable or difficult
		 * to use code
		 * so if 50 different developers only add on new parameter to a constructor, each change is small, but taken together
		 * make it unmanageable
		 * The BUILDER pattern is a creational pattern in which parameters are passed to a builder object, often through
		 * method chaining and an object is generated with a final build call, often used with immutable objects, but it can
		 * be used with mutable objects as well
		 * if you have many constructors you can create an object where not all the values have been instantiated
		 * the Builder pattern ensures that the object will have values for all its parameters
		 * commonly used with immutable classes
		 * this approach leads to far more manageable code, if a new optional field is added to Animal, then existing code
		 * that creates objects using the AnimalBuilder class does not need to be changed
		 * Builder classes are tightly coupled with the Animal class
		 * in practice a builder class is often packaged alongside it's target class, either as a static inner class
		 * of its target class or within the same java package (advantage of this is if one changed, the other can be 
		 * quickly updated). Another advantage is you can choose to make the constructor, in this case of the Animal class,
		 * private or default, thus forcing the user to use to rely on the builder object
		 */
		AnimalBuilder cowBuilder=new AnimalBuilder();
		//common to chain methods with the Builder pattern
		cowBuilder.setAge(12).setName("cow").setFavouriteFoods(Arrays.asList("hay","grass","oats"));
		//the build method is what creates the Animal object
		Animal cow=cowBuilder.build();
		System.out.println(cow);
		/*
		 * don't even have to create a reference for the AnimalBuilder class
		 */
		Animal sheep=new AnimalBuilder().setAge(4).setName("Sheep").setFavouriteFoods(Arrays.asList("hay","barley","oats")).build();
		System.out.println(sheep);
		//this is just an animal with an age
		Animal gorilla=new AnimalBuilder().setAge(12).build();
		System.out.println(gorilla);
		//this object is an animal that just has favouritefoods
		Animal flamingo=new AnimalBuilder().setFavouriteFoods(Arrays.asList("banana","orange","mango")).build();
		System.out.println(flamingo);
		
		HumanBuilder hBuilder=new HumanBuilder();
		hBuilder.setAge(4).setName("noel").setWeight(145.45);
		Human noel=hBuilder.build();
		/*
		 * we start off in our human class with only age,name and weight. if we add  new variables to the human class, all we have to do
		 * is then add a new setter for that variables
		 * we add a double height variables
		 * and a LocalDate dob(date of birth)
		 * when we are creating a human directly from a a HumanBuilder object you have to have the last method in the chain to be "build()"
		 * as build() returns a human, all the other setter methods in the HumanBuilder class return a HumanBuilder object
		 */
		Human harry=new HumanBuilder().setAge(23).build();
		System.out.println(harry);
		/*
		 * this will now be a brand new Human, so this Human object has no age, but it does have a date of birth
		 * with this method we can make a object as complex or a simple as we want. we don't need to have constructors for every 
		 * different sort of human we want 
		 * i.e
		 * human with only an age
		 * Human with a age and name
		 * human with only a Dob, etc 
		 * Objects with a lot of variables could end up with a lot of constructors, using this method all we need is setter method for
		 * each one of the setters
		 * so for instance 15 variables, only 15 setters needed, doing constructors for all those all possible combinations would mean
		 * a massive amount of constructors and really really long and complex code
		 */
		harry=new HumanBuilder().setDob(LocalDate.now().minusYears(18)).build();
		System.out.println(harry);
		harry=new HumanBuilder().setAge(23).setDob(LocalDate.now().minusYears(23)).setHeight(6.2).setName("harry").setWeight(123.45).build();
		
		Human eddie=new HumanBuilder().setName("eddie").setHeight(5.9).setAge(40).build();
		Animal dog=new AnimalBuilder().setName("spot").build();
		
		
		Employee etna=new EmployeeBuilder().setBoss(eddie).setPet(dog).setName("etna").build();
		

	}

}
