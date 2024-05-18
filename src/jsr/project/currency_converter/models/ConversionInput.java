package jsr.project.currency_converter.models;

public class ConversionInput {
    private String desiredCurrency;
    private double amount;

    public ConversionInput(String desiredCurrency, double amount) {
        this.desiredCurrency = desiredCurrency;
        this.amount = amount;
    }

    public String getDesiredCurrency() {
        return desiredCurrency;
    }

    public double getAmount() {
        return amount;
    }
}
