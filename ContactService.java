package ContactV3;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	private List<Contact> contacts;
	
	public ContactService() {
		this.contacts = new ArrayList<>();
	}
	
	public void addContact(Contact contact) {
		for (Contact existingContact : contacts) {
			if (existingContact.getContactID().equals(contact.getContactID())) {
				throw new IllegalArgumentException("Contact ID must be unique"); // Check for ID uniqueness within runtime
			}
		}
		contacts.add(contact);
	}

	public void deleteContact(String contactID) {
		Contact contactDelete = null;
		for (Contact contact : contacts) {
			if (contact.getContactID().equals(contactID)) { //deletes by finding the key value within the list array of contactID
				contactDelete = contact;
				break;
			}
		}
		if (contactDelete != null) {
			contacts.remove(contactDelete); //deletion is done through the remove cmd
		} else {
			throw new IllegalArgumentException("Contact not found"); // error check
		}
			}
	
	public void updateContact(String contactID, String firstName, String lastName, String phone, String address){
		for (Contact contact : contacts) {
			if (contact.getContactID().equals(contactID)) {
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
			contact.setPhone(phone);
			contact.setAddress(address);
			return;
			}
	}
		throw new IllegalArgumentException("Contact not found");

	}
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public Contact getContactByID(String contactID) {
		for (Contact contact : contacts) {
			if (contact.getContactID().equals(contactID)) {
				return contact;
			}
		}
		return null;
	}
}
