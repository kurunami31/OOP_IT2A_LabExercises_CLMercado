public class SeedTester {
    public static void main(String[] args) {
        Seed sd1 = new Seed(null, null, 0, 0, null);
        Seed sd2 = new Seed(null, null, 0, 0, null);
        Seed sd3 = new Seed(null, null, 0, 0, null);

        sd1.setName("Carrot");
        sd1.setType("Vegetable");
        sd1.setGrowthTime(70);
        sd1.setPrice(50.0);
        sd1.setSeason("Spring");
        System.out.println("Seed 1:");
        System.out.println("Name: " + sd1.getName());
        System.out.println("Type: " + sd1.getType());
        System.out.println("Growth Time: " + sd1.getGrowthTime() + " days");
        System.out.println("Price: " + sd1.getPrice() + " php");
        System.out.println("Season: " + sd1.getSeason());
        System.out.println();

        sd2.setName("Tomato");
        sd2.setType("Fruit");
        sd2.setGrowthTime(80);
        sd2.setPrice(75.0);
        sd2.setSeason("Summer");
        System.out.println("Seed 2:");
        System.out.println("Name: " + sd2.getName());
        System.out.println("Type: " + sd2.getType());
        System.out.println("Growth Time: " + sd2.getGrowthTime() + " days");
        System.out.println("Price: " + sd2.getPrice() + " php");
        System.out.println("Season: " + sd2.getSeason());
        System.out.println();

        sd3.setName("Lettuce");
        sd3.setType("Vegetable");
        sd3.setGrowthTime(55);
        sd3.setPrice(40.0);
        sd3.setSeason("Fall");
        System.out.println("Seed 3:");
        System.out.println("Name: " + sd3.getName());
        System.out.println("Type: " + sd3.getType());
        System.out.println("Growth Time: " + sd3.getGrowthTime() + " days");
        System.out.println("Price: " + sd3.getPrice() + " php");
        System.out.println("Season: " + sd3.getSeason());
        System.out.println();
    }
}
