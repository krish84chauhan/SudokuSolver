# SudokuSolver
#  Sudoku Solver

A simple **Sudoku Solver desktop application built in Java** using **Java Swing**.
The application provides an interactive 9×9 Sudoku grid where users can enter a puzzle and solve it automatically using a **backtracking algorithm**.

##  Features

*  Interactive **9×9 Sudoku grid**
*  Solves Sudoku using the **Backtracking Algorithm**
*  Validates the entered Sudoku puzzle
*  Detects invalid inputs and Sudoku configurations
*  **Clear** button to reset the board
* **Load Example** button with a sample Sudoku puzzle
* Simple and user-friendly **GUI**
*  Displays success and error messages

##  Technologies Used

* **Java**
* **Java Swing**
* **AWT**
* **Backtracking Algorithm**

##  Project Structure

```text
Sudoku-Solver/
│
├── SudokuSolver.java
└── README.md
```

##  How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/Sudoku-Solver.git
```

### 2. Navigate to the Project Folder

```bash
cd Sudoku-Solver
```

### 3. Compile the Java Program

```bash
javac SudokuSolver.java
```

### 4. Run the Application

```bash
java SudokuSolver
```

##  How to Use

1. Launch the application.
2. Enter the Sudoku puzzle into the 9×9 grid.
3. Leave unknown cells empty.
4. Click **Solve**.
5. The program checks whether the entered puzzle is valid.
6. If a solution exists, the completed Sudoku is displayed automatically.
7. Use **Clear** to remove the current puzzle.
8. Use **Load Example** to load the built-in sample puzzle.

##  Algorithm

The application uses the **Backtracking Algorithm** to solve the Sudoku.

The basic process is:

```text
1. Find an empty cell.
2. Try numbers from 1 to 9.
3. Check whether the number is valid.
4. If valid, place the number.
5. Recursively solve the remaining cells.
6. If no number works, undo the previous choice.
7. Continue until the Sudoku is solved.
```

A number is considered valid only if it does not already exist in:

* The same row
* The same column
* The corresponding 3×3 box

The project implements these checks through the `isSafe()` method.

##  Input Validation

The application validates user input before attempting to solve the puzzle.

It checks that:

* Only numbers are entered.
* Numbers must be between **1 and 9**.
* The initial Sudoku configuration must be valid.
* A message is displayed if the puzzle has no solution.

##  GUI

The application is created using Java Swing. It contains:

* A Sudoku 9×9 grid
* **Solve** button
* **Clear** button
* **Load Example** button
* Error and success message dialogs

The main window is created as a `JFrame`, and the Sudoku cells are represented using `JTextField` components.

##  Concepts Demonstrated

This project demonstrates practical use of:

* Object-Oriented Programming
* Java GUI Programming
* Event Handling
* Recursion
* Backtracking
* 2D Arrays
* Input Validation
* Exception Handling
* Algorithmic Problem Solving

## 🔮 Future Improvements

Possible improvements include:

* Add difficulty levels
* Add a **New Game** button
* Highlight invalid entries
* Add a timer
* Add a Sudoku puzzle generator
* Add difficulty selection
* Improve the visual design
* Add keyboard/input restrictions for Sudoku cells

## Author

krishna chauhan

GitHub: `https://github.com/your-username`

---

⭐ If you found this project useful, consider giving the repository a star!

