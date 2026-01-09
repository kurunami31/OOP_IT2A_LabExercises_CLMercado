package Activity_1;
// Bicycle subclass
public class Bicycle extends Vehicle {
    @Override
    public void move() {
        System.out.println("Bicycle is moving");
    }

    // Override fuelType() since bicycles don't need fuel
    @Override
    public void fuelType() {
        System.out.println("Bicycles don't need fuel.");
    }
}