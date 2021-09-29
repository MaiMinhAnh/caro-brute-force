/**
 * @author Anh Mai
 * Sep 27, 2021
 */
package basic;

import java.util.concurrent.TimeUnit;

/**
 * @author Anh Mai
 *
 * 
 */
public class Main {

	/**
	 * @param args void
	 */
	public static void main(String[] args) {
		FileSearch fileSearch = new FileSearch("D:\\", "05_MaiThiMinhAnh_20172954.pdf");
		Thread thread = new Thread(fileSearch);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
