package draughts.views.models;

import draughts.types.Error;
import draughts.utils.WithConsoleView;

public class ErrorView extends WithConsoleView{

	static final String[] MESSAGES = { 
		"No te entiendo: <d><d>{,<d><d>}[0-2]",
		"No es una coordenada del tablero",
        "No hay ficha que mover",
        "No es una de tus fichas",
        "No vas en diagonal",
        "No respetas la distancia",
        "No está vacío el destino",
        "No avanzas",
        "No comes contrarias"
    };

	Error error;

	public ErrorView(Error error) {
		this.error = error;
	}
	
	public void writeln() {
		this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	
	
}
