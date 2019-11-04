package draughts.controllers;

import draughts.models.Game;
import draughts.models.Coordinate;
import draughts.models.State;
import draughts.types.Error;
import draughts.models.Board;
import draughts.models.Color;

public class PlayController extends AcceptorController{

	private Game game;
	private State state;

	private MoveController moveController;
	private CancelController cancelController;

    public PlayController(Game game, State state) {
		this.game = game;
		this.state = state;
		this.moveController = new MoveController(game,state);
		this.cancelController = new CancelController(game,state);
	}

	public Error move(Coordinate origin, Coordinate target){
        return this.moveController.move(origin, target);
	}

	public void cancelGame(){
		this.cancelController.cancelGame();
	}

	public Color getTurnColor() {
		return this.game.getTurnColor();
	}

	public Board getBoard() {
		return this.game.getBoard();
	}

	public boolean gameOver(){
		return this.game.gameOver();
	}

	public void finishGame(){
		this.state.next();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
