/**
 * @author Anh Mai
 * Sep 27, 2021
 */
package predicate;


import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;



/**
 * @author Anh Mai
 *
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		Predicate<Hosting> customPredicate = x -> x.getName().startsWith("a") || x.getName().endsWith("e");
		
		BiPredicate<Hosting, Hosting> biPredicate = (host1, host2)->host1.getName()==host2.getName();
		
		
		Hosting h1 = new Hosting(1, "amazon", "aws.amazon.com");
        Hosting h2 = new Hosting(2, "linode", "linode.com");
        Hosting h3 = new Hosting(3, "liquidweb", "liquidweb.com");
        Hosting h4 = new Hosting(4, "google", "google.com");
        Hosting h5 = new Hosting(5, "google", "google.com");
        
        List<Hosting> hostingList = Arrays.asList(new Hosting[] {h1, h2, h3, h4});
        
        
        List<Hosting> res = hostingList.stream()
        		.filter(customPredicate)
        		.toList();
        res.stream().forEach(y->System.out.println(y.getName()));
        
        if (biPredicate.test(h4, h5)) {
			System.out.println("Hostname giong nhau");
		}

	}

}
