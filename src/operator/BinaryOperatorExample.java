/**
 * @author Anh Mai
 * Sep 28, 2021
 */
package operator;

import java.util.function.BinaryOperator;

/**
 * @author Anh Mai
 *
 * 
 */
public class BinaryOperatorExample {

	/**
	 * @param args void
	 */
	public static void main(String[] args) {

		BinaryOperator<Integer> func1 = (x, y) -> x + y;
		int sum = func1.apply(2, 3);
		System.out.println(sum);

	}

}
