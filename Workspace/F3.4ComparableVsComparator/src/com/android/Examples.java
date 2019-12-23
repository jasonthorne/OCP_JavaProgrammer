package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Examples {
	/*
	 * the comparable interface has one method
	 * compareTo(), here we will be implementing the comparable interface and overriding the 
	 * compareTo() method (comparable interface looks like 
	 * interface Comparable<T>{
	 * 		int compareTo(T arg)
	 * comparable is a functional interface, so we can create lambdas from this interface, 
	 * Comparator is a seperate interface and has a COMPARE() METHOD
	 * to explain how compareTo works we will give the example of the String class. String class
	 * implements the Comparable
	 * say we are calling teh follwing
	 * str1.compareTo(str2)
	 * compareTo returns 0 if both the same String
	 * "apple".compareTo("apple");
	 * returns a NEGATIVE number if the string calling the method comes BEFORE the string sent to the 
	 * method
	 * "apple".compareTo("berry")
	 * returns a POSITIVE number if the string calling the method comes AFTER the string sent to the 
	 * method
	 * "berry".compareTo("apple");
		Objects, whose class implements comparable, can be used by ALL collection class objects and Maps to 
		arrange the order of objects in any collection.
		These objects are also the only objects taht can be inserted into a TreeSet and the only objects
		that can be a key in TreeMap
	 */
	
	static void ex1() {
		System.out.println("strings ");
		System.out.println("adam".compareTo("zee"));//returns a minus
		System.out.println("betty".compareTo("adam"));//returns a positive 
		System.out.println("betty".compareTo("betty"));//returns 0
		//returns positive as capital "Z" comes before lower case "a"
		System.out.println("adam".compareTo("Zee"));
		/*
		 * can't use null with compareTo, as null as no value and you can't compare nothing with
		 * something.
		 * if you can't use null with compareTo, that means you can't add null to TreeSet or as a Key
		 * in a TreeMap
		 */
		Set<Integer>mySet=new TreeSet<>();
		/*
		 * this will generate a NullPointerException
		 */
	//	mySet.add(null);
		Integer one=1;
		Integer two=2;
		Integer twentytwo=22;
		Integer minusFive=-5;
		System.out.println("comparing Integers");
		System.out.println(one.compareTo(two));//-1
		System.out.println(twentytwo.compareTo(one));//1
		System.out.println(twentytwo.compareTo(minusFive));//1
		System.out.println(one.compareTo(one));//0
	}
	
	static void ex2() {
		System.out.println("rat class implements Comparable");
		
		Rat rat=new Rat("rory",3,12.4);
		Rat rat2=new Rat("rory",3,11.4);
		Rat rat3=new Rat("rory",2,12.4);
		Rat rat4=new Rat("angela",3,13.4);
		Rat rat5=new Rat("angela",3,13.4);
		Set<Rat>ratTree=new TreeSet<>();
		ratTree.addAll(Arrays.asList(rat,rat2,rat3,rat4,rat5));
		System.out.println(ratTree);
		
		Ostrich os1=new Ostrich("ollie",2,45.6);
		Ostrich os2=new Ostrich("ollie",2,45.6);
		Ostrich os3=new Ostrich("andy",3,54);
		Ostrich os4=new Ostrich("bill",3,67);
		Ostrich os5=new Ostrich("dermot",5,89);
		Ostrich os6=new Ostrich("dermot",3,99);
		Ostrich os7=new Ostrich("eddie",6,78);
		Ostrich os8=new Ostrich("eddie",6,74);
		Set<Ostrich>ostrichTree=new TreeSet<>();
		ostrichTree.addAll(Arrays.asList(os1,os2,os3,os4,os5,os6,os7,os8));
		System.out.println(ostrichTree);
	}
	
	static void ex3() {
		System.out.println("Comparators");
		/*
		 * TreeSet is a ordered list that does not allow duplicates
		 * its ordered by only allowing objects that implement the Comparable interface
		 * TreeMap the keys are a ordered list that does not allow duplicates
		 * the keys are ordered by only allowing objects that implement the Comparable interface
		 */
		List<Integer>listNum=new ArrayList<>();
		listNum.addAll(Arrays.asList(23,23,23,4,1,67,2,67,3,3,1002,-56,0));
		Set<Integer>mySet=new TreeSet<>();
		//Collections.sort(listNum);
		mySet.addAll(listNum);
		System.out.println(mySet);
		/*
		 * As well as using the comparable interface we could also use a seperate object of type 
		 * comparator to organise a list, (seperate method for using a comparator with a 
		 * set and hashMap and not used with queues)(not a treeSEt or treeMap). by using this
		 * a list of object does not need to implement the comparable interface
		 * interface Comparator<T>{
		 * 		public compare(T t,T t2)
		 * }
		 * Comparable has a compareTo() method
		 * Comparator has a  COMPARE() method
		 */
		//classes usually do NOT implement Comparator
		/*
		 * more often than not, you use this by creating a anonymous inner class or a lambda, as this
		 * is a functional interface (only one abstract method)
		 */
		System.out.println("anonymous inner class implementation of Comparator");
		/*
		 * this is going to be used to organis a list of names, organised alphabetically and ignoring the
		 * case
		 */
		Comparator<String>byString=new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}	
		};//end of anonymous class
		
		System.out.println("list of Strings");
		List<String>names=new ArrayList<>();
		names.addAll(Arrays.asList("bernie","ann","Ann","adam","Aidan","bernie","Ciara","Siobhan","mick",
				"shelly","LaURA","COLM"));
		System.out.println(names);
		/*
		 * only objects that implement comparable can use this particular method, String class does
		 * implement Comparable, and the compareTo() compares symbols first, numbers next, then
		 * upper case, then lower case
		 * this will organise names
		 */
		Collections.sort(names);
		//names is now sorted according to the rules of the compareTo method of the String class
		System.out.println(names);
		//clearing all strings
		names.clear();
		//adding original strings
		names.addAll(Arrays.asList("bernie","ann","Ann","adam","Aidan","bernie","Ciara","Siobhan","mick",
				"shelly","LaURA","COLM"));
		System.out.println(names);
		/*
		 * this uses the byString comparator, which just organises strings by alphabetical and ignores
		 * case
		 */
		Collections.sort(names, byString);
		System.out.println("ordered by alphabetical only");
		System.out.println(names);
		
		Squirrel sammy=new Squirrel("sammy",2,3);
		Squirrel sharon=new Squirrel("sharon",4,2);
		Squirrel samantha=new Squirrel("samantha",1,5);
		Squirrel sean=new Squirrel("sean",7,1);
	//	Squirrel sean2=new Squirrel("sean",5,2);//insert into squirrels list to see duplicates not removed
		
		List<Squirrel>squirrels=new ArrayList<>();
		squirrels.addAll(Arrays.asList(sammy,sharon,samantha,sean));
		System.out.println("squirrel list unordered");
		System.out.println(squirrels);
		System.out.println("Squirrels sorted by name uses compareTo in squirrel class");
		/*
		 * Collections.sort can only takes list of objects whose classes implement comparable
		 * Squirrel implments Comparable and the compareTo organises squirrels in a list by 
		 * names in alphabetical order
		 * N.B sorting does NOT remove duplicates names, see sean2
		 */
		Collections.sort(squirrels);
		System.out.println(squirrels);
		/*
		 * this sorts a list by weight of Squirrel
		 */
		Comparator<Squirrel>bySquirrelWeight=new Comparator<Squirrel>() {
			/*
			 * if this returns a minus number
			 * squirrel 1 comes before squirrel 2
			 * if returns a plus number
			 * squirrel 2 comes before squirrel 1
			 * if 0 they are the same and can be put in any order, but they will be together in the list
			 */
			@Override
			public int compare(Squirrel s1, Squirrel s2) {
				Integer s1Weight=s1.getWeight();
				Integer s2Weight=s2.getWeight();
				return s1Weight.compareTo(s2Weight);

			}	
		};//end of anonymous class
		
		squirrels.clear();//empties the list
		squirrels.addAll(Arrays.asList(sammy,sharon,samantha,sean));
		System.out.println("unsorted squirrels");
		System.out.println(squirrels);
		Collections.sort(squirrels, bySquirrelWeight);
		System.out.println("sorted by squirrel weight");
		System.out.println(squirrels);
		
		
		Comparator<Squirrel>bySquirrelHeight=new Comparator<Squirrel>() {
			/*
			 * if this returns a minus number
			 * squirrel 1 comes before squirrel 2
			 * if returns a plus number
			 * squirrel 2 comes before squirrel 1
			 * if 0 they are the same and can be put in any order, but they will be together in the list
			 */
			@Override
			public int compare(Squirrel s1, Squirrel s2) {
				Integer s1Height=s1.getHeight();
				Integer s2Height=s2.getHeight();
				return s1Height.compareTo(s2Height);

			}	
		};//end of anonymous class
		
		squirrels.clear();
		squirrels.addAll(Arrays.asList(sammy,sharon,samantha,sean));
		Collections.sort(squirrels, bySquirrelHeight);
		System.out.println("squirrels sorted by height");
		System.out.println(squirrels);
		/*
		Comparator<Squirrel>sqrComparator=new Comparator<Squirrel>() {

			@Override
			public int compare(Squirrel s1, Squirrel s2) {
				if(s1.equals(s2))
					return 0;
				if(!(s1.getName().equals(s2.getName())))
					s1.compareTo(s2);
				Integer weight1=s1.getWeight();
				Integer weight2=s2.getWeight();
				if(!(weight1.equals(weight2)))
					
				Integher
			}
			
		};*/
		
		Comparator<Rat>byRat=new Comparator<Rat>() {
			@Override
			public int compare(Rat r1, Rat r2) {
				/*
				 * you can add additional criteria in here
				 */
			//	if(!(r1.equals(r2))
					return r1.compareTo(r2);		
			}
		};
		
		Rat rat1=new Rat("roger",2,4.5);
		Rat rat2=new Rat("rachel",1,5.6);
		Rat rat3=new Rat("ray",3,7.8);
		Rat rat4=new Rat("ray",6,8.6);
		
		List<Rat>ratList=new ArrayList<Rat>();
		ratList.addAll(Arrays.asList(rat1,rat2,rat3,rat4));
		System.out.println("list of Rats");
		System.out.println(ratList);
		Collections.sort(ratList);
		System.out.println("sorted by compareTo");
		System.out.println(ratList);
		ratList.clear();
		ratList.addAll(Arrays.asList(rat1,rat2,rat3,rat4));
		System.out.println("sorted by compare");
		Collections.sort(ratList, byRat);
		System.out.println(ratList);
		/*
		 * Comparator is a function interface, so we usually use a lambda when creating a 
		 * compartor
		 */
		/*
		 * this will sort our list of Squirrels by weight 
		 */
		Comparator<Squirrel>byWeight=(s1,s2)->s1.getWeight()-s2.getWeight();
		
		
		
	}
	
	static void ex4() {
		
		
		/*
		 * we will have a list of Ducks, that we will sort by name
		 * then by weight
		 * then by height
		 * then by id
		 * Duck class will NOT implement comparable
		 */
		Comparator<Duck>byDuckWeight=new Comparator<Duck>(){

			@Override
			public int compare(Duck d1, Duck d2) {
				Integer duck1W=d1.getWeight();
				Integer duck2W=d2.getWeight();
				return duck1W.compareTo(duck2W);
	//			return 0;
			}
			
		};//end of anonymous inner class
		
		Duck duck1=new Duck("daffy",2,10);
		Duck duck2=new Duck("donald",1,11);
		Duck duck3=new Duck("daisy",345,12);
		Duck duck4=new Duck("andy",7,14);
		Duck duck5=new Duck("donna",4,15);
		
		List<Duck>ducks=new ArrayList<>();
		ducks.addAll(Arrays.asList(duck1,duck2,duck3,duck4,duck5));
		System.out.println(ducks);
		/*
		 * this will not compile, as Duck does NOT implement comparable, so this 
		 * Collections.Sort method only works for objects that implement comparable
		 */
	//	Collections.sort(ducks);
		/*
		 * this will organise our list of Ducks by weight ascending order
		 */
		Collections.sort(ducks,byDuckWeight);
		System.out.println(ducks);
		/*
		 * this is a comparator that will compare by the names of the Duck in alphabetical order 
		 * ascending, also taking case into account
		 */
		Comparator<Duck>byDuckName=new Comparator<Duck>() {

			@Override
			public int compare(Duck d1, Duck d2) {
				return d1.getName().compareTo(d2.getName());
			}
			
		};
		
		ducks.clear();
		ducks.addAll(Arrays.asList(duck1,duck2,duck3,duck4,duck5));
		Collections.sort(ducks,byDuckName);
		System.out.println("ducks sorted by name");
		System.out.println(ducks);
		
		Comparator<Duck>comparatorDuck=new Comparator<Duck>() {

			@Override
			public int compare(Duck d1, Duck d2) {
				Integer weight1=d1.getWeight();
				Integer weight2=d2.getWeight();
				Integer height1=d1.getHeight();
				Integer height2=d2.getHeight();
				Integer id1=d1.getId();
				Integer id2=d2.getId();
				//if same duck, return 
				if(d1.equals(d2))
					return 0;
				if(!(d1.getName().equals(d2.getName())))
					return d1.getName().compareTo(d2.getName());
				if(!(weight1.equals(weight2)))
					return weight1.compareTo(weight2);
				if(!(height1.equals(height2)))
					return height1.compareTo(height2);
				return id1.compareTo(id2);
			}
			
		};//end of anonymous class 
		
		
	}

}
