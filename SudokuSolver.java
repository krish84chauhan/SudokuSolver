import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuSolver extends JFrame {

    private JTextField[][] cells = new JTextField[9][9];

    private JButton solveButton;
    private JButton clearButton;
    private JButton exampleButton;

    public SudokuSolver() {

        setTitle("Sudoku Solver");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 15, 15, 15
                )
        );

        // Title
        JLabel title = new JLabel(
                "SUDOKU SOLVER",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        mainPanel.add(title, BorderLayout.NORTH);

        // Sudoku grid
        JPanel gridPanel = new JPanel(
                new GridLayout(9, 9)
        );

        createSudokuGrid(gridPanel);

        mainPanel.add(
                gridPanel,
                BorderLayout.CENTER
        );

        // Buttons
        JPanel buttonPanel = new JPanel(
                new FlowLayout()
        );

        solveButton = new JButton("Solve");
        clearButton = new JButton("Clear");
        exampleButton = new JButton("Load Example");

        solveButton.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        clearButton.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        exampleButton.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        buttonPanel.add(solveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exampleButton);

        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        // Button actions
        solveButton.addActionListener(
                e -> solveSudoku()
        );

        clearButton.addActionListener(
                e -> clearBoard()
        );

        exampleButton.addActionListener(
                e -> loadExample()
        );

        add(mainPanel);

        setVisible(true);
    }

    /*
     * Create 9x9 Sudoku grid
     */
    private void createSudokuGrid(JPanel gridPanel) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                cells[row][col] =
                        new JTextField();

                cells[row][col].setHorizontalAlignment(
                        JTextField.CENTER
                );

                cells[row][col].setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                22
                        )
                );

                /*
                 * Create borders for 3x3 boxes
                 */
                int top =
                        (row % 3 == 0) ? 3 : 1;

                int left =
                        (col % 3 == 0) ? 3 : 1;

                int bottom =
                        (row == 8) ? 3 : 1;

                int right =
                        (col == 8) ? 3 : 1;

                cells[row][col].setBorder(
                        BorderFactory.createMatteBorder(
                                top,
                                left,
                                bottom,
                                right,
                                Color.BLACK
                        )
                );

                gridPanel.add(
                        cells[row][col]
                );
            }
        }
    }

    /*
     * Solve Sudoku
     */
    private void solveSudoku() {

        int[][] board = new int[9][9];

        /*
         * Read values from GUI
         */
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                String value =
                        cells[row][col]
                                .getText()
                                .trim();

                if (value.isEmpty()) {

                    board[row][col] = 0;

                } else {

                    try {

                        int number =
                                Integer.parseInt(value);

                        if (number < 1 ||
                                number > 9) {

                            showError(
                                    "Enter numbers between 1 and 9."
                            );

                            return;
                        }

                        board[row][col] =
                                number;

                    } catch (
                            NumberFormatException e) {

                        showError(
                                "Only numbers are allowed."
                        );

                        return;
                    }
                }
            }
        }

        /*
         * Check whether initial puzzle
         * is valid
         */
        if (!isValidBoard(board)) {

            showError(
                    "Invalid Sudoku puzzle!"
            );

            return;
        }

        /*
         * Solve using backtracking
         */
        if (solve(board)) {

            /*
             * Display solution
             */
            for (int row = 0; row < 9; row++) {

                for (int col = 0; col < 9; col++) {

                    cells[row][col].setText(
                            String.valueOf(
                                    board[row][col]
                            )
                    );
                }
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Sudoku solved successfully!"
            );

        } else {

            showError(
                    "No solution exists for this puzzle."
            );
        }
    }

    /*
     * Backtracking algorithm
     */
    private boolean solve(int[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                /*
                 * Find empty cell
                 */
                if (board[row][col] == 0) {

                    /*
                     * Try numbers 1 to 9
                     */
                    for (
                            int number = 1;
                            number <= 9;
                            number++
                    ) {

                        /*
                         * Check whether number
                         * can be placed
                         */
                        if (isSafe(
                                board,
                                row,
                                col,
                                number
                        )) {

                            board[row][col] =
                                    number;

                            /*
                             * Recursively solve
                             */
                            if (solve(board)) {

                                return true;
                            }

                            /*
                             * Undo the choice
                             */
                            board[row][col] = 0;
                        }
                    }

                    /*
                     * No number worked
                     */
                    return false;
                }
            }
        }

        /*
         * No empty cells
         */
        return true;
    }

    /*
     * Check whether a number is safe
     */
    private boolean isSafe(
            int[][] board,
            int row,
            int col,
            int number
    ) {

        /*
         * Check row
         */
        for (int i = 0; i < 9; i++) {

            if (board[row][i] == number) {

                return false;
            }
        }

        /*
         * Check column
         */
        for (int i = 0; i < 9; i++) {

            if (board[i][col] == number) {

                return false;
            }
        }

        /*
         * Find 3x3 box
         */
        int startRow =
                row - row % 3;

        int startCol =
                col - col % 3;

        /*
         * Check 3x3 box
         */
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (
                        board[startRow + i]
                             [startCol + j]
                        == number
                ) {

                    return false;
                }
            }
        }

        return true;
    }

    /*
     * Validate existing puzzle
     */
    private boolean isValidBoard(
            int[][] board
    ) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                int number =
                        board[row][col];

                if (number != 0) {

                    /*
                     * Temporarily remove
                     * number
                     */
                    board[row][col] = 0;

                    boolean safe =
                            isSafe(
                                    board,
                                    row,
                                    col,
                                    number
                            );

                    /*
                     * Put number back
                     */
                    board[row][col] =
                            number;

                    if (!safe) {

                        return false;
                    }
                }
            }
        }

        return true;
    }

    /*
     * Clear Sudoku board
     */
    private void clearBoard() {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                cells[row][col].setText("");
            }
        }
    }

    /*
     * Load example puzzle
     */
    private void loadExample() {

        int[][] puzzle = {

                {5, 3, 0, 0, 7, 0, 0, 0, 0},

                {6, 0, 0, 1, 9, 5, 0, 0, 0},

                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},

                {4, 0, 0, 8, 0, 3, 0, 0, 1},

                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},

                {0, 0, 0, 4, 1, 9, 0, 0, 5},

                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (puzzle[row][col] == 0) {

                    cells[row][col].setText("");

                } else {

                    cells[row][col].setText(
                            String.valueOf(
                                    puzzle[row][col]
                            )
                    );
                }
            }
        }
    }

    /*
     * Display error message
     */
    private void showError(
            String message
    ) {

        JOptionPane.showMessageDialog(
                this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new SudokuSolver()
        );
    }
}