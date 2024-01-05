import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    // Declaring variables for num1, num2, and result
    double num1 = 0, num2 = 0, result = 0;

    // Declaring a variable to keep track of the number of times the decimal button has been clicked
    int decimalClickCount = 0;

    // Declaring a variable to keep track of the operator
    String operator = null;

    // Creating instance of JFrame  
    JFrame frame = new JFrame();
        
    // Creating instance of JTextField
    JTextField textField = new JTextField();

    // Creating instances of JButtons
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton plus = new JButton("+");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton minus = new JButton("-");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton multiply = new JButton("*");
    JButton decimal = new JButton(".");
    JButton zero = new JButton("0");
    JButton equals = new JButton("=");
    JButton divide = new JButton("/");
    JButton negative = new JButton("(-)");
    JButton delete = new JButton("del");
    JButton clear = new JButton("clr");

    Calculator (){
        // Disabling direct edit from the text field and hiding caret
        textField.setEditable(false);

        textField.setCaretColor(Color.WHITE);

        // Setting size and location of text field
        textField.setBounds(75, 15, 240, 60); //x axis,5 y axis, width, height  

        //Setting size and locations of number, operator, decimal, and equals buttons
        one.setBounds(75, 75, 60, 60); //x axis,5 y axis, width, height  
        two.setBounds(135, 75, 60, 60);
        three.setBounds(195, 75, 60, 60);
        plus.setBounds(255, 75, 60, 60);
        four.setBounds(75, 135, 60, 60);
        five.setBounds(135, 135, 60, 60);
        six.setBounds(195, 135, 60, 60);
        minus.setBounds(255, 135, 60, 60);
        seven.setBounds(75, 195, 60, 60);
        eight.setBounds(135, 195, 60, 60);
        nine.setBounds(195, 195, 60, 60);
        multiply.setBounds(255, 195, 60, 60);
        decimal.setBounds(75, 255, 60, 60);
        zero.setBounds(135, 255, 60, 60);
        equals.setBounds(195, 255, 60, 60);
        divide.setBounds(255, 255, 60, 60);

        // Setting size and locations of negative, delete, and clear buttons
        negative.setBounds(90, 320, 70, 60); //x axis,5 y axis, width, height  
        clear.setBounds(160, 320, 70, 60);
        delete.setBounds(230, 320, 70, 60); 

        // Adding text field to the frame
        frame.add(textField);

        JButton[] buttons = new JButton[19];
        // JButton[] otherButtons = new JButton[19];

        // Number buttons
        buttons[0] = one;
        buttons[1] = two;
        buttons[2] = three;
        buttons[3] = four;
        buttons[4] = five;
        buttons[5] = six;
        buttons[6] = seven;
        buttons[7] = eight;
        buttons[8] = nine;
        buttons[9] = zero;

        // Operator buttons
        buttons[10] = plus;
        buttons[11] = minus;
        buttons[12] = multiply;
        buttons[13] = divide;
        buttons[14] = equals;

        // Other buttons
        buttons[15] = decimal;
        buttons[16] = negative;
        buttons[17] = delete;
        buttons[18] = clear;

        // Adding buttons in JFrame  
        for (int i = 0; i < 19; i++) {
            frame.add(buttons[i]);

            buttons[i].addActionListener(this);
        }

        // Setting frame size and layout and making it visible
        frame.setSize(400,500); //400 width and 500 height  
        frame.setLayout(null); //using no layout managers  
        frame.setVisible(true); //making the frame visible      
    }

    @Override 
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton clickedButton = (JButton) source;
            String buttonText = clickedButton.getText();

            if(buttonText.matches("\\d")){
                textField.setText(textField.getText() + buttonText);
            } else {
                switch(buttonText){
                    case "+":
                        operator = "+";
                        num1 = Double.parseDouble(textField.getText());
                        textField.setText("");
                        break;
                    case "-":
                        operator = "-";
                        num1 = Double.parseDouble(textField.getText());
                        textField.setText("");
                        break;
                    case "*":
                        operator = "*";
                        num1 = Double.parseDouble(textField.getText());
                        textField.setText("");
                        break;
                    case "/":
                        operator = "/";
                        num1 = Double.parseDouble(textField.getText());
                        textField.setText("");
                        break;
                    case "=":
                        num2 = Double.parseDouble(textField.getText());
                        performCalculation();
                        textField.setText(String.valueOf(result));
                        decimalClickCount = 0;
                        break;
                    case ".":
                        decimalClickCount++;

                        if(decimalClickCount <= 1){
                            textField.setText(textField.getText() + buttonText);
                        }
                        decimalClickCount = 0;
                        break;
                    case "(-)":
                        num1 = Double.parseDouble(textField.getText()) * -1;
                        textField.setText("" + num1);
                        break;
                    case "clr": 
                        num1 = 0;
                        result = 0;
                        decimalClickCount = 0;
                        textField.setText("");
                        break;
                    case "del": 
                        String originalText = textField.getText();

                        if(originalText.substring(originalText.length() - 1).equals(".")){
                            decimalClickCount = 0;
                        }
                        textField.setText(originalText.substring(0, originalText.length() - 1));
                }
            }
        }
    }

    private void performCalculation() {
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            // Add cases for other operators
        }
    }

    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();
    }
}


