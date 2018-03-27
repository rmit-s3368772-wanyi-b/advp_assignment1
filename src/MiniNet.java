import java.util.*;

/**
* The MiniNet program implements an application that
* that keeps track of information in a simple social network.
*
* @author  Wan Yi Beh (S3368772)
* @version 1.0
* @since   2018-03-23
*/

public class MiniNet {
	public static void main(String[] args) {

		Map<String, Person> ppl = new HashMap<>();
		Driver d = new Driver(ppl);
		d.runNet();

		System.out.println("\n\n****************************");
		System.out.println("* Shutting MiniNet..........");
		System.out.println("* MiniNet successfully shut.");
		System.out.println("****************************");
	}
}
