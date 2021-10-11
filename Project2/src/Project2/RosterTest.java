package Project2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
class RosterTest {

    @Test
    public void testAdd() {
        Student[] studentArray = { };
        Roster myRoster = new Roster(studentArray, 0);
        Profile newProfile = new Profile("name", Major.CS);
        Resident myStudent = new Resident(newProfile, 12,
                0, 0, "--/--/--", 0);
        myRoster.add(myStudent);
        Assertions.assertFalse(myRoster.add(myStudent));

    }

    @Test
    public void testRemove() {

    }
}