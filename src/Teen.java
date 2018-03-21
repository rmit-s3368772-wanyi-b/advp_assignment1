/**
 * 
 * @author huanineupane
 */

class Teen extends Person {

	private HashMap friends;
	private String status;
	
	//constructor 
	public Teen (String name, int age, String gender, String status) {
		super(name, age, gender);
		this.status = status;
		
	}
	//accessor 
	public String getStatus() {
		return status;
	}
	public String getFriends() {
		return friends;
	}
	//mutator
	public void setStatus(String status) {
		this.status = status;
	}
	public void setFriends(String friends) {
		this.friends = friends;
	}

}
