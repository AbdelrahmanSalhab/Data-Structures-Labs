package Lab3;

public class Node <T extends Comparable<T>> {

    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + "";
    }

    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public Node<T> getPrev() { return prev; }
    public void setPrev(Node<T> prev) { this.prev = prev; }
    public int compare(T data) {
        return this.data.compareTo(data);
    }
}
