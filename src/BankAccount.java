public class BankAccount {
    private String holderName;
    private int accountNumber;
    private double balance;

    public BankAccount(){}

    public BankAccount(String holderName, int accountNumber, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.holderName = holderName;
    }

    public double Deposit(double depAmt){
        balance += depAmt;
        return depAmt;
    }
    public double Withdrawal(double withdrawAmt){
        balance -= withdrawAmt;
        return withdrawAmt;
    }

    public double trx(BankAccount transfer, double amt){
        double pullAmt = this.Withdrawal(amt);
        return transfer.Deposit(pullAmt);
    }

    /**
     * USING SETTERS/GETTERS
     * @return
     */
    public String getAccountHolderName(){
        return this.holderName;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * taking away setaccountnumber because i dont want people to be able to change that!
     * @return
     */
//    public void setAccountNumber(int accountNumber) {
//        this.accountNumber = accountNumber;
//    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void transfer(BankAccount acc, double amount) {
        Withdrawal(amount);
        acc.Deposit(amount);
/**
 * alternative for ^^^
 * this.Balance -= amount;
 * acc.Deposit(amount);
 * acc.Balance += amount;
 */
    }

    public void setAccountHolderName(String name){
        this.holderName = name;
    }

    public void Total(){
        System.out.println("The customer's name is " + holderName + " and their balance " + balance);
    }

}
