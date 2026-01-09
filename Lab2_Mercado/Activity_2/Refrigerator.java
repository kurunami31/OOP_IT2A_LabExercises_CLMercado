package Activity_2;

// Refrigerator subclass
public class Refrigerator extends Appliances {
    @Override
    public void turnOn() {
        System.out.println("Refrigerator is now ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Refrigerator is now OFF");
    }
}