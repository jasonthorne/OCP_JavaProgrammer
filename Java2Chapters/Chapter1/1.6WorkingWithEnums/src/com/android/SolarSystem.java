package com.android;

import java.util.Arrays;
import java.util.List;

public class SolarSystem {
	/*
	 * creates an array of 5 planets
	 */
	private Planets[]planetArray=new Planets[5];
	
	SolarSystem() {
		planetArray[0]=Planets.EARTH;
		planetArray[1]=Planets.MARS;
		planetArray[2]=Planets.VENUS;
		planetArray[3]=Planets.JUPITER;
		planetArray[4]=Planets.SATURN;
	}
	
	public String toString() {
		
		List<Planets>listPlanets=Arrays.asList(planetArray);
		/*
		 * this will call the toString method of the List interface which in turn will call the toString() 
		 * methods of each of the planets
		 */
		return listPlanets.toString();
			
	}
	/*
	 * this enum type is ONLY available inside this class, you will not be able to create a Planet outside of 
	 * this class, this enum also implements the Cosmic interface which has two methods 
	 * gravity() and 
	 * move();
	 */
	private enum Planets implements Cosmic{
		
		
		EARTH,MARS,VENUS, MERCURY,JUPITER(45_000_000,56789.89,98765.99){
			/*
			 * Jupiter has it's own toString method
			 */
			public String toString() {
				String str="name is "+name()+" population is "+population+" surfaceArea is "+surfaceArea+" size is "+size;
				return str;
			}
			/*
			 * Jupiter has it's own gravity method
			 */
			public void gravity() {
				System.out.println("jupiters own gravity method");
			}
		},SATURN(35_000_000,12343.88,2356.99);
		/*
		 * every planet will have these variables
		 */
		int population;
		double surfaceArea;
		double size;
		/*
		 * this is the construtor that will be called when a planet enum type is created that takes no
		 * arguements, which will be for EARTH,MARS,VENUS
		 */
		private Planets(){
			
			/*
			 * this will assing a population, a surfaceArea and a size based on the ordinal of the planet
			 */
			population=ordinal()+1*4;
			surfaceArea+=ordinal()+1*7;
			size+=size+ordinal()+1;
			/*
			 * calls the gravity and move method for this planet
			 */
		//	System.out.println("using this");
			/*
			 * this will call the toString method for the planet which will print out all the general toString
			 * method for EARTH,MARS,VENUS and SATURN
			 */
	//		System.out.println(this);
			gravity();
			move();
		}
		/*
		 * this is a constructor that will be called a planet enum type is created that takes in a int, double and
		 * a double, which will be JUPITER and SATURN
		 * 
		 */
		
		private Planets(int population,double surfaceArea,double size) {
			/*
			 * a constructor can call another constructor in the same enum, 
			 */
			//this();
			
			this.population=population;
			this.surfaceArea=surfaceArea;
			this.size=size;
			/*
			 * will call the toString() method for this planet, which would be JUPITER and SATURN
			 */
		//	System.out.println(this);
			//will call the gravity and move() method for this planet
			gravity();
			move();
			
		}
		/*
		 * EARTH,MARS,VENUS and SATURN will call these version of these methods
		 */
		@Override
		public void gravity() {
			System.out.println(name()+" general gravity method for planets");
			
		}
		@Override
		public void move() {
			System.out.println(name()+" general Move method for planets");
			
		}
		/*
		 * this is the general toString method for any planet that does not have it's own toString method
		 * so again EARTH,MARS,VENUS and SATURN will call these version of these methods
		 */
		@Override
		public String toString() {
			String str="general names"+name()+" population "+population+" surfaceArea "+surfaceArea+" size "+size;
			return str;
		}
	}

}

interface Cosmic{
	void gravity();
	void move();
}
