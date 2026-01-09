package Activity_2;

// WashingMachine subclass
public class WashingMachine extends Appliances {
    @Override
    public void turnOn() {
        System.out.println("Washing Machine is now ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Washing Machine is now OFF");
    }
}