package complexJson.financeEntitiesTransponster;

import java.util.List;

public class Customer {
    private long customerId;
    private String name;
    private String email;
    private String phone;
    private List<Account> accounts;
    private List<Loan> loans;
    private List<Mortgage> mortgages;

    public long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public List<Loan> getLoans() {
        return loans;
    }
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
    public List<Mortgage> getMortgages() {
        return mortgages;
    }
    public void setMortgages(List<Mortgage> mortgages) {
        this.mortgages = mortgages;
    }
}
