import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Class to handle the requirements to create an Adult.
 *
 * @author Huani Neupane (S3685849)
 * @version 1.0
 * @since 2018-03-23
 */

public class Adult extends Person implements Friends {

	// Attributes
	private String status;
	private Adult partner;
	private Map<String, Adult> friends = new HashMap<>();
	private Map<String, Person> children = new HashMap<>();

	// Constructor
	public Adult(String _name, int _age, String _gender, String _status) {
		super(_name, _age, _gender);
		this.status = _status;
	}

	/**
	 * Accessor
	 * 
	 * @return status of Adult.
	 * @return father of Adult.
	 * @return mother of Adult.
	 */
	public String getStatus() {
		return this.status;
	}

	public Adult getPartner() {
		return this.partner;
	}

	/**
	 * Mutator
	 * 
	 * @param status
	 *            of Adult.
	 * @param child
	 *            of Adult.
	 * @param partner
	 *            of Adult.
	 */

	public void setStatus(String status) {
		this.status = status;
	}

	public void setChild(Person a) {
		this.children.put(a.getName(), a);
	}

	public void setPartner(Adult _partner) {
		// Assumption: no divorce/changing partner allowed
		if (this.partner != null) {
			System.out.println("-->WARNING: Attempted to SET PARTNER\n" + "             to a MARRIED person!!!");
			return;
		}

		this.partner = _partner;
		_partner.partner = this;
	}

	// display friend list
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

	// To display profile of Adult.
	public String displayPartner() {
		return this.partner.getName();
	}

	// To display a list of family members of Adult.
	public void listFamilyMembers() {

		if (this.children.size() == 0) {
			System.out.println(this.getName() + " has no children, unfortunately!");
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

	// To check if 2 Adults are direct fiends.
	public boolean isFriend(Person a) {
		return this.friends.containsKey(a.getName()) == true ? true : false;
	}

	// To display profile of a Adult.
	public void displayProfile() {
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Status: " + this.getStatus());
		if (this.getPartner() != null) {
			System.out.println("Partner: " + this.getPartner().getName());
		}
	}

	// To update profile of an Adult.
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

	@Override
	public boolean addFriend(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

}
