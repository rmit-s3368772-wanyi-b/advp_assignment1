import java.util.*;

/**
 * Class to handle the minimum requirements to create a person.
 * @author Wan Yi Beh
 */

public abstract class Person {

   // variables
   private String name;
   private int age;
   private String gender;


   // constructors
   public Person(String _name, int _age, String _gender) {
      this.name = _name;
      this.age = _age;
      this.gender = _gender;
   }

   // accessors
   public String getName()
   {
      return name;
   }

   public int getAge()
   {
      return age;
   }

   public String getGender()
   {
      return gender;
   }

   // mutators
   public void setName(String name)
   {
      this.name = name;
   }

   public void setAge(int age)
   {
      this.age = age;
   }

   public void setGender(String gender)
   {
      this.gender = gender;
   }
   
   

//   public void displayProfile(Map<String, Person> ppl){
//      Scanner input = new Scanner(System.in);
//      System.out.println("Enter name: ");
//      String name = input.nextLine();
//
//      Set set = ppl.entrySet();
//
//      // get an iterator
//      Iterator iterator = set.iterator();
//
//      // display list of details
//      System.out.println("=====LIST NAMES OF MARRIED PEOPLE====");
//      while (iterator.hasNext()) {
//         Map.Entry list = (Map.Entry) iterator.next();
//         if (input.equals( ((Person) list.getKey()) ) )
//         {
//            System.out.println("Name: " + list.getKey());
//            System.out.println("Age: " + ((Person) list.getValue()).getAge());
//            System.out.println("Gender: " + ((Person) list.getValue()).getGender());
//         }
//      }
//   }

}
