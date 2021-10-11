package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class DateTest {

    /** Testbed main for the Date class */
    public static void main( String[] args ){
        //test case #1, a date with a year less than 1980 should be invalid.
        Date date = new Date( "11/1/1979" );
        boolean expectedResult = false;
        boolean result = date.isValid();
        System.out.print( "Test case #1: " );
        if ( result == expectedResult ){
            System.out.println( "Pass." );
        }
        else{
            System.out.println( "Fail." );
        }

        //test case #2, a date beyond today's date should be invalid.
        date = new Date();
        date.setDay( date.getDay() + 1 );
        result = date.isValid();
        System.out.print( "Test case #2: " );
        if ( result == expectedResult ){
            System.out.println( "Pass." );
        }
        else{
            System.out.println( "Fail." );
        }

        //test case #3, a date with an invalid month.
        date = new Date( "13/1/2020" );
        result = date.isValid();
        System.out.print( "Test case #3: " );
        if ( result == expectedResult ){
            System.out.println( "Pass." );
        }
        else{
            System.out.println( "Fail." );
        }

        //test case #4, an invalid month.
        date = new Date( "0/22/2020" );
        result = date.isValid();
        System.out.print( "Test case #4: " );
        if ( result == expectedResult ){
            System.out.println( "Pass." );
        }
        else{
            System.out.println( "Fail." );
        }

        //test case #5, another invalid leap year day.
        date = new Date( "2/29/2018" );
        result = date.isValid();
        System.out.print( "Test case #5: " );
        if ( result == expectedResult ){
            System.out.println( "Pass." );
        }
        else{
            System.out.println( "Fail." );
        }

        //test case #6, an invalid day (April has 30 days).
        date = new Date( "4/31/2021" );
        result = date.isValid();
        System.out.print( "Test case #6: " );
        if ( result == expectedResult ){
            System.out.println( "Pass." );
        }
        else{
            System.out.println( "Fail." );
        }

        //test case #7, ensure 2000 is considered a leap year.
        date = new Date( "2/29/2000" );
        expectedResult = true;
        result = date.isValid();
        System.out.print( "Test case #7: " );
        if ( result == expectedResult ){
            System.out.println( "Pass." );
        }
        else{
            System.out.println( "Fail." );
        }

        //test case #8, an invalid day (January has 31 days).
        date = new Date( "1/32/2021" );
        expectedResult = false;
        result = date.isValid();
        System.out.print( "Test case #8: " );
        if ( result == expectedResult ){
            System.out.println( "Pass." );
        }
        else{
            System.out.println( "Fail." );
        }
    }
}
