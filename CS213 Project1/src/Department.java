public enum Department {
    BAIT("Business Analytics and Information Technology"),
    CS("Computer Science"),
    EE("Electrical Engineering"),
    ITI("Information Technology and Informatics"),
    MATH("Mathematics");

    private final String fullName;

    Department(String fullName)
    {
        this.fullName = fullName;
    }
    public String getFullName()
    {
        return fullName;
    }
}


