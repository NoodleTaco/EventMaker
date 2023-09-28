
import java.util.Calendar;
public class Date implements Comparable<Date>  {
    private int year;
    private int month;
    private int day;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUARTERCENTENNIAL = 400;
    public boolean isValid(Date d){

        boolean leap=isLeap(d);
        if(d.month==2) {
            if (leap) {
                return d.day >= 1 && d.day <= 29;
            }
            else {
                return d.day >= 1 && d.day <= 28;

            }
        }




        if(d.month<1|| d.month>12){
           return false;
        }

        if(d.getMonth()%2==0){
            return d.getDay() <= 30 && d.getDay() >= 1;

        }
        else{
            return d.getDay() <= 31 && d.getDay() >= 1;
        }
    }

    public static boolean isLeap(Date d){
        if(d.year%QUARTERCENTENNIAL!=0){
            return false;

        }
        if(d.year%CENTENNIAL==0){
            if(d.year%QUARTERCENTENNIAL!=0){
                return false;

            }
        }

        else{
            return true;
        }

        return false;

    }


    public Date(int year,int month,int day) {
        this.year = day;
        this.month = day;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public int compareTo(Date o) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.set(Calendar.MONTH, o.getMonth());
        c1.set(Calendar.YEAR, o.getYear());
        c1.set(Calendar.DAY_OF_WEEK, o.getDay());

        c2.set(Calendar.MONTH, this.getMonth());
        c2.set(Calendar.YEAR, this.getYear());
        c2.set(Calendar.DAY_OF_WEEK, this.getDay());


        return c2.compareTo(c1);




/*
        if(o.getYear()<this.getYear()){
            return 1;

        }
        else if(o.getYear()>this.getYear()){
            return -1;
        }
        else {
            if(o.getMonth()<this.getMonth()){
                return 1;

            }
            else if(o.getMonth()>this.getMonth()){
                return -1;

        }
            else{
                if(o.getDay()<this.getDay()){
                    return 1;

                }
                else if(o.getDay()>this.getDay()){
                    return -1;
            }
                else{
                     return 0;
                }
            }
        }

 */
    }



    /*public static void main(String[] args){
        testLeap();
        testNonLeap();
        TestMonth();

    }*/
    public boolean notPast(){
        Calendar b = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, this.getMonth());
        c.set(Calendar.YEAR, this.getYear());
        c.set(Calendar.DAY_OF_WEEK, this.getDay());
        return c.compareTo(b) >= 0;


    }

    public boolean notLate(){



        Calendar c = Calendar.getInstance();
        Calendar b = Calendar.getInstance();

        b.set(Calendar.MONTH, (Calendar.MONTH+6)%12);
        b.set(Calendar.YEAR, Calendar.YEAR+(this.getMonth()+6)/12);


        c.set(Calendar.MONTH, this.getMonth());
        c.set(Calendar.YEAR, this.getYear());
        c.set(Calendar.DAY_OF_WEEK, this.getDay());

        return b.compareTo(c) >= 0;
    }





}
