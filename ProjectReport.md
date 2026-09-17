# SUDOKU SOLVER

---

## 1. Introduction

Sudoku is a number-based puzzle played on a 9×9 grid. The goal is to fill the cells with numbers from 1 to 9 without repeating any number in the same row, column or 3×3 box.

This project is a *Sudoku Solver developed using Java Swing**. It offers an interface where users can enter a Sudoku puzzle and solve it automatically. The application uses the **backtracking algorithm** to find the solution.

---

## 2. Objectives

The main objectives of this project are:

* To develop a Sudoku solving application using Java.

* To create a user- graphical interface.

* To implement the backtracking algorithm.

* To validate the input before solving.

* To display the solution directly on the Sudoku grid.

---

## 3. Technologies Used

* **Programming Language:** Java

* **GUI:** Java Swing

* **Layout:** AWT and Swing layouts

* **Algorithm:** Backtracking

* **Data Structure:** Two-dimensional array

The program uses a 9×9 array of `JTextField` components to create the Sudoku grid.

---

## 4. Main Features

The application provides the following features:

1. **Solve** – Solves the entered Sudoku puzzle.

2. **Clear** – Clears all values from the grid.

3. **Load Example** – Loads a sample Sudoku puzzle.

4. **Input Validation** – Checks that entered values are valid.

5. **Puzzle Validation** – Checks whether the initial puzzle follows Sudoku rules.

6. **Error Messages** – Displays messages for input or puzzles.

These operations are connected to the GUI buttons using Java event listeners.

---

## 5. Working of the Project

The working process is:

**Enter Puzzle → Validate Input → Check Puzzle → Backtracking → Display Solution**

When the user clicks **Solve** the program reads the values from the grid and stores them in a 2D integer array. Empty cells are represented by `0`. The program then checks the puzzle before starting the solving process.

The backtracking algorithm finds a cell and tries numbers from 1 to 9. If a number is valid it is placed in the cell. The algorithm continues. If the selected number does not lead to a solution the program removes it. Tries another number.

---

## 6. Validation

The program checks whether a number can safely be placed in a cell by checking:

* The current row

* The current column

* The corresponding 3×3 box

If the number already exists in any of these areas it is rejected.

The program also handles input such as numbers outside the range 1–9 and non-numeric values.

---

## 7. Advantages

* Easy to use.

* Simple graphical interface.

* Solves Sudoku automatically.

* Demonstrates recursion and backtracking.

* Provides input validation.

* Reduces the time required to solve puzzles

---

## 8. Limitations

* Supports a standard 9×9 Sudoku.

* Does not save puzzles permanently.

* Does not have difficulty levels.

* No database is used.

---

## 9. Future Scope

The project can be improved by adding:

* puzzle generation.

* Different difficulty levels.

* Timer and scoring system.

* Save and load options.

* Step-, by-step solving.

* Improved graphical design.

* Database support.

---

## 10. Conclusion

The **Sudoku Solver** is a Java Swing application that provides a way to solve Sudoku puzzles. The project demonstrates the use of Java GUI programming arrays, validation, recursion and the backtracking algorithm.

This project helped in understanding how an algorithm can be combined with a graphical user interface to create an application.

---

## 11. Project Structure

```text

Sudoku-Solver/

│

├── SudokuSolver.java

└── README.md

```

The main class contains the GUI, Sudoku validation, solving algorithm, example puzzle and application startup code.
