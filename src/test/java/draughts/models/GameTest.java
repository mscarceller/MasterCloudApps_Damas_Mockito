package draughts.models;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import draughts.types.Error;

@RunWith(MockitoJUnitRunner.class)

public class GameTest {

    @Mock
    Coordinate origin;

    @Mock
    Coordinate target;

    @Mock
    Coordinate between;

    @Mock
    Board board;

    @Mock
    Piece piece;

    @Mock
    Turn turn;

    @InjectMocks
    Game game;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        when(origin.isValid()).thenReturn(true);
        when(target.isValid()).thenReturn(true);
        when(board.isEmpty(origin)).thenReturn(false);
        when(turn.isColor(any())).thenReturn(true);
        when(origin.isDiagonal(target)).thenReturn(true);
        when(board.getPiece(origin)).thenReturn(piece);
        when(piece.isAdvanced(origin, target)).thenReturn(true);
        when(origin.diagonalDistance(target)).thenReturn(2);
        when(board.isEmpty(target)).thenReturn(true);
    }

    @Test
    public void testGivenGameWhenOuterCoordinateOriginThenOutCoordinateError(){
        when(origin.isValid()).thenReturn(false);
        assertThat(game.checkValidMovementCoordinates(origin, target), is(false));
        verify(origin).isValid();
        assertThat(game.move(origin,target), is(Error.OUT_COORDINATE));
    }

    @Test
    public void testGivenGameWhenOuterCoordinateTargetThenOutCoordinateError(){
        when(target.isValid()).thenReturn(false);
        assertThat(game.checkValidMovementCoordinates(origin, target), is(false));
        assertThat(game.move(origin,target), is(Error.OUT_COORDINATE));
    }

    @Test
    public void testGivenGameWhenEmptyCoordinateThenEmptyCoordinateError(){
        when(board.isEmpty(origin)).thenReturn(true);
        assertThat(game.move(origin,target), is(Error.EMPTY_ORIGIN));
        verify(board).isEmpty(origin);
    }

    @Test
    public void testGivenGameWhenTryToMoveOponentPieceThenError(){
        when(board.getColor(origin)).thenReturn(Color.WHITE);
        when(turn.isColor(Color.WHITE)).thenReturn(false);
        assertThat(game.move(origin,target), is(Error.OPPOSITE_PIECE));
        verify(board).getColor(origin);
        verify(turn).isColor(Color.WHITE);
    }

    @Test
    public void testGivenGameWhenTryToMoveNotInDiagonalThenError(){
        when(origin.isDiagonal(target)).thenReturn(false);
        assertThat(game.move(origin,target), is(Error.NOT_DIAGONAL));
        verify(origin).isDiagonal(target);
    }


    @Test
    public void testGivenGameWhenMoveWithNotAdvancedThenError() {
       when(board.getPiece(origin)).thenReturn(piece);
       when(piece.isAdvanced(origin, target)).thenReturn(false);
       assertThat(game.move(origin, target), is(Error.NOT_ADVANCED));
       verify(piece).isAdvanced(origin, target);
       verify(board).getPiece(origin);
    }


    @Test
    public void testGivenGameWhenMoveBadDistanceThenError() {
        when(origin.diagonalDistance(target)).thenReturn(3);
        assertThat(this.game.move(origin, target), is(Error.BAD_DISTANCE));
        verify(origin).diagonalDistance(target);
    }

    @Test
    public void testGivenGameWhenNotEmptyTargeThenError() {
        when(board.isEmpty(target)).thenReturn(false);
        assertThat(this.game.move(origin, target), is(Error.NOT_EMPTY_TARGET));
        verify(board).isEmpty(target);
    }

    @Test
    public void testGivenGameWhenEatEmptyPieceThenError() {
        when(origin.betweenDiagonal(target)).thenReturn(between);
        when(board.getPiece(between)).thenReturn(null);
        assertThat(game.move(origin,target), is(Error.EATING_EMPTY));
        verify(origin).betweenDiagonal(target);
        verify(board).getPiece(between);
    }

}
