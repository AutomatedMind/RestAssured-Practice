package complexJson.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import complexJson.financeEntitiesTransponster.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DeserializationForComplexJson {
    @Test
    public void deserializeBankingJsonToObject() throws IOException {
        // Reading the banking JSON file
        File bankingJson = new File("src/test/resources/banking_with_loans_mortgages_friends.json");
        ObjectMapper objectMapper = new ObjectMapper();

        // Deserializing the JSON into a Customer object
        Customer customer = objectMapper.readValue(bankingJson, Customer.class);

        // Getting customer details
        String customerName = customer.getName();
        String customerEmail = customer.getEmail();
        String customerPhone = customer.getPhone();
        long customerId = customer.getCustomerId();

        // Printing customer details
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Email: " + customerEmail);
        System.out.println("Customer Phone: " + customerPhone);
        System.out.println("Customer ID: " + customerId);

        // Getting accounts of the customer
        List<Account> accounts = customer.getAccounts();
        for (Account account : accounts) {
            long accountId = account.getAccountId();
            String accountType = account.getAccountType();
            double accountBalance = account.getBalance();
            System.out.println("\nAccount ID: " + accountId);
            System.out.println("Account Type: " + accountType);
            System.out.println("Account Balance: " + accountBalance);

            // Getting transactions of the account
            List<Transaction> transactions = account.getTransactions();
            for (Transaction transaction : transactions) {
                long transactionId = transaction.getTransactionId();
                String transactionDate = transaction.getDate();
                double transactionAmount = transaction.getAmount();
                String transactionDescription = transaction.getDescription();
                System.out.println("\nTransaction ID: " + transactionId);
                System.out.println("Transaction Date: " + transactionDate);
                System.out.println("Transaction Amount: " + transactionAmount);
                System.out.println("Transaction Description: " + transactionDescription);
            }
        }

        // Getting loans of the customer
        List<Loan> loans = customer.getLoans();
        for (Loan loan : loans) {
            long loanId = loan.getLoanId();
            String loanType = loan.getLoanType();
            double loanAmount = loan.getLoanAmount();
            double interestRate = loan.getInterestRate();
            System.out.println("\nLoan ID: " + loanId);
            System.out.println("Loan Type: " + loanType);
            System.out.println("Loan Amount: " + loanAmount);
            System.out.println("Interest Rate: " + interestRate);

        }

        // Getting mortgages of the customer
        List<Mortgage> mortgages = customer.getMortgages();
        for (Mortgage mortgage : mortgages) {
            long mortgageId = mortgage.getMortgageId();
            String propertyAddress = mortgage.getPropertyAddress();
            double mortgageAmount = mortgage.getMortgageAmount();
            double mortgageOutstandingAmount = mortgage.getOutstandingAmount();
            double mortgageInterestRate = mortgage.getInterestRate();
            long mortgageTermInYears = mortgage.getTermInYears();
            double mortgageMonthlyPayment = mortgage.getMonthlyPayment();
            System.out.println("\nMortgage ID: " + mortgageId);
            System.out.println("Property Address: " + propertyAddress);
            System.out.println("Mortgage Amount: " + mortgageAmount);
            System.out.println("Mortgage Outstanding Amount: " + mortgageOutstandingAmount);
            System.out.println("Mortgage Interest Rate: " + mortgageInterestRate);
            System.out.println("Term in Years: " + mortgageTermInYears);
            System.out.println("Monthly Payment: " + mortgageMonthlyPayment);

            // Getting payments for the mortgage
            List<Payment> mortgagePayments = mortgage.getPayments();
            for (Payment mortgagePayment : mortgagePayments) {
                long mortgagePaymentId = mortgagePayment.getPaymentId();
                String mortgagePaymentDate = mortgagePayment.getDate();
                double mortgagePaymentAmount = mortgagePayment.getAmount();
                System.out.println("\nMortgage Payment ID: " + mortgagePaymentId);
                System.out.println("Mortgage Payment Date: " + mortgagePaymentDate);
                System.out.println("Mortgage Payment Amount: " + mortgagePaymentAmount);
            }
        }
    }
}
