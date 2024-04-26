package TestV3;
import ContactV3.Contact;
import ContactV3.ContactService;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testAddContact() {
		ContactService contactService = new ContactService();
		
		Contact contact = new Contact("00", "Harrow", "Hark", "5556667777", "66 Dreary Lane");
		
		contactService.addContact(contact);
		
		List<Contact> contacts = contactService.getContacts();
		
		assertFalse(contacts.isEmpty());
		
		assertTrue(contacts.contains(contact));
		
	}
	
	@Test
	void testDeleteContact() {
		ContactService contactService = new ContactService();
		
		Contact contact = new Contact("00", "Harrow", "Hark", "5556667777", "66 Dreary Lane");
		
		contactService.addContact(contact);
		
		contactService.deleteContact("00");
		
		List<Contact> contacts = contactService.getContacts();
		
		boolean contactDeleted = true;
		for (Contact c : contacts) {
			if (c.getContactID().equals("00")) {
				contactDeleted = false;
				break;
			}
		}
		
		assertTrue(contactDeleted);
	}

	@Test
	void testUpdateContact() {
		ContactService contactService = new ContactService();
		
		Contact contact = new Contact("00", "Harrow", "Hark", "5556667777", "66 Dreary Lane");
		contactService.addContact(contact);
		
		contactService.updateContact("00", "Gideon", "Nav", "5556667777", "76 Dreary Lane");
		
		Contact updatedContact = contactService.getContactByID("00");
		
		assertEquals("Gideon", updatedContact.getFirstName());
		assertEquals("Nav", updatedContact.getLastName());
		assertEquals("5556667777", updatedContact.getPhone());
		assertEquals("76 Dreary Lane", updatedContact.getAddress());
	}
}
