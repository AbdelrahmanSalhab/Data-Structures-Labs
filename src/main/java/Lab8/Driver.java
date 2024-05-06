package Lab8;

public class Driver {

    public static void main(String[] args) {
        AVL<Integer> avl = new AVL<>();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        avl.insert(25);
        avl.insert(35);
        avl.insert(45);
        avl.insert(55);
        avl.insert(170);
        avl.insert(180);
        avl.insert(440);
        avl.insert(450);
        avl.insert(460);
        avl.insert(470);
        avl.insert(480);
        avl.insert(490);
        avl.insert(500);
        avl.insert(600);
        avl.insert(610);
        avl.insert(630);
        avl.insert(640);
        avl.delete(490);
        avl.delete(410);
        avl.delete(10);

        avl.traverseInOrder();
    }
}
