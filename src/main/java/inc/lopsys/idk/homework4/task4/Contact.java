package inc.lopsys.idk.homework4.task4;

class Contact {
    private String firstName;
    private String lastName;

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return (lastName != null ? lastName + " " + firstName : firstName);
    }
}
