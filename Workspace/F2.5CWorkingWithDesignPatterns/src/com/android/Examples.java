package com.android;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.android.Flower.Colour;
import com.android.Flower.Type;
import com.android.Human.HumanBuilder;
/*
 * this will import everything from the Employee class
 * including the nested static EmployeeBuilder class and 
 * the Title Enum
 */
import com.android.Employee.*;
/*
import com.android.Employee.EmployeeBuilder;
import com.android.Employee.Title;
*/



public class Examples {
	
	static void ex1() {
		System.out.println("flower with just an age");
		//this is a flower with just an age
		Flower myFlower=new FlowerBuilder().setAge(12).build();
		System.out.println(myFlower);
		//this is a flower with no values for any of its variable
		myFlower=new FlowerBuilder().build();
		System.out.println(myFlower);
		Colour myColour=Colour.RED;
		
		myFlower=new FlowerBuilder().setAge(12).setWeight(2.4).
				setColour(myColour).setType(Type.ROSE).build();
		System.out.println(myFlower);
		myFlower=new FlowerBuilder().setAge(5).setType(Type.TULIP).setWeight(3.4)
				.setColour(Colour.YELLOW).setSmell(true).setPetals(12).setHeight(7).
				build();
		System.out.println(myFlower);
	}
	
	static void ex2() {
		/*
		 * this creates an Animal with an Age of 12 and name of "cow
		 */
		Animal myAnimal=new AnimalBuilder().setAge(12).setName("cow").build();
		System.out.println(myAnimal);
		/*
		 * this creates an Animal with the age of 0 and the name of 
		 * "" (blank string)
		 */
		myAnimal=new AnimalBuilder().build();
		System.out.println(myAnimal);
	}
	
	static void ex3() {
		System.out.println("creating Immutable class objects with a Builder class");
		//this is creating a AnimalBuilder object
		AnimalBuilder cowBuilder=new AnimalBuilder();
		//common to chain methods with the Builder pattern
		/*
		 * we have not yet created our cow, this is just assigning the value of 12 to the int age
		 * variable inside the cowBuilder class and the value of "bessie" to the String name variable
		 * of the cowBuilder class
		 */
		cowBuilder.setAge(12).setName("bessie");
		/*
		 * the build() method of the AnimalBuilder class is what creates the Animal
		 */
		Animal cow=cowBuilder.build();//cow 1 created with age of 12 name of bessie
		cow=cowBuilder.build();//cow 2 created with age of 12 name of bessie
		System.out.println(cow);
		cow=cowBuilder.setAge(4).build();//cow 3 created with age of 4 name of bessie
		System.out.println(cow);
		List<Animal>herd=new ArrayList<Animal>();
		for(int i=0;i<50;i++) {
			cow=cowBuilder.build();
			herd.add(cow);
		}
		/*
		 * you do not have to create a AnimalBuilder reference when creating an Animal
		 * if you are going to be creating a Animal with the same name and age, then you
		 * could use a AnimalBuilder reference
		 */
		Animal sheep=new AnimalBuilder().setAge(3).setName("flossie").build();
		System.out.println(sheep);
		//this is an Animal of name "goat" and age of 0
		Animal goat=new AnimalBuilder().setName("goat").build();
		System.out.println(goat);
		//this is an Animal with a name of "" and a age of 15
		Animal pig=new AnimalBuilder().setAge(15).build();
		System.out.println(pig);
	}
	
	static void ex4() {
		/*
		 * inside HumanBuilder we have a private Human called myHuman
		 * so every time we use hBuilder, we are referring to this particular Human
		 */
		HumanBuilder hBuilder=new HumanBuilder();
		//this is a seperate Human
		Human me=new HumanBuilder().setAge(46).setName("noel").setWeight(300.2).build();
		//this is referring to the Human created in the line
		//HumanBuilder hBuilder=new HumanBuilder();
		Human you=hBuilder.setAge(20).setName("mary").build();
		//this is also the same Human
		Human someOne=hBuilder.setAge(45).build();
	//	System.out.println(me);
		System.out.println(you);
		System.out.println(someOne);
		//they are the same object, so this is true
		System.out.println(you.equals(someOne));
		
		Human harry=new HumanBuilder().setDob(LocalDate.now().minusYears(30)).setName("harry").build();
		System.out.println(harry);
		int age=25;
		harry=new HumanBuilder().setAge(age).setDob(LocalDate.now().minusYears(age)).setName("mary").build();
		System.out.println(harry);
	}
	
	static void ex5() {
		Employee emp1=new EmployeeBuilder().setGender(true).setStartDate(LocalDate.now()
				.minusYears(3)).build();
		System.out.println(emp1);
		Employee emp2=new EmployeeBuilder().setName("mary").setStartDate(LocalDate.now()
				.minusMonths(9)).setRole(Title.MANAGER).setWages(45_000.56).setGender(true).
				build();
		System.out.println(emp2);
		
		EmployeeBuilder empBuild=new EmployeeBuilder();
		System.out.println("using EmployeeBuilder numerous times");
		//this creates a NEW employee with default values
		System.out.println(empBuild.build());
		//this creates a new employee with the name of pat and the rest default values
		System.out.println(empBuild.setName("pat").build());
		/*
		 * this creates a new employee with the title of GENERAL and wages of 90,000.12 and
		 * the name pat and the rest have default values
		 */
		System.out.println(empBuild.setRole(Title.GENERAL).setWages(90_000.12).build());
		
	}

}
