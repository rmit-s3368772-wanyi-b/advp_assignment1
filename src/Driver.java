import java.util.*;

/**
* The MiniNet program implements an application that
* that keeps track of information in a simple social network.
*
* @author  Wan Yi Beh (S3368772)
* @version 1.0
* @since   2018-03-23
*/

public class Driver {

	int select;
	Person person = null;
	Map<String, Person> ppl = new HashMap<>();

	public Driver(Map<String, Person> _ppl) { this.ppl = _ppl; }

	/**
	* Intialise a list of sample people to
	* be tested out on application.
	*/
	public void initialiseObj(Map<String, Person> _ppl) {

		// Initialing a list of Adult(s)
		_ppl.put("Adam Lambert",
				new Adult("Adam Lambert", 27, "Male", "work in KFC"));
		_ppl.put("Alice", new Adult("Alice", 28, "Female", "CEO"));
		_ppl.put("Chandler",
				new Adult("Chandler", 20, "Male", "Student in RMIT"));
		_ppl.put("Sarah", new Adult("Sarah", 35, "Female", "Writer for Age"));
		_ppl.put("Bob", new Adult("Bob", 34, "Male", "Tradie by day"));
		_ppl.put("Peter", new Adult("Peter", 19, "Male", "Driving a taxi"));
		_ppl.put("Kate", new Adult("Kate", 21, "Female", "Just chilling"));

		// Setting partners
		((Adult) _ppl.get("Alice")).setPartner((Adult) _ppl.get("Bob"));
		((Adult) _ppl.get("Sarah")).setPartner((Adult) _ppl.get("Chandler"));
		((Adult) _ppl.get("Kate")).setPartner((Adult) _ppl.get("Adam Lambert"));

		// Initializing a list of Teen(s) and Infant(s)
		_ppl.put("Adam", new Teen("Adam", 8, "Female", "doing PhD at RMIT",
				(Adult) this.ppl.get("Chandler")));
		_ppl.put("Gigi", new Teen("Gigi", 10, "Female",
				"studying at a highschool", (Adult) this.ppl.get("Bob")));
		_ppl.put("Ivan", new Infant("Ivan", 1, "Male",
				(Adult) this.ppl.get("Adam Lambert")));

		// Setting friends
		((Adult) _ppl.get("Bob")).addFriend((Adult) _ppl.get("Peter"));
		((Adult) _ppl.get("Bob")).addFriend((Adult) _ppl.get("Alice"));
		((Adult) _ppl.get("Alice")).addFriend((Adult) _ppl.get("Peter"));
		((Adult) _ppl.get("Adam Lambert")).addFriend((Adult) _ppl.get("Bob"));
		((Adult) _ppl.get("Kate")).addFriend((Adult) _ppl.get("Alice"));
		((Teen) _ppl.get("Adam")).addFriend((Teen) _ppl.get("Gigi"));

	}

	/**
	* Start run application - MiniNet.
	*/
	public void runNet() {

		this.initialiseObj(ppl);

		Scanner input = new Scanner(System.in);

		do {
			displayMenu();
			select = input.nextInt();
			if (!((Integer) select instanceof Integer) || (select < 1) || (select > 8)) {
				System.out.println("--> Error: You entered an invalid input.");
				continue;
			}

			switch (select) {
			case 1: // To list everyone
				displayAll();
				break;

			case 2: // To display profile of a selected person
				if (selectPerson()) {
					this.person.displayProfile();
				} else
					System.out.println("--> Error: Entered name does not exist.");
				break;

			case 3: // To update profile of a selected person
				if (selectPerson()) {
					this.person.updateProfile(this.ppl);
				} else
					System.out.println("--> Error: Entered name does not exist.");
				break;

			case 4: // To delete a person
				deletePerson();
				break;

			case 5: // To verify the direct friendship of 2 person
				checkFriends();
				break;

			case 6: // To add a person
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

			case 7: // To find the family members of selected person
				if (selectPerson()) {
					this.person.listFamilyMembers();
				} else
					System.out.println(" --> Error: entered NAME does NOT EXIST.");
				break;

			case 8:
				System.out.println("Adam's partner: " + ((Adult) this.ppl.get("Adam")).getPartner().getName());
				System.out.println("Alice's partner: " + ((Adult) this.ppl.get("Alice")).getPartner().getName());
				break;

			default:
				break;
			}

		} while (select != 9);
	}

	/**
	*  To display main menu.
	*/
	private void displayMenu() {
		System.out.println("\n\n\n********************************");
		System.out.println("* ======== MiniNet Menu =======*");
		System.out.println("* 1. List everyone             *");
		System.out.println("* 2. Display a profile         *");
		System.out.println("* 3. Add a profile             *");
		System.out.println("* 4. Update a profile          *");
		System.out.println("* 5. Delete a profile          *");
		System.out.println("* 6. Are they friends?         *");
		System.out.println("* 7. Find out family members   *");
		System.out.println("* 8. Quit                      *");
		System.out.println("********************************");
		System.out.print("Enter an option: ");
	}

	/**
	*  To collect user's input on name.
	*/
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

	/**
	*  Main Menu - Case 1: To display a list of all people on the network.
	*/
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

	/**
	*  Main Menu - Case 3: To add an Adult in the network.
	*/
	public void addAdult(String name, int age, String gender) {
		Scanner input = new Scanner(System.in);
		System.out.printf("%-10s", "- Status: ");
		String status = input.nextLine();
		ppl.put(name, new Adult(name, age, gender, status));
	}

	/**
	*  Main Menu - Case 3: To add a Teen in the network.
	*/
	public void addTeen(String name, int age, String gender) {
		Scanner input = new Scanner(System.in);

		System.out.printf("%-10s", "- Status: ");
		String status = input.nextLine();

		displayMarriedPeople();

		System.out.println("- Enter name of one of your parents:  ");
		String parentname = input.nextLine();

		Adult a = verifyMarriedList(parentname);

		Teen teen = new Teen(name, age, gender, status, a);
		this.ppl.put(name, teen);
		a.setChild(teen);
		a.getPartner().setChild(teen);
	}

	/**
	*  Main Menu - Case 3: To add an Infant in the network.
	*/
	public void addInfant(String name, int age, String gender) {
		Scanner input = new Scanner(System.in);

		displayMarriedPeople();

		System.out.println("- Enter name of one of your parents:  ");
		String parentname = input.nextLine();

		Adult a = verifyMarriedList(parentname);

		Infant infant = new Infant(name, age, gender, a);
		this.ppl.put(name, infant);
		a.setChild(infant);
		a.getPartner().setChild(infant);

	}

	/**
	*  Main Menu - Case 5: To delete a person in the network.
	*/
	public void deletePerson() {
		// remove person from the list
		if (selectPerson()) {
			this.ppl.remove(this.person.getName());
			System.out.println(" --> " + this.person.getName() + "'s profile: DELETED.");
		} else
			System.out.println(" --> Error: entered NAME does NOT EXIST.");
	}

	/**
	*  Main Menu - Case 6: To verify the direct friendship of 2 person.
	*/
	public void checkFriends() {

		Person firstPerson;

		System.out.println("\n\n= Verify if 2 people are friends =\n");
		System.out.print("- First Person \n  ");
		if (selectPerson()) {
			firstPerson = this.person;
		} else {
			System.out.println("--> Error: Entered name does not exist.");
			return;
		}

		System.out.print("\n- Second Person \n  ");
		if (!selectPerson()) {
			System.out.println("--> Error: Entered name does not exist.");
			return;
		}

		// Scenario 1: They are both Adults.
		if (firstPerson.getAge() > 16 && this.person.getAge() > 16) {
			if (((Adult) firstPerson).isFriend((Adult) this.person) == true) {
				System.out.println("--> YES, " + firstPerson.getName()
							+ " is a friend of " + this.person.getName());
				return;
			} else {
				System.out.println("--> NO, " + firstPerson.getName()
							+ " is NOT a friend of " + this.person.getName());
				return;
			}
		}

		// Scenario 2: They are both Teens.
		if (firstPerson.getAge() > 2 && firstPerson.getAge() < 17
		 && this.person.getAge() > 2 && this.person.getAge() < 17) {
			if (((Teen) firstPerson).isFriend((Teen) this.person) == true) {
				System.out.println("--> YES, " + firstPerson.getName()
							+ " is a friend of " + this.person.getName());
				return;
			} else {
				System.out.println("--> NO, " + firstPerson.getName()
							+ " is NOT a friend of " + this.person.getName());
				return;
			}
		}

		// Scenario 3: Any of them are Infant.
		if (firstPerson.getAge() < 3 || this.person.getAge() < 3) {
			System.out.println("--> Error: At least 1 of entered name is an infant.\n"
							+ "            An Infant is not allow to have any friends.");
			return;
		}

		System.out.println("--> Error: An Adult is not allowed to be friends with a Teen.");
		return;
	}


	/**
	*  To display a list of coupled people.
	*/
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

	/**
	*  To verify if a person has a partner.
	*/
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
}
