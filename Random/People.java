public class People implements Comparable<People>{
	
	private int id;
	private String firstName;
	private String lastName;
	
	public People() {
		super();
	}

	public People(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String toString() {
		
		return id + " " + firstName + " " + lastName;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int compareTo(People o) {
		if (this.firstName.compareTo(o.getFirstName()) < 0) {
			return -1;
		}
		else if (this.firstName.compareTo(o.getFirstName()) > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
}
