/**
 * @author Anh Mai
 * Sep 27, 2021
 */
package concurrent;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Anh Mai
 *
 * 
 */
public class Main {

	/**
	 * @param args
	 * void
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ConcurrentLinkedDeque< String> list = new ConcurrentLinkedDeque<String>();
		Thread threads[] = new Thread[100];
//		for (int i = 0; i < threads.length; i++) {
//			AddTask task = new AddTask(list);
//			threads[i] = new Thread(task);
//			threads[i].start();
//		}
//		System.out.println("Main: "+ threads.length+" AddTask launched");
//
//		for (int i = 0; i < threads.length; i++) {
//			threads[i].join();
//		}
		System.out.println("Main: size of list "+ list.size());
		
		
		for (int i = 0; i < threads.length; i++) {
			String string = list.getFirst();
			PollTask task = new PollTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
			
		}
		System.out.println(threads.length+" polltask launched");
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		System.out.println("list size: "+list.size());
		
		
	}
	
	

}
