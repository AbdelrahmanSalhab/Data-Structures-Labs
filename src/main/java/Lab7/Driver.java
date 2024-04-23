package Lab7;

public class Driver {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.readFile();
        System.out.println("Districts: ");
        Manager.getDistricts().traverseInOrder();
        System.out.println("Locations: ");
        Manager.getDistricts().largest().getData().getLocations().traverseInOrder();
    }
}
