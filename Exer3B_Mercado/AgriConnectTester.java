public class AgriConnectTester {
    public static void main(String[] args) {
        Farmer f = new Farmer("Juan Dela Cruz");
        Buyer b = new Buyer("Maria Santos");

        f.displayInfo();
        f.work();

        b.displayInfo();
        b.buy();
    }
}