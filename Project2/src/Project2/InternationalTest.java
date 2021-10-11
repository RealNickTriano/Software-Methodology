package Project2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
class InternationalTest {

    @Test
    void checkTuition()
    {
        Profile newProfile = new Profile("name", Major.CS);
        int credits;
        boolean studyAbroad;
        International student;

        // Test case #1: International student with 12 credits:
        credits = 12;
        studyAbroad = false;
        student = new International(newProfile, credits, studyAbroad,
                0, "--/--/--", 0);
        student.tuitionDue();
        Assertions.assertTrue(student.getTuitionDue() == 35655);

        // Test case #2: International student in study abroad program with 12 credits:
        credits = 12;
        studyAbroad = true;
        student = new International(newProfile, credits, studyAbroad,
                0, "--/--/--", 0);
        student.tuitionDue();
        Assertions.assertTrue(student.getTuitionDue() == 5918);

        // Test case #3: International student with 20 credits, not in study abroad:
        credits = 20;
        studyAbroad = false;
        student = new International(newProfile, credits, studyAbroad,
                0, "--/--/--", 0);
        student.tuitionDue();
        Assertions.assertTrue(student.getTuitionDue() == 39519);

        // Test case #4: International student with 20 credits, in study abroad:
        credits = 20;
        studyAbroad = true;
        student = new International(newProfile, credits, studyAbroad,
                0, "--/--/--", 0);
        student.tuitionDue();
        Assertions.assertFalse(student.getTuitionDue() == 39519);

        // Test case #5: International student with 12 credits, in study abroad:
        credits = 12;
        studyAbroad = true;
        student = new International(newProfile, credits, studyAbroad,
                0, "--/--/--", 0);
        student.tuitionDue();
        Assertions.assertFalse(student.getTuitionDue() == 35655);
    }

}