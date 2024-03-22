package Lab3;

public class DNode<T extends Comparable<T>> {

    private T data;
    private DNode<T> next;
    private DNode<T> prev;

    public DNode(T data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + "";
    }

    public DNode<T> getNext() {
        return next;
    }
    public void setNext(DNode<T> next) {
        this.next = next;
    }
    public DNode<T> getPrev() { return prev; }
    public void setPrev(DNode<T> prev) { this.prev = prev; }
    public int compare(T data) {
        return this.data.compareTo(data);
    }

    public T getData() {
        return data;
    }
}
