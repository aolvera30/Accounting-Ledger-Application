package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.Transactions.saveTransactions;

public class Main
{
    public static void main(String[] args)
    {
        // Load transactions from file
        List<Transactions> transactions = Transactions.loadTransactions();

        Scanner userInput = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("Welcome, please choose one of the following: ");
            System.out.println();
            System.out.println("D.Add Deposit");
            System.out.println("P.Make Payment");
            System.out.println("L.Ledger");
            System.out.println("X.Exit");


            String choice = userInput.nextLine().toUpperCase();
            switch (choice) {
                case "D":
                    addDeposit(userInput, transactions);
                    break;
                case "P":
                    makePayment(userInput, transactions);
                    break;
                case "L":
                    viewLedger(transactions);
                    break;
                case "X":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        saveTransactions(transactions);
        userInput.close();

    }

    private static void addDeposit(Scanner userInput, List<Transactions> transactions)
    {

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println("Enter deposit description: ");
        String description = userInput.nextLine();

        System.out.println("Enter child's name: ");
        String vendor = userInput.nextLine();

        System.out.println("Enter deposit amount: ");
        double amount = userInput.nextDouble();
        userInput.nextLine();


        Transactions deposit = new Transactions(date, time, description, vendor, amount);
        transactions.add(deposit);

        Transactions.saveTransactions(transactions);

        System.out.println("Deposit added successfully :) ");

    }

    private static void makePayment(Scanner userInput, List<Transactions> transactions)
    {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println("Enter payment description: ");
        String description = userInput.nextLine();

        System.out.println("Enter vendor's name");
        String vendor = userInput.nextLine();

        System.out.println("Enter payment amount: ");
        double amount = userInput.nextDouble();
        userInput.nextLine();

        // Make the payment amount negative
        amount = -Math.abs(amount);

        Transactions payment = new Transactions(date, time, description, vendor, amount);
        transactions.add(payment);

        Transactions.saveTransactions(transactions);

        System.out.println("Payment made successfully :) ");

    }

    private static void viewLedger(List<Transactions> transactions)
    {
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("Ledger Display Options: ");
            System.out.println("A. All Entries");
            System.out.println("D. Deposits");
            System.out.println("P. Payments");
            System.out.println("R. Reports");
            System.out.println("O. Back");

            String choice = userInput.nextLine().toUpperCase();
            switch (choice) {
                case "A":
                    displayAllEntries(transactions);
                    break;

                case "D":
                    displayDeposits(transactions);
                    break;

                case "P":
                    displayPayments(transactions);
                    break;

                case "R":
                    Reports.displayReports(userInput, transactions); // Call displayReports from Reports class
                    break;

                case "O":
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }

    }

    private static void displayAllEntries(List<Transactions> transactions)
    {
        System.out.println("All Entries:");
        for (Transactions transaction : transactions) {
            System.out.println(transaction.toCSVString());
        }
    }

    private static void displayDeposits(List<Transactions> transactions)
    {
        System.out.println("Deposits:");
        for (Transactions transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.println(transaction.toCSVString());
            }
        }
    }

    private static void displayPayments(List<Transactions> transactions)
    {
        System.out.println("Payments:");
        for (Transactions transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction.toCSVString());
            }
        }
    }
}

