
public interface BoardGameInterface {
	
	static char PLAYER_X='X';
	static char PLAYER_O='O';
	static char EMPTY_CELL=' ';

	void displayBoard();

	void clearBoard();

	void changeTurn();

	void placeMarker(int row, int col);

	boolean inWinner();

	boolean isWinner(char currPlayer);

	boolean isFull();

	boolean isEmpty();

	void startGame();

}
