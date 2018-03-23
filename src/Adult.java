import java.util.*;
import java.util.Map.Entry;


 /**
 * Class to handle the requirements to create an Adult.
 *
 * @author  Huani Neupane (s3685849)
 * @version 1.0
 * @since   2018-03-23
 */

class Adult extends Person implements Friends{

<<<<<<< HEAD
=======
	// Attributes
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	private String status;
	private Adult partner;
	private Map<String, Adult> friends = new HashMap<>();
	private Map<String, Person> children = new HashMap<>();

<<<<<<< HEAD
=======
	// Constructor
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	public Adult(String _name, int _age, String _gender, String _status) {
		super(_name, _age, _gender);
		this.status = _status;
	}

<<<<<<< HEAD
	/**
     * Accessor
     * @return status of Person.
     * @return partner of Person.
     */
=======
	// Accessors
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	public String getStatus() {
		return this.status;
	}

	public Adult getPartner() {
		return this.partner;
	}

<<<<<<< HEAD
	/**
     * Mutators
     */

 	public String displayPartner() {
 		return this.partner.getName();
 	}

	// To add friend to an Adult.
	public boolean addFriend(Person person)
	{
		if (person.getAge() > 16)
		{
=======
	// Mutators

	public boolean addFriend(Person person) {
		if (person.getAge() > 16) {
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
			this.friends.put(person.getName(), (Adult) person);
			((Adult) person).friends.put(this.getName(), this);
			return true;
		}
		return false;
	}

<<<<<<< HEAD
	// To set status to an Adult.
=======
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	public void setStatus(String status) {
		this.status = status;
	}

	// To set partner to an Adult.
	public void setPartner(Adult _partner) {
		// Assumption: no divorce/changing partner allowed
		if (this.partner != null) {
			System.out.println(" -->WARNING: Attempted to SET PARTNER\n"
					+ "             to a MARRIED person!!!");
			return;
		}
<<<<<<< HEAD
=======

>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
		this.partner = _partner;
		_partner.partner = this;
	}

<<<<<<< HEAD
	// To set child to an Adult.
=======
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	public void setChild(Person a) {
		this.children.put(a.getName(), a);
	}

	// To display a list of friends of an Adult.
	public void displayFriendList() {
		// get set of the entries
		Set set = this.friends.entrySet();

		// get an iterator
		Iterator iterator = set.iterator();

		// display the list
		System.out.println("=====LIST NAMES OF FRIENDS====");
		byte count = 0;
		while (iterator.hasNext()) {
			count++;
			Map.Entry list = (Map.Entry) iterator.next();
			System.out.println(count + ". " + list.getKey());
		}
	}

<<<<<<< HEAD
	// To display a list of family members of an Adult.
	public void listFamilyMembers() {

		if (this.children.size() == 0)
		{
			System.out.println(this.getName() + " has no children, unfortunately!");
=======
	// display partner
	public String displayPartner() {
		return this.partner.getName();
	}

	// display family members (parents/child(ren))
	public void listFamilyMembers() {

		if (this.children.size() == 0) {
			System.out.println(
					this.getName() + " has no children, unfortunately!");
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
			return;
		}

		// get set of the entries
		Set set = this.children.entrySet();

		// get an iterator
		Iterator iterator = set.iterator();

		// display the list
		System.out.println("===== My Children ====");
		byte count = 0;
		while (iterator.hasNext()) {
			count++;
			Map.Entry list = (Map.Entry) iterator.next();
			System.out.println("Child " + count + ": " + list.getKey());
		}
	}

	// To check if the two Adults are friends.
	public boolean isFriend(Person a) {
		return this.friends.containsKey(a.getName()) == true ? true : false;
	}

	// To display profile of an Adult.
	public void displayProfile() {
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Status: " + this.getStatus());
		if (this.getPartner() != null) {
			System.out.println("Partner: " + this.getPartner().getName());
		}
	}

<<<<<<< HEAD

	// To update profile of an Adult.
	public void updateProfile(Map<String,Person> map) {
=======
	public void updateProfile(Map<String, Person> map) {
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
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
<<<<<<< HEAD
=======

>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
}
