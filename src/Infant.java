import java.util.*;

/**
 *
 * @author Huani Neupane (s3685849)
 *
 */

class Infant extends Person {

<<<<<<< HEAD
	private Map<String, Adult> parents = new HashMap<>();

=======
	// Attributes
	private Map<String, Adult> parents = new HashMap<>();

	// Constructor
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	public Infant(String name, int age, String gender, Adult father) {
		super(name, age, gender);
		this.parents.put("Father", father);
		this.parents.put("Mother", father.getPartner());
		father.setChild(this);
		father.getPartner().setChild(this);
	}

<<<<<<< HEAD
	/**
     * Accessor
     * @return father of Person.
     * @return mother of Person.
     */
=======
	// Accessors
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	public Adult getFather() {
		return this.parents.get("Father");
	}

	public Adult getMother() {
		return this.parents.get("Mother");
	}

<<<<<<< HEAD
	// To display profile of an Infant.
=======
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	public void displayProfile() {
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Father: " + this.getFather().getName());
		System.out.println("Mother: " + this.getMother().getName());
	}

	// To display a list of family members of an Infant.
	public void listFamilyMembers() {
		System.out.println("- Father: " + this.parents.get("Father").getName());
		System.out.println("- Mother: " + this.parents.get("Mother").getName());
	}

<<<<<<< HEAD
	// To update profile of an Infant.
	public void updateProfile(Map<String,Person> map) {
		System.out.println("\n********************************");
		System.out.println("* 1. Update name               *");
		System.out.println("* 2. Update age                *");
		System.out.println("* 3. Update gender             *");
		System.out.println("* 4. Quit                      *");
		System.out.println("********************************");
		System.out.print("Enter an option: ");
=======
	public void updateProfile(Map<String, Person> map) {

		int choice = 0;

		do {
			System.out.println("\n********************************");
			System.out.println("* 1. Update name               *");
			System.out.println("* 2. Update age                *");
			System.out.println("* 3. Update gender             *");
			System.out.println("* 4. Quit                      *");
			System.out.println("********************************");
			System.out.print("Enter an option: ");
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf

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
				return;
			default:
				System.out.println("Please input the right option");
			}
		} while (choice != 4);

	}

}
