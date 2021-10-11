package Project2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
class DateTest {

    @Test
    void isValid() {

        Date date;

        //test case #1, a date with a year less than 2021 should be invalid.
        date = new Date( "6/1/2020" );
        Assertions.assertFalse(date.isValid());

        //test case #2, a date beyond today's date should be invalid.
        date = new Date();
        date.setDay( date.getDay() + 1 );
        Assertions.assertFalse(date.isValid());

        //test case #3, a date with an invalid month.
        date = new Date( "13/1/2021" );
        Assertions.assertFalse(date.isValid());

        //test case #4, an invalid month.
        date = new Date( "0/22/2021" );
        Assertions.assertFalse(date.isValid());

        //test case #5, an invalid day (April has 30 days).
        date = new Date( "4/31/2021" );
        Assertions.assertFalse(date.isValid());

        //test case #6, an invalid day (January has 31 days).
        date = new Date( "1/32/2021" );
        Assertions.assertFalse(date.isValid());

        // test case #7, a valid date
        date = new Date( "8/5/2021" );
        Assertions.assertTrue(date.isValid());

        // test case #8, a valid date
        date = new Date( "2/2/2021" );
        Assertions.assertTrue(date.isValid());
    }
}