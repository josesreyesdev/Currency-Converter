package jsr.project.currency_converter.main;

import jsr.project.currency_converter.utils.config.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String apiKey = Configuration.API_KEY;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingresa tu moneda actual (por ejemplo, USD)");
            String currentCurrencyCode = scanner.nextLine().toUpperCase();

            if (currencyCodeIsValid(currentCurrencyCode)) {
                System.out.println("Ingresa la moneda deseada (por ejemplo, MXN):");
                String desiredCurrencyConvert = scanner.nextLine().toUpperCase();

                if (currencyCodeIsValid(desiredCurrencyConvert)) {

                    double amountOfMoney = 0;

                    do {
                        System.out.println("Ingresa la cantidad de " + currentCurrencyCode + " a convertir:");

                        // Verificar si el siguiente token es un double
                        if (scanner.hasNextDouble()) {
                            amountOfMoney = scanner.nextDouble();

                            // Consumir el salto de línea pendiente
                            scanner.nextLine();

                            break; // Salir del bucle si se ingresa un double válido
                        } else {
                            System.out.println("Entrada inválida. Por favor, ingresa una cantidad válida.");
                            scanner.nextLine(); // Limpiar la entrada del scanner
                        }
                    } while (true); // Continuar hasta que se ingrese un double válido

                    String uri = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + currentCurrencyCode;

                    System.out.println();
                    System.out.println("Ingresa una S para continuar ó una N para terminar");
                    String exit = scanner.nextLine();
                    if (exit.equalsIgnoreCase("N")) {
                        break;
                    }
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