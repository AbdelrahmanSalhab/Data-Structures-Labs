package Lab4;

public class Driver {
    public static void main(String[] args){

        CursorArray<Integer> cursor = new CursorArray<>(20);
        int summerList = cursor.createList();
        cursor.insertAtHead(4, summerList);
        cursor.insertAtHead(3, summerList);
        cursor.insertAtHead(7, summerList);
        cursor.traversList(summerList);

        int winterList = cursor.createList();
        cursor.insertAtHead(1, winterList);
        cursor.insertAtHead(2, winterList);
        cursor.insertAtHead(5, winterList);

//        cursor.mergeLists(summerList,winterList);
//        cursor.traversList(summerList);

    }

}
