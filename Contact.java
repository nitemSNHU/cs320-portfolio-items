public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String number;
    private String address;
    
    public Contact(String contactID, String firstName, String lastName,
            String number, String address) {

	 if (contactID == null || contactID.length() > 10) { // Checks that the string is not null and the length isn't above 10 chars
	     throw new IllegalArgumentException("Contact ID cannot be null or above 10 characters.");
	 }
	
	 if (firstName == null || firstName.length() > 10) { // Checks that the string is not null and the length isn't above 10 chars
	     throw new IllegalArgumentException("First name cannot be null or above 10 characters.");
	 }
	
	 if (lastName == null || lastName.length() > 10) { // Checks that the string is not null and the length isn't above 10 chars
	     throw new IllegalArgumentException("Last name cannot be null or above 10 characters.");
	 }
	
	 // Had to use Google to find this regex pattern. I didn't know how else to make sure it was only numbers and not characters.
	 if (number == null || !number.matches("\\d{10}")) { // Checks that the string is not null and the length isn't 10
	     throw new IllegalArgumentException("Phone number can only be digits and cannot be null or not 10 digits exactly.");
	 }
	
	 if (address == null || address.length() > 30) { // Checks that the string is not null and the length isn't above 30 chars
	     throw new IllegalArgumentException("Address cannot be null or above 30 characters.");
	 }
	
	 this.contactID = contactID;
	 this.firstName = firstName;
	 this.lastName = lastName;
	 this.number = number;
	 this.address = address;
    }
	
    
    // Getters.
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    // Setters. Note that contactID may not be changed.
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null or above 10 characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null or above 10 characters.");
        }
        this.lastName = lastName;
    }

    public void setNumber(String number) {
        if (number == null || !number.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number can only be digits and cannot be null or not 10 digits exactly.");
        }
        this.number = number;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null or above 30 characters.");
        }
        this.address = address;
    }
}

