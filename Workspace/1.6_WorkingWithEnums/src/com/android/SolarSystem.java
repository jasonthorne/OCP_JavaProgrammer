package com.android;

import java.util.Arrays;
import java.util.List;

public class SolarSystem {
	
	private Planets[]planetArray = new Planets[6]; //array of 6 planets
	
	//constructor that creates our solar system:
	SolarSystem() {
		
		planetArray[0]= Planets.EARTH; //its at THIS line that all our planet enum types are created. Constructors are ONLT called at this line.
		planetArray[1]= Planets.MARS;
		planetArray[2] = Planets.VENUS;
		planetArray[3] = Planets.MERCURY;
		planetArray[4] = Planets.JUPITER;
		planetArray[5] = Planets.SATURN;
	}
	
	//solarSystem has it's own toString method:
	@Override
	public String toString() {
		List<Planets>listPlanets=Arrays.asList(planetArray);
		return listPlanets.toString();
	}
	
	
	//this enum type is ONLY avaliable inside this class. You will not be able to create a planet outside of this class. 
	//This enum also implements the Cosmic interface, which has 2 methods: void gravity() & void move().
	private enum Planets implements Cosmic{
		
		EARTH, MARS, VENUS, MERCURY,
		JUPITER(45_000_000, 56789.89, 98_765.99){
			 
			@Override //overriding a second time for Jupiter
			public void gravity() { 
				System.out.println("\nJupiter's own gravity method");
			}
			
			@Override //overriding a second time for Jupiter
			public void move() {
				System.out.println("\nJupiter's own move method");
			}
			
			@Override //overriding a second time for Jupiter
			public String toString() {
				//String str = "largest planet is: " + name() + "population: " + population + "surface area: " + surfaceArea + "size: " + size;
				//return str;
				return "largest planet is: " + name() + ". population: " + population + ". surface area: " + surfaceArea + ". size: " + size;
			}
			
		},
		SATURN(35_000_000, 12343.56, 2_345.67)
		;
		
		//vars:
		int population;
		double surfaceArea;
		double size;
		
		//-----------------------
		//constructors:
		
		private Planets() { //the constructor that will be called when a planet enum is created that takes no args. (EARTH, MAR,VENUS & MERCURY)
			
			
			//This will assign a population a surface area and size based on the ordinal of the enum:
			population+=(ordinal()+1)*4;
			surfaceArea+=(ordinal()+1)*7;
			size+=(ordinal()+1)*2;
			
			//call the toString, gravity & move methods for this planet:
			System.out.println(this); //call toString method
			gravity();
			move();
		}
		
		private Planets(int population, double surfaceArea, double size) { //called when creating: JUPITER
			this.population = population;
			this.surfaceArea = surfaceArea;
			this.size = size;
			
			gravity();
			move();
		}
		
		//----------------------
		//EARTH, MARS, VENUS & SATURN will call these versions of these methods: 
		@Override
		public void gravity() {
			System.out.println(name() + "\ngeneral gravity method for planets");
			
		}

		@Override
		public void move() {
			System.out.println(name() + "\ngeneral move method for planets");
			
		}
		
		@Override
		public String toString() {
			String str = "name of planet: " + name() + ". population: " + population + ". surface area: " + surfaceArea + ". size: " + size;
			return str;
		}
		
	}

}

interface Cosmic{
	void gravity();
	void move();
}
