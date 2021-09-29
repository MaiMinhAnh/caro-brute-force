/**
 * @author Anh Mai
 * Sep 28, 2021
 */
package function;

import java.util.function.BiFunction;

/**
 * @author Anh Mai
 *
 * 
 */
public class BiFunctionExample {

	public static void main(String[] args) {
		BiFunction<String, String, String> concatStr = (x, y)-> x+y;
		
		System.out.println(concatStr.apply("Minh", "Anh"));
		
	}
}
