import java.util.*;
import java.util.Map.Entry;

/**
 * Class to handle the requirements to create an Adult.
 * @author Wan Yi Beh
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

}
