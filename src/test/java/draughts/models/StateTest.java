package draughts.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class StateTest {

    @InjectMocks
    State state;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGivenStateWhenNextStateThenFlowIsCorrect(){
        assertEquals(StateValue.INITIAL, state.getValueState());
        state.next();
        assertEquals(StateValue.IN_GAME, state.getValueState());
        state.next();
        assertEquals(StateValue.FINAL, state.getValueState());
        state.next();
        assertEquals(StateValue.EXIT, state.getValueState());
    }

    @Test
    public void givenStateWhenResetStateThenStateValueisINITIAL() {
        state.next();
        state.next();
        state.reset();
        assertEquals(StateValue.INITIAL, state.getValueState());
    }

}