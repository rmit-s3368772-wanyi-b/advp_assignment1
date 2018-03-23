import java.util.*;

/**
<<<<<<< HEAD
* Abstract class of Person that contains
* subclasses such as: Adult, Teen, and Infant.
*
* @author  Wan Yi Beh (S3368772)
* @version 1.0
* @since   2018-03-23
*/

public abstract class Person {

=======
 * Class to handle the minimum requirements to create a person.
 * 
 * @author Huani Neupane (s3685849)
 */

public abstract class Person {

	// Attributes
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	private String name;
	private int age;
	private String gender;

<<<<<<< HEAD
=======
	// Constructors
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	public Person(String _name, int _age, String _gender) {
		this.name = _name;
		this.age = _age;
		this.gender = _gender;
	}

<<<<<<< HEAD
	/**
     * Accessor
     * @return name of Person.
     * @return age of Person.
     * @return gender of Person.
     */

=======
	// Accessors
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

<<<<<<< HEAD
	/**
     * Mutators
     * @param name of Person.
     * @param age of Person.
     * @param gender of Person.
     */

=======
	// Mutators
>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
	public void setName(String _name) {
		this.name = _name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	// To display profile of different types.
	public abstract void displayProfile();

<<<<<<< HEAD
	// To update profile of different types.
	public abstract void updateProfile(Map<String,Person> map);

	// To display a list of family members.
	public abstract void listFamilyMembers();
=======
	public abstract void listFamilyMembers();

	public abstract void updateProfile(Map<String, Person> map);

>>>>>>> d040b8d49809c72f9744d8c25cef00b38dbfb1bf
}
