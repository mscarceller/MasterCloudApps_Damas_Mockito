package draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import draughts.models.Piece;
import draughts.utils.Console;
import draughts.views.models.PieceView;

@RunWith(MockitoJUnitRunner.class)
public class PieceViewTest {

    @Mock
    Piece piece;

    @Mock
    Console console;

    @InjectMocks
    PieceView pieceView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGivenPieceWhenWritePieceBlackThenOK(){
        when(piece.isBlack()).thenReturn(false);
        pieceView.writePiece();
        verify(console).write("b");
    }

    @Test
    public void testGivenPieceWhenWritePieceWhiteThenOK(){
        when(piece.isBlack()).thenReturn(true);
        pieceView.writePiece();
        verify(console).write("n");
    }
}