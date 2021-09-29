/**
 * @author Anh Mai
 * Sep 28, 2021
 */
package predicate;

/**
 * @author Anh Mai
 *
 * 
 */
public class Hosting {

	private int id;
	private String name;
	private String url;
	/**
	 * 
	 */
	public Hosting(int id, String name, String url) {
		this.id = id;
		this.name = name;
		this.url = url;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
