package complexJson.financeEntitiesTransponster;

import java.util.List;

public class Mortgage {
    private long mortgageId;
    private String propertyAddress;
    private double mortgageAmount;
    private double outstandingAmount;
    private double interestRate;
    private long termInYears;
    private double monthlyPayment;
    private List<Payment> payments;

    public long getMortgageId() {
        return mortgageId;
    }

    public void setMortgageId(long mortgageId) {
        this.mortgageId = mortgageId;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public double getMortgageAmount() {
        return mortgageAmount;
    }

    public void setMortgageAmount(double mortgageAmount) {
        this.mortgageAmount = mortgageAmount;
    }

    public double getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(double outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public long getTermInYears() {
        return termInYears;
    }

    public void setTermInYears(long termInYears) {
        this.termInYears = termInYears;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
