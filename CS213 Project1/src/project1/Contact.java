package project1;
/**
 * This class holds the participant's contact information.
 * Holds the participants email address and department.
 * @author Micheal Kassie, Donald Yubeaton
 */
public class Contact {
    private Department department;
    private String email;

    /**
     * Default Constructor
     */
    public Contact()
    {}

    /**
     * Parameterized constructor
     * @param email   string for the email instance
     * @param department  event's department
     */
    public Contact(String email,Department department) {
        this.email = email;
        this.department= department;
    }
    /**
     * Returns the contact's department
     * @return department instance
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets the Contact's department
     * @param department  the new department of the contact
     */
    public void setDepartment(Department department) {
        this.department = department;
    }


    /**
     * Returns the contact's email
     * @return email  the contact's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the Contact's email
     * @param email  the new email address of the contact
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Checks if a given contact is valid
     * The contact's email and department must fullfill its criteria
     * @param contact the contact to be checked
     * @return true if the domain is @rutgers.edu and the department is valid, false otherwise
     */
    public boolean isValid(Contact contact){
        if(contact.getEmail().contains("@rutgers.edu")){
            String domain = contact.getEmail().substring(contact.getEmail().length()-12);

            if(domain.equals("@rutgers.edu")){
                if(contact.getDepartment().equals(Department.BAIT) || contact.getDepartment().equals(Department.CS)
                        || contact.getDepartment().equals(Department.ITI) || contact.getDepartment().equals(Department.EE)
                        || contact.getDepartment().equals(Department.MATH))
                {
                    return true;
                }
            }

        }
        return false;
    }

}
