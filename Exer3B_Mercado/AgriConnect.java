class User {
    String name;

    User(String name) {
        this.name = name;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
    }
}

class Farmer extends User {
    Farmer(String name) {
        super(name);
    }

    void work() {
        System.out.println(name + " is farming.");
    }
}

class Buyer extends User {
    Buyer(String name) {
        super(name);
    }

    void buy() {
        System.out.println(name + " is buying products.");
    }
}
