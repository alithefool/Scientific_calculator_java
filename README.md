Scientific Calculator - Java (JFrame)
Overview

This project is a scientific calculator built using Java Swing (JFrame). It performs basic arithmetic operations, such as addition, subtraction, multiplication, and division, as well as advanced scientific functions like trigonometry, logarithms, exponentiation, and factorial calculations. The calculator has a simple GUI with responsive buttons for numeric input and operations.
Features

    Basic Arithmetic: Addition, Subtraction, Multiplication, Division.
    Scientific Functions:
        Trigonometric: sin, cos, tan.
        Hyperbolic functions: sinh, cosh, tanh.
        Logarithmic and exponential functions: log, e^x.
        Power functions: x^2, x^3, X^Y.
        Square root (√x), reciprocal (1/x), and factorial (n!).
    Input Modifications: Clear, Clear Entry (CE), Backspace, and Sign change (+/-).
    Responsive UI: Graphical interface created using JFrame for intuitive user interaction.

Components
User Interface Elements

    TextField: Displays the input and results of calculations.
    Buttons:
        Numeric buttons: 0-9 for number inputs.
        Arithmetic operators: +, -, *, /.
        Special function buttons: sin, cos, tan, log, X^Y, etc.
        Equal button (=): Computes and displays the result of the calculation.
        Backspace button (B): Deletes the last entered digit.
        Clear (C) and Clear Entry (CE) buttons: Clears the input.

Supported Operations

    Basic Operations:
        Addition: +
        Subtraction: -
        Multiplication: *
        Division: /

    Scientific Operations:
        Trigonometric Functions: sin, cos, tan
        Hyperbolic Functions: sinh, cosh, tanh
        Logarithm: log
        Exponential: e^x
        Power: x^y, x^2, x^3
        Square Root: √x
        Reciprocal: 1/x
        Factorial: n!

    Special Functionalities:
        Sign Change (+/-): Changes the sign of the current input.
        Backspace: Deletes the last entered digit.

How to Use

    Launch the Calculator:
        Run the calculator.java file. The GUI will open up with a display and buttons for input.

    Performing Calculations:
        Enter numbers using the numeric buttons (0-9).
        Click on operation buttons (+, -, *, /) for basic calculations.
        Use scientific function buttons for advanced operations like sin, log, x^2, n!, etc.
        Press = to see the result.

    Clearing Input:
        C: Clears the entire input.
        CE: Clears the current entry.
        Backspace: Deletes the last character.

    Changing Sign:
        Use the +/- button to toggle between positive and negative values.

Code Structure

    Main Class: calculator.java
        Contains the main method to launch the application.
        Initializes the GUI components (buttons, text fields, etc.).
        Handles button actions for different operations.

    Key Methods:
        createButton: Creates numeric or operator buttons.
        createFunctionButton: Generates buttons for advanced mathematical functions.
        createEqualButton: Defines the = button's behavior to evaluate expressions.
        performFunction: Applies the selected scientific function to the current input.

How to Run

    Prerequisites:
        Java Development Kit (JDK) installed on your system.
        A Java IDE (like IntelliJ, Eclipse, or NetBeans) or a terminal to compile and run the program.

    Running the Program:
        Compile the calculator.java file:

javac calculator.java

Run the compiled file:

        java calculator

The calculator will launch, and you can start using it to perform calculations.
