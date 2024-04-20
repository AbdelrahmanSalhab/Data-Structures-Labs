package Lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Driver {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {

        try {
            System.out.println(isBalanced());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        String string = "a+b*c-d";
//        System.out.println(toPostfix(string));

    }

    public static boolean isBalanced() throws FileNotFoundException {

        boolean isBalanced = true;
        File file = new File("MyList.java");
        Scanner scan = new Scanner(file);

        while(scan.hasNext() && isBalanced){
            String s = scan.next();

            for(int i=0; i<s.length(); i++) {
                char nextChar = s.charAt(i);

                if (nextChar == '(' || nextChar == '[' || nextChar == '{')
                    stack.push(nextChar);

                else if (nextChar == ')' || nextChar == ']' || nextChar == '}') {
                    if (stack.isEmpty())
                        isBalanced = false;
                    else {
                        char openDelimiter = stack.peek();
                        if (openDelimiter == '(' && nextChar == ')' || openDelimiter == '[' && nextChar == ']' || openDelimiter == '{' && nextChar == '}')
                            stack.pop();
                        else
                            isBalanced = false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
//
//    public String toPostfix(String infix){
//        String postfix = "";
//        Stack<Character> operands = new Stack<>();
//        Stack<Character> variables = new Stack<>();
//
//        for(int i=0; i<infix.length(); i++) {
//            char nextChar = postfix.charAt(i);
//            if()
//
//        }
//
//            return postfix;
//    }

}
