package draughts.controllers;

public abstract class AcceptorController extends Controller {

    public abstract void accept(ControllersVisitor controllersVisitor);

}