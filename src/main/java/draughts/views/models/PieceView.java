package draughts.views.models;

import draughts.models.Piece;
import draughts.utils.Console;


public class PieceView {

    private Console console;
    private Piece piece;

    public PieceView(Piece piece){
        this.console = new Console();
        this.piece = piece;
    }

    public void writePiece(){
        if (piece!=null){
            if (this.piece.isBlack())
                console.write("n");
            else
                console.write("b");
        }
        else{
            console.write(" ");
        }
    }

}