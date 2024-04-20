package Lab4;

public class CursorArray<T extends Comparable<T>> {

    private CNode<T>[] cursorArray;
    private int capacity;

    public CursorArray(int capacity) {
        cursorArray = new CNode[capacity];
        this.capacity = capacity;
        initialization();
    }

    public int initialization(){
        for(int i=0;i<cursorArray.length-1;i++)
            cursorArray[i] = new CNode<T>(null, i+1);
        cursorArray[cursorArray.length-1] = new CNode<>(null, 0);
        return 0;
    }

    public int malloc() {
        int p = cursorArray[0].next;
        cursorArray[0].next = cursorArray[p].next;
        return p;
    }

    public void free(int p){
        cursorArray[p] = new CNode<T>(null, cursorArray[0].next);
        cursorArray[0].next = p;
    }

    public boolean isNull(int l){
        return cursorArray[l] == null;
    }
    public boolean isEmpty(int l){
        return cursorArray[l].next == 0;
    }
    public boolean isLast(int p){
        return cursorArray[p].next == 0;
    }

    public int createList(){
        int l = malloc();
        if(l==0)
            System.out.println("Error: Out of space!!!");
        else
            cursorArray[l] = new CNode<T>(null,0);
        return l;
    }

    public void insertAtHead(T data, int l){
        if(isNull(l)) // list not created
            return;
        int p = malloc();
        if(p!=0){
            cursorArray[p] = new CNode<T>(data, cursorArray[l].next );
            cursorArray[l].next = p;
        }
        else
            System.out.println("Error: Out of space!!!");
    }

    public void sortedInsert(T data, int l){
        if(isNull(l)) // list not created
            return;
        if(isEmpty(l)) { // list empty
            insertAtHead(data, l);
            return;
        }

        int p = malloc();
        if(p!=0){
            CNode<T> next = cursorArray[cursorArray[l].next];
            for(; next.data!=null &&
                 data.compareTo(next.data) > 0 ;
                        l = cursorArray[l].next,
                        next = cursorArray[cursorArray[l].next]
            );

            cursorArray[p] = new CNode<>(data, cursorArray[l].next);
            cursorArray[l].next = p;
        }
        else
            System.out.println("Error: Out of space!!!");
    }

    public void traversList(int l) {
        System.out.print("list "+l+" -->");
        while(!isNull(l) && !isEmpty(l)){
            l=cursorArray[l].next;
            System.out.print(cursorArray[l]+"-->");
        }
        System.out.println("null");
    }

    public int find(T data, int l){
        while(!isNull(l) && !isEmpty(l)){
            l=cursorArray[l].next;
            if(cursorArray[l].data.equals(data))
                return l;
        }
        return -1; // not found
    }

    public int findPrevious(T data, int l){
        while(!isNull(l) && !isEmpty(l)){
            if(cursorArray[cursorArray[l].next].data.equals(data))
                return l;
            l=cursorArray[l].next;
        }
        return -1; // not found
    }

    public boolean delete(T data, int l) {
        int p = findPrevious(data, l);
        if (p != -1) {
            int c = cursorArray[p].next;
            CNode<T> temp = cursorArray[c];
            cursorArray[p].next = temp.next;
            free(c);
            return true;
        }
        return false;
    }

    public T deleteFirst(int l) {
        int p = cursorArray[l].getNext();
        if (p != 0) {
            int c = cursorArray[p].getNext();
            cursorArray[l].setNext(c);
            free(p);
            return cursorArray[p].getData();
        }
        return null;
    }

    public T deleteLast(int l) {
        int current = l;
        int previous = l;

        while (!isNull(l)) {
            if (isLast(current)) {
                free(current);
                cursorArray[previous].setNext(0);
                return cursorArray[current].getData();
            }
            previous = current;
            current = cursorArray[current].getNext();
        }
        return null;
    }

    public int listLength(int l){
        if(isLast(l))
            return 0;
        int count = 0;
        while(!isLast(l)) {
            count++;
            l = cursorArray[l].next;
        }
        return count;
    }

    public int listLengthRec(int l){
        if(isEmpty(l))
            return 0;
        return 1 + listLengthRec(cursorArray[l].next);
    }

    public void removeList(int l){
        while(!isLast(l)){
            int p = cursorArray[l].next;
            cursorArray[l].next = cursorArray[p].next;
            free(p);
        }
        free(l);
    }

    public void removeListRec(int l){
        if(isEmpty(l))
            free(l);
        else{
            int p = cursorArray[l].next;
            cursorArray[l].next = cursorArray[p].next;
            free(p);
            removeListRec(l);
        }
    }

    public void mergeLists(int l1, int l2){

        for(; !isLast(l1); l1 = cursorArray[l1].next);

        int unwantedDummy = l2;
        l2 = cursorArray[l2].next;
        free(unwantedDummy);
        cursorArray[l1].setNext(l2);
    }

    // returns the index for the new merged sorted list
    public int mergeAndSortLists(int l1, int l2){
        CursorArray<T> cursor = new CursorArray<>(capacity);
        int newList = cursor.createList();

        l1 = cursorArray[l1].next;
        while(cursorArray[l1].data != null){
            cursor.sortedInsert(cursorArray[l1].data, newList);
            l1 = cursorArray[l1].next;
        }

        l2 = cursorArray[l2].next;
        while(cursorArray[l2].data != null){
            cursor.sortedInsert(cursorArray[l2].data, newList);
            l2 = cursorArray[l2].next;
        }
        cursorArray = cursor.cursorArray;
        return newList;
    }

    public CNode<T>[] getCursorArray() {
        return cursorArray;
    }
}
