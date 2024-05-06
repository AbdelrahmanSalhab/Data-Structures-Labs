package Lab5;

import Lab4.CursorArray;

public class CursorStack<T extends Comparable<T>> implements Stackable<T> {

    CursorArray<T> CA = new CursorArray<>(20);
    int list;

    public CursorStack() {
        list = CA.createList();
    }

    @Override
    public void push(T data) {
        CA.insertAtHead(data, list);
    }

    @Override
    public T pop() {
        return (T) CA.deleteFirst(list);
    }

    @Override
    public boolean isEmpty() {
        return CA.isEmpty(list);
    }

    @Override
    public void clear() {
        while(!CA.isEmpty(list)) {
            int p = CA.getCursorArray()[list].getNext();
            CA.getCursorArray()[list].setNext(CA.getCursorArray()[p].getNext());
            CA.free(p);
        }
    }

    @Override
    public T peek() {
        return (T) CA.getCursorArray()[CA.getCursorArray()[list].getNext()].getData();
    }

}
