import java.util.*;

/**
 * 
 * @author Huani Neupane (s3685849)
 */

class Teen extends Person {

	// variables
	private String status;
	private Map<String, Teen> friends = new HashMap<>();
	private Map<String, Adult> parents = new HashMap<>();

	// ppl.get("father");

	// constructor
	public Teen(String name, int age, String gender, String _status, Adult father) {
		super(name, age, gender);
		this.status = _status;
		this.parents.put("Father", father);
		this.parents.put("Mother", father.getPartner());
		father.setChild(this);
		father.getPartner().setChild(this);
	}

	// accessor
	public String getStatus() {
		return status;
	}

	public Adult getFather() {
		return this.parents.get("Father");
	}

	public Adult getMother() {
		return this.parents.get("Mother");
	}

	// mutator
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean addFriend(Person person)
	{
		if (person.getAge() > 2 && person.getAge() < 17)
		{
			this.friends.put(person.getName(), (Teen) person);
			((Teen) person).friends.put(this.getName(), this);
			return true;
		}
		return false;
	}

	// display friend list
	public void displayFriendList() {

		// get set of the entries
		Set set = this.friends.entrySet();

		// get an iterator
		Iterator iterator = set.iterator();

		// display the list
		System.out.println("=====LIST NAMES OF FRIENDS====");
		while (iterator.hasNext()) {
			Map.Entry list = (Map.Entry) iterator.next();
			System.out.println(list.getKey());// Since Key is a copy of obj name
			// System.out.println(((Person) list.getValue()).getName());
		}
	}

	// check if 2 person are friends
	public boolean isFriend(Person a) {
		return this.friends.containsKey(a.getName()) == true ? true : false;
	}

	// display family members
	public void listFamilyMembers() {
		System.out.println("- Father: " + this.parents.get("Father").getName());
		System.out.println("- Mother: " + this.parents.get("Mother").getName());
	}

	public void displayProfile() {
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Status: " + this.getStatus());
		System.out.println("Father: " + this.getFather().getName());
		System.out.println("Mother: " + this.getMother().getName());
	}

	public void updateProfile(Map<String,Person> map) {
		System.out.println("\n********************************");
		System.out.println("* 1. Update name               *");
		System.out.println("* 2. Update age                *");
		System.out.println("* 3. Update gender             *");
		System.out.println("* 4. Update status             *");
		System.out.println("* 5. Quit                      *");
		System.out.println("********************************");
		System.out.print("Enter an option: ");

		Scanner input = new Scanner(System.in);
		System.out.println("Enter your choice please: ");
		int choice = input.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Enter new name: ");
			String newName = input.nextLine();
			map.put( newName, map.remove(this.getName()) );
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
	}

}
