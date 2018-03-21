import java.util.*;

/**
 * Class to handle the requirements to create an Adult.
 * @author Wan Yi Beh
 */

class Adult extends Person {

   private String status;
   private Adult partner;
   private Map<String, Adult> friends;
   private Infant arrInfant[] = new Infant [5];
   private Teen arrTeen[] = new Teen [5];

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
   public void setStatus(String status) {
      this.status = status;
   }
   public void setPartner (Adult partner) {
	   this.partner = partner;
   }

   // display friend list
   public void displayFriendList () {
	     // get set of the entries
         Set set = this.friends.entrySet();

         // get an iterator
         Iterator iterator = set.iterator();

         // display the list
         System.out.println("=====LIST NAMES OF FRIENDS====");
         while (iterator.hasNext()) {
             Map.Entry list = (Map.Entry) iterator.next();
             System.out.println(list.getKey());//Since Key is a copy of obj name
             //Otherwise
             //System.out.println(((Person) list.getValue()).getName());
         }
   }
   
   
   public void isFriend(Person a) {
      // return this.friends.containKey(a.getName()) == true ? true : false;
   }

}
