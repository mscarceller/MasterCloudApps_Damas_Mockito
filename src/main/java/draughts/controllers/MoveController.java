package draughts.controllers;

import draughts.models.Coordinate;
import draughts.models.Game;
import draughts.models.State;
import draughts.types.Error;

public class MoveController {

	private Game game;
	private State state;

	public MoveController(Game game,State state) {
		this.game = game;
		this.state = state;
	}

	public Error move(Coordinate origin, Coordinate target) {
		return this.game.move(origin, target);
	}

}