package Lab5;

public interface Stackable<T extends Comparable<T>> {
    void push(T data);
    T pop();
    T peek();
    void clear();
    boolean isEmpty();

}
