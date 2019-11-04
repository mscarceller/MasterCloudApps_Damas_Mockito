package draughts.controllers;

import draughts.models.Game;
import draughts.models.State;
import draughts.views.CancelView;

public class CancelController {

    private Game game;
    private State state;

	public CancelController(Game game,State state) {
        this.game = game;
        this.state = state;
	}

	public void cancelGame() {
        new CancelView().confirmCancel(this);		
    }
    
    public void cancel(boolean cancel){
        if (cancel)
            this.state.next();
    }

}