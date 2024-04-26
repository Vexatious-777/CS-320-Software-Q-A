package TestV3;
import ContactV3.Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact ("00", "Harrow", "Hark", "5556667777", "66 Dreary Lane");
		assertEquals("00", contact.getContactID());
		assertEquals("Harrow", contact.getFirstName());
		assertEquals("Hark", contact.getLastName());
		assertEquals("5556667777", contact.getPhone());
		assertEquals("66 Dreary Lane", contact.getAddress());
	}
	
	@Test
	void testContactPhoneNotTen() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00", "Harrow", "Hark", "55566", "66 Dreary Lane");
		});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00", "Harrowmorethanten", "Hark", "5556667777", "66 Dreary Lane");
		});
	}
	
	@Test
	void testContactLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
		new Contact("00", "Harrow", "HarkMoreThanTen", "5556667777", "66 Dreary Lane");
	});
	}
	
	@Test
	void testContactAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
		new Contact("00", "Harrowmorethanten", "Hark", "5556667777", "66 Dreary Lane 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30");
	});
	}
	
	@Test
	void testContactUniqueIDTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0123456789023", "Harrowmorethanten", "Hark", "5556667777", "66 Dreary Lane");
	});
	}
}
