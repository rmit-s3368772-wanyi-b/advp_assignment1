import java.util.*;

/**
* Class to handle the requirements to create an Teen.
*
* @author  Huani Neupane (S3685849)
* @version 1.0
* @since   2018-03-23
*/

class Teen extends Person implements Friends{

	// Attributes
	private String status;
	private Map<String, Teen> friends = new HashMap<>();
	private Map<String, Adult> parents = new HashMap<>();

	// Constructor
	public Teen(String name, int age, String gender, String _status,
			Adult father) {
		super(name, age, gender);
		this.status = _status;
		this.parents.put("Father", father);
		this.parents.put("Mother", father.getPartner());
		father.setChild(this);
		father.getPartner().setChild(this);
	}

	/**
     * Accessor
     * @return status of Teen.
     * @return father of Teen.
     * @return mother of Teen.
     */

	public String getStatus() {
		return status;
	}

	public Adult getFather() {
		return this.parents.get("Father");
	}

	public Adult getMother() {
		return this.parents.get("Mother");
	}

	/**
     * Mutator
     * @param status of Teen.
     */
	public void setStatus(String status) {
		this.status = status;
	}

	// To add friend of a Teen.
	public boolean addFriend(Person person) {
		if (person.getAge() > 2 && person.getAge() < 17) {
			this.friends.put(person.getName(), (Teen) person);
			((Teen) person).friends.put(this.getName(), this);
			return true;
		}
		return false;
	}

	// To display a list of friends of a Teen.
	public void displayFriendList() {

		// get set of the entries
		Set set = this.friends.entrySet();

		// get an iterator
		Iterator iterator = set.iterator();

		// display the list
		System.out.println("=====LIST NAMES OF FRIENDS====");
		while (iterator.hasNext()) {
			Map.Entry list = (Map.Entry) iterator.next();
			System.out.println(list.getKey()); // Since Key is a copy of obj name
			// same as : System.out.println(((Person) list.getValue()).getName());
		}
	}

	// To check if 2 Teens are friends.
	public boolean isFriend(Person a) {
		return this.friends.containsKey(a.getName()) == true ? true : false;
	}

	// To display a list of family members of a Teen.
	public void listFamilyMembers() {
		System.out.println("- Father: " + this.parents.get("Father").getName());
		System.out.println("- Mother: " + this.parents.get("Mother").getName());
	}

	// To display profile of a Teen.
	public void displayProfile() {
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Status: " + this.getStatus());
		System.out.println("Father: " + this.getFather().getName());
		System.out.println("Mother: " + this.getMother().getName());
	}

	// To update profile of a Teen.
	public void updateProfile(Map<String, Person> map) {

		int choice = 0;

		do {
			System.out.println("\n********************************");
			System.out.println("* 1. Update name               *");
			System.out.println("* 2. Update age                *");
			System.out.println("* 3. Update gender             *");
			System.out.println("* 4. Update status             *");
			System.out.println("* 5. Quit                      *");
			System.out.println("********************************");
			System.out.print("Enter an option: ");

			Scanner input = new Scanner(System.in);
			choice = input.nextInt();
			input.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter new name: ");
				String newName = input.nextLine();
				map.put(newName, map.remove(this.getName()));
				this.setName(newName);
				System.out.println("Name updated successfully!!");
				break;
			case 2:
				System.out.println("Enter new age: ");
				int newAge = input.nextInt();
				super.setAge(newAge);
				System.out.println("Age updated successfully!!");
				break;
			case 3:
				System.out.println("Enter new gender: ");
				String newGender = input.nextLine();
				super.setGender(newGender);
				System.out.println("Gender updated successfully!!");
				break;
			case 4:
				System.out.println("Enter new status: ");
				String newStatus = input.nextLine();
				setStatus(newStatus);
				System.out.println("Status updated successfully!!");
				break;
			case 5:
				return;
			default:
				System.out.println("Please input the right option");
			}
		} while (choice != 5);
	}

}
