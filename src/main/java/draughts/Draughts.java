package draughts;

import draughts.controllers.AcceptorController;
import draughts.views.View;
import draughts.controllers.Logic;

public class Draughts{

    public Logic logic;
    public View view;

    protected Draughts() {
      this.logic = new Logic();
      this.view = new View();
	  }

    public static void main(String[] args) {
		  new Draughts().play();
    }

    protected void play() {

      AcceptorController acceptorController;
      do {
        acceptorController = this.logic.getController();
        if (acceptorController != null){
          this.view.interact(acceptorController);
        }
      } while (acceptorController != null);

    }

}
