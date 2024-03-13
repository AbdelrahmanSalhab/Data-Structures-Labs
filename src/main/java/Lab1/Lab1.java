package Lab1;

public class Lab1 {

    public static void writeNums(int i, int n) {
        if (i <= n) {
            System.out.print(i + " ");
            writeNums(i + 1, n);
        }
    }

    private static void writeNums(int n) {
        writeNums(0,n);
    }

    public static void inverseSentence(String sentence) {
        if(sentence.contains(" ")){
            int index = sentence.indexOf(" ");
            inverseSentence(sentence.substring(index+1));
            System.out.print(sentence.substring(0,index) + " ");
        }else
            System.out.print(sentence + " ");

    }

    //Same as the previous method but returns the result instead of printing it
    public static String inverseReturn(String sentence) {
        if(sentence.contains(" ")){
            int index = sentence.indexOf(" ");
            return inverseComplete(sentence.substring(index+1),0) + " " + inverseComplete(sentence.substring(0,index),0);
        }else
            return sentence;
    }

    private static String inverseComplete(String sentence, int index) {
        if(index == sentence.length())
            return "";
        else
            return inverseComplete(sentence, index+1) + sentence.charAt(index);
    }

    // Returns the number of occurrences of a character in a sentence
    public static int NumOfOccurences(String sentence, char n){
        if(sentence.isEmpty())
            return 0;
        else
            return NumOfOccurences(sentence.toLowerCase(), n, 0, 0);
    }

    // Helper method
    private static int NumOfOccurences(String sentence, char n, int count , int index){
        if(index >= sentence.length())
            return count;
        else if(sentence.charAt(index) == n)
            count = NumOfOccurences(sentence, n, count + 1, index + 1);
        else
            count = NumOfOccurences(sentence, n, count, index+1);
        return count;
    }

    public static int sumOfDigits(int n){
        if(n < 10)
            return n;
        else
            return sumOfDigitsHelper(n%10 + sumOfDigits(n/10));
    }

    public static int sumOfDigitsHelper(int n){
        if(n < 10)
            return n;
        else
            return n%10 + sumOfDigits(n/10);
    }


    public static int sumOfOddDigits(int n){
            if(n == 0)
                return 0;
            else if (n%2 == 0)
                return sumOfOddDigits(n/10);
            else
                return n%10 + sumOfOddDigits(n/10);
    }

    public static int binarySearch(int[] list, int target) {
        if (list.length == 0){
            return -1;
        }else
            return binarySearch(list,target,0, list.length-1);
    }

    //Helper Method
    private static int binarySearch(int[] list, int target, int low, int high){
        if(low > high){
            return -1;
        }

        int mid = (low + high)/2;

        if(low == high && list[low] != target && list[mid] != target)
            return -1;

        if(list[mid] == target)
            return mid;
        else if(list[mid] > target)
            return binarySearch(list, target, low, mid-1);
        else
            return binarySearch(list, target, mid+1, high);
    }

    public static void main(String[] args) {
        System.out.println(inverseReturn("Mamoun is very beautiful"));
        System.out.println(NumOfOccurences("Mamoun is very beautiful", 'm'));
        System.out.println(sumOfDigits(12345));
        System.out.println();

        System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,100}, 20));
    }
}