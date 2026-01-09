package Activity_3;

// CheckingAccount subclass
public class CheckingAccount extends Account {

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " into Checking Account.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Checking Account.");
        } else {
            System.out.println("Withdrawal denied. Insufficient funds.");
        }
    }
}