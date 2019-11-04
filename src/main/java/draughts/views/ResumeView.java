package draughts.views;

import draughts.utils.YesNoDialog;
import draughts.controllers.ResumeController;

public class ResumeView {

    private YesNoDialog yesNoDialog;

    public ResumeView(){
        this.yesNoDialog = new YesNoDialog();
    }

    public void interact(ResumeController resumeController) {
        resumeController.isNewGame(this.yesNoDialog.read("¿Queréis jugar otra"));
    }

}