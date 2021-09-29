/**
 * @author Anh Mai
 * Sep 27, 2021
 */
package consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Anh Mai
 *
 * 
 */
public class ConsumerExample {

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		List<Programing> list = new ArrayList<Programing>();
		list.add(new Programing("Java", 1));
		list.add(new Programing("C#", 5));
		
		Consumer<Programing> consumer = p->System.out.println(
				"name: "+p.language+", exp: "+p.exp
				);
		//using consumer
		list.forEach(consumer);

		
		BiConsumer<String, Integer> biConsumer = (language, exp)->System.out.println("Language: "+language+", exp: "+exp);;

		biConsumer.accept("PHP", 7);
	}

}
