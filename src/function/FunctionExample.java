/**
 * @author Anh Mai
 * Sep 27, 2021
 */
package function;

import java.util.Arrays;
import java.util.function.Function;


/**
 * @author Anh Mai
 *
 * 
 */
public class FunctionExample {

	public static void main(String[] args) {
		Function<String, Integer> parseInt = Integer::parseInt;
		Function<Integer, Integer> absInt = Math::abs;
		
		Function<String, Integer> parseandabs = parseInt.andThen(absInt);
		
		Arrays.stream("4, -9, 19".split(", "))
		.map(parseandabs).forEach(System.out::println);
		
		
		
	}
}
