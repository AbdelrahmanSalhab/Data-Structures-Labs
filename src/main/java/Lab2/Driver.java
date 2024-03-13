package Lab2;

public class Driver {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(5);
        list.insert(3);
        list.insert(7);
        list.insert(1);
        list.insert(9);
        list.insert(2);
        list.insert(6);
        list.insert(4);;
        list.insert(8);
        list.insert(10);
        list.print();

        if(list.search(5))
            System.out.println("Found");
        else
            System.out.println("Not found");

        if(list.delete(5))
            System.out.println("Deleted 5");
        else
            System.out.println("5 not found");
        list.print();
        list.reverseRecursive();
        list.print();
    }
}
