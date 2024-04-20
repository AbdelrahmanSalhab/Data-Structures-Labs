package Lab6;

import Lab5.LStack;

public class SQueue <T extends Comparable<T>> implements Queue<T>{
    private LStack<T> stack;
    private LStack<T> temp;

    public SQueue(){
        stack = new LStack<>();
        temp = new LStack<>();
    }

    @Override
    public void enqueue(T data){
        while (!stack.isEmpty()) {
            temp.push(stack.pop().getData());
        }
        stack.push(data);
        while (!temp.isEmpty()) {
            stack.push(temp.pop().getData());
        }
    }

    @Override
    public T dequeue(){
        T data = null;
        if(!stack.isEmpty()){
            data = stack.pop().getData();
        }
        return data;
    }

    @Override
    public T getFront(){
        T data = null;
        if(!stack.isEmpty()){
            data = stack.peek().getData();
        }
        return data;
    }

}
