package Activity_1;
// Main class to test
public class VehicleMain {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();

        System.out.println("Car:");
        car.move();
        car.fuelType();

        System.out.println("\nBicycle:");
        bicycle.move();
        bicycle.fuelType();
    }
}