
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinesweeperGame extends JFrame {
    private Grid grid; // Reference to the grid
	private JButton[][] gridButtons;

    public MinesweeperGame() {
        this.grid = new Grid(10, 10, 25); // Create a 10x10 grid with 25 bombs
        initializeUI();
    }

    private void initializeUI() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setLayout(new GridLayout(grid.getNumRows(), grid.getNumColumns()));
        // Initialize gridButtons with appropriate dimensions
        
        gridButtons = new JButton[grid.getNumRows()][grid.getNumColumns()];
        for (int row = 0; row < grid.getNumRows(); row++) {
            for (int col = 0; col < grid.getNumColumns(); col++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                Font buttonFont = new Font(button.getFont().getName(), Font.PLAIN, 40); // Change the size (16 here, you can adjust as needed)
                button.setFont(buttonFont);

                final int currentRow = row;
                final int currentCol = col;

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(currentRow, currentCol);
                    }
                });
                gridButtons[row][col] = button;// Assign button to gridButtons array
                add(button);
            }
        }

        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    private void handleButtonClick(int row, int col) {
        if (grid.isBombAtLocation(row, col)) {
            // Game over, the user clicked on a cell containing a bomb
            // You can reveal all cells and show a message
            revealAllCells();
            JOptionPane.showMessageDialog(this, "Game Over! You clicked on a bomb.");
            // Reset the game or perform other actions as needed
            resetGame();
        } else {
            int count = grid.getCountAtLocation(row, col);
            if (count == 0) {
                // If the count is 0, reveal adjacent cells with 0 count
                revealAdjacentCells(row, col);
            } else {
                // Reveal the count in the clicked cell
                revealCell(row, col);
            }

            // Check for win condition
            if (checkWinCondition()) {
                JOptionPane.showMessageDialog(this, "Congratulations! You won!");
                // Reset the game or perform other actions as needed
                resetGame();
            }
        }
    }


    private void revealCell(int row, int col) {
        JButton button = gridButtons[row][col]; // Assuming gridButtons is a JButton[][] representing the grid

        if (grid.isBombAtLocation(row, col)) {
            button.setText("T"); // Display "T" for a bomb
        } else {
            button.setText("F"); // Display "F" if it's not a bomb
        }
    }


    private void revealAdjacentCells(int row, int col) {
        for (int i = Math.max(0, row - 1); i <= Math.min(grid.getNumRows() - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(grid.getNumColumns() - 1, col + 1); j++) {
                if (!(i == row && j == col)) { // Skip the current cell
                    int bombCount = grid.getCountAtLocation(i, j);
                    JButton button = gridButtons[i][j];

                    if (grid.isBombAtLocation(i, j)) {
                        button.setText("T"); // Display "T" for a bomb
                    } else if (bombCount > 0) {
                        button.setText(String.valueOf(bombCount)); // Display the count of bombs
                    } else {
                        button.setText("F"); // Display "F" if it's not a bomb and count is 0
                    }
                }
            }
        }
    }


    private void revealAllCells() {
        for (int row = 0; row < grid.getNumRows(); row++) {
            for (int col = 0; col < grid.getNumColumns(); col++) {
                revealCell(row, col);
            }
        }
    }

    private void resetGame() {
        // Reset the game by reinitializing the grid and updating the UI
        this.grid = new Grid(10, 10, 25); // Reinitialize the grid
        updateUI(); // Update the UI to reset the buttons
    }
    
    
    private void updateUI() {
        getContentPane().removeAll(); // Clear the current UI components

        setLayout(new GridLayout(grid.getNumRows(), grid.getNumColumns()));
        gridButtons = new JButton[grid.getNumRows()][grid.getNumColumns()];

        for (int row = 0; row < grid.getNumRows(); row++) {
            for (int col = 0; col < grid.getNumColumns(); col++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                Font buttonFont = new Font(button.getFont().getName(), Font.PLAIN, 40); // Change the size (16 here, you can adjust as needed)
                button.setFont(buttonFont);
                final int currentRow = row;
                final int currentCol = col;

                button.addActionListener(e -> handleButtonClick(currentRow, currentCol));
                gridButtons[row][col] = button;
                add(button);
            }
        }

        revalidate(); // Refresh the layout
        repaint(); // Repaint the components
    }

    private boolean checkWinCondition() {
		// TODO Auto-generated method stub
		return false;
	}
    

	

	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MinesweeperGame game = new MinesweeperGame();
            game.setVisible(true);
        });
    }
	

}
