package optional.Palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 chuỗi: ");
        String stringInput = sc.nextLine();
        boolean flag = true;
        Stack<String> stackString = new Stack<>();
        Queue<String> queueString = new LinkedList<>();
        String[] splitStringInput = stringInput.split("");
        for (int i = 0; i < splitStringInput.length; i++) {
            stackString.push(splitStringInput[i]);
        }
        for (int i = 0; i < splitStringInput.length; i++) {
            queueString.add(splitStringInput[i]);
        }
        while (!stackString.isEmpty()) {
            if (!stackString.pop().equalsIgnoreCase(queueString.poll())) {
                System.out.println("Đây KHÔNG phải là chuỗi Palidrome.");
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("Đây là chuỗi Palidrome.");
    }
}
