/**
 * @author Nicholas Triano
 * @author Antonio Ignarra
 */
package com.company;

import java.util.StringTokenizer;
import java.util.Calendar;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public Date(String date) //take “mm/dd/yyyy” and create a Date object
    {
        StringTokenizer st1 = new StringTokenizer(date, "/");
        this.month = Integer.parseInt(st1.nextToken());
        this.day = Integer.parseInt(st1.nextToken());
        this.year = Integer.parseInt(st1.nextToken());

    }
    public Date() //create an object with today’s date (see Calendar class)
    {
        Calendar calendar = Calendar.getInstance();

        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DATE);
        this.year = calendar.get(Calendar.YEAR);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public boolean isValid()
    {
        Calendar calendar = Calendar.getInstance();

        // TODO: Change this method to use compareTo method
        if(month > Constants.MONTHS_IN_YEAR)
            return false;
        if (year < Constants.THE_EIGHTYS || year > calendar.get(Calendar.YEAR))
        {
            return false;
        }

        if( year == calendar.get(Calendar.YEAR) && month > calendar.get(Calendar.MONTH) )
        {
            return false;
        }
        else if( year == calendar.get(Calendar.YEAR) && month == calendar.get(Calendar.MONTH) && day > calendar.get(Calendar.DATE) )
        {
            return false;
        }

        // April, June, September, and November have 30 days
        if (month == Constants.APRIL || month == Constants.JUNE
                || month == Constants.SEPTEMBER || month == Constants.NOVEMBER)
        {
            return day <= Constants.THIRTY_DAYS;
        }
        // Feburary
        else if(month == Constants.FEBURARY)
        {
            // Feburary leap year Algorithm
            if(isLeapYear())
            {
                return day <= Constants.TWENTY_NINE_DAYS;
            }
            else return day <= Constants.TWENTY_EIGHT_DAYS;

        }
        // All other months have 31 days
        else return day <= Constants.THIRTY_ONE_DAYS;
    }

    private boolean isLeapYear()
    {
        if(year % Constants.QUADRENNIAL == 0)
        {
            if(year % Constants.CENTENNIAL == 0)
            {
                return year % Constants.QUATERCENTENNIAL == 0;
            }
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Date date) {

        // if current object is greater return 1
        if (this.year > date.getYear())
            return 1;
        // if current object is less return -1
        else if ( this.year < date.getYear())
            return -1;
        // if year is same but month is ahead, object is greater
        else if (this.year == date.getYear() && this.month > date.getMonth())
            return 1;
        // if year is same but month is before, object is less
        else if (this.year == date.getYear() && this.month < date.getMonth())
            return -1;
        // if month is equal but day is ahead, object is greater
        else if (this.month == date.getMonth() && this.day > date.getDay())
            return 1;
        // if month is equal but day is before, object is less
        else if (this.month == date.getMonth() && this.day < date.getDay())
            return -1;
        // if they are equal return 0
        else
            return 0;

    }
}
