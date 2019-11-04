package draughts.views;

import draughts.utils.Console;
import draughts.controllers.StartController;

public class StartView {

    private Console console;

    private static final String TITLE = "Las Damas!!!";

    public StartView(){
        this.console = new Console();
    }

    public void interact(StartController startController) {
        console.writeln(TITLE);
        startController.next();
    }

}