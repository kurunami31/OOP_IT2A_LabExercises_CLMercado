public class Seed {
    private String name;
    private String type;
    private int growthTime; // in days
    private double price; // in php
    private String season; // e.g., "Spring", "Summer", "Fall", "Winter"

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGrowthTime() {
        return growthTime;
    }

    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Seed(String name, String type, int growthTime, double price, String season) {
        this.name = name;
        this.type = type;
        this.growthTime = growthTime;
        this.price = price;
        this.season = season;
    }
}
