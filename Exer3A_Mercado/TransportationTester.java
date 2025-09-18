public class TransportationTester {
    public static void main(String[] args) {
        Transportation[] vehicles = {
                new Helicopter(),
                new Airplane(),
                new Spaceshuttle(),
                new Truck(),
                new SUV(),
                new Tricycle(),
                new Motorcycle(),
                new Kariton()
        };

        for (Transportation vehicle : vehicles) {
            vehicle.move();
        }
    }
}