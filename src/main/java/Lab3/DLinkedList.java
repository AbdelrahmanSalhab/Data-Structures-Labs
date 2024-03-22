package Lab3;

import Lab2.Node;

public class DLinkedList<T extends Comparable<T>>{

    private DNode<T> head;

    public void insert(T data){
        DNode<T>  newNode = new DNode<>(data);
        DNode<T> curr = head;

        for( ; curr != null && curr.compare(data) < 0 && curr.getNext()!=null ; curr = curr.getNext());

        if(curr == null) // case 0: empty list
            head = newNode;
        else if(curr.compare(data)>=0 && curr.getPrev()==null){ // case 1: insert at first
            newNode.setNext(curr);
            curr.setPrev(newNode);
            head = newNode;
        }
        else if(curr.compare(data)<0 && curr.getNext() == null){ // case 3: insert at last
            newNode.setPrev(curr);
            curr.setNext(newNode);
        }
        else { // case 2: insert between
            newNode.setNext(curr);
            newNode.setPrev(curr.getPrev());
            curr.getPrev().setNext(newNode);
            curr.setPrev(newNode);
        }
    }

    public boolean find(T data) {
        DNode<T> current = head;
        while(current != null && current.compare(data) <= 0){
            if(current.compare(data) == 0)
                return true;
            current = current.getNext();
        }
        return false;
    }

    public boolean findRecursive(T data) {
        if(head == null)
            return false;
        return findRecursive(data, head);
    }

    //helper method
    private boolean findRecursive(T data, DNode<T> current) {
        if(current == null || current.compare(data) > 0)
            return false;
        if(current.compare(data) == 0)
            return true;
        return findRecursive(data, current.getNext());
    }

    public boolean delete(T data){
        DNode<T> curr = head;
        while(curr!=null && curr.compare(data)<=0){
            if(curr.compare(data)==0)
                break;
            curr = curr.getNext();
        }

        if(curr != null && curr.compare(data)==0){ // found
            if(curr.getPrev()==null && curr.getNext()==null) // case 0: delete one item
                head = null;
            else if(curr.getPrev() == null){ // case 1: delete 1st item
                curr.getNext().setPrev(null);
                head = curr.getNext();
            }
            else if(curr.getNext() == null) { // case 3: delete last item
                curr.getPrev().setNext(null);
            }
            else {  // case 2: delete between
                curr.getPrev().setNext(curr.getNext());
                curr.getNext().setPrev(curr.getPrev());
            }
            return true;
        }
        return false;
    }

    public void traverse(){
        DNode<T> current = head;
        System.out.print("Head --> ");
        while(current != null){
            System.out.print(current + " <--> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void traverseReverse(){
        DNode<T> current = head;

        while(current!=null && current.getNext() != null){
            current = current.getNext();
        }
        System.out.print("null <-- ");

        while(current!=head && current != null){
            System.out.print(current + " <--> ");
            current = current.getPrev();
        }
        if(current == null)
            System.out.println(" Head");
        else
            System.out.println(current + " <-- Head");
    }

    public void traverseReverseRecursive(){
        System.out.print("null <-- ");
        traverseReverseRecursive(head);
        System.out.println(" Head");
    }
    // helper method
    private void traverseReverseRecursive(DNode<T> curr){
        if(curr!=null){
            traverseReverseRecursive(curr.getNext());
            System.out.print(curr + " <--> ");
        }
    }

    public void reverse(){
        DNode<T> current = head;
        DNode<T> previous = null;

        while (current != null) {
            previous = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(previous);
            current = current.getPrev();
        }
        if (previous != null) {
            head = previous.getPrev();
        }
    }

    public void reverseRecursive(){
        head = reverseRecursive(head);
    }

    //helper method
    private DNode<T> reverseRecursive(DNode<T> curr) {
        if(curr.getNext() == null) {
            curr.setNext(curr.getPrev());
            curr.setPrev(null);
            return curr;
        }
        DNode<T> next = curr.getNext();
        curr.setNext(curr.getPrev());
        curr.setPrev(next);
        return reverseRecursive(curr.getPrev());
    }

    public int length(){
        DNode<T> current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.getNext();
        }
        return count;
    }

    public int lengthRecursive(){
        return lengthRecursive(head);
    }
    // helper method
    private int lengthRecursive(DNode<T> current){
        if(current == null)
            return 0;
        return 1 + lengthRecursive(current.getNext());

    }

    public void removeDuplicates(){
        DNode<T> curr = head;
        while(curr!=null && curr.getNext()!=null){
            if(curr.compare(curr.getNext().getData()) == 0){
                delete(curr.getData());
                System.out.println(curr.getData() + " deleted duplicate");
            }
            curr = curr.getNext();
        }
    }

    public void removeDuplicatesRecursive(){
        DNode<T> curr = head;
        removeDuplicatesRecursive(curr);

    }

    //helper method
    private void removeDuplicatesRecursive(DNode<T> curr){
        if(curr==null || curr.getNext()==null)
            return;
        else if(curr.compare(curr.getNext().getData()) == 0){
            delete(curr.getData());
            System.out.println(curr.getData() + " deleted duplicate");
        }
        removeDuplicatesRecursive(curr.getNext());
    }

}