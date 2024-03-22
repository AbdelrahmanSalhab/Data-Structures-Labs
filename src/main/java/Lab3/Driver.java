package Lab3;

public class Driver {
    public static void main(String[] args) {
        DLinkedList<Integer> list = new DLinkedList<>();
        list.insert(1);
        list.insert(5);
        list.insert(7);
        list.insert(9);
        list.insert(2);
        list.insert(4);

        list.insert(8);
        list.insert(10);
        list.insert(3);
        list.insert(3);
        list.insert(3);
        list.insert(3);

        list.traverse();
        list.removeDuplicatesRecursive();
        list.reverseRecursive();
        list.traverse();

    }
}
