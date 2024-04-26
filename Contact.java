package ContactV3;

public class Contact {
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;  // variables to include per contact and the instantiation of a contact object
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		if(contactID == null || contactID.length()>10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if(phone == null || phone.length()!= 10) {
			throw new IllegalArgumentException("Invalid Phone number");
		}
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address"); // this line and the above are to ensure req's are met
		}
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	public String getContactID() { // no setter created for contact Id to ensure immutability
		return contactID;
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
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

}
