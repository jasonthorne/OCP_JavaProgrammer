import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		for(int i=0;i<10;i++) {
			//service.submit(()->System.out.println(ex1.get2("leo")));
		}
	
	}
	
	public synchronized void put2(String key, Animal value) {
		zooAnimal.put(key, value);
	}
	
	public synchronized void get2(String key) {
		zooAnimal.get(key);
	}
	
	
	
	

}
