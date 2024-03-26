package Lab4;

public class CursorArray<T extends Comparable<T>> {

    private CNode<T>[] cursorArray;

    public CursorArray(int capacity) {
        cursorArray = new CNode[capacity];
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
        return cursorArray[l]==null;
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

    public CNode<T> delete(T data, int l) {
        int p = findPrevious(data, l);
        if (p != -1) {
            int c = cursorArray[p].next;
            CNode<T> temp = cursorArray[c];
            cursorArray[p].next = temp.next;
            free(c);
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

        while(!isLast(l1)){
            l1 = cursorArray[l1].next;
        }
        int unwantedDummy = l2;
        l2 = cursorArray[l2].next;
        free(unwantedDummy);
        cursorArray[l1].setNext(l2);
    }

}
