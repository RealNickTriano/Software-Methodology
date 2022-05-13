package Project2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
class RosterTest {

    @Test
    public void testAdd() {

        // attempting to add the same student twice, should return false
        Student[] studentArray = { };
        Roster myRoster = new Roster(studentArray, 0);
        Profile newProfile = new Profile("name", Major.CS);
        Resident myStudent = new Resident(newProfile, 12,
                0, 0, "--/--/--", 0);
        myRoster.add(myStudent);
        Assertions.assertFalse(myRoster.add(myStudent));

        // attempting to add a student with the same name but different major, should return true
        newProfile = new Profile("name", Major.EE);
        NonResident mySecondStudent = new NonResident(newProfile, 12,
                0, "--/--/--", 0);
        Assertions.assertTrue(myRoster.add(mySecondStudent));

    }

    @Test
    public void testRemove() {

        // attempting to remove a student on the roster, should return true
        Student[] studentArray = { };
        Roster myRoster = new Roster(studentArray, 0);
        Profile newProfile = new Profile("name", Major.CS);
        Resident myStudent = new Resident(newProfile, 12,
                0, 0, "--/--/--", 0);
        myRoster.add(myStudent);
        Assertions.assertTrue(myRoster.remove(myStudent));


        // attempting to remove a student twice from the roster, should return false
        Assertions.assertFalse(myRoster.remove(myStudent));

        // attempting to remove a student who does not exist, should return false
        newProfile = new Profile("name", Major.EE);
        International intlStudent = new International(newProfile, 0, true, 0, "--/--/--", 0);
        Assertions.assertFalse(myRoster.remove(intlStudent));
    }
}