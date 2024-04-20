package Lab4;

public class Driver {
    public static void main(String[] args){

        CursorArray<Integer> cursor = new CursorArray<>(20);
        int summerList = cursor.createList();
        cursor.sortedInsert(4, summerList);
        cursor.sortedInsert(3, summerList);
        cursor.sortedInsert(7, summerList);
        cursor.sortedInsert(1, summerList);
        cursor.sortedInsert(2, summerList);
        cursor.sortedInsert(8, summerList);
        cursor.sortedInsert(6, summerList);
        System.out.println("summerList");
        cursor.traversList(summerList);

        int winterList = cursor.createList();
        cursor.sortedInsert(1, winterList);
        cursor.sortedInsert(2, winterList);
        cursor.sortedInsert(5, winterList);

        cursor.deleteLast(summerList);
        cursor.traversList(summerList);

    }

}
