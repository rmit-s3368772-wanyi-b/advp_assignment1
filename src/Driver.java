import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Wan Yi Beh
 *
 */

public class Driver {

   private int select;
   private Scanner input = new Scanner(System.in);


   public void runNet(){
      do {

         displayMenu();
         select = input.nextInt();

         switch (select){
            case 1: // list everyone
               //displayAll(profile);
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
      System.out.println("* ======= MiniNet Menu ======= *");
      System.out.println("* 1. List everyone             *");
      System.out.println("* 2. Select a profile          *");
      System.out.println("* 3. Add a profile             *");
      System.out.println("* 4. Update a profile          *");
      System.out.println("* 5. Quit                      *");
      System.out.println("********************************");
      System.out.print("Enter an option: ");
   }

   // 1 list all people
   private void displayAll(ArrayList<Person> profile) {
      System.out.println("============");
      int personNum = 1;
      for (Person p : profile) {
         System.out.printf("%d. %s, %s\n\t+ %s\n",
                 personNum, p.getName(), p.getClass().getSimpleName());
         personNum++;
      }
      System.out.println("=============");
   }

   // 2 select a profile
   private void displayProfile(){
      System.out.println("");
   }

   // 3 add a profile

   // 4 update profile

   private void updateProfile(){
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
   }
}