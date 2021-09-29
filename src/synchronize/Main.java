/**
 * @author Anh Mai
 * Sep 27, 2021
 */
package synchronize;

/**
 * @author Anh Mai
 *
 * 
 */
public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					customer.withDraw(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.start();

		Thread t2 = new Thread() {
			@Override
			public void run() {
				customer.deposit(500);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				customer.deposit(2000);

			}
		};
		t2.start();

	}

}
