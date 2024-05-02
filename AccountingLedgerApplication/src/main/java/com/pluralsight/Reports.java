package com.pluralsight;

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
    }

    private static void generatePreviousMonthReport(List<Transactions> transactions)
    {
    }

    private static void generateYearToDateReport(List<Transactions> transactions)
    {
    }

    private static void generatePreviousYearReport(List<Transactions> transactions)
    {
    }

    private static void searchByVendor(Scanner userInput, List<Transactions> transactions)
    {
    }
}



