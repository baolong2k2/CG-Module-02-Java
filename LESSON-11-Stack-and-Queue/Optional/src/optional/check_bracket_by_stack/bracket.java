package optional.check_bracket_by_stack;

import java.util.Scanner;
import java.util.Stack;

public class bracket {
    public static void main(String[] args) {
        String strExpr;
        Scanner scanner = new Scanner(System.in);
        strExpr = scanner.nextLine();

        Stack<Integer> parentPos = new Stack<>();
        for (int i = 0; i < strExpr.length(); i++) {
            if (strExpr.charAt(i) == '(') {
                parentPos.push(i);
            } else if (strExpr.charAt(i) == ')') {
                if (!parentPos.empty()) {
                    parentPos.pop();
                } else {
                    parentPos.push(i);
                }
            }
        }

        if (parentPos.empty())
            System.out.println("Parentness string is right format");
        else {
            System.out.println("Parentness string is not in right format");
            while (!parentPos.empty()) {
                System.out.println("at position : " + parentPos.peek());
                parentPos.pop();
            }
        }
    }
}
