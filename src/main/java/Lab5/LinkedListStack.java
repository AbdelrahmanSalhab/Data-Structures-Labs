package Lab5;

import Lab2.Node;

public class LinkedListStack<T extends Comparable<T>> implements Stackable<T>{

    private Node<T> topNode;

    @Override
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(topNode);
        topNode = newNode;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        T temp = topNode.getData();
        topNode.setNext(topNode.getNext());
        return temp;
    }

    @Override
    public T peek() {
        return topNode.getData();
    }

    public int length() {
        int length = 0;
        Node<T> curr = topNode;
        while (curr != null) {
            length++;
            curr = curr.getNext();
        }
        return length;
    }

    @Override
    public boolean isEmpty() {
        return (topNode == null);
    }

    @Override
    public void clear() {
        topNode = null;
    }

}
