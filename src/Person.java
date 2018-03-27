import java.util.*;

/**
* Abstract class of Person that contains
* subclasses such as: Adult, Teen, and Infant.
*
* @author  Wan Yi Beh (S3368772)
* @version 1.0
* @since   2018-03-23
*/

public abstract class Person {

	// Attributes
	private String name;
	private int age;
	private String gender;

	// Constructors
	public Person(String _name, int _age, String _gender) {
		this.name = _name;
		this.age = _age;
		this.gender = _gender;
	}

	/**
     * Accessor
     * @return name of Person.
     * @return age of Person.
     * @return gender of Person.
     */
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	/**
     * Mutators
     * @param name of Person.
     * @param age of Person.
     * @param gender of Person.
     */
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

	// To display a list of family members.
	public abstract void listFamilyMembers();

	// To update profile of different types.
	public abstract void updateProfile(Map<String, Person> map);

}
