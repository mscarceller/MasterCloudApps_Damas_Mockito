package draughts.models;

import draughts.types.Error;

public class Game {

	private Board board;
	private Turn turn;

	public Game() {
		this.clear();
	}

	public void clear(){
		this.board = new Board();
		this.turn = new Turn();
	}

	public Error move(Coordinate origin, Coordinate target) {
		if (!this.checkValidMovementCoordinates(origin,target)) {
			return Error.OUT_COORDINATE;
		}

		if (!this.checkThereIsPieceAtCoordinate(origin)) {
			return Error.EMPTY_ORIGIN;
		}

		if (this.checkTryToMoveOppositePiece(origin)){
			return Error.OPPOSITE_PIECE;
		}

		if(this.checkTryToMoveNotInDiagonal(origin,target)){
			return Error.NOT_DIAGONAL;
		}

		if(this.checkIsAdvanced(origin,target)){
			return Error.NOT_ADVANCED;
		}

		if(this.checkDiagonalDistance(origin,target)){
			return Error.BAD_DISTANCE;
		}

		if(!this.checkEmptyTarget(target)){
			return Error.NOT_EMPTY_TARGET;
		}

		if(this.checkIfEatingEmpty(origin,target)){
			return Error.EATING_EMPTY;
		}

		this.board.move(origin, target);
		this.turn.change();
		return null;
	}

	public boolean checkValidMovementCoordinates(Coordinate origin, Coordinate target){
		if (!origin.isValid() || !target.isValid())
			return false;
		return true;
	}

	public boolean checkThereIsPieceAtCoordinate(Coordinate origin){
		return (!board.isEmpty(origin));
	}

	public boolean checkTryToMoveOppositePiece(Coordinate origin){
		Color color = this.board.getColor(origin);
		return (!this.turn.isColor(color));
	}

	public boolean checkTryToMoveNotInDiagonal(Coordinate origin,Coordinate target){
		return (!origin.isDiagonal(target));
	}

	public boolean checkIsAdvanced(Coordinate origin,Coordinate target){
		Piece piece = this.board.getPiece(origin);
		return (!piece.isAdvanced(origin, target));
	}

	public boolean checkDiagonalDistance(Coordinate origin,Coordinate target){
		return (origin.diagonalDistance(target) >= 3);
	}

	public boolean checkEmptyTarget(Coordinate target){
		return (this.board.isEmpty(target));
	}

	public boolean checkIfEatingEmpty(Coordinate origin,Coordinate target){
		if (origin.diagonalDistance(target) == 2) {
			Coordinate between = origin.betweenDiagonal(target);
			if (this.board.getPiece(between) == null) {
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean gameOver(){
		return this.board.isLooser(this.getTurnColor());
	}

	public Color getColor(Coordinate coordinate) {
		return this.board.getColor(coordinate);
	}

	public Piece getPiece(Coordinate origin) {
		return this.board.getPiece(origin);
	}

	public Board getBoard() {
		return this.board;
	}

	public Color getTurnColor() {
		return this.turn.getTurnColor();
	}

	@Override
	public String toString() {
		return this.board + "\n" + this.turn;
	}
}