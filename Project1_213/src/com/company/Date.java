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

    public boolean isValid()
    {
        return true;
    }

    @Override
    public int compareTo(Date date) {
        return 0;
    }
}
