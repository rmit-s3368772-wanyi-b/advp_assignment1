import java.util.*;

/**
 *
 * @author Wan Yi Beh
 */

public class Driver {

	// variables
	int select;
	Person person = null;
	Map<String, Person> ppl = new HashMap<>();

	// constructors
	public Driver(Map<String, Person> _ppl) {
		this.ppl = _ppl;
	}

	// test cases
	public void initialiseObj(Map<String, Person> _ppl) {
		_ppl.put("Adam Lambert", new Adult("Adam Lambert", 27, "Male", "work in KFC"));
		_ppl.put("Alice", new Adult("Alice", 28, "Female", "CEO"));
		((Adult) _ppl.get("Alice")).setPartner((Adult) _ppl.get("Adam Lambert"));
		_ppl.put("Chandler", new Adult("Chandler", 20, "Male", "Student in RMIT"));
		_ppl.put("Sarah", new Adult("Sarah", 35, "Female", "Writer for Age"));
		_ppl.put("Bob", new Adult("Bob", 34, "Male", "Tradie by day"));
		_ppl.put("Peter", new Adult("Peter", 19, "Male", "Driving a taxi"));
		_ppl.put("Kate", new Adult("Kate", 21, "Female", "Just chilling"));

		((Adult) _ppl.get("Bob")).addFriend((Adult) _ppl.get("Peter"));
		((Adult) _ppl.get("Bob")).addFriend((Adult) _ppl.get("Alice"));
		((Adult) _ppl.get("Alice")).addFriend((Adult) _ppl.get("Peter"));
		((Adult) _ppl.get("Adam Lambert")).addFriend((Adult) _ppl.get("Bob"));
		((Adult) _ppl.get("Kate")).addFriend((Adult) _ppl.get("Alice"));
		
		// _ppl.put("Fiona", new Teen("Fiona", 12, "student","Hate maths"));
		// _ppl.put("Gigi", new Teen("Gigi", 10, "student","Facebooking"));
		// _ppl.put("Ivan", new Infant("Ivan", 2,));
	}

	public void runNet() {

		this.initialiseObj(ppl);

		Scanner input = new Scanner(System.in);

		do {
			displayMenu();
			select = input.nextInt();
			if (!((Integer) select instanceof Integer) || (select < 1) || (select > 8)) {
				System.out.println(" --> Error: invalid input, no such option.");
				continue;
			}

			switch (select) {
			case 1: // list everyone
				displayAll();
				break;

			case 2: // display
				if (selectPerson()) {
					this.person.displayProfile();
				} else
					System.out.println(" --> Error: entered NAME does NOT EXIST.");

				break;

			case 3: // update
				if (selectPerson()) {
					this.person.updateProfile();
				} else
					System.out.println(" --> Error: entered NAME does NOT EXIST.");

				break;

			case 4: // update selected profile
				deletePerson();
				break;

			case 5: // check for direct fiend of another person
				checkFriends();
				break;

			case 6: // add a profile
				Scanner sc = new Scanner(System.in);

				System.out.println("Enter basic info below");
				System.out.printf("%-10s", "- Name: ");
				String _name = sc.nextLine();

				System.out.printf("%-10s", "- Age: ");
				int _age = sc.nextInt();
				sc.nextLine();

				System.out.printf("%-10s", "- Gender: ");
				String _gender = sc.nextLine();

				if (_age > 16) {
					addAdult(_name, _age, _gender);
				} else if (_age > 2) {
					addTeen(_name, _age, _gender);
				} else {
					addInfant(_name, _age, _gender);
				}

				break;

			case 7: // find parents/child
				if (selectPerson()) {
					this.person.listFamilyMembers();
				} else
					System.out.println(" --> Error: entered NAME does NOT EXIST.");

				break;

			case 10:
				System.out.println("Adam's partner: " + ((Adult) this.ppl.get("Adam")).getPartner().getName());
				System.out.println("Alice's partner: " + ((Adult) this.ppl.get("Alice")).getPartner().getName());
				break;

			default:
				break;
			}

		} while (select != 8);
	}

	// public Person selectPerson() {
	// Scanner input = new Scanner(System.in);
	// System.out.println("Enter name: ");
	//
	// return this.ppl.get(input.nextLine());
	// }

	public void checkFriends() {
		// Scanner sc = new Scanner(System.in);
		Person firstPerson;

		System.out.println("\n\n=CHECKING IF 2 PEOPLE ARE FRIENDS=\n");

		System.out.print("- First Person \n  ");
		if (selectPerson()) {
			firstPerson = this.person;
		} else {
			System.out.println(" --> Error: entered NAME does NOT EXIST.");
			return;
		}

		System.out.print("\n- Second Person \n  ");
		if (!selectPerson()) {
			System.out.println(" --> Error: entered NAME does NOT EXIST.");
			return;
		}
		
		//CASE 1: They are both Adult.
		if (firstPerson.getAge() > 16 && this.person.getAge() > 16) {
			if (((Adult) firstPerson).isFriend((Adult) this.person) == true) {
				System.out.println("==> YES, " + firstPerson.getName() 
							+ " is a friend of " + this.person.getName());
				return;
			} else {
				System.out.println("==> NO, " + firstPerson.getName()
							+ " is NOT a friend of " + this.person.getName());
				return;
			}
		}

		//CASE 2: They are both Teen.
		if (firstPerson.getAge() > 2 && firstPerson.getAge() < 17 
		 && this.person.getAge() > 2 && this.person.getAge() < 17) {
			if (((Teen) firstPerson).isFriend((Teen) this.person) == true) {
				System.out.println("==> YES, " + firstPerson.getName() 
							+ " is a friend of " + this.person.getName());
				return;
			} else {
				System.out.println("==> NO, " + firstPerson.getName()
							+ " is NOT a friend of " + this.person.getName());
				return;
			}
		}
		
		
		//CASE 3: Any of them are Infant.
		if (firstPerson.getAge() < 3 || this.person.getAge() < 3) {
			System.out.println(" --> Error: At least 1 of entered name is an infant.\n"
							+ "            An Infant canNOT have any friends.");
			return;
		}
		
		System.out.println(" -->Error: An Adult canNOT be friend with a Teen.");
		return;
	}
	
	public boolean selectPerson() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter name: ");
		String input = sc.nextLine();

		if (this.ppl.containsKey(input)) {
			this.person = this.ppl.get(input);
			return true;
		}

		return false;
	}

	// 0 main menu
	private void displayMenu() {
		System.out.println("\n\n\n********************************");
		System.out.println("* ======== MiniNet Menu =======*");
		System.out.println("* 1. List everyone             *");
		System.out.println("* 2. Display a profile         *");
		System.out.println("* 3. Update a profile          *");
		System.out.println("* 4. Delete a profile          *");
		System.out.println("* 5. Are they friends?         *");
		System.out.println("* 6. Add a profile             *");
		System.out.println("* 7. Find out family members   *");
		System.out.println("* 8. Quit                      *");
		System.out.println("********************************");
		System.out.print("Enter an option: ");
	}

	// 1. list all people
	public void displayAll() {
		// get set of the entries
		Set set = this.ppl.entrySet();

		// get an iterator
		Iterator iterator = set.iterator();

		// display the list
		System.out.println("=====LIST NAMES OF FRIENDS====");
		byte count = 0;
		while (iterator.hasNext()) {
			count++;
			Map.Entry list = (Map.Entry) iterator.next();
			System.out.println(count + ". " + list.getKey());// Since Key is a copy of obj name
		}
	}

	// add a profile
	public void addAdult(String name, int age, String gender) {
		Scanner input = new Scanner(System.in);
		System.out.printf("%-10s", "- Status: ");
		String status = input.nextLine();
		ppl.put(name, new Adult(name, age, gender, status));
	}

	public void addTeen(String name, int age, String gender) {
		Scanner input = new Scanner(System.in);

		System.out.printf("%-10s", "- Status: ");
		String status = input.nextLine();

		displayMarriedPeople();

		System.out.println("- Enter name of one of your parents:  ");
		String parentname = input.nextLine();

		Adult a = verifyMarriedList(parentname);

		Teen teen = new Teen(name, age, gender, status, a, a.getPartner());
		this.ppl.put(name, teen);
		a.setChild(teen);
		a.getPartner().setChild(teen);
	}

	public void addInfant(String name, int age, String gender) {
		Scanner input = new Scanner(System.in);

		displayMarriedPeople();

		System.out.println("- Enter name of one of your parents:  ");
		String parentname = input.nextLine();

		Adult a = verifyMarriedList(parentname);

		Infant infant = new Infant(name, age, gender, a, a.getPartner());
		this.ppl.put(name, infant);
		a.setChild(infant);
		a.getPartner().setChild(infant);

	}

	// display married people list
	public void displayMarriedPeople() {

		Set set = this.ppl.entrySet();

		// get an iterator
		Iterator iterator = set.iterator();

		// display the list of married adult people
		System.out.println("=====LIST NAMES OF MARRIED PEOPLE====");
		byte count = 0;
		while (iterator.hasNext()) {
			count++;
			Map.Entry list = (Map.Entry) iterator.next();
			if ((((Person) list.getValue()) instanceof Adult)) {
				if (((Adult) list.getValue()).getPartner() != null) {
					System.out.println(count + ". " + list.getKey());
				}
			}
		}
	}

	// verify marriage people name input
	public Adult verifyMarriedList(String input) {

		Set set = this.ppl.entrySet();

		// get an iterator
		Iterator iterator = set.iterator();

		// display the list of married adult people
		byte count = 0;
		while (iterator.hasNext()) {
			count++;
			Map.Entry list = (Map.Entry) iterator.next();
			if ((((Person) list.getValue()) instanceof Adult)) {
				if (((Adult) list.getValue()).getPartner() != null) {
					if (input.equals(((Adult) list.getValue()).getName())) {
						return ((Adult) list.getValue());
					}
				}
			}
		}
		return null;
	}

	// 5. Are they friends
<<<<<<< HEAD
	public void checkFriendship() {
=======

	public void checkFriendship() {

>>>>>>> f83a9cdb8555ad953923a3d2b62b9f92119fea4d
	}

	// 6. Delete profile4
	public void deletePerson() {
		// remove person from the list
		if (selectPerson()) {
			this.ppl.remove(this.person.getName());
			System.out.println(" --> " + this.person.getName() + "'s profile: DELETED.");
		} else
			System.out.println(" --> Error: entered NAME does NOT EXIST.");
	}

	// 7. Find parents/children

	// 8. QUIT!!!

}
