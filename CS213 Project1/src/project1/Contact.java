package project1;
public class Contact {
    private Department department;
    private String email;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Contact()
    {

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
            String s = c.getEmail().substring(c.getEmail().length()-12);

            if(s.equals("@rutgers.edu")){
                if(c.getDepartment().equals(Department.BAIT) || c.getDepartment().equals(Department.CS)|| c.getDepartment().equals(Department.ITI) || c.getDepartment().equals(Department.EE) || c.getDepartment().equals(Department.MATH))
                {
                    return true;
                }
            }

        }
        return false;
    }

}
