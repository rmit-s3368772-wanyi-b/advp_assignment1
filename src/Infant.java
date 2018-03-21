import java.util.*;

/**
 *
 * @author huanineupane
 *
 */

class Infant extends Person {

	// variables
	private Map<String, Adult> parents;

	// constructor
	public Infant (String name, int age, String gender, Adult father, Adult mother) {
		super(name, age, gender);
		this.parents.put("father", father);
		this.parents.put("mother", mother);
	}

	// accessor
	public Adult getFather() {
		return this.parents.get("father");
	}

	public Adult getMother() {
		return this.parents.get("mother");
	}

	// mutator

	// display parents list
	public void displayParents() {

		// get set of the entries
		Set set = this.parents.entrySet();

		// get an iterator
		Iterator iterator = set.iterator();

		// display the list
		//System.out.println("=====LIST NAMES OF FRIENDS====");
		while (iterator.hasNext())
		{
			Map.Entry list = (Map.Entry) iterator.next();
			//System.out.println(list.getKey());//Since Key is a copy of obj name
			if (list.getKey().equals("father"))
			{
				System.out.println("Father: " + ((Person) list.getValue()).getName());
			}
			else
			{
				System.out.println("Mother: " + ((Person) list.getValue()).getName());
			}
		}
	}



}
