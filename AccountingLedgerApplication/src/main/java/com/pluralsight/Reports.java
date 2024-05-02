package com.pluralsight;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Reports
{

    public static void displayReports(Scanner userInput, List<Transactions> transactions)
    {

        while (true) {
            System.out.println();
            System.out.println("Reports:");
            System.out.println("1. Month To Date");
            System.out.println("2. Previous Month");
            System.out.println("3. Year To Date");
            System.out.println("4. Previous Year");
            System.out.println("5. Search by Vendor");
            System.out.println("0. Back");

            String choice = userInput.nextLine();
            switch (choice) {
                case "1":
                    generateMonthToDateReport(transactions);
                    break;

                case "2":
                    generatePreviousMonthReport(transactions);
                    break;

                case "3":
                    generateYearToDateReport(transactions);
                    break;

                case "4":
                    generatePreviousYearReport(transactions);
                    break;

                case "5":
                    searchByVendor(userInput, transactions);
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");


            }


        }
    }

    private static void generateMonthToDateReport(List<Transactions> transactions)
    {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        double totalDeposits = 0;
        double totalPayments = 0;

        System.out.println("Month To Date Report: ");
        System.out.println("Date | Time| Description | Vendor | Amount ");
        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (transactionDate.getMonthValue() == currentMonth && transactionDate.getYear() == currentYear) {
                System.out.println(transaction.toCSVString());
                if (transaction.getAmount() > 0) {
                    totalDeposits += transaction.getAmount();
                } else {
                    totalPayments += transaction.getAmount();
                }
            }
        }
        System.out.println("Total Deposit Amount: " + totalDeposits);
        System.out.println("Total Payment Amount: " + totalPayments);


    }

    private static void generatePreviousMonthReport(List<Transactions> transactions)
    {
        LocalDate currentDate = LocalDate.now();
        LocalDate previousMonthDate = currentDate.minusMonths(1);
        int previousMonth = previousMonthDate.getMonthValue();
        int previousYear = previousMonthDate.getYear();

        double totalDeposits = 0;
        double totalPayments = 0;

        System.out.println("Previous Month Report:");
        System.out.println("Date | Time | Description | Vendor | Amount");
        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (transactionDate.getMonthValue() == previousMonth && transactionDate.getYear() == previousYear) {
                System.out.println(transaction.toCSVString());
                if (transaction.getAmount() > 0) {
                    totalDeposits += transaction.getAmount();
                } else {
                    totalPayments += transaction.getAmount();
                }
            }
        }

        System.out.println("Total Deposit Amount: " + totalDeposits);
        System.out.println("Total Payment Amount: " + totalPayments);

    }

    private static void generateYearToDateReport(List<Transactions> transactions)
    {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        double totalDeposits = 0;
        double totalPayments = 0;

        System.out.println("Year To Date Report:");
        System.out.println("Date | Time | Description | Vendor | Amount");
        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (transactionDate.getYear() == currentYear) {
                System.out.println(transaction.toCSVString());
                if (transaction.getAmount() > 0) {
                    totalDeposits += transaction.getAmount();
                } else {
                    totalPayments += transaction.getAmount();
                }

            }
        }

        System.out.println("Total Deposit Amount: " + totalDeposits);
        System.out.println("Total Payment Amount: " + totalPayments);

    }

    private static void generatePreviousYearReport(List<Transactions> transactions)
    {
        LocalDate currentDate = LocalDate.now();
        int previousYear = currentDate.minusYears(1).getYear();

        double totalDeposits = 0;
        double totalPayments = 0;

        System.out.println("Previous Year Report:");
        System.out.println("Date | Time | Description | Vendor | Amount");
        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (transactionDate.getYear() == previousYear) {
                System.out.println(transaction.toCSVString());
                if (transaction.getAmount() > 0) {
                    totalDeposits += transaction.getAmount();
                } else {
                    totalPayments += transaction.getAmount();
                }
            }
        }

        System.out.println("Total Deposit Amount: " + totalDeposits);
        System.out.println("Total Payment Amount: " + totalPayments);
    }

    private static void searchByVendor(Scanner userInput, List<Transactions> transactions)
    {
        System.out.println("Enter vendor's name: ");
        String vendor = userInput.nextLine();
        System.out.println("Transactions for vendor " + vendor + ":");
        for (Transactions transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println(transaction.toCSVString());
            }
        }

    }
}
