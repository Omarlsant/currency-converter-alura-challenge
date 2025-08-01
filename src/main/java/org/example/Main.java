package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiClient apiClient = new ApiClient();

        try {
            System.out.println("Loading exchange rates, please wait...");
            // We fetch the exchange rates only once at the beginning (using USD as base)
            ApiResponse apiResponse = apiClient.getExchangeRates("USD");

            if (!"success".equals(apiResponse.result())) {
                System.out.println("Could not retrieve exchange rates. Please check your API Key or connection.");
                return;
            }
            System.out.println("Exchange rates loaded successfully!");

            // Main program loop
            while (true) {
                displayMenu();
                int option = 0;
                try {
                    option = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a number only.");
                    scanner.next(); // Clear the invalid input from the scanner
                    continue;
                }

                if (option == 13) {
                    System.out.println("Thank you for using the Currency Converter. Goodbye!");
                    break;
                }

                if (option < 1 || option > 12) {
                    System.out.println("Invalid option, please try again.");
                    continue;
                }

                System.out.print("Enter the amount you wish to convert: ");
                double amount;
                try {
                    amount = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid numerical amount.");
                    scanner.next(); // Clear the invalid input
                    continue;
                }

                // Conversion logic
                performConversion(option, amount, apiResponse);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error connecting to the API: " + e.getMessage());
            System.out.println("Please ensure you have an internet connection and your API Key is correct.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void displayMenu() {
        System.out.println("\n***************************************************");
        System.out.println("Welcome to the Currency Converter =]");
        System.out.println("\nChoose one of the following conversion options:");
        System.out.println(" 1) US Dollar (USD) =>> Peruvian Sol (PEN)");
        System.out.println(" 2) Peruvian Sol (PEN) =>> US Dollar (USD)");
        System.out.println(" 3) US Dollar (USD) =>> Argentine Peso (ARS)");
        System.out.println(" 4) Argentine Peso (ARS) =>> US Dollar (USD)");
        System.out.println(" 5) US Dollar (USD) =>> Brazilian Real (BRL)");
        System.out.println(" 6) Brazilian Real (BRL) =>> US Dollar (USD)");
        System.out.println(" 7) US Dollar (USD) =>> Colombian Peso (COP)");
        System.out.println(" 8) Colombian Peso (COP) =>> US Dollar (USD)");
        System.out.println(" 9) US Dollar (USD) =>> Bolivian Boliviano (BOB)");
        System.out.println("10) Bolivian Boliviano (BOB) =>> US Dollar (USD)");
        System.out.println("11) US Dollar (USD) =>> Chilean Peso (CLP)");
        System.out.println("12) Chilean Peso (CLP) =>> US Dollar (USD)");
        System.out.println("13) Exit");
        System.out.print("Choose a valid option: ");
        System.out.println("\n***************************************************");
    }

    public static void performConversion(int option, double amount, ApiResponse response) {
        String fromCurrency = "", toCurrency = "";

        switch (option) {
            case 1 -> { fromCurrency = "USD"; toCurrency = "PEN"; }
            case 2 -> { fromCurrency = "PEN"; toCurrency = "USD"; }
            case 3 -> { fromCurrency = "USD"; toCurrency = "ARS"; }
            case 4 -> { fromCurrency = "ARS"; toCurrency = "USD"; }
            case 5 -> { fromCurrency = "USD"; toCurrency = "BRL"; }
            case 6 -> { fromCurrency = "BRL"; toCurrency = "USD"; }
            case 7 -> { fromCurrency = "USD"; toCurrency = "COP"; }
            case 8 -> { fromCurrency = "COP"; toCurrency = "USD"; }
            case 9 -> { fromCurrency = "USD"; toCurrency = "BOB"; }
            case 10 -> { fromCurrency = "BOB"; toCurrency = "USD"; }
            case 11 -> { fromCurrency = "USD"; toCurrency = "CLP"; }
            case 12 -> { fromCurrency = "CLP"; toCurrency = "USD"; }
        }

        Double fromRate = response.conversion_rates().get(fromCurrency);
        Double toRate = response.conversion_rates().get(toCurrency);

        if (fromRate == null || toRate == null) {
            System.out.printf("Conversion rate not found for %s or %s.%n", fromCurrency, toCurrency);
            return;
        }

        // The conversion formula remains the same and works for all cases
        // To convert from A to B (with a common base like USD): (amount in A / rate of A) * rate of B
        double convertedAmount = (amount / fromRate) * toRate;

        System.out.printf("The value of %.2f [%s] is equivalent to =>>> %.2f [%s]%n",
                amount, fromCurrency, convertedAmount, toCurrency);
    }
}
