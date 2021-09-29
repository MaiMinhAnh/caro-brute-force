/**
 * @author Anh Mai
 * Sep 28, 2021
 */
package operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.function.UnaryOperator;

/**
 * @author Anh Mai
 *
 * 
 */
public class UnaryOperatorExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

		List<Integer> result = math(list, x -> x + 7, x -> x * 3);
		System.out.println(result);

		// System.out.println(add(list, (a, b)->{a*b});
	}

	// unaryOperator
	public static List<Integer> math(List<Integer> list, UnaryOperator<Integer> u1, UnaryOperator<Integer> u2) {
		List<Integer> result = new ArrayList<Integer>();
		for (Integer i : list) {
			result.add(u1.andThen(u2).apply(i));
		}
		return result;
	}

}
