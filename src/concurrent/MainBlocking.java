/**
 * @author Anh Mai
 * Sep 27, 2021
 */
package concurrent;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Anh Mai
 *
 * 
 */
public class MainBlocking {

	/**
	 * @param args
	 * void
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<String>();
		Client client = new Client(list);
		Thread thread = new Thread(client);
		thread.start();
		System.out.println(thread.getPriority()+thread.getName());
		System.out.println(Thread.currentThread().getPriority() + Thread.currentThread().getName());
	
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<3; j++) {
				String request = list.take();
				System.out.println("Main: request: "+request+", size: "+list.size());
			}
			
		}

	}

}
