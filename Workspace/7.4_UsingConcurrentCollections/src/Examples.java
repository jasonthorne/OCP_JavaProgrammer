import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		
		//================================ConcurrentHashMap:
		
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
		
		
		//================================ConcurrentLinkedQueue:
		
		//Queue<Integer>
		
		
		
		
		
	}
	
}
