package dua_ngua;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			MyThread thread = new MyThread();
			thread.start();

		}
	}

}
