package Lab6;

public interface Queue <T extends Comparable<T>>{

    public void enqueue(T data);
    public T dequeue();
    public T getFront();
}
