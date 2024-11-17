package complexJson.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import complexJson.financeEntitiesTransponster.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class SerializationForComplexJson {

    @Test
    public void serializationForBankingJson() throws IOException {
        // Creating Customer object and setting values using setter methods
        Customer customer = new Customer();
        customer.setCustomerId(123456789);
        customer.setName("Rachel Green");
        customer.setEmail("rachel.green@centralperk.com");
        customer.setPhone("555-RACHEL");

        // Creating Savings Account object and setting values
        Account savingsAccount = new Account();
        savingsAccount.setAccountId(987654321);
        savingsAccount.setAccountType("Savings");
        savingsAccount.setBalance(200000.50);

        // Creating Transactions for the Savings account
        Transaction savingsTransaction1 = new Transaction();
        savingsTransaction1.setTransactionId(1001);
        savingsTransaction1.setDate("2024-02-10");
        savingsTransaction1.setAmount(-500.25); // Transaction amount (negative indicates debit)
        savingsTransaction1.setDescription("Shopping for clothes");

        Transaction savingsTransaction2 = new Transaction();
        savingsTransaction2.setTransactionId(1002);
        savingsTransaction2.setDate("2024-02-15");
        savingsTransaction2.setAmount(100000.00); // Transaction amount (positive indicates credit)
        savingsTransaction2.setDescription("Bonus from work");

        /*// Creating a list of transactions for the savings account
        List<Transaction> savingsTransactions = new ArrayList<>();
        savingsTransactions.add(savingsTransaction1);  // Adding the first transaction
        savingsTransactions.add(savingsTransaction2);  // Adding the second transaction
        // Adding the list of transactions to the savings account
        savingsAccount.setTransactions(savingsTransactions);*/
        //or
        // Adding transactions to the savings account
        savingsAccount.setTransactions(Arrays.asList(savingsTransaction1, savingsTransaction2));

        // Creating Checking Account object and setting values
        Account checkingAccount = new Account();
        checkingAccount.setAccountId(123789456);
        checkingAccount.setAccountType("Checking");
        checkingAccount.setBalance(10000.75);

        // Creating Transaction for the Checking account
        Transaction checkingTransaction = new Transaction();
        checkingTransaction.setTransactionId(2001);
        checkingTransaction.setDate("2024-03-01");
        checkingTransaction.setAmount(-2500.00);
        checkingTransaction.setDescription("Rent for apartment");

        // Adding transaction to the checking account
        checkingAccount.setTransactions(Arrays.asList(checkingTransaction));

        // Creating a Loan object
        Loan loan = new Loan();
        loan.setLoanId(12345);
        loan.setLoanAmount(250000.00);
        loan.setLoanType("Car Loan");
        loan.setInterestRate(3.5F);

        // Creating a Mortgage object and linking it to the Loan object
        Mortgage mortgage = new Mortgage();
        mortgage.setMortgageId(1);
        mortgage.setPropertyAddress("Monica's Apartment, New York");
        mortgage.setMortgageAmount(500000.00);
        mortgage.setOutstandingAmount(300000.00);
        mortgage.setInterestRate(4.0);
        mortgage.setTermInYears(20);
        mortgage.setMonthlyPayment(1500.00);

        // Creating a Payment object and adding it to the Mortgage payments
        Payment payment = new Payment();
        payment.setPaymentId(10001);
        payment.setDate("2024-02-25");
        payment.setAmount(1500.00);

        mortgage.setPayments(Arrays.asList(payment));

        // Adding all the accounts and loan information to the customer object
        customer.setAccounts(Arrays.asList(savingsAccount, checkingAccount));
        customer.setLoans(Arrays.asList(loan));
        customer.setMortgages(Arrays.asList(mortgage));

        // Creating a File object to store the JSON output
        File bankingJson = new File("src/test/resources/banking_with_loans_mortgages_friends.json");

        // Creating ObjectMapper to convert Java object into JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Writing the customer object as JSON to the file
        objectMapper.writeValue(bankingJson, customer);

        // Converting the customer object into a pretty-printed JSON string and printing to the console
        String customerJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
        System.out.println(customerJson);
    }

}
