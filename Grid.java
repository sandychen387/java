
//https://youtu.be/3P9zozjhXPI

import java.util.Arrays;
import java.util.Random;

public class Grid {
    private boolean[][] bombGrid;
    private int[][] countGrid;
    private int numRows;
    private int numColumns;
    private int numBombs;
    
    public Grid() {
        this(10, 10, 25);// Default constructor
    }

    public Grid(int rows, int columns) {
        this(rows, columns, 25); // Constructor with specified rows and columns
    }

    public Grid(int rows, int columns, int numBombs) {// Constructor with specified rows, columns, and number of bombs
        numRows = rows;
        numColumns = columns;
        this.numBombs = numBombs;
        bombGrid = new boolean[numRows][numColumns];
        countGrid = new int[numRows][numColumns];
        createBombGrid();
        createCountGrid();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumBombs() {
        return numBombs;
    }

    public boolean isBombAtLocation(int row, int column) {
        return bombGrid[row][column];
    }

    public int getCountAtLocation(int row, int column) {
        return countGrid[row][column];
    }

    
    public boolean[][] getBombGrid() {
    	boolean[][] copiedBombGrid = new boolean[numRows][];
        for (int i = 0; i < numRows; i++) {
            copiedBombGrid[i] = Arrays.copyOf(bombGrid[i], numColumns);//creates a copy of the 1D array at index i, with a specified length of numColumns
        }
        return copiedBombGrid;
    }
   
    
    public int[][] getCountGrid() {
    	int[][] copiedCountGrid = new int[numRows][];
        for (int i = 0; i < numRows; i++) {
            copiedCountGrid[i] = Arrays.copyOf(countGrid[i], numColumns);//creates a copy of the 1D array at index i, with a specified length of numColumns
        }
        return copiedCountGrid;
    }
   

    private void createBombGrid() {
        Random random = new Random();// initializing a Random object named random

        int bombsPlaced = 0;// initializes a counter bombsPlaced to keep track of the number of bombs placed in the grid.
        while (bombsPlaced < numBombs) {// while loop that runs until the required number of bombs (numBombs) are placed in the grid
            int row = random.nextInt(numRows);
            int col = random.nextInt(numColumns);

            if (!bombGrid[row][col]) {//checks if there's no bomb (!bombGrid[row][col]) already placed at the generated random cell in the grid
                bombGrid[row][col] = true;//presence of a bomb
                bombsPlaced++;//increments the bombsPlaced counte
            }
        }
    }
    
    private void createCountGrid() {
        for (int row = 0; row < numRows; row++) {//iterates through each cell in the grid
            for (int col = 0; col < numColumns; col++) {
                countGrid[row][col] = countBombsInNeighborhood(row, col);//assigns the number of bombs in the neighborhood of each cell
            }
        }
    }
   
    
    private int countBombsInNeighborhood(int row, int col) {
        int bombCount = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {//keep track of the number of bombs found in the neighborhood.
                int newRow = row + r;//
                int newCol = col + c;
                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numColumns) {//checks if the newRow and newCol values are within the valid bounds of the grid to avoid accessing cells outside the grid
                    if (bombGrid[newRow][newCol]) {//If the neighboring cell within the grid contains a bomb (bombGrid[newRow][newCol] is true), it increments the bombCount.
                        bombCount++;
                    }
                }
            }
        }
        return bombCount;
    }
}
