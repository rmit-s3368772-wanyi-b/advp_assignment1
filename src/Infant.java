import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Class to handle the requirements to create an Infant.
 *
 * @author Huani Neupane (s3685849)
 * @version 1.0
 * @since 2018-03-23
 */

class Infant extends Person {

	private Map<String, Adult> parents = new HashMap<>();

	public Infant(String name, int age, String gender, Adult father) {
		super(name, age, gender);
		this.parents.put("Father", father);
		this.parents.put("Mother", father.getPartner());
		father.setChild(this);
		father.getPartner().setChild(this);
	}

	/**
	 * Accessor
	 * 
	 * @return father of Person.
	 * @return mother of Person.
	 */

	public Adult getFather() {
		return this.parents.get("Father");
	}

	public Adult getMother() {
		return this.parents.get("Mother");
	}

	// To display profile of an Infant.
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

	// To update profile of an Infant.
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

			choice = 0;

			Scanner input = new Scanner(System.in);
			try {
				int c = input.nextInt();
				choice = c;
			} catch (InputMismatchException e) { // catch if input is not an integer
				System.err.println("Input needs to be an integer ");
			}

			switch (choice) {
			case 1:
				input.nextLine(); // to read the "enter" from user
				System.out.println("Enter new name: ");
				String newName = input.nextLine();
				map.put(newName, map.remove(this.getName()));
				this.setName(newName);
				System.out.println("Name updated successfully!!");
				break;
			case 2:
				System.out.println("Enter new age: ");
				try {
					int newAge = input.nextInt();
					super.setAge(newAge);
					System.out.println("Age updated successfully!!");
				} catch (InputMismatchException e) {
					System.err.println("Sorry, input needs to be an interger");
				}
				break;
			case 3:
				input.nextLine(); // to read the "enter" from user
				System.out.println("Enter new gender (Male/Female): ");
				String newGender = input.nextLine();
				if (newGender.equals("Male") || newGender.equals("Female")) {
					super.setGender(newGender);
					System.out.println("Gender updated successfully!!");
				} else {
					System.out.println("Sorry, you have input an invalid Gender");
				}
				break;
			case 4:
				return;
			default:
				System.out.println("Please input the right option");
			}
		} while (choice != 4);

	}

}
