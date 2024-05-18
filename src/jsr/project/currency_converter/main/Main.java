package jsr.project.currency_converter.main;

import jsr.project.currency_converter.models.ConversionInput;
import jsr.project.currency_converter.models.ExchangeRate;
import jsr.project.currency_converter.models.SearchExchangeRate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // código de moneda actual
            String currentCurrencyCode = promptForCurrencyCode(scanner, "Ingresa tu moneda actual (por ejemplo, MXN)");

            if (currencyCodeIsValid(currentCurrencyCode)) {

                ExchangeRate currentExchangeRate = getCurrentExchangeRate(currentCurrencyCode);

                if (currentExchangeRate.result().equalsIgnoreCase("error")) {
                    System.out.println("Error en la moneda actual, intenta de nuevo");
                    continue;
                }

                // Obtener la moneda deseada y la cantidad de dinero a convertir
                ConversionInput conversionInput = promptForConversionInput(scanner, currentExchangeRate);

                // Realizar la conversión aquí
                convertedAmount(conversionInput, currentExchangeRate);

                System.out.println();
                System.out.println("Si no desea continuar ingrese N, de lo contrario ingrese cualquier otra letra  ");
                String exit = scanner.nextLine();
                if (exit.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }
        System.out.println("Finalizó la ejecución");
    }

    // Conversor de monto
    private static void convertedAmount(ConversionInput conversionInput, ExchangeRate currentExchangeRate) {

        var desiredCurrency = conversionInput.desiredCurrency();

        double convertedAmount = conversionInput.amount() *
                currentExchangeRate.conversion_rates().get(desiredCurrency);

        double roundedAmount = Math.round(convertedAmount * 100.0) / 100.0;

        System.out.println("La cantidad en " + desiredCurrency + " son: " + roundedAmount);
    }

    // Solicitar entrada para convercion
    private static ConversionInput promptForConversionInput(Scanner scanner, ExchangeRate exchangeRate) {
        do {
            // moneda deseada a convertir
            String desiredCurrencyConvert = promptForCurrencyCode(scanner, "Ingresa la moneda deseada (por ejemplo, USD)");

            if (currencyCodeIsValid(desiredCurrencyConvert) &&
                    exchangeRate.conversion_rates().containsKey(desiredCurrencyConvert)) {

                //cantidad de dinero
                double amountOfMoney = promptForAmount(scanner, exchangeRate.base_code(), desiredCurrencyConvert);

                return new ConversionInput(desiredCurrencyConvert, amountOfMoney);
            } else {
                System.out.println("Error en la moneda deseada, intenta de nuevo!");
            }
        } while (true);
    }

    // Solicitar código de moneda
    private static String promptForCurrencyCode(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine().toUpperCase();
    }

    // Función que valida si un código de moneda es válido
    private static boolean currencyCodeIsValid(String currencyCode) {
        try {
            // Intenta convertir el código de moneda a un número
            Integer.parseInt(currencyCode);
            // Si no se lanza una excepción, significa que es un número, por lo que el código de moneda no es válido
            return false;
        } catch (NumberFormatException e) {
            // Si se lanza una excepción, significa que no es un número, por lo que el código de moneda es válido
            return true;
        }
    }

    // Función que obtiene la tasa de cambio actual para una moneda dada
    private static ExchangeRate getCurrentExchangeRate(String currencyCode) {
        SearchExchangeRate searchExchangeRate = new SearchExchangeRate();
        return searchExchangeRate.searchCurrentExchangeRate(currencyCode);
    }

    // Solicitar cantidad de dinero
    private static double promptForAmount(Scanner scanner, String currentCurrencyCode, String desiredCurrencyConvert) {
        while (true) {
            System.out.println("Ingresa la cantidad de " + currentCurrencyCode + " para convertir a " + desiredCurrencyConvert + ":");

            if (scanner.hasNextDouble()) {
                double amountOfMoney = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea pendiente
                return amountOfMoney;
            } else {
                System.out.println("Entrada inválida. Por favor, ingresa una cantidad válida.");
                scanner.nextLine(); // Limpiar la entrada del scanner
            }
        }
    }
}