import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Examples {
	
	/**
	 * ALL collections: Sets, lists, queues are NOT thread safe. 
	 * Also, all classes that implement the Map interface are also NOT thread safe.
	 * 
	 * The Concurrency API is a collection of Interfaces that allow thread safe sets, list, queues and Maps.
	 */
	
	static void ex1() { 
		
		System.out.println("ex1");
		
		Map<String, Object>foodData = new HashMap<String,Object>();
		
		List<String>names=new ArrayList<>(Arrays.asList("bob", "frank", "biggles"));
		
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		foodData.put("lion", 3);
		
		System.out.println(names);
		System.out.println(foodData);
		
		for(String name: names) {
			
			/*
			if(name.equals("frank")) { //works for anything BUT the first element, as pointer starts b4 this  (so DONT USE :P)
				names.remove(name);
			}*/
			
			//names.remove(name); ///++fallsover bevcause the first element cant be removed as pointer starts b4 this
			
		}
		
		System.out.println(names);
		
		
		for(String key:foodData.keySet()) {
			
			/*
			if(key.equals("flamingo")) { //works for anything BUT the first element, as pointer starts b4 this (so DONT USE :P)
				foodData.remove(key);
			}*/
			
			//foodData.remove(key); ///++fallsover bevcause the first element cant be removed as pointer starts b4 this
		}
		
		System.out.println(foodData);
		
	}
	
	private static Map<String, Animal>zooAnimal=new HashMap<String, Animal>();
	
	
	static void ex2() { 
		
		System.out.println("ex2");
		
		Examples ex1 = new Examples(); 
		ex1.put2("spot", new Animal("Dog"));
		ex1.put2("tibbles", new Animal("Cat"));
		ex1.put2("leo", new Animal("Lion"));
		
		//---------------
		System.out.println("zooAnimal: " + zooAnimal);
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		try {
			
			/*
			 * The hashmap is not threadsafe here, but the remove2 method is threadsafe.
			 */
			for(String key:zooAnimal.keySet()) {
				service.submit(()->ex1.remove2(key));
			}
			
			Thread.sleep(100);
			
		}catch(Exception e) {
			
		}
		finally {
			service.shutdown();
		}
		
		System.out.println("zooAnimal: " + zooAnimal);
		
	
	}
	
	//--------------------------------------------
	//threadsafe methods:
	
	public synchronized void put2(String key, Animal value) {
		zooAnimal.put(key, value);
	}
	
	public synchronized void get2(String key) {
		zooAnimal.get(key);
	}
	
	public synchronized void remove2(String key) {
		zooAnimal.remove(key);
	}
	
	//========================================================================CONCURRENY API +++++++++++++++++++++++++++++++++++
	/*
	 * An alternative to the above teqneuwq is to use specific thread safe collections.
	 * We can use the concurrency API as this is just a collection of interfaces that makes classes thread safe.
	 * These interfaces include performance enhancements that avoid unnecessary synchronization. 
	 * 
	 * So this is what you can use to manage access to our collections across multiple threads. 
	 * The first type we will use is the concurrent hashmap, the only difference from a normal hashmap is that the object type is a concurrent hashmap. 
	 */
	
	
	//this is the same methods as a normal hashmap except that they're all threadsafe
	private static Map<String, Object>farm = new ConcurrentHashMap<String,Object>();
	static int statKey = 0;
	
	static void ex3() {
		
		farm.put("1", "cow");
		farm.put("2", "sheep");
		farm.put("3", "pig");
		farm.put("4", "chicken");
		
		System.out.println("get of Concurrent Hashmap: " + farm.get("3"));
		
		System.out.println(farm); //hashmap b4 removal
		
		for(String key: farm.keySet()) {
			farm.remove(key);
		}
		
		System.out.println(farm); //hashmap after removal
		
		//---------
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		farm.put("1", "cow");
		farm.put("2", "sheep");
		farm.put("3", "pig");
		farm.put("4", "chicken");
		
		
		/*
		 * you should use a concurrent collection class anytime you are going to have multiple threads modify a collection object 
		 * outside of a synchronized block or method.
		 * If your collection is immutsable or read only (in other words you cant change the collection)
		 * then a concurrent collection class is not needed.
		 * It is considered a good practice to pass a concurrent (thread safe) collection using a non concurrent interface reference
		 * void method (Map<String,Object>myMap){}
		 * and we will pas the following to this method: 
		 * private static Map<String, Object>farm = new ConcurrentHashMap<String,Object>();
		 * method(farm)
		 */
		
		/*
		 * +++++++++++++++++++++++++++++++++++LEARN THESE +++++++++++++++++++++++++++++++++++++++++++
		 * 
		 * List of concurrent classes:
		 * 
		 * All of these collections opperate in much the same way as their non synchronized version.
		 * The only difference is in how you actually declare the object itself. ie:
		 * Set<String>mySkipSet = new ConcurrentSkipListSet();
		 * 
		 * CLASS NAME					JAVA COLLECTIONS FRAMEWORK
		 * -----------------------------------------------------------
		 * ConcurrentHashMap			ConcurrentMap
		 * ConcurrentLinkedDeque		Deque
		 * ConcurrentLinkedQueue		Queue
		 * ConcurrentSkipListMap		ConcurrentMap, SortedMap, NavigableMap
		 * ConcurrentSkipListSet		SortedSet, NavigableSet
		 * CopyOnWriteArrayList			List
		 * CopyOnWriteArraySet			Set
		 * LinkedBlockingDeque			BlockingQueue, BlockingDeque
		 * LinkedBlokcingQueue			BlockingQueue
		 * 
		 * 
		 */
		
		
	}
	
	
	
	static void ex4() {
		
		System.out.println("\nex4");
		
		//ConcurrentHashMap:================================
		
		/*
		 * Implements the Map interface
		 */
		
		Map<String, Integer>myMap = new ConcurrentHashMap<>();
		myMap.put("yo", 3);
		//etc..
		
		/*ConcurrentHashMap also implements the ConcurrentMap interface, 
		so we can also create a ConcurrentHashMap
		This is a MORE specific hashMap so will be more thread safe
		
		You would use this if ou want to make sure this operates correctly in a multithreaded environment
		*/
		
		ConcurrentMap<Integer, String>map2 = new ConcurrentHashMap<>();
		
		
		//ConcurrentLinkedQueue:================================
		//thread safe queue
		
		Queue<Integer>queue=new ConcurrentLinkedQueue<>();
		
		queue.offer(31);
		queue.offer(1);
		queue.offer(100);
		
		System.out.println("queue: " + queue);
		
		//peek only retrieves the value at the had of the queue:
		System.out.println("peek: " + queue.peek());
		
		//poll retrieves the value and removes it from queue:
		System.out.println(queue.poll());
		
		System.out.println("queue: " + queue);
		
		//ConcurrentLinkedQueue:================================
		
		/*
		 * thread safe deque, deque can add art the end and beginning and can remove from the end and begininng.
		 */
		
		Deque<Integer>deque= new ConcurrentLinkedDeque<>();
		
		deque.offer(12); //puts at end of deque
		deque.push(100); //puts at start of deque
		deque.offer(45); //puts at end of deque
		deque.push(120); //puts at start of deque
		
		System.out.println("deque: "+ deque); //[120, 100, 12, 45]
		
		//display and remove the first item on the list:
		System.out.println(deque.pop());
		
		//display and remove the last item on the list:
		System.out.println(deque.pollLast());
	
		System.out.println("deque: "+ deque); //[100, 12]
		
		
	}
	
	
	
	
	static void ex5() {
		
		System.out.println("\nex5");
		//+++++++BLOCKING CLASSES+++++++++++++++++++++++++++++++++++++
		
		/*
		 * Blocking classes implement the blocking interfaces 
		 * and the ones we cover are LinkedBlockingQueue and LinkedBlockingQueue 
		 * both implement the blockingQueue interface
		 * 
		 * These are like regular queues except they are thread safe 
		 * and also include methods that wait a specific amount of time to complete a particular operation
		 * Methods of note are;
		 * 
		 * + Offer(E e, long timeOut, TimeUnit unit)
		 * 
		 * e is the type of object in your queue, timeout is the amount of time, timeUnit is the amount of time you want to use.
		 * 
		 * offer adds items to the queue and will wait a specified time if queue is not ready.
		 * If this goes ver the set amount of time, this returns false. 
		 * 
		 * 
		 * 
		 * + Poll(long timeOut, TimeUnit unit)
		 * Retrieves and removes an item from the queue, waiting the specified time. 
		 * returns null if the time elapses before the item if available.
		 * 
		 * 
		 * Both of the above methods can throw a checked exception which is an interrupted exception,
		 * so they need to be thrown be the method or wrapped in try/catch
		 * 
		 */
		
		//LinkedBlockingQueue:================================
		
		try {
			BlockingQueue<Integer>blockQueue = new LinkedBlockingQueue<>();
			System.out.println(blockQueue.offer(39)); //returns true as will be inserted
			
			//will add 345 to the queue and waits 4 seconds if necessary to do so. Will return false if didn't have enough time.
			System.out.println(blockQueue.offer(345, 4, TimeUnit.SECONDS)); 
			System.out.println(blockQueue.offer(100, 4, TimeUnit.SECONDS)); 
			System.out.println(blockQueue.offer(200, 4, TimeUnit.SECONDS)); 
			
			System.out.println(blockQueue);
			
			if(blockQueue.offer(345, 4, TimeUnit.SECONDS)) {
				System.out.println("do some code");
			}
			
			//remove at start of queue:
			System.out.println(blockQueue.poll()); //will display 39 and remove from queue
			
			System.out.println(blockQueue.poll(4, TimeUnit.SECONDS)); //will display 345 and remove from queue
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		//LinkedBlockingDeque:================================
		
		/*
		 * As this class extends nboth queue and dequeu, 
		 * all the methods of those classes are also available to this,
		 * and also all of the methods of the BlockingQueue
		 */
		
		try {
			BlockingDeque<Integer>blockDeque = new LinkedBlockingDeque<>();
			
			blockDeque.offer(34); //insert at end of queue
			blockDeque.push(50); //insert at end of queue
			blockDeque.offerLast(120, 4, TimeUnit.MILLISECONDS); //end of deque
			blockDeque.offerFirst(234, 3, TimeUnit.MILLISECONDS); //start of deque
			
			System.out.println(blockDeque);
			
			
			System.out.println(blockDeque.poll());  //rereives and removes from head of deque
			System.out.println(blockDeque.poll(6, TimeUnit.SECONDS)); 
			System.out.println(blockDeque.pollFirst(200, TimeUnit.MILLISECONDS)); 
			System.out.println(blockDeque.pollLast(1, TimeUnit.MILLISECONDS)); 
			
			System.out.println(blockDeque);
			
		}catch(Exception e) {
			
		}
		
	}
	
	
	static void ex6() {
		
		
		//+++++++++++++++++CONCURRENT SKIP LISTS:
		
		/*
		 * ConcurrentSkipListSet and ConcurrentSkipListMap are concurrent thread safe versions of 
		 * TreeSet and TreeMap
		 * TreeSet only allows objects that implement comparable interface or uses a comparator.
		 */
		
		//ConcurrentSkipListSet================================
		
		System.out.println("\nex6");
		
		TreeSet<Integer>tInt = new TreeSet<>();
		
		tInt.add(1200);
		tInt.add(50);
		tInt.add(12);
		tInt.add(100);
		System.out.println(tInt);
		
		
		//------
		
		TreeSet<Human>humanTree = new TreeSet<>();
		
		 //a Human does NOT implement comparable, so Human CANNOT be be added to a TreeSet.
		//However you can create a TreeSet of Humans as a subclass of Human COULD implement the comparable Interface.
		//humanTree.add(new Human()); ---will not compile! 
		
		Duck ant = new Duck("ant");
		Duck zed = new Duck("zed");
		Duck bert = new Duck("bert");
		Duck duck2 = new Duck("zed"); 
		
		TreeSet<Duck>duckTree = new TreeSet<>(Arrays.asList(ant, zed, bert, duck2)); 
		System.out.println(duckTree);
		
		System.out.println(duckTree.add(duck2)); //returns false, as value already exists.
		
		
		//==========================
		
		/*
		 * The key in the TreeMap has to be unique (cannot be repeated), so the key in the hashmap has to be an object that implements the comparable interface.
		 * Integer implements comparable interface so this will compile and run.
		 * The value can be any object, anfd you can have repeating values.
		 */
		Map<Integer, String>myMap = new HashMap<>();
		myMap.put(1, "john");
		myMap.put(2, "mary");
		myMap.put(3, "frank");
		myMap.put(4, "frank");
		myMap.put(1, "bob"); //this will override the key/value pair of 1, "john"
		
		System.out.println("myMap: " + myMap);
		
		//----
		
		Map<Animal, String>myAnimal= new TreeMap<>();
		//myAnimal.put(new Animal("spot"), "spot");
		//System.out.println(myAnimal); 		//fallsover as this doesn't implement comparable
		
		
		//--------------------------
		
		Map<Duck, Integer>duckMap = new TreeMap<>();
		
		duckMap.put(new Duck("daffy"), 6);
		
		
		
		//======================================================================
		
		//Concurrent (thread safe) version of TreeSet is ConcurrentSkipListSet:
		
		NavigableSet<String>set = new ConcurrentSkipListSet<>();
		
		/*
		 * Only objects that implements the comparable interface can be added to a ConcurrentSkipListSet and the same rules for TreeSet apply to it.
		 * But it is thread safe and all methods of this class are also thread safe.
		 */
		
		set.addAll(Arrays.asList("zed", "Zed", "bee", "ant", "Caroline", "angela", "123", "^^+", "bee"));
		
		System.out.println(set);
		
		//--------------------
		
		//same rules for treeMap as for skiplistmap except that this collection object is Threadsafe and can only be accessed by one thread at a time.
		NavigableMap<Integer, String>navMap = new ConcurrentSkipListMap<>();
		
		//All the methods of this class are threadsafe.
		
		NavigableMap<Duck, String>navMap2 = new ConcurrentSkipListMap<>();
	
	}
	
	
	static void ex7() {
		
		System.out.println("\nex7");
		
		//CopyOnWriteCollections================================
		
		

		
	}
	
	
	
	
}
