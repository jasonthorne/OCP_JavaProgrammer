package com.android;

import java.util.Arrays;
import java.util.List;

public class SolarSystem {
	/*
	 * creates an array of 6 planets
	 */
	private Planets[]planetArray=new Planets[6];
	//constructor that creates our SolarSystem
	SolarSystem() {
		/*
		 * its at this line that all our planet enum types are create
		 * the constructors are only called at this line
		 */
		planetArray[0]=Planets.EARTH;//uses toString from enum body
		planetArray[1]=Planets.MARS;//uses toString from enum body
		planetArray[2]=Planets.VENUS;//uses toString from enum body
		planetArray[3]=Planets.MERCURY;//uses toString from enum body
		planetArray[4]=Planets.JUPITER;//uses it's OWN toString
		planetArray[5]=Planets.SATURN;//uses toString from enum body
	}
	/*
	 * SolarSystem also has it's own toSTring method
	 */
	@Override
	public String toString() {
		List<Planets>listPlanets=Arrays.asList(planetArray);
		return listPlanets.toString();
	}
	/*
	 * this enum type is ONLY available inside this class, you will not
	 * be able to created a Planet outside of this class, this enum
	 * also implements the Cosmic interface, which has two method
	 * void gravity()
	 * and void move()
	 */
	private enum Planets implements Cosmic{
		//these all use the no arguement constructor
		EARTH,MARS,VENUS,MERCURY,
		JUPITER(45_000_000,56789.89,98_765.99){
			/*
			 * these were methods in the Cosmic interface, which we 
			 * did override in the main enum body. however we choose
			 * to override them again here, so that means juipter will 
			 * have its own gravity and move() method
			 */
			@Override
			public void gravity() {
				System.out.println("Jupiters own gravity method");
			}
			
			@Override
			public void move() {
				System.out.println("Jupiters own move method");
			}
			/*
			 * here we choose also to override the toString() method,
			 * so jupiter is the only planet that has it's own
			 * unique toString method
			 */
			@Override
			public String toString() {
				String str="largest planet is "+name()+" population is "+
			population+" surfaceArea is "+surfaceArea+"size is "+size;
				return str;
			}
		},
		SATURN(35_000_000,12343.56,2_345.67);
		int population;
		double surfaceArea;
		double size;
		/*
		 * this is the constructor that will be called when a planet enum
		 * is created that takes not arguments, which will be 
		 * EARTH,MARS,VENUS and MERCURY
		 */
		private Planets() {
			/*
			 * this will assign a population, a surfaceARea and a size
			 * based on the ordinal of the enum
			 */
			population=(ordinal()+1)*4;
			surfaceArea+=(ordinal()+1)*7;
			size+=(ordinal()+1)*2;
			/*
			 * this calls the toString() method for this planet
			 * for all planets, except Juipiter, this will call the 
			 * toString() method in the main enum body
			 */
			System.out.println(this);
			/*
			 * calls the gravity and move() method for this planet
			 */
			gravity();
			move();
			
		}
		/*
		 * this is a constructor that takes a int, a double and a double
		 * and will be called when creating JUPITER and SATURN
		 */
		private Planets(int population,double surfaceArea,double size) {
			this.population=population;
			this.surfaceArea=surfaceArea;
			this.size=size;
			
			System.out.println(this);
			gravity();
			move();
		}
		/*
		 * EARTH, MARS,VENUS,MERCURY and SATURN will call these versions of
		 * this these methods
		 */
		@Override
		public void gravity() {
			System.out.println(name()+"general gravity method for planets");
			
		}
		@Override
		public void move() {
			System.out.println(name()+" general move method for planets");
			
		}
		
		@Override
		public String toString() {
			String str="name of planet "+name()+" population "+population+
					" surfaceArea "+surfaceArea+" size"+size;
			return str;
		}
		
	}

}

interface Cosmic{
	void gravity();
	void move();
}
