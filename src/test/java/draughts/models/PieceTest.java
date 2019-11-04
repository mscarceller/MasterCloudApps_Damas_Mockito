package draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PieceTest {

    @Test
    public void testGivenPieceWhenIsAdvancedThenTrue(){
        assertTrue(new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(4,1)));
        assertTrue(new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(3,2)));
    }

    @Test
    public void testGivenPieceWhenNotIsAdvancedThenFalse(){
        assertFalse(new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(6,1)));
        assertFalse(new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(1,2)));
    }

    @Test
    public void testGivenPieceThenReturnCorrectColor(){
        Piece piece = new Piece(Color.WHITE);
        assertEquals(Color.WHITE, piece.getColor());
    }
}