package CurrencyCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CurrencyConverter extends JFrame {
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JTextField amountTextField;
    private JLabel resultLabel;
    private CurrencyConversion currencyConversion;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        currencyConversion = new CurrencyConversion();

        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] currencies = {"USD", "EUR", "GBP", "JPY"};
        fromCurrencyComboBox = new JComboBox<>(currencies);
        toCurrencyComboBox = new JComboBox<>(currencies);
        amountTextField = new JTextField();
        resultLabel = new JLabel("Converted Amount: ");

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        mainPanel.add(new JLabel("From Currency:"));
        mainPanel.add(fromCurrencyComboBox);
        mainPanel.add(new JLabel("To Currency:"));
        mainPanel.add(toCurrencyComboBox);
        mainPanel.add(new JLabel("Amount:"));
        mainPanel.add(amountTextField);
        mainPanel.add(convertButton);
        mainPanel.add(resultLabel);

        add(mainPanel);
    }

    private void convertCurrency() {
        try {
            String fromCurrency = fromCurrencyComboBox.getSelectedItem().toString();
            String toCurrency = toCurrencyComboBox.getSelectedItem().toString();
            double amount = Double.parseDouble(amountTextField.getText());

            double convertedAmount = currencyConversion.convert(fromCurrency, toCurrency, amount);
            DecimalFormat df = new DecimalFormat("#.##");
            resultLabel.setText("Converted Amount: " + df.format(convertedAmount) + " " + toCurrency);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CurrencyConverter().setVisible(true);
            }
        });
    }
}
