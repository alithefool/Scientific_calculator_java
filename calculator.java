import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class calculator {

    private JFrame frame;
    private JTextField textField;

    double first; // First operand for calculations
    double second; // Second operand for calculations
    double result; // Result of the calculation
    String operation; // Stores the current operation

    // Launch the application.
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                calculator window = new calculator();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace(); // Handle exceptions
            }
        });
    }

    public calculator() {
        initialize(); 
    }

    // Initialize the contents of the frame.
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(100, 100, 357, 539);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); // Set layout to null for absolute positioning

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        textField.setBounds(10, 39, 320, 63);
        textField.setBackground(Color.DARK_GRAY); 
        textField.setForeground(Color.WHITE);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("SCIENTIFIC CALCULATOR");
        lblNewLabel.setBounds(10, 11, 320, 27);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel.setForeground(Color.WHITE);
        frame.getContentPane().add(lblNewLabel);

        // Button setup - create buttons for the calculator's functions

        // Clear buttons
        createButton("C", 139, 243, e -> textField.setText(null)); // Clear
        createButton("CE", 74, 243, e -> textField.setText(null)); // Clear entry

        // Number buttons
        createButton("0", 74, 449);
        createButton("1", 74, 398);
        createButton("2", 139, 398);
        createButton("3", 202, 398);
        createButton("4", 74, 347);
        createButton("5", 139, 347);
        createButton("6", 202, 347);
        createButton("7", 74, 295);
        createButton("8", 139, 295);
        createButton("9", 202, 295);
        createButton(".", 202, 449);

        // Operation buttons
        createOperationButton("+", 266, 243); // Addition
        createOperationButton("-", 266, 295); // Subtraction
        createOperationButton("*", 266, 347); // Multiplication
        createOperationButton("/", 266, 398); // Division
        createButton("X^Y", 10, 243); // Power

        // Function buttons
        createFunctionButton("sin", 139, 139, e -> performFunction(Math::sin)); // Sine function
        createFunctionButton("cos", 202, 139, e -> performFunction(Math::cos)); // Cosine function
        createFunctionButton("tan", 266, 139, e -> performFunction(Math::tan)); // Tangent function
        createFunctionButton("sinh", 139, 191, e -> performFunction(Math::sinh)); // Hyperbolic sine function
        createFunctionButton("cosh", 202, 191, e -> performFunction(Math::cosh)); // Hyperbolic cosine function
        createFunctionButton("tanh", 266, 191, e -> performFunction(Math::tanh)); // Hyperbolic tangent function
        createFunctionButton("log", 74, 192, e -> performFunction(Math::log)); // Logarithm function
        createFunctionButton("ex", 74, 139, e -> performFunction(Math::exp)); // Exponential function
        createFunctionButton("\u221A", 10, 139, e -> performFunction(Math::sqrt)); // Square root function
        createFunctionButton("1/x", 9, 191, e -> performFunction(value -> 1 / value)); // Reciprocal function
        createFunctionButton("x2", 10, 347, e -> performFunction(value -> value * value)); // Square function
        createFunctionButton("x3", 10, 295, e -> performFunction(value -> value * value * value)); // Cubic function
        createFunctionButton("n!", 10, 398, e -> { // Factorial function
            double a = Double.parseDouble(textField.getText());
            double f = 1;
            while (a != 0) {
                f *= a--; // Calculate factorial
            }
            textField.setText(String.valueOf(f)); // Display result
        });

        // Special buttons
        createEqualButton(266, 449);
        createBackspaceButton(202, 243);

        // +/- button to change the sign of the input
        JButton button = new JButton("+/-");
        button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button.setBounds(10, 449, 64, 50);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.addActionListener(e -> {
            double a = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(a * -1)); 
        });
        frame.getContentPane().add(button); 
    }

    // Creates a standard button
    private void createButton(String text, int x, int y) {
        createButton(text, x, y, e -> {
            String number = textField.getText() + text; 
            textField.setText(number);
        });
    }

    // Overloaded method to create a button with an action listener
    private void createButton(String text, int x, int y, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action); 
        button.setFont(new Font("Tahoma", Font.BOLD, 23));
        button.setBounds(x, y, 64, 50);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(button); 
    }

    // Creates a function button (e.g., trig functions)
    private void createFunctionButton(String text, int x, int y, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action); 
        button.setFont(new Font("Tahoma", Font.PLAIN, 13));
        button.setBounds(x, y, 64, 50);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(button); 
    }

    // Creates the equals button
    private void createEqualButton(int x, int y) {
        JButton button = new JButton("=");
        button.addActionListener(e -> {
            second = Double.parseDouble(textField.getText()); // Get second operand
            // Perform calculation based on selected operation
            switch (operation) {
                case "+" -> result = first + second;
                case "-" -> result = first - second;
                case "*" -> result = first * second;
                case "/" -> result = first / second;
                case "%" -> result = first % second;
                case "X^Y" -> result = Math.pow(first, second);
            }
            textField.setText(String.format("%.2f", result)); // Display result
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 21));
        button.setBounds(x, y, 64, 50);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(button); 
    }

    // Creates an operation button (+, -, *, /)
    private void createOperationButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.addActionListener(e -> {
            first = Double.parseDouble(textField.getText()); 
            textField.setText(""); 
            operation = text; 
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 21));
        button.setBounds(x, y, 64, 50);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(button); 
    }

    // Creates a backspace button
    private void createBackspaceButton(int x, int y) {
        JButton button = new JButton("B");
        button.addActionListener(e -> {
            String backSpace = null;
            if (textField.getText().length() > 0) {
                StringBuilder str = new StringBuilder(textField.getText());
                str.deleteCharAt(textField.getText().length() - 1);
                backSpace = str.toString();
                textField.setText(backSpace); 
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 19));
        button.setBounds(x, y, 64, 50);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(button); 
    }

    // Applies a mathematical function to the current input
    private void performFunction(java.util.function.Function<Double, Double> function) {
        double a = Double.parseDouble(textField.getText()); // Get current input
        textField.setText(String.valueOf(function.apply(a))); // Apply function and display result
    }
}
