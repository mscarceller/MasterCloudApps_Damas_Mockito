package draughts.controllers;

import draughts.models.StateValue;
import draughts.models.State;

import java.util.HashMap;
import java.util.Map;

import draughts.models.Game;

public class Logic {

	State state;
	Game game;

	protected Map<StateValue, AcceptorController> acceptorControllers;

	public Logic() {
		this.state = new State();
		this.game = new Game();
		this.acceptorControllers = new HashMap<StateValue, AcceptorController>();
		this.acceptorControllers.put(StateValue.INITIAL, new StartController(this.game,this.state));
		this.acceptorControllers.put(StateValue.IN_GAME, new PlayController(this.game,this.state));
		this.acceptorControllers.put(StateValue.FINAL, new ResumeController(this.game,this.state));
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

	public AcceptorController getController() {
		return this.acceptorControllers.get(this.getValueState());
	}

	public StateValue getValueState(){
		return this.state.getValueState();
	}

	public void nextState() {
		this.state.next();
	}

}