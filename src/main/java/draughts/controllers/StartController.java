package draughts.controllers;

import draughts.models.Color;
import draughts.models.Game;
import draughts.models.State;

public class StartController extends AcceptorController {

	private Game game;
	private State state;

	public StartController(Game game, State state) {
		this.game = game;
		this.state = state;
	}

	public Color getTurnColor() {
		return this.game.getTurnColor();
	}

	public void next() {
		this.state.next();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
