import java.util.*;
import java.util.Map.Entry;

/**
 * Class to handle the requirements to create an Adult.
 * @author huanineupane
 */

class Adult extends Person {

   // variables
   private String status;
   private Adult partner;
   private Map<String, Adult> friends;
   private Map<String, Person> children;

   // constructor
   public Adult(String _name, int _age, String _gender, String _status)
   {
      super(_name, _age, _gender);
      this.status = _status;
   }
   
   // accessor
   public String getStatus()
   {
      return this.status;
   }

   public Adult getPartner()
   {
      return this.partner;
   }


   // mutators
   
   public void setStatus(String status)
   {
      this.status = status;
   }

   public void setPartner (Adult partner)
   {
      this.partner = partner;
   }

   public void setChild (Person a)
   {
      this.children.put(a.getName(),a );
   }

   //displaying the Name of Children 
   public void displayChildren () {

      // get set of the entries
      Set set = this.children.entrySet();

      // get an iterator
      Iterator iterator = set.iterator();

      // display the list
      System.out.println("=====LIST NAMES OF FRIENDS====");
      while (iterator.hasNext()) {
         Map.Entry list = (Map.Entry) iterator.next();
         System.out.println(list.getKey());//Since Key is a copy of obj name
      }
   }

   // display friend list
   public void displayFriendList ()
   {
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

   //display partner
   public String displayPartner()
   {
      return this.partner.getName();
   
   }

   // check if 2 person are friends
   public boolean isFriend(Person a)
   {
      return this.friends.containsKey(a.getName()) == true ? true : false ;

   }

	
	public void displayProfile() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.println("Enter the name of person : ");
		String name = input.nextLine();
		
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Status: " + this.getStatus());
		if (this.getPartner() != null) {
			System.out.println("Partner: " + this.getPartner().getName());
		}
	}
	
	
	public void updateProfile(Map<String,Person> map) {
	
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
        System.out.println("* 4. Update status             *");
        System.out.println("* 5. Quit                      *");
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
