import java.util.*;

/**
 *
 * @author Wan Yi Beh
 *  */


public class Driver {

	Map<String, Person> ppl = new HashMap<>();

    public Driver (Map<String, Person> _ppl) {
	   this.ppl = _ppl;
    }
 
    public void initialiseObj (Map<String, Person> _ppl) {
    		_ppl.put("Alice", new Adult("Alice", 27, "F", "work in KFC"));
		_ppl.put("Bob", new Adult("Bob", 28, "M","CEO"));
//		_ppl.put("Fiona", new Teen("Fiona", 12, "student"));
//		_ppl.put("Gigi", new Teen("Gigi", 10, "student"));
//		_ppl.put("Ivan", new Teen("Ivan", 2));
    }
	 
	int select;
	 Scanner input = new Scanner(System.in);


   public void runNet(){
      do {

         displayMenu();
         select = input.nextInt();

         switch (select){
            case 1: // list everyone
               displayAll(profile);
               break;

            case 2: // select a profile
               displayProfile();
               break;

            case 3:
               //displayAll();
         }
      } while (select !=4);
   }


   // 0 main menu
   private void displayMenu(){
      System.out.println("\n********************************");
      System.out.println("* ======== MiniNet Menu =======  *");
      System.out.println("* 1. List everyone               *");
      System.out.println("* 2. Select a profile            *");
      System.out.println("* 3. Add a profile               *");
      System.out.println("* 4. Update a profile            *");
      System.out.println("* 5. Are they friends?           *");
      System.out.println("* 6. Delete profile              *");
      System.out.println("* 7. Find their parents/children *");
      System.out.println("* 8. Quit                        *");
      System.out.println("**********************************");
      System.out.print("Enter an option: ");
   }

   // 1. list all people
   public void displayAll() {
	   
   }

   // 2. display a profile
   public void displayProfile(){
      System.out.println("");
   }

   // 3. add a profile
   public void addPerson() {
	   
   }

   // 4. update profile
   public void updateProfile(){
         System.out.println("\n********************************");
         // System.out.println("*" + getName() + "'s Profile  *");
         System.out.println("* 1. Update name               *");
         System.out.println("* 2. Update age                *");
         System.out.println("* 3. Update gender             *");
         System.out.println("* 4. Update status             *");
         System.out.println("* 5. Quit                      *");
         System.out.println("********************************");
         System.out.print("Enter an option: ");

      // System.out.println("Please input new name: ");
      // person.setName(input.next());
      // System.out.println("Changes saved successfully.");
         
    // 5. Are they friends
         
    //6. Delete profile
         
    //7. Find parents/children
         
    // 8. QUIT!!!
         
   }
}