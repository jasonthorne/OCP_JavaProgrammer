package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Examples {
	/**
	 * compareTo() using compareTo() string to explain how compareTo() works. String class implements the Comparable
	 * interface
	 *  returns 0 if both the same string
	 * returns a negative number if the string calling the method comes BEFORE the string sent to the method
	 * returns a positive number if the string calling the method comes AFTER the string sent to the method
	 * compareTo is a method of the Comparable interface, 
	 * Objects, whose class implements Comparable, can be used by any collection class to arrange the order of
	 * objects in any collection (List,Set,etc). These are also the only objects that can be inserted in a 
	 *  TreeSet and the only objects that can be a key in a TreeMap
	 * and also a
	 * @param args
	 */
	static void ex1() {
		System.out.println("Strings");
		System.out.println("adam".compareTo("betty"));//returns negative number
		System.out.println("betty".compareTo("adam"));//returns positive number
		System.out.println("betty".compareTo("betty"));//returns 0
		//will give a null pointer exception
		//System.out.println("adam".compareTo(null));
		System.out.println("Integers");
		Integer one=1;
		Integer two=2;
		System.out.println(one.compareTo(two));//returns -1
		System.out.println(two.compareTo(one));//returns 1
		/*
		 * Rat class implements the Comparable interface which means we can use them in a TreeSet or as a key in 
		 * a TreeMap. if same rat, will not be inserted
		 * if have same name,age and weight, will not be inserted
		 * sort first by name
		 * then age
		 * then weight
		 */
		TreeSet<Rat>ratTree=new TreeSet<Rat>();
		Rat rat1=new Rat("rory",3,12.4);//will be inserted
		Rat rat2=new Rat("rory",3,12.4);//will not be inserted
		
		ratTree.addAll(Arrays.asList(rat1,rat2));
		System.out.println(ratTree.size());
	//	Rat rat3=new Rat("bernie",3,12.4);
	//	Rat rat4=new Rat("adam",3,12.4);
	//	Rat rat3=new Rat("rory",4,12.4);
	//	Rat rat4=new Rat("rory",2,12.4);
		Rat rat3=new Rat("rory",3,14.5);
		Rat rat4=new Rat("rory",3,11.2);
		ratTree.addAll(Arrays.asList(rat3,rat4));
		System.out.println(ratTree);
		
	}
	
	static void ex2() {
		/*
		 * as well as using Comparable interface we could also use Comparator which is a functional interface that 
		 * looks like the following
		 *  Comparator<T>{
		 * 	public int compare(T t, T t2);
		 * }
		 * Comparable has a method compareTo()
		 * Comparator has a method compare()
		 * this is an inner class that implements the comparator interface and takes two strings and compares them
		 * by weight. it is common to srot
		 */
		Comparator<String>byString=new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareToIgnoreCase(arg1);
			//	return 0;
			}	
		};
		
		//create an array of Strings
		System.out.println("List of Strings");
		List<String>names=new ArrayList<>();
		names.addAll(Arrays.asList("bernie","ann","adam","Aidan","bernie","Ciara","Sioblhan","mick","shelly","laura"));
		System.out.println(names);
		/*
		 * the sort method will use the compareTo() method of the String class which orders by Captial letters first,
		 * then alphabetically
		 */
		Collections.sort(names);
		System.out.println("capitals first");
		System.out.println(names);
		/*
		 * /
		 * we can also call a sort method taht takes a list and a Comparator
		 */
		System.out.println("using byString Comparator");
		Collections.sort(names,byString);
		System.out.println(names);
		
		/*
		 * this is an inner class that implements the Comparator interface and takes two ducks and compares them by
		 * weight (we use the Integer class compareTo() method to determine which is bigger/smaller or same)
		 */
		Comparator<Duck>byDuckWeight=new Comparator<Duck>() {

			@Override
			public int compare(Duck d1, Duck d2) {
				Integer duck1W=d1.getWeight();
				Integer duck2w=d2.getWeight();
				return duck1W.compareTo(duck2w);
			}
			
		};
		
		Duck daffy=new Duck("daffy",2,10);
		Duck donald=new Duck("donald",1,5);
		Duck andy=new Duck("andy",5,20);
		Duck betty=new Duck("betty",7,15);
		
		List<Duck>ducks=new ArrayList<>();
		ducks.addAll(Arrays.asList(daffy,donald,andy,betty));
		System.out.println("ducks list");
		System.out.println(ducks);
		System.out.println("ducks sorted by name");
		/*
		 * this will use the compareTo() method in teh Duck class which sorts Duck by name
		 */
		Collections.sort(ducks);
		System.out.println(ducks);
		System.out.println("ducks sorted by weight");
		/*
		 * uses the innner class implementation of the comparator interface
		 */
		Collections.sort(ducks, byDuckWeight);
		System.out.println(ducks);

	/*
	 * this uses the compareTo() method of the Rat class, which returns true if same rat or all same name, age and
	 * weight	
	 */
		Comparator<Rat>byRat=new Comparator<Rat>() {

			@Override
			public int compare(Rat r1, Rat r2) {
				return r1.compareTo(r2);
			}		
		};
		
		Rat rat1=new Rat("roger",2,4.5);
		Rat rat2=new Rat("rachel",1,5.6);
		Rat rat3=new Rat("ray",3,7.8);
		Rat rat4=new Rat("ray",6,8.6);
		List<Rat>ratList=new ArrayList<Rat>();
		ratList.addAll(Arrays.asList(rat1,rat2,rat3,rat4));
		System.out.println("list of rats");
		System.out.println(ratList);
		System.out.println("list of rats with CompareTo()");
		Collections.sort(ratList);
		System.out.println(ratList);
		System.out.println("list of Rats with comparator");
		Collections.sort(ratList,byRat);
		System.out.println(ratList);
		
		/*
		 * we could also use a lambda to implement the interface, this is using the compareTo() method of the 
		 * Rat class
		 */
		ratList.clear();
		ratList.addAll(Arrays.asList(rat1,rat2,rat3,rat4));
		//this will order them in DESCENDING ORDER
		//***********mention about using ***************
		Comparator<Duck>byWeightDesc=(d1,d2)->d2.getWeight()-d1.getWeight();
		/*
		 * to get descending order have the second rat call the compareTo() method on teh first Rat
		 */
		Comparator<Rat>byRatLambda=(r1,r2)->r2.compareTo(r1);
		Collections.sort(ratList,byRatLambda);
		System.out.println("ratList with comparator lambda in descending order");
		System.out.println(ratList);
		
	}
	
	static void ex3() {
		/*
		 * Squirrel class does not implement compareTo() method, so we  have to use comparator if we want to 
		 * arrange elements in a list of squirrels in a certain way
		 */
		Comparator<Squirrel>sqrComparator=new Comparator<Squirrel>() {

			@Override
			public int compare(Squirrel s1, Squirrel s2) {
				/*
				 * here we use the same structure as the Rat class compareTo() method
				 * we wish to use the wrapper compareTo() methods for Integer and Double, so we create a two new
				 * Integer wrapper objects to represent the ages of both squirrels and two Double Wrapper objects
				 * to represent the weights of both squirrels
				 * if not the same rat or have all same values, we will sort by name, then age, then weight
				 */
				Integer age1=s1.getAge();
				Integer age2=s2.getAge();
				Double weight1=s1.getWeight();
				Double weight2=s2.getWeight();
				//if same or all same values returns 0, which means the same
				if(s1.equals(s2))
					return 0;
				//calls teh string equals method, if not the same string
				if(!(s1.getName().equals(s2.getName())))
					//compares the two names
					return s1.getName().compareTo(s2.getName());
				//calls the Integer wrapper equals method, if not teh same number
				if(!(age1.equals(age2)))
					//comparest the two Integers, using the compareTo() method of the Integer wrapper class
					return age1.compareTo(age2);
				//if none of hte above it true, then the weight has to be different
				//compares the two different Doubles, using the compareTo() method of the Double wrapper class
				return weight1.compareTo(weight2);
			}
			
		};
		
		Squirrel s1=new Squirrel("andy",3,12.5);
		Squirrel s2=new Squirrel("andy",2,14.5);
		Squirrel s3=new Squirrel("betty",4,13.5);
		Squirrel s4=new Squirrel("betty",4,12.5);
		
		List<Squirrel>sqrList=new ArrayList<>();
		sqrList.add(s1);
		sqrList.add(s2);
		sqrList.add(s3);
		sqrList.add(s4);
		
		System.out.println(sqrList);
		
		Collections.sort(sqrList, sqrComparator);
		//sorts by name and then by weight
		System.out.println(sqrList);
		/*
		 * can also use a lambda as comparator is a function interface (only one abstract method
		 * public int compare(T t, T t2);
		 * this comparator interface also has dfault and static methods that can be used for comparing
		 */
		sqrComparator=(sq1,sq2)->{//sq1 and sq1 are our two squirrels
			//this is a static methd that compares the two string objects name in both squirrels
			Comparator<Squirrel>cs=Comparator.comparing(s->s.getName());
			//if the above says both names are the same then do the following
			cs=cs.thenComparing(s->s.getAge());
			//if the above says both ages are teh same then do the following
			cs=cs.thenComparing(s->s.getWeight());
			//will then compare both squirrels with all of the above
			return cs.compare(sq1, sq2);
		};
		
		Comparator<Squirrel>sqrCompByWeight=(sq1,sq2)->{
			Comparator<Squirrel>cs=Comparator.comparingDouble(s->s.getWeight());//compares weight first
			cs=cs.thenComparing(s->s.getAge());
			cs=cs.thenComparing(s->s.getName());
			return cs.compare(sq1, sq2);
		};
		
		sqrList=new ArrayList<>();
		sqrList.add(s1);
		sqrList.add(s2);
		sqrList.add(s3);
		sqrList.add(s4);
		System.out.println("sorted by lambda1, name, age, weight");
		Collections.sort(sqrList,sqrComparator);
		System.out.println(sqrList);
		System.out.println("sorted by lambda2, weight,age,weight");
		Collections.sort(sqrList,sqrCompByWeight);
		System.out.println(sqrList);
	}
	
		
		

}
