/**
 * Makes a Date object from a string or today's date if given no arguments.
 * Various getters for retrieving data, toString and compareTo method is overwritten.
 * Includes isValid() method for date validation and isLeapYEar() helper method to assist with that.
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
package com.company;

import java.util.StringTokenizer;
import java.util.Calendar;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    /**
     * take a String “mm/dd/yyyy” and creates a Date object
     *
     * @param date String in format of “mm/dd/yyyy” to represent a date
     */
    public Date(String date) {
        StringTokenizer st1 = new StringTokenizer(date, "/");
        this.month = Integer.parseInt(st1.nextToken());
        this.day = Integer.parseInt(st1.nextToken());
        this.year = Integer.parseInt(st1.nextToken());

    }

    /**
     * create an object with today’s date
     */
    public Date() {
        Calendar calendar = Calendar.getInstance();

        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DATE);
        this.year = calendar.get(Calendar.YEAR);
    }

    /**
     * Allows other classes to set the day
     * @param day number of days in month
     */
    public void setDay(int day)
    {
        this.day = day;
    }
    /**
     * Allows other classes to retrieve the day
     *
     * @return day as Int
     */
    public int getDay() {
        return day;
    }

    /**
     * Allows other classes to retrieve the month
     *
     * @return month as Int
     */
    public int getMonth() {
        return month;
    }

    /**
     * Allows other classes to retrieve the year
     *
     * @return year as Int
     */
    public int getYear() {
        return year;
    }

    /**
     * Formats Date object into a string for use in output
     *
     * @return date in String format of month/day/year
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /**
     * Checks the date to see if it is valid or not
     *
     * @return true if date is valid, false if the date is invalid
     */
    public boolean isValid() {
        Calendar calendar = Calendar.getInstance();

        // TODO: Change this method to use compareTo method
        if (month > Constants.MONTHS_IN_YEAR)
            return false;
        if (year < Constants.THE_EIGHTYS || year > calendar.get(Calendar.YEAR)) {
            return false;
        }

        if (year == calendar.get(Calendar.YEAR) && month > calendar.get(Calendar.MONTH)) {
            return false;
        } else if (year == calendar.get(Calendar.YEAR) && month == calendar.get(Calendar.MONTH) && day > calendar.get(Calendar.DATE)) {
            return false;
        }

        // April, June, September, and November have 30 days
        if (month == Constants.APRIL || month == Constants.JUNE
                || month == Constants.SEPTEMBER || month == Constants.NOVEMBER) {
            return day <= Constants.THIRTY_DAYS;
        }
        // Feburary
        else if (month == Constants.FEBURARY) {
            // Feburary leap year Algorithm
            if (isLeapYear()) {
                return day <= Constants.TWENTY_NINE_DAYS;
            } else return day <= Constants.TWENTY_EIGHT_DAYS;

        }
        // All other months have 31 days
        else return day <= Constants.THIRTY_ONE_DAYS;
    }

    /**
     * Helper method to isValid checks for a leap year
     *
     * @return true if date is a leap year, false if not
     */
    private boolean isLeapYear() {
        if (year % Constants.QUADRENNIAL == 0) {
            if (year % Constants.CENTENNIAL == 0) {
                return year % Constants.QUATERCENTENNIAL == 0;
            }
            return true;
        }
        return false;
    }

    /**
     * Compares two Dates and checks if they are less than, equal to, or greater than each other
     *
     * @param date The date to be compared
     * @return 0 if equal, -1 if less than, 1 if greater than
     */
    @Override
    public int compareTo(Date date) {

        if (this.year > date.getYear())
            return 1;
        else if (this.year < date.getYear())
            return -1;
        else if (this.year == date.getYear() && this.month > date.getMonth())
            return 1;
        else if (this.year == date.getYear() && this.month < date.getMonth())
            return -1;
        else if (this.month == date.getMonth() && this.day > date.getDay())
            return 1;
        else if (this.month == date.getMonth() && this.day < date.getDay())
            return -1;
        else
            return 0;

    }

    /** Testbed main for the Date class */
    public static void main(String[] args){
        //test case #1, a date with a year less than 1980 should be invalid.
        Date date = new Date("11/1/1979");
        boolean expectedResult = false;
        boolean result = date.isValid();
        System.out.print("Test case #1: ");
        if (result == expectedResult){
            System.out.println("Pass.");
        }
        else{
            System.out.println("Fail.");
        }

        //test case #2, a date beyond today's date should be invalid.
        date = new Date();
        date.setDay(date.getDay() + 1);
        result = date.isValid();
        System.out.print("Test case #2: ");
        if (result == expectedResult){
            System.out.println("Pass.");
        }
        else{
            System.out.println("Fail.");
        }

        //test case #3, a date with an invalid month.
        date = new Date("13/1/2020");
        result = date.isValid();
        System.out.print("Test case #3: ");
        if (result == expectedResult){
            System.out.println("Pass.");
        }
        else{
            System.out.println("Fail.");
        }

        //test case #4, an invalid leap year day.
        date = new Date("2/29/2021");
        result = date.isValid();
        System.out.print("Test case #4: ");
        if (result == expectedResult){
            System.out.println("Pass.");
        }
        else{
            System.out.println("Fail.");
        }

        //test case #5, another invalid leap year day.
        date = new Date("2/29/2018");
        result = date.isValid();
        System.out.print("Test case #5: ");
        if (result == expectedResult){
            System.out.println("Pass.");
        }
        else{
            System.out.println("Fail.");
        }

        //test case #6, an invalid day (April has 30 days).
        date = new Date("4/31/2021");
        result = date.isValid();
        System.out.print("Test case #6: ");
        if (result == expectedResult){
            System.out.println("Pass.");
        }
        else{
            System.out.println("Fail.");
        }

        //test case #7, ensure 2000 is considered a leap year.
        date = new Date("2/29/2000");
        expectedResult = true;
        result = date.isValid();
        System.out.print("Test case #7: ");
        if (result == expectedResult){
            System.out.println("Pass.");
        }
        else{
            System.out.println("Fail.");
        }

        //test case #8, an invalid day (January has 31 days).
        date = new Date("1/32/2021");
        expectedResult = false;
        result = date.isValid();
        System.out.print("Test case #8: ");
        if (result == expectedResult){
            System.out.println("Pass.");
        }
        else{
            System.out.println("Fail.");
        }
    }

}
