import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {


    @Test
    void testEverythingCorrect() {
        Contact contact = new Contact(
                "123abc",
                "Name",
                "Last",
                "0123456789",
                "123 Address Drive"
        );

        assertEquals("123abc", contact.getContactID());
        assertEquals("Name", contact.getFirstName());
        assertEquals("Last", contact.getLastName());
        assertEquals("0123456789", contact.getNumber());
        assertEquals("123 Address Drive", contact.getAddress());
    }

    @Test
    void testNullID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "Name",
                    "Last",
                    "0123456789",
                    "123 Address Drive"
            );
        });
    }

    @Test
    void testIDOver10Chars() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "123abc123456789",
                    "Name",
                    "Last",
                    "0123456789",
                    "123 Address Drive"
            );
        });
    }

    @Test
    void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "123abc",
                    null,
                    "Last",
                    "0123456789",
                    "123 Address Drive"
            );
        });
    }

    @Test
    void testFirstNameOver10Chars() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "123abc",
                    "Name123456789",
                    "Last",
                    "0123456789",
                    "123 Address Drive"
            );
        });
    }

    @Test
    void testNullLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "123abc",
                    "Name",
                    null,
                    "0123456789",
                    "123 Address Drive"
            );
        });
    }

    @Test
    void testLastNameOver10Chars() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "123abc",
                    "Name",
                    "Last123456789",
                    "0123456789",
                    "123 Address Drive"
            );
        });
    }

    @Test
    void testNullNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "123abc",
                    "Name",
                    "Last",
                    null,
                    "123 Address Drive"
            );
        });
    }

    @Test
    void testNumberExactly10DigitsShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "123abc",
                    "Name",
                    "Last",
                    "1",
                    "123 Address Drive"
            );
        });
    }
    
    @Test
    void testNumberExactly10DigitsLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "123abc",
                    "Name",
                    "Last",
                    "00112233445566778899",
                    "123 Address Drive"
            );
        });
    }

    @Test
    void testNumberHasLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "123abc",
                    "Name",
                    "Last",
                    "A123456789",
                    "123 Address Drive"
            );
        });
    }

    @Test
    void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "123abc",
                    "Name",
                    "Last",
                    "0123456789",
                    null
            );
        });
    }

    @Test
    void testAddressOver30Chars() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "123abc",
                    "Name",
                    "Last",
                    "0123456789",
                    "1234567890123456789012345678901"
            );
        });
    }
}
