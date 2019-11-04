package draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.experimental.categories.Category;
import org.junit.Test;

import draughts.models.StateValue;
import draughts.SmokeTest;

public class LogicTest {

    @Test
    @Category(SmokeTest.class)
    public void testGivenLogicWhenLogicIsCreatedFirstControllerIsStartController() {
        Logic logic = new Logic();
        assertTrue(logic.getController() instanceof StartController);
    }

    @Test
    @Category(SmokeTest.class)
    public void testGivenLogicWhenGameStartThenStatesFlowIsCorrect() {
        Logic logic = new Logic();
        assertEquals(StateValue.INITIAL, logic.getValueState());
        logic.nextState();
        assertEquals(StateValue.IN_GAME, logic.getValueState());
        logic.nextState();
        assertEquals(StateValue.FINAL, logic.getValueState());
        logic.nextState();
        assertEquals(StateValue.EXIT, logic.getValueState());
    }

}
