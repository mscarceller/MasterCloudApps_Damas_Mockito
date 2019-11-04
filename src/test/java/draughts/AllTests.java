package draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    draughts.views.AllTests.class,
    draughts.controllers.AllTests.class,
    draughts.models.AllTests.class
	})
public class AllTests {

}