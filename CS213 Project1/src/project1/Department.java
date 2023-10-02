package project1;
/**
 * Departments open to events
 * @author Donald Yubeaton, Micheal Kassie
 */
public enum Department {
    BAIT("Business Analytics and Information Technology"),
    CS("Computer Science"),
    EE("Electrical Engineering"),
    ITI("Information Technology and Informatics"),
    MATH("Mathematics");

    private final String fullName;

    /**
     * Enum Constructor
     */
    Department(String fullName)
    {
        this.fullName = fullName;
    }

    /**
     * Returns the Department's full name
     * @return the department's full name
     */
    public String getFullName()
    {
        return fullName;
    }
}


