package Activity_3;

// Abstract class Account
public abstract class Account {
    protected double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    // Abstract methods
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    // Concrete method
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}