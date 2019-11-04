package draughts.views.models;

import draughts.utils.Console;
import draughts.controllers.PlayController;
import draughts.models.Board;

public class BoardView {

    private Console console;

    public BoardView(){
        this.console = new Console();
    }

    public void writeBoard(PlayController playController){
        Board board = playController.getBoard();
        console.writeln();
        console.writeln(" 12345678 ");
        for(int coordY = 0 ; coordY < 8 ; coordY++){
            console.write(String.valueOf((coordY+1)));
            for(int coordX = 0 ; coordX < 8 ; coordX++){
                new SquareView(board.getSquare(coordY,coordX)).writePiece();
            }
            console.writeln(String.valueOf((coordY+1)));
        }
        console.writeln(" 12345678 ");
    }
}