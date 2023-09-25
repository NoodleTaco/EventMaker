public class Contact {
    private Department department;
    private String email;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Contact(String email,Department department) {
        this.email = email;
        this.department= department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isValid(Contact c){
        if(c.getEmail().contains("@rutgers.edu")){
            c.getEmail().substring(c.getEmai().length()-12,c.getEmai().length());

        }


    }

}
