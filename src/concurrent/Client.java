/**
 * @author Anh Mai
 * Sep 27, 2021
 */
package concurrent;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author Anh Mai
 *
 * 
 */
public class Client implements Runnable {

	private LinkedBlockingDeque<String> requestList;

	/**
	 * 
	 */
	public Client(LinkedBlockingDeque<String> requestList) {
		super();
		this.requestList = requestList;
	}

	@Override
	public void run() {
		
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<5; j++) {
				StringBuilder request = new StringBuilder();
				request.append(i);
				request.append(":");
				request.append(j);
				try {
					requestList.put(request.toString());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Client: "+request+", "+new Date());
			}
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		System.out.println("Client: End");
		
	}

}
