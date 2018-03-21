/**
 * Class to handle the requirements to create an Adult.
 * @author Wan Yi Beh
 */

class Adult extends Person {
   private String status;
   private Adult partner;

   public Adult(String name, int age, String gender, String status) {
      super(name, age, gender);
      this.status = status;
   }

   // get variables
   public String getStatus() {
      return status;
   }

   public Adult getPartner() {
      return partner;
   }

   // set variables
   public void setStatus(String status) {
      this.status = status;
   }

   //add

   // display
   public void displayAdult() {
      System.out.println("\n********************************");
      System.out.print("Name: " + getName() + "\n");
      System.out.print("Age: " + getAge() + "\n");
      System.out.print("Gender: " + getGender() + "\n");
      System.out.print("Status: " + getStatus() + "\n");
      System.out.println("********************************\n");
   }

   public void isFriend(Person a) {
      // return this.friends.containKey(a.getName()) == true ? true : false;
   }

}
