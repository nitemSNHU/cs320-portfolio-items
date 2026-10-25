import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private Map<String, Contact> userContacts = new HashMap<>();

    // Add or remove contacts
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        } else if (userContacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact cannot be a duplicate ID of one already existing.");
        } else {
        userContacts.put(contact.getContactID(), contact);
        }
    }

    public void deleteContact(String contactID) {
        if (!userContacts.containsKey(contactID)) {
            throw new IllegalArgumentException("No ID matched the contact to delete.");
        }

        userContacts.remove(contactID);
    }
    
    // Change information
    public void changeFirstName(String contactID, String firstName) {
        Contact contact = getContact(contactID);
        contact.setFirstName(firstName);
    }

    public void changeLastName(String contactID, String lastName) {
        Contact contact = getContact(contactID);
        contact.setLastName(lastName);
    }

    public void changeNumber(String contactID, String number) {
        Contact contact = getContact(contactID);
        contact.setNumber(number);
    }

    public void changeAddress(String contactID, String address) {
        Contact contact = getContact(contactID);
        contact.setAddress(address);
    }

    // Get contact
    private Contact getContact(String contactID) {
        Contact contact = userContacts.get(contactID);

        if (contact == null) {
            throw new IllegalArgumentException("No ID matched the input.");
        }

        return contact;
    }
}
