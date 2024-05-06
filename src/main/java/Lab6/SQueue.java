package Lab6;

import Lab5.LinkedListStack;

public class SQueue <T extends Comparable<T>> implements Queueable<T> {

    private LinkedListStack<T> stack;
    private LinkedListStack<T> temp;

    public SQueue(){
        stack = new LinkedListStack<>();
        temp = new LinkedListStack<>();
    }

    @Override
    public void enqueue(T data){
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(data);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    @Override
    public T dequeue(){
        return stack.pop();
    }

    @Override
    public T getFront(){
        return stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void clear() {
        stack.clear();
    }


}
