/**
 * @author Anh Mai
 * Sep 27, 2021
 */
package supplier;

import java.util.function.Supplier;

/**
 * @author Anh Mai
 *
 * 
 */
public class Main {

	
	public static void main(String[] args) {

		
		Customer c = factory((Customer::new));
		System.out.println(c.getName());
	}
	
	
	public static Customer factory(Supplier<? extends Customer> supplier) {
		Customer customer = supplier.get();
		
		customer.setName("MA");
		customer.setSalary(10000);
		
		return customer;
		
	}
	
	
	
	
	
	
	
}
