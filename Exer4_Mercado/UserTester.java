public class UserTester {
    // code 1//
    /*
     * public static void main(String[] args) {
     * User u1 = new Farmer("Juan Dela Cruz");
     * User u2 = new Buyer("Maria Santos");
     * 
     * u1.displayInfo();
     * u2.displayInfo();
     * u1.displayInfo("Registered Farmer");
     * u2.displayInfo("Registered Buyer");
     * if (u1 instanceof Farmer f) {
     * f.work();
     * }
     * if (u2 instanceof Buyer b) {
     * b.buy();
     * }
     * }
     */
    // code 2//
    public static void main(String[] args) {
        User[] users = new User[3];
        users[0] = new Farmer("Juan Dela Cruz");
        users[1] = new Buyer("Maria Santos");
        users[2] = new Farmer("Pedro Reyes");

        for (User user : users) {
            user.displayInfo();

            user.displayInfo("Active User");

            if (user instanceof Farmer f) {
                f.work();
            } else if (user instanceof Buyer b) {
                b.buy();
            }

            System.out.println();
        }
    }
}