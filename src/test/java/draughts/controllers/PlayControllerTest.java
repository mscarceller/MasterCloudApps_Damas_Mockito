package draughts.controllers;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import draughts.models.Game;
import draughts.models.Coordinate;
import draughts.models.State;

public class PlayControllerTest {

    @Mock
    Game game;

    @Mock
    State state;

    @Mock
    Coordinate origin;

    @Mock
    Coordinate target;

    @InjectMocks
    PlayController playController;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        when(game.move(origin, target)).thenReturn(null);
        assertNull(playController.move(origin, target));
        verify(game).move(origin, target);
    }

    @Test
    public void testGivenPlayControllerWhenGameIsOverThenStateSiFinal() {
        when(game.gameOver()).thenReturn(true);
        assertTrue(playController.gameOver());
        verify(game).gameOver();
    }

}
