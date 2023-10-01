package project1;
import java.util.Calendar;
/**
 An instance of this class holds a date
 Provides multiple methods that check if a date follows criteria to be considered valid
 @author Donald Yubeaton, Micheal Kassie
 */
public class Date implements Comparable<Date>  {
    private int year;
    private int month;
    private int day;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUARTERCENTENNIAL = 400;

    // Add 7 instead of 6 to account for Calendar using 0-based months
    public static final int WITHINSIXMONTHS = 7;

    /**
     Parameterized Constructor
     @param month the Date's month
     @param day the Date's day
     @param year the Date's year
     */
    public Date(int month,int day,int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     Checks if a Date is a valid calendar date
     
     */
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
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30; // April, June, September, and November have 30 days.
        } else {
            return day <= 31; // All other months have 31 days.
        }
    }

    public static boolean isLeap(Date d){
        if(d.year%QUADRENNIAL!=0){
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
        c1.set(Calendar.DAY_OF_MONTH, o.getDay());

        c2.set(Calendar.MONTH, this.getMonth());
        c2.set(Calendar.YEAR, this.getYear());
        c2.set(Calendar.DAY_OF_MONTH, this.getDay());


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



        Calendar date = Calendar.getInstance();
        Calendar currentDate = Calendar.getInstance();
        //System.out.println("Current Date: " + currentDate.toString());

        currentDate.add(Calendar.MONTH, WITHINSIXMONTHS);
        //System.out.println("6 Months From Now: " + currentDate.toString());
        //System.out.println("Date to add: " + date.toString());
        date.set(Calendar.MONTH, this.getMonth());
        date.set(Calendar.YEAR, this.getYear());
        date.set(Calendar.DAY_OF_MONTH, this.getDay());



        return date.before(currentDate);
    }
    @Override
    public String toString(){

        String s;
        s = month+"/"+ day+"/"+year;
        return s;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Date) {
            Date date = (Date) obj; //type casting from Object to Student
            return this.year == date.year && this.month == date.month && this.day == date.day;
        }
        return false;
    }





}
