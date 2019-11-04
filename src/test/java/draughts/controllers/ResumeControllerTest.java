package draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import draughts.models.Game;
import draughts.models.State;
import draughts.models.StateValue;

public class ResumeControllerTest {

    @Mock
    Game game;

    @Mock
    State state;

    @InjectMocks
    ResumeController resumeController;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenResumeControllerWhenResumeGameThenStateIsInitalState() {
        when(state.getValueState()).thenReturn(StateValue.INITIAL);
        resumeController.isNewGame(true);
        assertEquals(StateValue.INITIAL,state.getValueState());
        verify(state).reset();
    }

    @Test
    public void testGivenResumeControllerWhenNotResumeGameThenExit() {
        when(state.getValueState()).thenReturn(StateValue.EXIT);
        resumeController.isNewGame(false);
        assertEquals(StateValue.EXIT,state.getValueState());
        verify(state).next();
    }

}