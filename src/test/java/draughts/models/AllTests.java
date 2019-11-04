package draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    BoardTest.class,
    CoordinateTest.class,
    GameTest.class,
    PieceTest.class,
    StateTest.class
})

public class AllTests {
}
