class User {
    String name;

    User(String name) {
        this.name = name;
    }

    void displayInfo() {
        System.out.println("User: " + name);
    }

    void displayInfo(String role) {
        System.out.println(role + ": " + name);
    }
}

class Farmer extends User {
    Farmer(String name) {
        super(name);
    }

    @Override
    void displayInfo() {
        System.out.println("Farmer: " + name);
    }

    void work() {
        System.out.println(name + " is farming.");
    }
}

class Buyer extends User {
    Buyer(String name) {
        super(name);
    }

    @Override
    void displayInfo() {
        System.out.println("Buyer: " + name);
    }

    void buy() {
        System.out.println(name + " is buying products.");
    }
}