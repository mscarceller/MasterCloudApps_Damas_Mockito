package draughts.controllers;

import draughts.models.Game;
import draughts.models.State;

public class ResumeController extends AcceptorController {

	private Game game;
	private State state;

	public ResumeController(Game game, State state) {
		this.game = game;
		this.state = state;
	}

	public void isNewGame(boolean newGame) {
		if (newGame) {
			this.newGame();
		} else {
			this.exitGame();
		}
	}

	public void newGame(){
		this.game.clear();
		this.state.reset();
	}

	public void exitGame(){
		this.state.next();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
