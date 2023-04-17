package exercise3;

public class Account implements Comparable<Account> {

	 // private instance attributes
    private int accountNumber;
    private String customerName;
    private double accountBalance;

    public Account(int accountNumber, String customerName, double accountBalance) {
        super();
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * method compares two Account objects for sorting
     */
    @Override
    public int compareTo(Account account) {
        int result;
        // current item object price is smaller
        if (this.accountBalance < account.getAccountBalance())
            result = -1;
        else if (this.accountBalance > account.getAccountBalance())//Balance higher
            result = 1;
        else //same prices
            result = 0;
        return result;
    }

    /**
     * provides Item detail
     */
    @Override
    public String toString() {
        return  customerName+"[Account Number = " + accountNumber + ", Account Balance = $" + accountBalance + "]\n";
    }


	
	
}
