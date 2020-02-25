import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
