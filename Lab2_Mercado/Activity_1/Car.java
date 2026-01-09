package Activity_1;
// Car subclass
public class Car extends Vehicle {
    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    // Inherits fuelType() from Vehicle (no override needed)
}