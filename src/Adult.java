import java.util.*;
import java.util.Map.Entry;

/**
 * Class to handle the requirements to create an Adult.
 * @author Wan Yi Beh
 */

class Adult extends Person implements Profile{

   // variables
   private String status;
   private Adult partner;
   private Map<String, Adult> friends;
   private Person children[] = new Person [20];

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


   //displaying the Name of Children 
   public void displayChildren () {
	   for (Person a : children ) {
		   System.out.println(a.getName());
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
      while (iterator.hasNext()) {
          Map.Entry list = (Map.Entry) iterator.next();
          System.out.println(list.getKey());//Since Key is a copy of obj name

          // System.out.println(((Person) list.getValue()).getName());
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
		Scanner input = new Scanner (System.in);
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
        
        switch(choice) {
       	 	case 1 : 
       	 		System.out.println("Enter your name: ");
       	        String name = input.nextLine();
       	        
	}
	
}
