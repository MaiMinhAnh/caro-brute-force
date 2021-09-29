/**
 * @author Anh Mai
 * Sep 27, 2021
 */
package consumer;

/**
 * @author Anh Mai
 *
 * 
 */
public class Programing {
	public String language;
	public int exp;
	/**
	 * 
	 */
	public Programing(String language, int exp) {
		super();
		this.language = language;
		this.exp = exp;
	}
	
	public void print() {
		System.out.println("Language: "+language+", Exp: "+exp);
	}

}
