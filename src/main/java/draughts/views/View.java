package draughts.views;

import draughts.controllers.AcceptorController;
import draughts.controllers.ControllersVisitor;
import draughts.controllers.PlayController;
import draughts.controllers.ResumeController;
import draughts.controllers.StartController;

public class View implements ControllersVisitor {

    private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;
	
	public View(){
		this.startView = new StartView();
		this.playView = new PlayView();
		this.resumeView = new ResumeView();
	}
	
	public void interact(AcceptorController acceptorController) {
		acceptorController.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);		
	}

	@Override
	public void visit(PlayController playController) {
		this.playView.interact(playController);
	}
	
	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}
	
}