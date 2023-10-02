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

    public static final int MONTH_JANUARY = 1;

    public static final int MONTH_FEBRUARY = 2;

    public static final int MONTH_APRIL = 4;

    public static final int MONTH_JUNE = 6;

    public static final int MONTH_SEPTEMBER = 9;

    public static final int MONTH_NOVEMBER = 11;

    public static final int MONTH_DECEMBER = 12;

    public static final int FEBRUARY_DAYS = 28;

    public static final int FEBRUARY_LEAP_DAYS = 29;

    public static final int THIRTY_DAYS = 30;

    public static final int THIRTY_ONE_DAYS = 31;

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
     @return true if the date is a valid calendar date, false otherwise
     */
    public boolean isValid(){

        boolean leap=isLeap(this);
        if(this.month==MONTH_FEBRUARY) {
            if (leap) {
                return this.day >= 1 && this.day <= FEBRUARY_LEAP_DAYS;
            }
            else {
                return this.day >= 1 && this.day <= FEBRUARY_DAYS;

            }
        }
        if(this.month<MONTH_JANUARY|| this.month>MONTH_DECEMBER){
           return false;
        }
        else if (month == MONTH_APRIL || month == MONTH_JUNE || month == MONTH_SEPTEMBER || month == MONTH_NOVEMBER) {
            return this.day <= THIRTY_DAYS;
        } else {
            return this.day <= THIRTY_ONE_DAYS;
        }
    }

    /**
     Checks if a date occurs during a leap year
     @param date the date being checked
     @return true if the date occurs during a leap year, false otherwise
     */
    public static boolean isLeap(Date date){
        if(date.year%QUADRENNIAL!=0){
            return false;

        }
        if(date.year%CENTENNIAL==0){
            if(date.year%QUARTERCENTENNIAL!=0){
                return false;
            }
        }
        else{
            return true;
        }
        return false;

    }



    /**
     Returns the Date's year
     @return the Date's year
     */
    public int getYear() {
        return year;
    }

    /**
     Returns the Date's month
     @return the Date's month
     */
    public int getMonth() {
        return month;
    }

    /**
     Returns the Date's day
     @return the Date's day
     */
    public int getDay() {
        return day;
    }

    /**
     Sets the Date's day
     @param day the new day value for the Date
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     Sets the Date's month
     @param month the new month value for the Date
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     Sets the Date's year
     @param year the new year value for the Date
     */
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
    }







    /**
     Checks if the date is a future date
     @return true if the date is a future date, false otherwise
     */
    public boolean notPast(){
        Calendar b = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, this.getMonth());
        c.set(Calendar.YEAR, this.getYear());
        c.set(Calendar.DAY_OF_WEEK, this.getDay());
        return c.compareTo(b) >= 0;


    }

    /**
     Checks if the date occurs within 6 months
     @return true if the date occurs within 6 months, false otherwise
     */
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
    public static void main(String[] args){
        testFebruaryLeapA();
        testFebruaryLeapB();
        testFebruaryLeapC();

        testFebruaryNonLeapA();
        testFebruaryNonLeapB();
        testFebruaryNonLeapC();

        testOtherMonthsA();
        testOtherMonthsB();
        testOtherMonthsC();
        testOtherMonthsD();
        testOtherMonthsE();

        testMonthA();
        testMonthB();

    }





    private static void testFebruaryLeapA(){
        Date date= new Date(2,29,2020);
        String s= "FebLeapA";
        boolean expectedOutput= true;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }
    private static void testFebruaryLeapB(){
        Date date= new Date(2,30,2016);
        String s= "FebLeapB";
        boolean expectedOutput= false;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }

    private static void testFebruaryLeapC(){
        Date date= new Date(2,0,2012);
        String s= "FebLeapC";
        boolean expectedOutput= false;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }
    private static void testFebruaryNonLeapA(){
        Date date= new Date(2,29,2021);
        String s= "FebNonLeapA";
        boolean expectedOutput= false;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }
    private static void testFebruaryNonLeapB(){
        Date date= new Date(2,28,2023);
        String s= "FebNonLeapB";
        boolean expectedOutput= true;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }
    private static void testFebruaryNonLeapC(){
        Date date= new Date(2,0,2022);
        String s= "FebNonLeapB";
        boolean expectedOutput= false;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }

    private static void testOtherMonthsA(){
        Date date= new Date(1,31,2022);
        String s= "OtherMonthsA";
        boolean expectedOutput= true;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }

    private static void testOtherMonthsB(){
        Date date= new Date(10,31,2007);
        String s= "OtherMonthsB";
        boolean expectedOutput= false;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }
    private static void testOtherMonthsC(){
        Date date= new Date(11,0,2006);
        String s= "OtherMonthsC";
        boolean expectedOutput= false;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }
    private static void testOtherMonthsD(){
        Date date= new Date(1,32,2011);
        String s= "OtherMonthsD";
        boolean expectedOutput= false;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }
    private static void testOtherMonthsE(){
        Date date= new Date(4,30,2011);
        String s= "OtherMonthsD";
        boolean expectedOutput= true;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }

    private static void testMonthA(){
        Date date= new Date(14,4,2013);
        String s= "MonthDaysA";
        boolean expectedOutput= false;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }
    private static void testMonthB(){
        Date date= new Date(12,4,2013);
        String s= "MonthDaysB";
        boolean expectedOutput= true;
        boolean actualOutput= date.isValid();
        testResult(expectedOutput, actualOutput, s);


    }





    private static void testResult(boolean expectedOutput, boolean actualOutput, String s){
        if(expectedOutput!=actualOutput){
            System.out.println("Test case# "+s+" failed");
            return;

        }
        System.out.println("Test case# "+s+" passed");

    }





}
