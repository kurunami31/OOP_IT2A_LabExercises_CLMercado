package Activity_4;

// Main class to test polymorphism
public class EmployeeMain {
    public static void main(String[] args) {
        // Array of Employee objects (polymorphism in action)
        Employee[] employees = {
            new FullTimeEmployee("Alice", 101, 5000),
            new PartTimeEmployee("Bob", 102, 20, 80),
            new FullTimeEmployee("Charlie", 103, 6000),
            new PartTimeEmployee("Diana", 104, 25, 60)
        };

        // Loop through employees and call methods dynamically
        for (Employee emp : employees) {
            emp.displayInfo();
            System.out.println("Pay: " + emp.calculatePay());
            System.out.println("-------------------------");
        }
    }
}