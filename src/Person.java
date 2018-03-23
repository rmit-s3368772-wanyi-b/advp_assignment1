import java.util.*;

/**
 * Class to handle the minimum requirements to create a person.
 * 
 * @author Huani Neupane (s3685849)
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

	// Accessors
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	// Mutators
	public void setName(String _name) {
		this.name = _name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public abstract void displayProfile();

	public abstract void listFamilyMembers();

	public abstract void updateProfile(Map<String, Person> map);

}
