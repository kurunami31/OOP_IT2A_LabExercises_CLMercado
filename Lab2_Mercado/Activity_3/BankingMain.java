package Activity_3;

// Main class to test
public class BankingMain {
    public static void main(String[] args) {
        Account savings = new SavingsAccount(1000);
        Account checking = new CheckingAccount(2000);

        System.out.println("=== Savings Account Transactions ===");
        savings.checkBalance();
        savings.deposit(500);
        savings.withdraw(800); // Allowed
        savings.withdraw(3000); // Denied due to minimum balance
        savings.checkBalance();

        System.out.println("\n=== Checking Account Transactions ===");
        checking.checkBalance();
        checking.deposit(1000);
        checking.withdraw(2500); // Allowed
        checking.withdraw(1000); // Denied if insufficient funds
        checking.checkBalance();
    }
}