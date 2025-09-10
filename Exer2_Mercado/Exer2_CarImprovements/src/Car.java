public class Car {
    private String color;
    private String model;
    private String brand;
    private int yearModel;

    // no argument constructor
    public Car() {
        this.color = "No Color";
        this.model = "No Model";
        this.brand = "No Brand";
        this.yearModel = 0;
    }

    public Car(String color, String model, String brand, int yearModel) {
        this.color = color;
        this.model = "No Model";
        this.brand = "No Brand";
        this.yearModel = 0;
    }

    // -----------methods----------------
    public void displayInfo() {
        String info = "";
        info += "Color: " + this.color;
        info += "Model: " + this.model;
        info += "Brand: " + this.brand;
        info += "Year Model: " + this.yearModel;
        System.out.println(info);
    }
}