package Activity_2;

// Abstract class Appliance
public abstract class Appliances {
    // Abstract methods
    public abstract void turnOn();
    public abstract void turnOff();

    // Concrete method
    public void power() {
        System.out.println("Powering on/off...");
    }
}