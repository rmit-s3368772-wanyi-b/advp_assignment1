import java.util.*;
import java.util.Map.Entry;

/**
 * Class to handle the requirements to create an Adult.
 * 
 * @author Huani Neupane (s3685849)
 */

class Adult extends Person {

	// variables
	private String status;
	private Adult partner;
	private Map<String, Adult> friends = new HashMap<>();
	private Map<String, Person> children = new HashMap<>();

<<<<<<< HEAD
   @Override
   public void displayProfile() {
      // TODO Auto-generated method stub
      System.out.println("Name: " + this.getName());
      System.out.println("Age: " + this.getAge());
      System.out.println("Gender: " + this.getGender());
      System.out.println("Status: " + this.getStatus());
      if (this.getPartner() != null) {
         System.out.println("Partner: " + this.getPartner().getName());
      }
   }
	
	@Override
	public void updateProfile() {
       // TODO Auto-generated method stub
       Scanner input = new Scanner(System.in);
       System.out.println("Enter a name from the existing list please: ");
       String initialName = input.nextLine();

       System.out.println("\n********************************");
       System.out.println("* 1. Update name               *");
       System.out.println("* 2. Update age                *");
       System.out.println("* 3. Update gender             *");
       System.out.println("* 4. Update status             *");
       System.out.println("* 5. Quit                      *");
       System.out.println("********************************");
       System.out.print("Enter an option: ");


       System.out.println("Enter your choice please: ");
       int choice = input.nextInt();

       switch (choice) {
          case 1:
             System.out.println("Enter your name: ");
             String name = input.nextLine();

       }
    }
	
=======
	
	// constructor
	public Adult(String _name, int _age, String _gender, String _status) {
		super(_name, _age, _gender);
		this.status = _status;
	}

	// accessor
	public String getStatus() {
		return this.status;
	}

	public Adult getPartner() {
		return this.partner;
	}

	// mutators
	
	public boolean addFriend(Person person)
	{
		if (person.getAge() > 16)
		{
			this.friends.put(person.getName(), (Adult) person);
			((Adult) person).friends.put(this.getName(), this);
			return true;
		}
		return false;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPartner(Adult _partner) {
		this.partner = _partner;
		_partner.partner = this;
	}


	public void setChild(Person a) {
		this.children.put(a.getName(), a);
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
			Map.Entry list = (Map.Entry) iterator.next();
			System.out.println(count + ". " + list.getKey());
		}
	}

	// display partner
	public String displayPartner() {
		return this.partner.getName();
	}

	// display family members
	public void listFamilyMembers() {
		// get set of the entries

		Set set = this.children.entrySet();

		// get an iterator
		Iterator iterator = set.iterator();

		// display the list
		System.out.println("===== My Children ====");
		byte count = 0;
		while (iterator.hasNext()) {
			Map.Entry list = (Map.Entry) iterator.next();
			System.out.println("Child " + count + ": " + list.getKey());
		}
	}

	// check if 2 person are friends
	public boolean isFriend(Person a) {
		return this.friends.containsKey(a.getName()) == true ? true : false;
	}

	public void displayProfile() {
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Status: " + this.getStatus());
		if (this.getPartner() != null) {
			System.out.println("Partner: " + this.getPartner().getName());
		}
	}

	public void updateProfile() {
		System.out.println("\n********************************");
		System.out.println("* 1. Update name               *");
		System.out.println("* 2. Update age                *");
		System.out.println("* 3. Update gender             *");
		System.out.println("* 4. Update status             *");
		System.out.println("* 5. Quit                      *");
		System.out.println("********************************");
		System.out.print("Enter an option: ");

		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();

		do {
			switch (choice) {
			case 1:
				System.out.println("Enter new name: ");
				String newName = input.nextLine();
				super.setName(newName);
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
		} while (choice == 5);

	}
<<<<<<< HEAD

=======
>>>>>>> a39832e997e5db4ba8586ed4252e12ac4837bcba
>>>>>>> 6b0f89dfbaa10c35382dc107d7626a576b3558a8
}
