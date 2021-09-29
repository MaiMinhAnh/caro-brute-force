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
public class Customer {

	private int balance = 1000;
	/**
	 * 
	 */
	public Customer() {
		System.out.println("Tai khoan kha dung: "+balance);
	}
	
	public synchronized void withDraw(int amount) throws InterruptedException {
		System.out.println("Giao dich rut tien: "+amount);
		while(balance<amount) {
			System.out.println("Khong du tien trong tai khoan.");
			wait();
		}
		balance = balance - amount;
		System.out.println("Rut tien thanh cong.");
	}
	
	public synchronized void deposit(int amount) {
		System.out.println("DAng thuc hien nap "+amount);
		balance += amount;
		System.out.println("nap tien thanh cong. Tai khoan: "+balance);
		notify();
	}
}
