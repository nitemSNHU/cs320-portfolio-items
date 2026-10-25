import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContact() {

        ContactService service = new ContactService();

        Contact contact = new Contact( // Taken from previously tested correct contact
                "123abc",
                "Name",
                "Last",
                "0123456789",
                "123 Address Drive"
        );
    }

    @Test
    void testAddMatchingIDs() {

        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                "123abc",
                "Name",
                "Last",
                "0123456789",
                "123 Address Drive"
        );

        Contact contact2 = new Contact(
                "123abc",
                "Name2",
                "Last2",
                "1234567890",
                "124 Address Drive"
        );

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    void testAddNullContact() {

        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    void testDeleteContact() { // Had to look this up on google. Tested to ensure that deleting a contact fails after successfully deleting once.

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "123abc",
                "Name",
                "Last",
                "0123456789",
                "123 Address Drive"
        );

        service.addContact(contact);
        service.deleteContact("123abc");

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("123abc");
        });
    }

    @Test
    void testDeleteContactInvalidID() {

        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("NonexistentIDTest");
        });
    }

    @Test
    void testChangeFirstName() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "123abc",
                "Name",
                "Last",
                "0123456789",
                "123 Address Drive"
        );

        service.addContact(contact);
        service.changeFirstName("123abc", "Name2");

        assertEquals("Name2", contact.getFirstName());
    }

    @Test
    void testChangeLastName() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "123abc",
                "Name",
                "Last",
                "0123456789",
                "123 Address Drive"
        );

        service.addContact(contact);
        service.changeLastName("123abc", "Last2");

        assertEquals("Last2", contact.getLastName());
    }

    @Test
    void testChangeNumber() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "123abc",
                "Name",
                "Last",
                "0123456789",
                "123 Address Drive"
        );

        service.addContact(contact);
        service.changeNumber("123abc", "1234567890");

        assertEquals("1234567890", contact.getNumber());
    }

    @Test
    void testChangeAddress() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "123abc",
                "Name",
                "Last",
                "0123456789",
                "123 Address Drive"
        );

        service.addContact(contact);
        service.changeAddress("123abc", "124 Address Drive");

        assertEquals("124 Address Drive", contact.getAddress());
    }

    @Test
    void testChangeInvalidID() {

        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.changeFirstName("invalidtestingAgain", "Name2");
        });
    }
}