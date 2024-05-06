package Lab5;

public class ArrayStack<T> {

    private T[] arr;
    private int top;

    public ArrayStack(){
        top = 0;
        arr = (T[])(new Object[100]);
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public int getTop(){
        return top;
    }

    public void push(T data){
        if (top != arr.length)
            arr[top++] = data;
    }

    public Object pop(){
        if (isEmpty()) return null;
        return arr[top--];
    }

    public String toString() {
        String res = "Top-->";
        for(int i = top; i>=0; i--)
            res+="["+ arr[i]+"]-->";
        return res+"Null";
    }

}
