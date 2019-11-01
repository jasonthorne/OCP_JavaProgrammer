package com.android;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.SynchronousQueue;
import java.util.function.Predicate;


public class Examples {
	/*
		 * you can create your own Collection class
		 * see cat class to see implementation of the Collection interface
		 * see Hippo class to see implementation of the List interface
		 * see Ostrich class to see the implemenation of the Set interface
		 * see Falcon class to see the implementation of the Queue interface
		 * see Rhino class to see the implementation of the Map interface
		 */
	static void ex1() {
		System.out.println("***ex1");
		/*
		 * Cat class did not specify a generic in the class declaration
		 * public class Cat implements Collection
		 */
		Cat tibbles=new Cat();
		/*
		 * you can't create a Cat with a Generic type as generic type was not included in class declaration
		 */
		//Cat<Integer>tom=new Cat();
		/*]
		 *Hippo did specify a generic in the class declaration,
		 *public class Hippo<T> implements List<T>, so we can use a generic when creating a Hippo
		 */
		Hippo<String> harry=new Hippo();
		harry.add("only a string can be added");
		//but we do not HAVE to specify a generic, so type T here will be a Object
		Hippo helen=new Hippo();
		helen.add("can add any object including strings");
		System.out.println("some methods of the Collection interface");
		/*
		 * all methods of the collection interface are available to all List's, Set's and Queue's
		 */
		List<String>strList=new ArrayList<>();
		System.out.println("add()");
		/*
		 * this adds to our list
		 */
		strList.add("one");
		/*
		 * List allows duplicates
		 */
		strList.add("apple");
		strList.add("apple");
		strList.add("orange");
		/*
		 * can add at a particular index position in the list (uses array indexing so numbering starts at 0
		 */
		strList.add(1,"pineapple");
		//add returns true if inserted, false if not inserted
		System.out.println(strList.add("magpie"));//will return true
		//try to add anything other that a string to this list and it WILL NOT compile
	//	System.out.println(strList.add(4));
		System.out.println("strList is "+strList);
		/*
		 * a HashSet does NOT allow duplicates
		 * HashSet implements the Collection interface
		 */
		Set<String>set=new HashSet<>();
		System.out.println(set.add("sparrow"));//will return true
		System.out.println(set.add("sparrow"));//will return false as duplicates not allowed
		System.out.println(set.add("crow"));//will return true
		System.out.println(set.add("SPARROW"));//will return true as different case to "sparrow"
		//can print out just like an arrayList
		System.out.println(set);
		
		System.out.println("****remove()");
		//remove() removes the first instance of "apple"
		strList.remove("apple");
		System.out.println(strList);
		//remove string at index position 1
		strList.remove(1);
		System.out.println(strList);
		//return true if removed, false if not removed
		System.out.println(strList.remove("pineapple"));//pineapple no longer in the list so will return false
		//same way to remove from a hashSet
		set.remove("crow");
		System.out.println(set);
		//if we try to remove from a position that does not exist we get IndexOutOfBoundsException
		//strList.remove(12);
		
		System.out.println("****isEmpty() and size()");
		System.out.println(strList.size());
		//if list is empty return true, false if not
		System.out.println(strList.isEmpty());//return false
		List noList=new ArrayList<>();
		System.out.println(noList.isEmpty());//return true
		System.out.println(noList.size());//return 0
		
		System.out.println("***clear");
		/*
		 * deletes all elements in a collectoin
		 */
		List<Integer>numList=new ArrayList<>();
		numList.addAll(Arrays.asList(23,45,66,888,999,1000,4567));
		System.out.println(numList);
		numList.clear();
		System.out.println(numList);
		
		System.out.println("****Contains");
		/*
		 * returns true if the collection contains a object
		 * false if it does not contain the object
		 * uses the equals method of that class to identify a object
		 */
	/*	List<Dog>dogList=new ArrayList<>();
		Dog spot=new Dog();
		Dog rex=new Dog();
		Dog lassie=new Dog();
		Dog benji=new Dog();
		dogList.addAll(Arrays.asList(spot,rex,lassie));
		System.out.println(dogList);*/
		//uses equals method of the Dog class to identify a object
	//	System.out.println(dogList.contains(spot));//will return true
	//	System.out.println(dogList.contains(benji));//will return true
		
		List<String>fruits=new ArrayList<>();
		fruits.addAll(Arrays.asList("Apple","Oranges","Bananas"));
		System.out.println(fruits.contains("Apple"));//true
		System.out.println(fruits.contains("Mango"));//false	
	}
	
	static void ex2() {
		System.out.println("***ex2");
		System.out.println("ARRAYLISTS");
		/*
		 * List Implementations
		 * List interface and Set interface extend the Collection interface and ArrayList implements the List interface
		 * so we can have a Collection reference to a class that implements this interface
		 * Arraylist implements list, and List extends Collection, so Arraylist also implements List interface
		 */
		Collection<Integer>collectList=new ArrayList<>();
		/*
		 * List extends Collection so we can have a interface reference to a object that implements that interface
		 */
		List<Integer>numList=new ArrayList<Integer>();
		/*
		 * you can omit the <Integer> on the right hand side
		 */
		List<Integer>numList2=new ArrayList<>();
		//you can only add Integers to these lists
		numList2.add(4);//four autoboxed to become the INTEGER 4
		numList2.add(Integer.getInteger("345"));
		numList2.add(new Integer(6789));
		//can't add any other number to this bar a Integer
		byte myByte=(byte)12;
		//will not compile
		//numList.add(myByte);
		//we can cast it to become an int, which is then autoboxed to become an Integer
		numList2.add((int)myByte);
		//can't cast it to be a Integer wrapper objectg
		//numList.add((Integer)myByte);
		System.out.println(numList2);
		/*
		 * you can add dogs or subclasses of Dog to this list
		 */
		List<Dog>dogList=new ArrayList<Dog>();
		dogList.add(new Dog());
		dogList.add(new Collie());
		//can't add a super class referenced object to this list
		Animal anDog=new Dog();
		//will not compile
		//dogList.add(anDog);
		dogList.add((Dog)anDog);
		System.out.println(dogList);
		/*
		 * the reference is what dictates what type of Collection a Object is, in this case this is a List of Object
		 * reference, so you can add any elements to this arrayList
		 */
		List myList=new ArrayList<Integer>();
		/*
		 * this is a list of Object reference so you can add any element of any object type to this arraylist
		 */
		myList.add(4);
		myList.add(new Dog());
		myList.add(new Collie());
		myList.add("hello there ");
		//you can add null to a arraylist of any type
		myList.add(null);
		System.out.println(myList);
		
		Dog spot=new Dog("spot",12);
		Dog rex=new Dog();
		Dog lassie=new Dog("lassie",6);
		List<Dog>kennel=new ArrayList<>();
		//four dogs added to list
		kennel.addAll(Arrays.asList(spot,rex,lassie,new Dog("benji",4)));
		System.out.println("size of kennel is "+kennel.size());
		
		System.out.println("ITERATOR");
		/*
		 * Iterator is a object that is used to go through a collection object
		 */
		System.out.println("we can use a enhanced for loop");
		for(Dog d:kennel)
			System.out.println("name of dog is "+d.name);
		/*
		 * using a ListIterator to go through values in a List, you use the list object you with to go through and call the 
		 * listIterator() method of the list interface to create the ListIterator object
		 * this is the method signature for this method, T in our case is object type Dog
		 * public ListIterator<T> listIterator(int index) {//see Cat class for methods of the List interface
		 */
		ListIterator<Dog>dogIterator=kennel.listIterator();
		/*
		 * iterators are what you use when you are getting records from a database, 
		 */
		System.out.println("hasNext");
		/*
		 * this returns a boolean value which indicates if there is another record in the kennel list, so this will keep
		 * looping while there is another record in the list
		 */
		while(dogIterator.hasNext()) {
			/*
			 * if the list of dogs has another Dog, then print out the next dog. this will use the toSTring method of the 
			 * Dog class to print out the details of the Dog. The next() method will change our position to the next 
			 * Dog in our list
			 */
			
			System.out.println("next dog is "+dogIterator.next());//after this we will be on our next Dog
			//this is now the next dog, and the index of the next dog is 1
			System.out.println("next index is "+dogIterator.nextIndex());
			
			/*
			 * this will go onto the next dog in our list
			 */
		//	System.out.println("dog after that is "+dogIterator.next());
			/*
			 * this does not move us on to the next dog, it merely checks have we anohter dog in our list
			 * true if we have, false if not
			 */
			System.out.println(dogIterator.hasNext());
		}
		System.out.println("reset iterator back to 0");
		System.out.println("********"+dogIterator.nextIndex());
		while(dogIterator.nextIndex()>0) {
			dogIterator.previous();
		}
		/*
		 * or we could just redefine the iterator again which would have the same affect of resetting the iterator
		 */
	//	dogIterator=kennel.listIterator();
		System.out.println(dogIterator.nextIndex());
		while(dogIterator.hasNext()) {
			/*
			 * will print out name of dog then go to next dog
			 */
			System.out.println("name of Dogf is "+dogIterator.next().name);
		}
		/*
		 * we are now at the end of of iterator so there is no next
		 */
		System.out.println(dogIterator.hasNext());
		/*
		 * but if there was a next index it would be 4
		 */
		System.out.println(dogIterator.nextIndex());
		/*
		 * as well as using NEXT we can also use PREVIOUS
		 * we are currently after the last dog in our list of Dogs it will enter the list and start at the last dog
		 * and work its way back to the first dog
		 */
		while(dogIterator.hasPrevious()) {
			System.out.println("hasPrevious dog is "+dogIterator.previous());
			//this will name of the Dog before the above Dog
			System.out.println("hasPrevious name is "+dogIterator.previous().name);
		}
		System.out.println(dogIterator.nextIndex());//will be 0
		System.out.println(dogIterator.previousIndex());//will be -1
		
		
		dogIterator=kennel.listIterator();
		
		while(dogIterator.hasNext()) {
			/*
			 * we create a Dog and we assign each Dog in the list to this reference, with this we can access all the
			 * atributes of each Dog
			 * returns current Dog and moves loop to next Dog
			 */
			Dog tempDog=dogIterator.next();
			System.out.println("age is "+tempDog.age);
			System.out.println("name is "+tempDog.name);
		}
		
		
	}
	
	static void ex3() {
		System.out.println("**ex3");
		System.out.println("****ARRAYDEQUE**");
		/*can be used instead of stacks (first in, last out)
		 * implements Collection, Queue, Deque
		 * Collection Base class
		 * Queue super class
		 * Deque sub class
		 * so you can have 
		 */
		Collection<String>collArraydeque=new ArrayDeque<>();
		Queue<Hippo>queueArraydeque=new ArrayDeque<>();
		Deque<Dog>dequeArraydeque=new ArrayDeque<>();
		//does NOT implement the List interface
		//List<Integer>listDeque=new ArrayDeque<>();
		
		ArrayDeque<String>strArrayDeque=new ArrayDeque<>();
		//duplicates are allowed
		String[]strArray= {"hello","hello","so long"};
		strArrayDeque.addAll(Arrays.asList("hello","apple","apple","orange","banana"));
		strArrayDeque.addAll(Arrays.asList(strArray));
		System.out.println(strArrayDeque);
		/*
		 * YOU CANNOT add null to an arraydeque, unlike an arraylist, you will get a nullpointerexception
		 */
	//	strArrayDeque.add(null);
		for(String s:strArrayDeque) {
			System.out.println(s);
		}
		/*
		 * unlike an arraylist you can't add a element at a particular location in an arrayDeque*/
		//  strArrayDeque.add(1,"tomato");//will not compile no such method
		 /* you can push() which puts element at beginning of list
		 */
		System.out.println("push**");
		strArrayDeque.push("Turnip");
		//you can offer which puts element at end of list
		System.out.println("offer**");
		strArrayDeque.offer("potato");
		System.out.println(strArrayDeque);//you also have a offerFirst()
		//create an arraylist and add it to arrayDeque
		System.out.println("pop**");
		//pop() removes first element from list and returns that element
		System.out.println(strArrayDeque.pop());//no popLast()
		System.out.println(strArrayDeque);
		//testing on a empty ArrayDeque
		ArrayDeque<String>empArrayDeque=new ArrayDeque<>();
		//throws NoSuchElementException RuntimeException
		//System.out.println(empArrayDeque.pop());
		System.out.println("poll**");
		//also removes first element from list and returns that element
		System.out.println(strArrayDeque.poll());
		System.out.println(strArrayDeque);
		//returns null for a empty list
		System.out.println(empArrayDeque.poll());
		System.out.println("pollLast**");
		//display last element in list and removes it
		System.out.println(strArrayDeque.pollLast());
		System.out.println(strArrayDeque);//there is a removeLast()
		System.out.println("remove**");
		//removes first element from list and returns that element
		System.out.println(strArrayDeque.remove());
		System.out.println(strArrayDeque);
		//throws NoSuchElementException RuntimeException
		//empArrayDeque.remove();
		System.out.println("peek**");
		//display first element of the list but will NOT remove it
		System.out.println(strArrayDeque.peek());//there is a peekLast()
		System.out.println(strArrayDeque);
		System.out.println(empArrayDeque.peek());//will print null
		System.out.println("peekLast()");
		//display last element of list but will NOT remove it
		System.out.println(strArrayDeque.peekLast());
		System.out.println(strArrayDeque);
		
		List<Integer>numbers=new ArrayList<>();
		numbers.addAll(Arrays.asList(20,40,50,100,200,300,400));
		ArrayDeque<Integer>dequeNumbers=new ArrayDeque<>();
		//this is a shallow copy of the arrayList of numbers
		dequeNumbers.addAll(numbers);
		numbers.set(0, 1000);
		int sum=0;
		/*
		 * this will add up all the numbers and empty out the arraydeque
		 */
		while(!(dequeNumbers.isEmpty())){
			sum=sum+dequeNumbers.poll();
		}
		System.out.println(sum);
		System.out.println(dequeNumbers);
		
		ArrayDeque<Dog>kennel=new ArrayDeque<>();
		List<Dog>dogList=Arrays.asList(new Dog(),new Dog("spot",3),new Dog("rex",5),new Dog("lassie",10));
		//addAll is a shallow copy of the dogList (the references are NOT copied)
		kennel.addAll(dogList);
		System.out.println(kennel);
		System.out.println(dogList);
		dogList.set(0, new Dog("benji",123));
		System.out.println(kennel);
		System.out.println(dogList);	
		
	}
	
	static void ex4() {
		System.out.println("ex4****");
		System.out.println("*****LINKEDLIST*******");
		/*
		 *  * implements Collection, Queue, Deque and List
		 * Collection Base class
		 * Queue super class
		 * Deque sub class
		 * also implements List
		 */
		 /*
		  * LinkedList implements both the queue/Deque and List interface
		  * allows duplicates and null elements
		  * all methods of List and Deuqe are then available to this class and it adds elements in predictable locations
		  */
		LinkedList<String>strLinked=new LinkedList<>();
		strLinked.add("apple");
		strLinked.offer("orange");//adds to end
		strLinked.push("pineapple");//adds to start
		strLinked.add(1, "mango");//adds at index position 1
		//list is now pineapple,mango,apple,orange
		strLinked.set(2, "banana");//changes pineapple to banana
		//list is now pinepalle,mango,banana,orange
		System.out.println(strLinked);
		//can get any item on the list by using get
		System.out.println(strLinked.get(1));
		//can add null
		strLinked.push(null);
		System.out.println(strLinked);
		//you can remove a particular object (from collection interface)
		strLinked.remove(null);
		//you can remove at a particular location
		strLinked.remove(1);//from List interface
		System.out.println(strLinked);
		//remove first item from list
		System.out.println(strLinked.remove());//from deque interface
		
		
	}
	
	static void ex5() {
		System.out.println("***ex5");
		System.out.println("*****SET INTERFACE******");
		System.out.println("Set interface does NOT allow duplicate elements and elements are returned in no particular "
				+ " order");
		System.out.println("extends the Collection interface");
		System.out.println("the classes we cover that implement this interface are ");
		System.out.println("HashSet");
		System.out.println("LinkedHashSet");
		System.out.println("TreeSet");
		System.out.println("********HASHSET*******");
		/*
		 * implements Collection and Set interface
		 * Collection super interface
		 * Set interface extends Collection
		 */
		//Set<String>strSet=new HashSet<>();
		HashSet<String>strHash=new HashSet<>();
		//only one scarlett will be added, but "noel" and "NOEL"
		System.out.println(strHash.addAll(Arrays.asList("noel","NOEL","scarlett","scarlett")));;
		System.out.println(strHash);
		//add returns true if the items is added to the set
		System.out.println("added to List "+strHash.add("noel"));
		System.out.println("added to list "+strHash.add("mary"));
		strHash.add(null);
		//you can add null, but only one null
		System.out.println(strHash);
		strHash.add(null);
		System.out.println(strHash);
		/*
		 * if you are adding many elements to a HashSet you will not know how many elements will be added to your
		 * set (as duplicates are NOT added), so size() is more important for this class that previous Collection
		 * types
		 */
		System.out.println("there are "+strHash.size()+" strings in this set");
		/*
		 * as this implements the Set Interface, you can have a set reference to a HashSet Object
		 */
		Set<Animal>testAnimal=new HashSet<>();
		//you could have a anonymous class implementation of any of the interfaces (click on + to expand selection)
		Set<Animal>setAnimal=new Set<Animal>() {

			@Override
			public boolean add(Animal e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends Animal> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator<Animal> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}


			
			
		};
		//can't have a list reference to a HashSet object as it does not implement the List interface
		//List<Animal>listAnimal=new HashSet<>();
		/*
		 * hashSet uses equals() hashCode() methods to determine if two objects are the same or equal. HashSet does
		 * not allow us to add two objects that return true from the equals method of that class.
		 * animal does not override the hashCode() or equals() method, so it will use the hashCode() and the equals()
		 * method implementation from the object class
		 */
		HashSet<Animal>animalHash=new HashSet<>();
		/*
		 * these two Animals have the same name and age, but they equals and hashcode method are not overriden
		 * so it will use the equals and hashcode method from the object class. the Equals() method in the
		 * object class returns "true" if they are the same object
		 * HashSet uses a combination of hashCode and equals() to see if they are the same object
		 */
		System.out.println("animal added "+animalHash.add(new Animal(1,"andy")));//added to HashSet
		System.out.println("animal added "+animalHash.add(new Animal(1,"andy")));//added to HashSet
		Animal andy=new Animal();
		Animal angela=andy;
		/*
		 * will only add one of these animals
		 */
		System.out.println("animal added "+animalHash.add(andy));
		System.out.println("animal addded "+animalHash.add(angela));
		
		
		/*
		 * two rats with the same age and the equals method returns true if they are the same age
		 */
		Rat ronnie=new Rat(4,"ronnie");
		Rat rachel=new Rat(4,"rachel");
		/*
		 * we have overriden the equals method but NOT the hashCode method and HashSet uses both equals
		 * and HashCode() to determine if both objects are the same
		 */
		System.out.println("two rats same age "+ronnie.equals(rachel));
		System.out.println("rats added to Animal set"+animalHash.add(ronnie));
		System.out.println("rats added again to Animal set"+animalHash.add(rachel));
		System.out.println(animalHash.add(ronnie));//can't add same object again
		//animalHash.add(rachel);
		//same for a HashSet of Rats
		HashSet<Rat>ratSet=new HashSet<>();
		System.out.println("rats added to Rat set "+ratSet.add(ronnie));
		System.out.println("rats added to Rat set "+ratSet.add(rachel));
		/*
		 * we have overriden the HashCode() method in the Hamster class and the has is produced on the age, so 
		 * two hamsters with the same age will have the same hashCode (the number produced is simply the age * 41)
		 * we have also overriden the equals method, so if two hamsters have the same age we will say that they 
		 * are equal
		 */
		HashSet<Hamster>hamsterHash=new HashSet<>();
		
		Hamster harry=new Hamster(2,"harry");
		Hamster helen=new Hamster(2,"helen");
		System.out.println("two hamsters same age "+harry.equals(helen));
		System.out.println("hamster added to list of Animals"+animalHash.add(harry));//will be added
		System.out.println("hamster added to list of Animals "+animalHash.add(helen));//will NOT be added
		System.out.println(hamsterHash.add(helen));//will be added
		System.out.println(hamsterHash.add(harry));//will NOT be added
		/*
		 * equals and hashcode are both overriden in the Dog class, and the equals() method returns true if both
		 * the age and name of the Dog is the same
		 */
		Dog lassie=new Dog();
		//prince and lassie are same dog, so will only be added once
		Dog prince=lassie;
		/*
		 *only three dogs are added as thje first two dogs have the same name and age, so only the first one is added
		 *lassie and prince are the same Dog, so only one will be added 
		 */
		HashSet<Dog>kennel=new HashSet<>(Arrays.asList(
				/*Added*/new Dog("spot",2),
				/*Not Added*/new Dog("spot",2),
				/*Added*/new Dog("rex",2),
				/*Added*/lassie,
				/*Not added*/prince));
		System.out.println(kennel.size());//only three dogs in this HashSet
		System.out.println(kennel);
		
		/*
		 * Dinosaur has both the equals() and the HashCode() overriden and is based on all of it's variable
		 * if two objects are considered to be equal they should have the same hashCode
		 */
		Dinosaur tRex=new Dinosaur(4,"TRex",607.8,23.2,true);
		Dinosaur tRex2=new Dinosaur(4,"TRex",607.8,23.2,true);
		Dinosaur tRex3=tRex2;
		Dinosaur bronto=new Dinosaur(12,"brontosaurus",1200.4,50.5,false);
		Dinosaur trici=new Dinosaur(12,"Triceratops",400.4,25.5,false);
		HashSet<Dinosaur>dinosaurs=new HashSet<>();
		System.out.println("****adding dinosaurs");
		System.out.println(dinosaurs.add(tRex));//true
		System.out.println(dinosaurs.add(tRex2));//false
		System.out.println(dinosaurs.add(tRex3));//false
		System.out.println(dinosaurs.add(bronto));//true
		System.out.println(dinosaurs.add(trici));//true
		System.out.println(dinosaurs.add(trici));//false
		System.out.println(dinosaurs.add(new Dinosaur()));//true
		System.out.println(dinosaurs.add(new Dinosaur()));//false
		System.out.println(dinosaurs.add(null));//true
		System.out.println(dinosaurs.add(null));//false
		
		System.out.println("we have "+dinosaurs.size()+" dinosaurs");
		System.out.println(dinosaurs);
		
		
		/*
		 * HashCode is overriden but not the equals method, so both of these will still be added, you should override
		 * both so you can be sure what will and will not be added to our HashSet
		 */
		Employee emp1=new Employee(45,"eddie",12.4,6.3);
		Employee emp2=new Employee(45,"eddie",12.4,6.3);
		System.out.println(emp1.equals(emp2));
		HashSet<Employee>empSet=new HashSet<>();
		empSet.addAll(Arrays.asList(emp1,emp2));
		System.out.println(empSet);	
	}
	
	static void ex6() {
		System.out.println("ex6***");
		System.out.println("*****LINKEDHASHSET*****");
		/*
		 * Implements Set and Collection interfaces
		 * DOES NOT IMPLEMENT LIST (a likely exam question)
		 * similar to HashSet, except that the elements orgainised in the set the order in which they were entered
		 * (like a list, but does not implement the List interface)
		 */
		Set<Animal>animalLHS=new LinkedHashSet<>();
		//can't have a list reference as it does not implement the List interface
		//List<Animal>nowWork=new LinkeHashSet<>();
		System.out.println("adding Animals to our LinkedHashSet");
		System.out.println(animalLHS.add(new Dog("marley",8)));//added
		System.out.println(animalLHS.add(new Animal(8,"marley")));//will be added as different object type
		System.out.println(animalLHS.add(new Hamster(2,"harry")));//will be added
		System.out.println(animalLHS.add(new Hamster(2,"helen")));//will NOT be added (hamsters same age)
		//adds two new Animal, we already have a dog marley with an age of 8
		animalLHS.addAll(Arrays.asList(new Dog("marley",8),new Dog("Benji",5),new Animal(15,"wally")));
		System.out.println(animalLHS.size());//5 Animals
		
		List<Animal>animalList=new ArrayList<>();
		animalList.add(new Dog());
		animalList.add(new Animal());
		//you can add existing lists to LinkedHashSEt
		animalList.addAll(Arrays.asList(new Dog("prince", 12),new Dog("lady",5),new Animal(20,"andy")));
		animalLHS.addAll(animalList);
		//10 Animals in set
		System.out.println(animalLHS.size());
		animalLHS.addAll(Arrays.asList(new Hamster(123,"harry"),new Hamster(123,"peter")));
		System.out.println(animalLHS.size());//will print 11
		//will print out in the order they were entered
		System.out.println(animalLHS);
		
		//iterator also works with LinkedHashSet
		Set<Animal>AnimalLinkedHashSet2=new LinkedHashSet<>();
		AnimalLinkedHashSet2.add(new Animal(4,"Qualley"));
		AnimalLinkedHashSet2.addAll(animalLHS);
		System.out.println(AnimalLinkedHashSet2);
		//with the iterator the values will output the way they were entered
				System.out.println("Order of Values");
				Iterator<Animal>animalIter=AnimalLinkedHashSet2.iterator();
				
				
				while(animalIter.hasNext())
					System.out.println(animalIter.next());
				for(Animal a:animalLHS)
					System.out.println("animal is "+a);
				
				/*
				 * as this is a LINKED hashSet they are placed in the set in the order
				 * they were entered
				 */
				Set<Dinosaur>dinoLinkedHashSet=new LinkedHashSet<>();
				Dinosaur tRex=new Dinosaur(12,"T-Rex",4560,12,true);
				Dinosaur brontosaurus=new Dinosaur(34,"brontosaurus",45678,55,false);
				Dinosaur raptor=new Dinosaur(14,"raptor",56,6,true);
				Dinosaur triceratops=new Dinosaur(30,"triceratops",234,12,false);
				/*
				 * all these will print out in the order they were inserted
				 */
				dinoLinkedHashSet.add(tRex);
				dinoLinkedHashSet.add(brontosaurus);
				dinoLinkedHashSet.add(raptor);
				dinoLinkedHashSet.add(triceratops);
				
				System.out.println("printing out LinkedHashSet of Dinosaurs");
				System.out.println(dinoLinkedHashSet);
	}
	
	static void ex7() {
		System.out.println("***ex7");
		System.out.println("*****TREESET");
		/*
		 * implements the following interfaces
		 * Collection<E>, NavigableSet, Set, SortedSet
		 * NavigableSet and SorteSet are both separate sub interfaces of Set 
		 * prints out in ascending order by default so 
		 * only objects that implements the Comparable interface can be added to a TreeSet(covered in the
		 * next two sections), the only method in the Comparable interface is the method compareTo(). this method is
		 * used to determine order and the TreeSet uses this method to determine order (see very basic implemenation of
		 * the Comparable interface in the Human class)
		 */
		
		//upperCase before lower case
		//numbers come before letters, but not displayed in logicla order as they are still strings, not numbers
		//duplicates not allowed
		TreeSet<String>stringTS=new TreeSet<>();
		stringTS.addAll(Arrays.asList("Adam","Caroline","Betty","betty","1","12","3"));
		System.out.println(stringTS);
		TreeSet<Integer>integerTS=new TreeSet<>();
		integerTS.addAll(Arrays.asList(12,45,788,9,34,56,1,100,100));
		System.out.println(integerTS);
		System.out.println(integerTS.add(78));//will be added, will print true
		System.out.println(integerTS.add(9));//will not be added will print false
		System.out.println(integerTS);
		/*
		 * a TreeSet can only add objects whose class implements Comparable.
		 * Animal does not implement the Comparable interface so this cannot be added to TreeSet
		 * now you can crete a TreeSet of type that does not implement the Comparable interface
		 */
		TreeSet<Animal>anSet=new TreeSet<>();
		//this will generate a ClassCastException
		//System.out.println(anSet.add(new Animal()));
		//mouse extends Animal and Mouse DOES implement the Comparable interface
		System.out.println(anSet.add(new Mouse()));
	//	System.out.println(anSet.add(new FieldMouse()));
		System.out.println("Iterator with TreeSet");
		System.out.println("Ascending Order");
		/*
		 * just like the other types of list we can use an iterator
		 */
		Iterator it=integerTS.iterator();
		/*
		 * does not have hasPrevious() or previous()
		 */
		while(it.hasNext()) {
			System.out.println("number iterator is "+it.next());
		}
		System.out.println("descending order");	
		/*
		 * can also print them in descending order using an iterator
		 */
		it=integerTS.descendingIterator();
		while(it.hasNext()) {
			System.out.print(it.next()+", ");
		}
		
		integerTS.addAll(Arrays.asList(12,89,99,10000,33456));
		it=integerTS.descendingIterator();
		integerTS.add(67);
		System.out.println(integerTS);
		/*
		 * Object does NOT implement the Comparable interface, however sub classes of Object do. so you can't add objects
		 * to this list, but you CAN add any object that implements the Comparable interface
		 */
		System.out.println("adding to a TreeSet of Objects");
		TreeSet<Object>objectsTS=new TreeSet<>();
		/*HOWEVER
		 * can't have a treeSet with different incompatible data types. so if we start out with String, we can only
		 * from that point onwards use strings or class that the string class compareTo could use, more about 
		 * compareTo() in next two sections
		 */
	//	System.out.println(objectsTS.add("hello"));
	//	System.out.println(objectsTS.add("angela"));
		System.out.println(objectsTS.add(12));
		System.out.println(objectsTS.add(2));
		//Doubles clash with Integers
	//	System.out.println(objectsTS.add(2.3));
		//both of these will generate a ClassCastException
	//	System.out.println(objectsTS.add(new int[] {7,8,12,2}));
	//	System.out.println(objectsTS.add(new StringBuilder("my Stringbuilder")));
		/*
		 * can't guarantee order when printing out a treeset (unless you override the compareTo() to order the items
		 * in the exact way your require). if you want elements ordered in the way they were enteredx use
		 * LinkedHashSet
		 */
		Set<String>linkSetString=new LinkedHashSet<String>();
		//creating copy of integers for later use
		TreeSet<Integer>copyTS=new TreeSet<>();
		copyTS.addAll(integerTS);
		System.out.println("methods of treeSet");
		//clears all values
		copyTS.clear();
		System.out.println(copyTS);
		copyTS.addAll(integerTS);
		integerTS.addAll(Arrays.asList(12,12,34,789,232452,8778,34343));
		
		List<String>myList=new ArrayList<>();
		myList.addAll(Arrays.asList("mary","john","pat","sarah","shelly","laura","colm","jack","mick"));
		//using removeIf
		myList.removeIf((String myStr)->{
			if(myStr.equals("mary"))
				return true;
			return false;
		});
		
		Predicate<String>myPred= (String myStr)->{
			return true;	
		};
		/*
		 * with a Iterator you can remove objects from a TreeSet (like you can with any list)
		 * this will remove all odd numbers from our TreeSet of integers
		 */
		Iterator itInt=integerTS.iterator();
	//	integerTS.add(99234);
		System.out.println(integerTS);
		while(itInt.hasNext()) {
			int num=(Integer)itInt.next();
			if(num%2>0) {
				itInt.remove();
			}		
		}
		///integerTS.add(19990);
		/*
		 * however Iterator does not have previous() or add() for this we need a ListIterator and ListIterator DOES
		 * NOT WORK for SETS
		 */
		Set<Integer>mySet=new HashSet<>();
		//will NOT COMPILE
		//ListIterator listIter=mySet.iterator();
		/*
		 * Listiterator has the additional add() and previous() methods, that a Iterator does not have
		 */
		List<String>fruits=new ArrayList<>();
		fruits.addAll(Arrays.asList("banana","apple","cherry","pineapple","strawberry","orange","mango"));
		ListIterator fruitIter=fruits.listIterator();
		String fruit;
		System.out.println("using listIterator");
		while(fruitIter.hasNext()) {
		/*
		 * this returns a ListIterator object which points to objects in our list , not it is pointing to a 
		 * individual strings in a list of Strings so we can and have to cast it to be of Type string
		 * here we can use add() and previous() (make sure you know exactly what you are doing though if you are
		 * going to be using previous as it is easy to end up with an infininte loop .ie if you 
		 * go
		 * if(fruit.equals("cherry")){
		 * 		fruitIter.add("blueberry")
		 * 		fruitIter.previous()
		 * }
		 * will resutl in an infinite loop
		 */	
			fruit=(String)fruitIter.next();
			if(fruit.equals("cherry")) {
				fruitIter.remove();//will remove cherry
				fruitIter.add("blueberry");//will add blueberry
				fruitIter.previous();//will go back to previous fruit in list
			}

		}//cherry is not no longer in the list
		System.out.println("fruits are now "+fruits);

	//	TreeSet<Integer>numbers=new TreeSet<Integer>();
		//will result in a 100 numbers from 1 to 100
	/*	while(numbers.size()<100) {
			numbers.add((int)(Math.random()*100));
		}*/
		//however this will compile but infinite loop, ask class why
	/*	while(numbers.size()<=100) {
			numbers.add((int)(Math.random()*100));
		}*/
	/*	System.out.println("nubmers");
		System.out.println(numbers);
		System.out.println(numbers.size());
		System.out.println(integerTS);
		System.out.println(integerTS.size());
		System.out.println((int)(Math.random()*100));*/
		
		/**
		 * if you define a iterator and then add a value to the list you base the iterator on,before you use the 
		 * iterator(in a loop) you cannot then use that iterator from that point forward (as the list/set/whatever 
		 * collection object you base your iterator on has changed)
		 */
		
/*		List<Integer>numbers=new ArrayList<>();
		Iterator numIter=numbers.iterator();
		numbers.add(89800);
		System.out.println(numbers);//everything will compile up to this point
		//howeve this will not compile and you will get ConcurrentModificationException
		while(numIter.hasNext()) {
			System.out.println(numIter.next());
		}*/
		
		TreeSet<String>names=new TreeSet<String>();
		names.addAll(Arrays.asList("alan","adam","bernie","ann"));
		Iterator namesIter=names.iterator();
		names.add("anne");
		//you can redefine the iterator and it will work as the iterator is now based on the new Set with
		//the newly added names
		namesIter=names.iterator();
		System.out.println(names);
		while(namesIter.hasNext()) {
			System.out.println(namesIter.next());
		}	
		
	}
	
	static void ex8() {
		System.out.println("***ex8");
		/*
		 * Exam Objective 4.8 Map and it's implementation
		 * Map interface DOES NOT extend the Collection Interface
		 * A map has a key and a value, duplicate keys not allowed, duplicate values are allowed, keys are used to 
		 * uniquely identify one of the items in your Map
		 * we will focus on HashMap, LinkedHashMap and TreeMap
		 * HashMap and LinkedHashMap allow null values
		 * TreeMap implements the sorted map interface and like HashMap and LinkedHashMap they are not synchronized
		 * (not thread safe)
		 */
		System.out.println("*****HashMap*****");
		System.out.println("consists of a key and a value, no primivites allowed, use wrapper equalivent if needed, "
				+ "null is allowed");
		//implemtns the Map<K,V) interface
		Map<String,Double>salary=new HashMap<>();
		//we use put() to insert values into a hashMap
		salary.put("noel", 9_600_000.0);//"noel" is the key, 9_600_000.0 is the value
		salary.put("mary", 9_600_000.0);//same values ARE allowed
		/*
		 * will not be inserted as the the key "noel" already exists, this will then return the previous value for
		 * the key "noel" which was the  number 9_600_000.0
		 */
		System.out.println(salary.put("noel", 78901.0));
		/*
		 * this will be inserted as the key "tom" did not already exist, so "tom" had no previous value associated with
		 * it, so it will return null
		 */
		System.out.println(salary.put("tom", 12345.0));
		System.out.println(salary);
		/*
		 * if you want to get a particular value of a hasmap, we use the get() method in combination with the 
		 * key (as each item in map has a unique key)
		 */
		System.out.println("wages of tom is "+salary.get("tom"));
		/*
		 * can't use position with a Map, this is looking for the value that has a key of the number 1, this does not
		 * exist so this will return null
		 */
		System.out.println("at postion 1 "+salary.get(1));
		/*
		 * can add null as a value, but only once as a value
		 */
		salary.put(null, 88888.0);//will be addedd
		salary.put(null, 99999.0);//will not be added as keys have to be unique
		System.out.println(salary);
		salary.put("pat", null);//will be added
		salary.put("shelly",null);//will be added
		System.out.println(salary);
		System.out.println("fireman hashMap");
		/*
		 * here we are creating a HashMap of FireMan along with they're wages (doubles)
		 */
		Fireman bruce=new Fireman(2,"bruce");
		Map<Fireman,Double>payRoll=new HashMap<>();
		payRoll.put(new Fireman(), 54_000d);//will be added
		payRoll.put(new Fireman(), 75_000d);//will  be added as different employee object
		payRoll.put(new Fireman(1,"scarlett"), 67_000d);//will  be added
		payRoll.put(bruce,57_000d);//will be added
		payRoll.put(bruce, 71_000d);//will not be added as we have already the same fireman bruce
		System.out.println(payRoll);
		System.out.println(payRoll.size());
		/*
		 * probably easier to have the key as unique number, rather than a unique fireman identifying a number
		 */
		Map<Integer,Fireman>fireMen=new HashMap<>();
		for(int i=0;i<5;i++)
			fireMen.put(i, new Fireman());
		System.out.println("we have "+fireMen.size()+" firemen");
		/*
		 * uses hashCode() and equals() to determine if two objects are equal, same as with HashSet
		 */
		System.out.println(new Nurse("helen").equals(new Nurse("helen")));
		Map<Nurse,Integer>nurses=new HashMap<>();
		nurses.put(new Nurse("helen"), 1);
		nurses.put(new Nurse("helen"), 2);
		System.out.println(nurses.size());
		/*
		 * can create a HashMap by adding an existing HashMap to it
		 * here we are creating a new HashMap called copyFiremen using the existing fireMen HashMap
		 */
		Map<Integer,Fireman>copyFireMen=new HashMap<>(fireMen);
		copyFireMen.put(7, new Fireman());
		System.out.println(copyFireMen.size());
		//will print out all the keys
		System.out.println("keys are "+copyFireMen.keySet());
		//this will copy all of the keys to a set of Strings and returns a Set of Integers
		Set<Integer>intKeys=copyFireMen.keySet();
		//will print out all the values, returns a Collection of values
		System.out.println("values are "+copyFireMen.values());
		//this will copy all of the values to this collection
		Collection<Fireman>firemenCol=copyFireMen.values();
		System.out.println("using intKeys");
		for(Integer k:intKeys) {
			System.out.println("key is "+k);
			System.out.println("hashCode is "+k.hashCode());
			System.out.println("getting value through key "+copyFireMen.get(k));
		}
		/*
		 * Dog class override both the equals() and the hashCode() methods, so if two Dogs have the same age 
		 * and name they will be said to be equal and if added as a key cannot be both added
		 */
		Dog dog1=new Dog();//dog will be added
		Dog dog2=new Dog();//will not be added as same name and age of the previous Dog
		Dog dog3=new Dog("spot",1);
		Dog dog4=new Dog("spot",1);
		Map<Dog,String>dogMap=new HashMap<Dog,String>();
		dogMap.put(dog1, "dog1");//added name of null age of 0
		dogMap.put(dog2, "dog2");//not added as has name of null age of 0
		dogMap.put(dog3, "dog3");//added name of spot age of 1
		dogMap.put(dog4, "dog4");//not added as has name of spot and age of 1
		dogMap.put(new Dog(), "dog5");//not added as has name of null age of 0
		System.out.println("amount of dogs added as keys "+dogMap.size());
		System.out.println("cannot guranantee the order they were entered in a hashMap, if you want too use LinkedHashMap");
		Map<Integer,String>namesMap=new HashMap<Integer,String>();
		namesMap.put(1, "ann");
		namesMap.put(2,"bríd");
		namesMap.put(3,"mary");
		namesMap.put(4,"paddy");
		namesMap.put(50, "kate");
		System.out.println(namesMap);
		System.out.println("names");
		System.out.println("keys");
		for(Integer i:namesMap.keySet()) {
			System.out.print(i+", ");
			System.out.println();
		}
		System.out.println("values");
		for(String s:namesMap.values()) {
			System.out.print(s+", ");
		}
		/*
		 * Map.entry<K,V>
		 */
		//Map.Entry<K, V>
		Map.Entry<Integer,String>myEntry=new Map.Entry<Integer, String>() {

			@Override
			public Integer getKey() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getValue() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String setValue(String value) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		//see above for the methods getKey(),getValue() and setValue()
		/*
		 * Map.Entry<K,V> is an interface that has three methods getKey(),getValue() and setValue()
		 * namesMap returns the SET that contains the keys and values we will increment through
		 */
		for(Map.Entry<Integer, String> entry:namesMap.entrySet()) {
			System.out.println("key is "+entry.getKey());
		//	entry.setValue("newName");
			System.out.println("value is "+entry.getValue());
			if(entry.getValue().equals("kate"))
				entry.setValue("Karen");
		}
		System.out.println(namesMap.entrySet());
		/*
		 * you can add an existing hashMap to another hashMap but still does not allow duplicate keys, so this will
		 * add nothing as our hashmap already contains the same keys as this HashMap
		 */
		namesMap.putAll(namesMap);
		System.out.println(namesMap);
		System.out.println("***putIfAbsent");
		namesMap=new HashMap<Integer,String>();
		namesMap.put(1, "toby");
		namesMap.put(2,"michelle");
		System.out.println(namesMap);
		/*
		 * you can't enter in duplicate keys, however when you attempt to do this, the new VALUE will over write the old
		 * value, so this record not reads
		 * key->2
		 * value->"laura"
		 */
		namesMap.put(2, "laura");
		System.out.println(namesMap);
		/*
		 * putIfAbsent() will insert a record if the key does not already exist, it will insert  nothing if the key
		 * already exists in the Map
		 */
		namesMap.putIfAbsent(3, "colm");//will be inserted as key value 3 does not currently exist in map
		namesMap.putIfAbsent(3, "keith");//will not be inserted as this key value already exists
		System.out.println(namesMap);
		System.out.println("***LinkedHashSet");
		/*
		 * use a LinkedHashMap to guarantee a order, this will print out in the order they were entered
		 */
		LinkedHashMap<Integer,String>lhmAnimal=new LinkedHashMap<Integer,String>();
		int counter=0;
		lhmAnimal.put(++counter, "pig");
		lhmAnimal.put(++counter, "cow");
		lhmAnimal.put(++counter, "sheep");
		lhmAnimal.put(++counter, "chicken");
		lhmAnimal.put(++counter, "goose");
		System.out.println(lhmAnimal);
		System.out.println("***printing out LinkedHashmapNames");
		for(Map.Entry<Integer, String> entry:lhmAnimal.entrySet()) {
			System.out.println("key is "+entry.getKey());
			System.out.println("value is "+entry.getValue());
		}
		
		for(Integer key:lhmAnimal.keySet()) {
			System.out.println("key inside loop is "+key);
			System.out.println("value inside loop is "+lhmAnimal.get(key));
		}
		for(String value:lhmAnimal.values())
			System.out.println("values inside own loops is "+value);
		//linked means ordered in order they were entered
		
		Dog spot=new Dog("spot",2);
		Dog rex=new Dog("rex",3);
		Dog benji=new Dog("benji",4);
		Dog lassie=new Dog("lassie",5);
		Map<Integer,Dog>DogLHM=new LinkedHashMap<Integer,Dog>();
		//can use the hashCode to give a unique value, if have same value, means have same name and age
		//and we don't want two dogs with same name and age
		DogLHM.put(spot.hashCode(), spot);
		DogLHM.put(rex.hashCode(), rex);
		DogLHM.put(benji.hashCode(), benji);
		//prints spot,rex,benji
		System.out.println(DogLHM);
		//puts in lassie instead of benji at the third position in the hashmap
		DogLHM.put(benji.hashCode(), lassie);
		//prints spot,rex,lassie
		System.out.println(DogLHM);
		//can add the same Dog as long as different key
		DogLHM.put(lassie.hashCode(), lassie);
		System.out.println(DogLHM);
		//both the same Dog
		System.out.println(DogLHM.get(benji.hashCode()).equals(DogLHM.get(lassie.hashCode())));
		//null values are allowed for keys and values, no repeating null  for keys, 
		//null repeating allowed for values
		System.out.println("Adding null");
		DogLHM=new LinkedHashMap<Integer,Dog>();
		DogLHM.put(1, spot);
		DogLHM.put(2, lassie);
		DogLHM.put(null, null);
		//has null id and null value
		System.out.println(DogLHM);
		//has null id and dog benji as value
		DogLHM.put(null, benji);
		System.out.println(DogLHM.size());
		System.out.println(DogLHM);
		
		
	}
	
	static void ex9() {
		System.out.println("*******TreeMap");
		/*
		 * tree Maps are maps with all the same advantages of maps and also they are sorted by key values in 
		 * Ascending order
		 * implements Map<K,V>, NavigableMap<K,V>, SortedMap<K,V>, 
		 * also only objects whose class implements the Comparable interface can be a the key in a TreeMap, the
		 * value can be any obejct
		 */
		Map<Integer,String>animalTM=new TreeMap<Integer,String>();
		animalTM.put(5, "camel");
		animalTM.put(1, "horse");
		animalTM.put(3, "sheep");
		animalTM.put("cow".hashCode(), "cow");
		animalTM.put("chicken".hashCode(), "chicken");
		System.out.println(animalTM);
		Map<Animal,String>notAddTM=new TreeMap<Animal,String>();
		//Animal does NOT implement the comparable interface, so you can't add a Animal
	//	notAddTM.put(new Animal(), "hello");//will give classCastException
		//Mouse DOES IMPLEMENT the comparable interface, so you can add a Mouse as a key
		notAddTM.put(new Mouse(), "bye");
		
		for(Integer i:animalTM.keySet()) {
			System.out.println(i);
			System.out.println(animalTM.get(i));
		}
		for(String s:animalTM.values()) {
			System.out.println("values "+s);
		}
		/*
		 * this will arrange the TreeMap in reverse order
		 */
		Map<Integer,String> newMap = new TreeMap(Collections.reverseOrder());
		newMap.putAll(animalTM);
	//	System.out.println(newMap);
		System.out.println("remove");
		System.out.println(newMap);
		//returns value if key exists and removes the key value pair, removes 3=sheep
		System.out.println(newMap.remove(3));
		
		System.out.println("containsKey");
		//returns true if our map contains the key
		System.out.println(newMap.containsKey(3));
		
		System.out.println("containsValue");
		//returns true if our map contains the value
		System.out.println(newMap.containsValue("camel"));
		//returns a set of all the keys
		System.out.println("keySet");
		System.out.println(newMap.keySet());
		//returns a collection of all the values
		System.out.println("values");
		System.out.println(newMap.values());
		
	}

}
