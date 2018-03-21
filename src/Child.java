/**
 * Class to handle the requirements to create a Child.
 * @author Wan Yi Beh
 */

class Child extends Person {

   // variables
   private Adult father;
   private Adult mother;

   // constructors
   public Child(String name, int age, String gender) {
      super(name, age, gender);
      addParents(father, mother);

      if (age >= 16) {
         throw new IllegalArgumentException("Please enter within range.");
      }
   }

   // get variables
   public Adult getFather() {
      return father;
   }

   public Adult getMother() {
      return mother;
   }

   // set variables


   // add variables
   private void addParents(Adult father, Adult mother) {
      this.father = father;
      this.mother = mother;
   }
}
