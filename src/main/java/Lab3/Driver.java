package Lab3;

public class Driver {
    public static void main(String[] args) {
        DLinkedList<Integer> list = new DLinkedList<>();
        list.insert(5);
        list.insert(3);
        list.insert(7);
        list.insert(1);
        list.insert(9);
        list.insert(2);
        list.insert(6);
        list.insert(4);
        list.insert(8);
        list.insert(10);
        list.print();

        if(list.find(5))
            System.out.println("Found");
        else
            System.out.println("Not found");

        if(list.delete(5))
            System.out.println("Deleted 5");
        else
            System.out.println("5 not found");
        list.print();
        list.reverse();
        list.print();
    }
}
