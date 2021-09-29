/**
 * @author Anh Mai
 * Sep 28, 2021
 */
package supplier;



/**
 * @author Anh Mai
 *
 * 
 */
public class Customer {

	private String name;
	private int salary;

	/**
	 * 
	 */
	public Customer() {

	}

	public Customer(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
