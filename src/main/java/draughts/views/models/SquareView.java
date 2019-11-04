package draughts.views.models;

import draughts.models.Square;



public class SquareView {

    private Square square;

    public SquareView(Square square){
        this.square = square;
    }

    public void writePiece(){
        new PieceView(this.square.getPiece()).writePiece();
    }

}