package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 The following annotation specifies the test runner to use is
 org.junit.runners.Suite
 */
@RunWith(Suite.class)
/**
 The following annotation run all Java .class listed in the braces.
 Use comma to separate different .class files.
 */
@Suite.SuiteClasses({
        RosterTest.class,
        DateTest.class,
        InternationalTest.class})
public class TestSuite {
//remains empty, used only as a holder for the above annotations.
}

