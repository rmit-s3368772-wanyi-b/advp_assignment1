import java.util.*;

/**
 * 
 * @author huanineupane
 */

class Teen extends Person {

   // variables
   private String status;
   private Map<String, Teen> friends;
   private Map<String, Adult> parents;

   //ppl.get("father");

   // constructor
   public Teen (String name, int age, String gender, String status, Adult father, Adult mother) {
      super(name, age, gender);
      this.status = status;
      this.parents.put("father", father);
      this.parents.put("mother", mother);
   }

   // accessor
    public String getStatus() {
      return status;
   }

   public Adult getFather() {
      return this.parents.get("father");
   }

   public Adult getMother() {
      return this.parents.get("mother");
   }

   // mutator
   public void setStatus(String status) {
      this.status = status;
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
            //System.out.println(((Person) list.getValue()).getName());
         }
   }

   // display parents list
   public void displayParents() {

      // get set of the entries
      Set set = this.parents.entrySet();

      // get an iterator
      Iterator iterator = set.iterator();

      // display the list
      System.out.println("=====LIST NAMES OF FRIENDS====");
         while (iterator.hasNext())
         {
            Map.Entry list = (Map.Entry) iterator.next();
            System.out.println(list.getKey());//Since Key is a copy of obj name
            if (list.getKey().equals("father"))
            {
                System.out.println("Father: " + ((Person) list.getValue()).getName());
            }
        }
   }

   // check if 2 person are friends
   public boolean isFriend(Person a) {
      return this.friends.containsKey(a.getName()) == true ? true : false ;
   }

}
