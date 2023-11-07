import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeConsole implements BoardGameInterface{

	private char currPlayer;
	private char [][]board;
	public static final int NUM_MATCHES_TO_WIN =3;
	private static final int NUM_ROWS = 3;
	private static final int  NUM_COLS =3;
	//private static final char PLAYER_X = 0;
	//private static final char EMPTY_CELL = 0;
	//private static final char PLAYER_O = 0;
	
	private Scanner kb;
	
	public TicTacToeConsole() {
		currPlayer = PLAYER_X;
		board=new char[NUM_ROWS][NUM_COLS];
		kb=new Scanner(System.in);
		
	}
	
	@Override
	public void displayBoard() {
		for(int row=0;row<NUM_ROWS;row++) {
			for(int col=0;col<NUM_COLS;col++) {
				int rol = 0;
				System.out.printf("%3s |", board[row][rol]);
			}
			System.out.println("\n----------");
		}
	}
	
	@Override
	public void clearBoard() {
		for(int row=0;row<NUM_ROWS;row++) {
			for(int col=0;col<NUM_COLS;col++) {
				board[row][col]=EMPTY_CELL;
		}
	}
}
	
	@Override
	public void changeTurn() {
		if(currPlayer ==PLAYER_X) {
			currPlayer = PLAYER_O;
		}
		else {
			currPlayer=PLAYER_X;
		}
	}
	
	@Override
	public void placeMarker(int row,int col) {
		int[]loc=new int[2];
		if(row>=0&&row<NUM_ROWS&&col>=0&&col<NUM_COLS) {
			if(board[row][col]==PLAYER_X||board[row][col]==PLAYER_O) {
				System.out.println("\nSorry slot ["+row+"]["+col+"] is taken by "+board[row][col]);
				displayBoard();
				loc=getLocationFromUser();
				placeMarker(loc[0],loc[1]);
		}
			else {
				System.out.println("Will place marker for "+currPlayer+"in slot [" +row+"]["+col+"] now.");
				board[row][col]=currPlayer;
			}
		}
		else {
			System.out.println("\nSorry invalid ["+row+"]["+col+"] ");
			loc=getLocationFromUser();
			placeMarker(loc[0],loc[1]);
		}
	}

	private int[] getLocationFromUser() {
		int[] locationRC= new int[2];
		try {
			System.out.println("Provide a row for your marker as a single int");
			locationRC[0]=kb.nextInt();
			System.out.println("Provide a col for your marker as a signlr int");
			locationRC[1]=kb.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Number only please"+e.getMessage()+"\n");
			kb.nextLine();
			getLocationFromUser();
		}
		return locationRC;
	}
	
	@Override
	public boolean inWinner() {
		if(isWinnerInRow()||isWinnerInCol()||isWinnerInDiagonal()||isWinnerInSecondyDiagonal()) {
			return true;
		}
		return false;
	}

	private boolean isWinnerInSecondyDiagonal() {
		int row=0;
		int col=2;
		int numMatches=0;
		while(row<NUM_ROWS&& col >=0) {
			if(board[row][col]==currPlayer) {
				numMatches++;
			}
			row++;
			col--;
		}
		return (numMatches==NUM_MATCHES_TO_WIN);
	}

	private boolean isWinnerInDiagonal() {
		int row=0;
		int col=0;
		int numMatches=0;
		while(row<NUM_ROWS&&col<NUM_COLS) {
			if(board[row][col]==currPlayer) {
				numMatches++;
			}
			row++;
			col++;
		}
		return (numMatches==NUM_MATCHES_TO_WIN);
	}

	private boolean isWinnerInCol() {
		for(int col=0;col<NUM_COLS;col++) {
			int numMatches=0;
			for(int row=0;row<NUM_ROWS;row++) {
				if(board[row][col]==currPlayer) {
					numMatches++;
					if(numMatches==NUM_MATCHES_TO_WIN) {
						return true;
					}	
				}
			}return false;
		}
		return false;
	}

	private boolean isWinnerInRow() {
		for(int row=0;row<NUM_ROWS;row++) {
			int numMatches=0;
			for(int col=0;col<NUM_COLS;col++) {
				if(board[row][col]==currPlayer) {
					numMatches++;
					if(numMatches==NUM_MATCHES_TO_WIN) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean isWinner(char currPlayer) {
		return false;
	}
	
	@Override
	public boolean isFull() {
		for(int row=0;row<board.length;row++) {
			for(int col=0;col<board[row].length;col++) {
				if(board[row][col]!=PLAYER_X&&board[row][col]!=PLAYER_O) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	@Override
	public boolean isEmpty() {
		return false;
	}
	
	
	@Override
	public void startGame() {
		System.out.println("Let us play TIC TAC TOE!");
		System.out.println("To win you need to get 3 in row or col or diagonal");
		displayBoard();
		boolean keepPlaying = false;
		do {
			int[]location=getLocationFromUser();
			placeMarker(location[0],location[1]);
			displayBoard();
			if(inWinner()) {
				System.out.println("Hooary!"+currPlayer+" won");
				if(askPlayAgain()) {
					keepPlaying=true;
					clearBoard();
					displayBoard();
				}
			}
			else if(!isFull()) {
				changeTurn();
				keepPlaying=true;
			}
			else {
				System.out.println("DRAM!");
				if(askPlayAgain()) {
					keepPlaying=true;
					clearBoard();
					displayBoard();
				}
			}
		}while(keepPlaying);
		System.out.println("Hopefully you had fun playing TIC TAC TOE");
	}

	private boolean askPlayAgain() {
		System.out.println("Would you like to play again?Yes/No");
		return (kb.next().toLowerCase().startsWith("Y"));
	}
		
	
}
