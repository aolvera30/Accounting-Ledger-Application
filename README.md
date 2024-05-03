# Accounting-Ledger-Application

Overview:
This Java application manages transactions for my child care services, as well as gas expenses. This application allows me to make deposits, payments, view ledgers, and generate various reports.

Main Class:

Purpose:
-The Main class serves as the entry point of the application.
-It prompts user with a menu to add deposits, make payments, view ledgers, or exit the program.
-It handles user inputs and calls corresponding methods based on the user's choice.

Methods:
1.main(String[] args):
Entry point of the application.
Manages the main loop for user interaction.
Calls methods to handle different user choices.

2.addDeposit(Scanner userInput, List<Transactions> transactions):
Allows users to add deposits.
Collects deposit details such as description, child's name, and amount.
Saves the deposit transaction to the ledger.

3.makePayment(Scanner userInput, List<Transactions> transactions):
Allows users to make payments.
Collects payment details such as description, vendor's name, and amount.
Saves the payment transaction to the ledger.

4.viewLedger(List<Transactions> transactions):
Allows users to view ledger options.
Provides options to view all entries, deposits, payments, generate reports, or go back to the main menu.


Transactions Class:

Purpose:
-The Transactions class represents individual transactions.
-It handles the creation, formatting, loading, and saving of transactions.

Fields:
- date, time, description, vendor, amount: Attributes of a transaction.

Methods:
1.toCSVString():
Formats a transaction as a CSV string.

2.fromCSVString(String csvLine):
Parses a CSV string to create a transaction object.

3.saveTransactions(List<Transactions> transactions):
Saves transactions to a CSV file.

4.loadTransactions():
Loads transactions from a CSV file.


Reports Class:

Purpose:
The Reports class provides methods to generate various types of reports based on transactions.

Methods:
1.displayReports(Scanner userInput, List<Transactions> transactions):
Displays a menu to choose different types of reports.
Calls corresponding report generation methods based on user input.

2.Report Generation Methods:
generateMonthToDateReport(List<Transactions> transactions): Generates a report for transactions within the current month.

generatePreviousMonthReport(List<Transactions> transactions): Generates a report for transactions within the previous month.

generateYearToDateReport(List<Transactions> transactions): Generates a report for transactions within the current year.

generatePreviousYearReport(List<Transactions> transactions): Generates a report for transactions within the previous year.

searchByVendor(Scanner userInput, List<Transactions> transactions): Searches transactions by vendor name and displays the results.




