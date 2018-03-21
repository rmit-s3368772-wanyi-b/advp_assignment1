import java.util.*;

/**
 *
 * @author huanineupane
 *
 */

class Infant extends Person implements Profile {

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

	@Override
	public void displayProfile() {
		// TODO Auto-generated method stub
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Father: " + this.getFather().getName());
		System.out.println("Mother: " + this.getMother().getName());	
	}

	@Override
	public void updateProfile(Map<String,Person> map) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
	     System.out.println("Enter a name from the existing list please: ");
	     String oldName = input.nextLine();
	     
	     if (map.get(oldName) != null) {
	    	 	System.out.println(oldName + "found! ");
	     }else
	     {
	    	  	System.out.println("Name not found! ");
	    	  	return;
	     }
	   
       System.out.println("\n********************************");
       System.out.println("* 1. Update name               *");
       System.out.println("* 2. Update age                *");
       System.out.println("* 3. Update gender             *");
       System.out.println("* 4. Quit                      *");
       System.out.println("********************************");
       System.out.print("Enter an option: ");
       
    
       System.out.println("Enter your choice please: ");
       int choice = input.nextInt();
       
       switch(choice) {
      	 	case 1 : 
      	 		System.out.println("Enter new name: ");
      	        String newName = input.nextLine();
      	        super.setName(newName);
      	        System.out.println("Name updated successfully!!");
      	        break;
      	 	case 2 :
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
	
	}



}
