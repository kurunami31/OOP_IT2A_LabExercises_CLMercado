package Activity_2;

// Main class to test
public class AppliancesMain {
    public static void main(String[] args) {
        Appliances washingMachine = new WashingMachine();
        Appliances refrigerator = new Refrigerator();

        System.out.println("Testing Washing Machine:");
        washingMachine.power();
        washingMachine.turnOn();
        washingMachine.turnOff();

        System.out.println("\nTesting Refrigerator:");
        refrigerator.power();
        refrigerator.turnOn();
        refrigerator.turnOff();
    }
}