/**
 * @author Anh Mai
 * Sep 27, 2021
 */
package consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author Anh Mai
 *
 * 
 */
public class BiConsumerExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Java", 4);
		map.put("C++", 7);
		
		BiConsumer<String, Integer> biConsumer = 
				(key, value)->System.out.println("key: "+key+", value: "+value);;
				
				map.forEach(biConsumer);
	}
}
