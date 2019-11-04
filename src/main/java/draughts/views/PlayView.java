package draughts.views;

import draughts.utils.Console;
import draughts.controllers.PlayController;
import draughts.types.Error;
import draughts.models.Coordinate;
import draughts.views.models.BoardView;
import draughts.views.models.ErrorView;

public class PlayView {

    private Console console;

    private BoardView boardView;

    private static final String[] COLORS = {"blancas", "negras"};

    public PlayView(){
        this.console = new Console();
        this.boardView = new BoardView();
    }

    public void interact(PlayController playController) {
        String color = PlayView.COLORS[playController.getTurnColor().ordinal()];
        Error error = null;
        do {
            boardView.writeBoard(playController);
            if (playController.gameOver()){
                console.write("Derrota!!! No puedes mover tus fichas!!!");
                playController.finishGame();
            }
            else{
                String command = this.console.readString("Mueven las " + color + ": ");
                if (command.equals("-1")){
                    playController.cancelGame();
                }
                else{
                    int origin = Integer.parseInt(command.substring(0, 2));
                    int target = Integer.parseInt(command.substring(3, 5));
                    error = playController.move(new Coordinate((origin/10)-1, (origin%10)-1), new Coordinate((target/10)-1, (target%10)-1));
                    if (error != null){
                        (new ErrorView(error)).writeln();
                        //console.write("Error!!!" + error.name());
                    }
                }
            }
            
        } while (error != null);  
    }

    
}