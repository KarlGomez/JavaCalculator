package Calculator;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CalculatorGUI extends JFrame {
    private JTextField textField;
    private Calculator calculator;
    private Color darkGray = new Color(53, 53, 53);
    private Color lightGray = new Color(86, 86, 86);
    private Color darkerGray = new Color(36, 36, 36);

    public CalculatorGUI() {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(3);
        this.setSize(300, 400);
        this.setLocationRelativeTo((Component)null);
        this.getContentPane().setBackground(this.darkGray);
        this.textField = new JTextField();
        this.textField.setEditable(false);
        this.textField.setBackground(this.lightGray);
        this.textField.setForeground(Color.WHITE);
        this.textField.setFont(new Font("Arial", 0, 26));
        this.textField.setPreferredSize(new Dimension(280, 50));
        this.add(this.textField, "North");
        this.calculator = new Calculator();
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));
        buttonPanel.setBackground(this.darkGray);
        String[] buttonLabels = new String[]{"", "", "←", "C", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        String[] var3 = buttonLabels;
        int var4 = buttonLabels.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String label = var3[var5];
            JButton button = new JButton(label);
            button.addActionListener(new CalculatorButtonListener());
            if (label.matches("[0-9.]")) {
                button.setBackground(this.darkerGray);
            } else {
                button.setBackground(this.lightGray);
            }

            button.setForeground(Color.WHITE);
            buttonPanel.add(button);
        }

        this.add(buttonPanel, "Center");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculator = new CalculatorGUI();
            calculator.setVisible(true);
        });
    }

    private class CalculatorButtonListener implements ActionListener {
        private CalculatorButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.matches("[0-9.]")) {
                JTextField var10000 = CalculatorGUI.this.textField;
                String var10001 = CalculatorGUI.this.textField.getText();
                var10000.setText(var10001 + command);
            } else if (command.matches("[/*\\-+]")) {
                CalculatorGUI.this.calculator.setOperand(Double.parseDouble(CalculatorGUI.this.textField.getText()));
                CalculatorGUI.this.calculator.setOperator(command.charAt(0));
                CalculatorGUI.this.textField.setText("");
            } else if (command.equals("=")) {
                double result = CalculatorGUI.this.calculator.calculate(Double.parseDouble(CalculatorGUI.this.textField.getText()));
                CalculatorGUI.this.textField.setText(String.valueOf(result));
            } else if (command.equals("←")) {
                String text = CalculatorGUI.this.textField.getText();
                if (!text.isEmpty()) {
                    CalculatorGUI.this.textField.setText(text.substring(0, text.length() - 1));
                }
            } else if (command.equals("C")) {
                CalculatorGUI.this.textField.setText("");
            }

        }
    }
}

