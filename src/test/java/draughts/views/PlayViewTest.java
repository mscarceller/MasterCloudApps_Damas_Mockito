package draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import draughts.controllers.PlayController;
import draughts.models.Color;
import draughts.models.Coordinate;
import draughts.utils.Console;
import draughts.views.models.BoardView;

@RunWith(MockitoJUnitRunner.class)
public class PlayViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @Mock
    BoardView boardView;

    @InjectMocks
    PlayView playView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testInteract(){
        when(playController.getTurnColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenReturn("32.41\n");
        playView.interact(playController);
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
    }

    @Test
    public void testGivenPlayViewWhenPlayerGiveUpThenNextState(){
        when(playController.getTurnColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: ")).thenReturn("-1");
        playView.interact(playController);
        verify(playController).cancelGame();
    }

    @Test
    public void testGivenPlayViewWherGameIsOverThenNextState(){
        when(playController.getTurnColor()).thenReturn(Color.WHITE);
        when(playController.gameOver()).thenReturn(true);
        playView.interact(playController);
        verify(playController).finishGame();
    }

}