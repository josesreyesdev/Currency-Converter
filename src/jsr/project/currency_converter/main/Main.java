package jsr.project.currency_converter.main;

import jsr.project.currency_converter.models.ExchangeRate;
import jsr.project.currency_converter.models.SearchExchangeRate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingresa tu moneda actual (por ejemplo, MXN)");
            String currentCurrencyCode = scanner.nextLine().toUpperCase();

            if (currencyCodeIsValid(currentCurrencyCode)) {

                do {
                    SearchExchangeRate searchExchangeRate = new SearchExchangeRate();
                    ExchangeRate currentExchangeRate = searchExchangeRate
                            .searchCurrentExchangeRate(currentCurrencyCode);
                    System.out.println("ExchangeRate ==> " + currentExchangeRate);

                    if (currentExchangeRate.result().equalsIgnoreCase("error")) {
                        System.out.println("Error en la moneda actual, intenta de nuevo");
                        break;
                    } else {
                        System.out.println("Ingresa la moneda deseada (por ejemplo, USD):");
                        String desiredCurrencyConvert = scanner.nextLine().toUpperCase();

                        if (currencyCodeIsValid(desiredCurrencyConvert)) {

                            do {

                                if (!currentExchangeRate.conversion_rates().containsKey(desiredCurrencyConvert)) {
                                    System.out.println("No encontre un valor para " + desiredCurrencyConvert + " intenta de nuevo");
                                    break;
                                }

                                double amountOfMoney = 0;

                                System.out.println("Ingresa la cantidad de " + currentCurrencyCode + " a convertir en " + desiredCurrencyConvert + ":");

                                if (scanner.hasNextDouble()) {
                                    amountOfMoney = scanner.nextDouble();

                                    // Consumir el salto de línea pendiente
                                    scanner.nextLine();

                                    break; // Salir del bucle si se ingresa un double válido
                                } else {
                                    System.out.println("Entrada inválida. Por favor, ingresa una cantidad válida.");
                                    scanner.nextLine(); // Limpiar la entrada del scanner
                                }



                            } while (true);
                            break;
                        }
                    }
                } while (true);
                System.out.println();
                System.out.println("Ingresa una S para continuar ó una N para terminar");
                String exit = scanner.nextLine();
                if (exit.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }

        System.out.println("Finalizo la ejecución");
    }

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
}