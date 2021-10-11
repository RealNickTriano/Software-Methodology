package Project2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
class RosterTest {

    @Test
    public void testAdd() {
        Student[] studentArray;
        Roster myRoster = new Roster(studentArray, 0);
        Student myStudent = new Student();
        myRoster.add(myStudent);
        Assertions.assertfalse(myRoster.add(myStudent));

    }

    @Test
    public void testRemove() {

    }
}