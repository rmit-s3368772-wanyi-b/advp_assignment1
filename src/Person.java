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
   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }

   public String getGender() {
      return gender;
   }

   // mutators
   public void setName(String name) {
      this.name = name;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }


}
