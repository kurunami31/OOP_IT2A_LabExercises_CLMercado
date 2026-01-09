package Activity_3;

// SavingsAccount subclass
public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 500.0; // Minimum balance requirement

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " into Savings Account.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Savings Account.");
        } else {
            System.out.println("Withdrawal denied. Minimum balance of " + MIN_BALANCE + " must be maintained.");
        }
    }
}