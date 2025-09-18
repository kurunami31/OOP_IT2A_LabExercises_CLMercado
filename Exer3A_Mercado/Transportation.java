public class Transportation {
    public void move() {
        System.out.println("Transportation is moving");
    }
}

class AirTransportation extends Transportation {
    @Override
    public void move() {
        System.out.println("Air transportation is flying through the sky");
    }
}

class Helicopter extends AirTransportation {
    @Override
    public void move() {
        System.out.println("Helicopter is hovering and flying");
    }
}

class Airplane extends AirTransportation {
    @Override
    public void move() {
        System.out.println("Airplane is flying at high altitude");
    }
}

class Spaceshuttle extends AirTransportation {
    @Override
    public void move() {
        System.out.println("Spaceshuttle is traveling to space");
    }
}

class LandTransportation extends Transportation {
    @Override
    public void move() {
        System.out.println("Land transportation is moving through roads");
    }
}

class Truck extends LandTransportation {
    @Override
    public void move() {
        System.out.println("Truck is hauling goods on the highway");
    }
}

class SUV extends LandTransportation {
    @Override
    public void move() {
        System.out.println("SUV is driving through rough terrain");
    }
}

class Tricycle extends LandTransportation {
    @Override
    public void move() {
        System.out.println("Tricycle is pedaling through the park");
    }
}

class Motorcycle extends LandTransportation {
    @Override
    public void move() {
        System.out.println("Motorcycle is speeding through the city");
    }
}

class Kariton extends LandTransportation {
    @Override
    public void move() {
        System.out.println("Kariton is being pushed along the street");
    }
}

class WaterTransportation extends Transportation {
    @Override
    public void move() {
        System.out.println("Water transportation is sailing through water");
    }
}

class Ship extends WaterTransportation {
    @Override
    public void move() {
        System.out.println("Ship is cruising across the ocean");
    }
}

class Boat extends WaterTransportation {
    @Override
    public void move() {
        System.out.println("Boat is navigating through the lake");
    }
}

class Submarine extends WaterTransportation {
    @Override
    public void move() {
        System.out.println("Submarine is diving underwater");
    }
}
