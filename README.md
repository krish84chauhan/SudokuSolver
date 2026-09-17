# SudokuSolver

This is a Sudoku Solver application made using Java. I created this project to practice Java, GUI development and the backtracking algorithm.

The application provides a 9×9 Sudoku board where you can enter a puzzle and let the program solve it automatically.

## Features

* 9×9 Sudoku board

* Solve Sudoku

* Uses the backtracking algorithm

* Checks whether the entered puzzle is valid

* Shows an error if invalid values are entered

* Clear the board with one click

* Load an example Sudoku puzzle

* Simple Java Swing interface

## How It Works

The part of this project is the backtracking algorithm.

The program looks for a cell and tries numbers from 1 to 9. Before placing a number it checks whether that number is already present in the row, column or 3×3 box.

If the number is valid the program moves to the empty cell. If it reaches a situation where no number works it goes back to the step and tries another number.

This process continues until the complete Sudoku is solved.

## Technologies Used

* Java

* Java Swing

* AWT

* Recursion

* Backtracking Algorithm

## How to Run

Make sure Java JDK is installed on your computer.

### Compile the program

```bash

javac SudokuSolver.java

```

### Run the program

```bash

java SudokuSolver

```

The Sudoku Solver window will open.

## How to Use

1. Enter the given numbers into the grid.

2. Leave the cells blank.

3. Click Solve.

4. The program will check the puzzle. Try to find a solution.

5. If a solution exists the completed Sudoku will appear on the board.

6. Click Clear to start

7. You can also click Load Example to try the sample puzzle included in the program.

## Project Structure

```text

Sudoku-Solver/

│

├── SudokuSolver.java

└── README.md

```

## What I Learned

While making this project I got experience, with:

* Java Swing and GUI components

* Event handling

* 2D arrays

* Recursion

* Backtracking

* Input validation

* Exception handling

* Solving problems using algorithms

## Future Improvements

I may add features in the future such as:

* Different Sudoku difficulty levels

* Sudoku puzzle generator

* Timer

* Better UI design

* Highlighting entries

* New Game option
