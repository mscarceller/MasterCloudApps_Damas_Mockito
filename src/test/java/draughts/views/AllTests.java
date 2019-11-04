package draughts.views;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    CancelViewTest.class,
    PieceViewTest.class,
    PlayViewTest.class,
    StartViewTest.class,
    ResumeViewTest.class
})

public class AllTests {
}