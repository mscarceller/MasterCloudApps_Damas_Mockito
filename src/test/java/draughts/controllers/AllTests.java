package draughts.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    PlayControllerTest.class,
    CancelControllerTest.class,
    ResumeControllerTest.class,
    LogicTest.class
})
public class AllTests {


}