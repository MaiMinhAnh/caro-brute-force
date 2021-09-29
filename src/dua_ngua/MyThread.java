package dua_ngua;

public class MyThread extends Thread {

	/**
	 * 
	 * */

	public void run() {
		// biến đếm số bước chạy
		int count = 0;

		// biến đếm quãng đường
		int s = 0;
		// liên tiếp chạy cho đến khi số bước chạy =100
		while (s != 100) {
			try {
				// sau 0.5s thì chạy thêm 1 bước
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 1 bước chạy random trong khoảng 1-10
			int rd = (int) (Math.random() * 9 + 1);
			// nếu quãng đường <100 tiếp tục cộng

			// tăng số bước chạy
			count++;
			// cộng quãng đường
			s += rd;

			// nếu quãng đường >100
			if (s > 100) {
				// tăng số bước chạy
				count++;
				// trừ 100 và cộng thêm bước chạy
				s = s + rd - 100;
			}
			// in ra quãng đường và số bước chạy
			// System.out.println(Thread.currentThread().getId() + " running : " + s + ",
			// count: " + count);

		}
		// nếu s = sô bước chạy = 100 thì về đích
		if (s == 100) {
			System.out.println(Thread.currentThread().getId() + " ve dich sau " + count + " buoc.");
		}
	}
}
