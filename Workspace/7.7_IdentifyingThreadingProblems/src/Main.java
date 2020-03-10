
public class Main {

	public static void main(String[] args) {
	
		//===========================CONCURRENCY API:
		/*
		 * The concurrency API reduces a lot of threading issues. It doesnt however elimenate them. 
		 * 
		 * 
		 */
		
		//-------------Understanding liveness:
		
		//https://www.geeksforgeeks.org/deadlock-starvation-and-livelock/
		
		/*
		 * Liveness is the ability for an application to execute in a timely manner.
		 * i.e if a thread is waiting for another thread to finish it's task. (await(), sleep(), cyclicBarrier())
		 * 
		 * 3 examples of these are deadlock, starvation and livelock
		 */
		
		/*
		 *Deadlock:
		 * 
		 * Deadlock occurs when 2 or more threads are blocked forever. 
		 * One thread will be waiting on another thread which may be waiting for the first thread.
		 */
		
		/*
		 * Starvation: 
		 * 
		 * This is where a single thread is perpetually denied access to a shared resource, variable 
		 * because other threads are constantly accessing some resource that blocks it.
		 */
		
		/*
		 * LiveLock: A deadlock but each process changes in response to the lock, which continues causing the problem. 
		 */
		
		
		/*
		 * Race Conditions:
		 * 
		 *This is when 2 tasks that should happen sequentially (one after the other) are completed at the same time.
		 *i.e 2 users trying to register the same username which could result in both users having the same userName.
		 */
		
		

	}

}
