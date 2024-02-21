package CurrencyCalculator;

public class CurrencyConversion {
    // Conversion rates
    private static final double USD_TO_EUR = 0.84;
    private static final double USD_TO_GBP = 0.73;
    private static final double USD_TO_JPY = 109.33;

    public double convert(String fromCurrency, String toCurrency, double amount) {
        double convertedAmount = 0;
        if (fromCurrency.equals("USD")) {
            switch (toCurrency) {
                case "EUR":
                    convertedAmount = amount * USD_TO_EUR;
                    break;
                case "GBP":
                    convertedAmount = amount * USD_TO_GBP;
                    break;
                case "JPY":
                    convertedAmount = amount * USD_TO_JPY;
                    break;
                default:
                    convertedAmount = amount;
            }
        } else if (fromCurrency.equals("EUR")) {
            switch (toCurrency) {
                case "USD":
                    convertedAmount = amount / USD_TO_EUR;
                    break;
                case "GBP":
                    convertedAmount = amount * (1 / USD_TO_EUR) * USD_TO_GBP;
                    break;
                case "JPY":
                    convertedAmount = amount * (1 / USD_TO_EUR) * USD_TO_JPY;
                    break;
                default:
                    convertedAmount = amount;
            }
        } else if (fromCurrency.equals("GBP")) {
            switch (toCurrency) {
                case "USD":
                    convertedAmount = amount / USD_TO_GBP;
                    break;
                case "EUR":
                    convertedAmount = amount * (1 / USD_TO_GBP) * USD_TO_EUR;
                    break;
                case "JPY":
                    convertedAmount = amount * (1 / USD_TO_GBP) * USD_TO_JPY;
                    break;
                default:
                    convertedAmount = amount;
            }
        } else if (fromCurrency.equals("JPY")) {
            switch (toCurrency) {
                case "USD":
                    convertedAmount = amount / USD_TO_JPY;
                    break;
                case "EUR":
                    convertedAmount = amount * (1 / USD_TO_JPY) * USD_TO_EUR;
                    break;
                case "GBP":
                    convertedAmount = amount * (1 / USD_TO_JPY) * USD_TO_GBP;
                    break;
                default:
                    convertedAmount = amount;
            }
        }
        return convertedAmount;
    }
}
