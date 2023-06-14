package optional.decimal_to_binary;


import java.util.Scanner;
import java.util.Stack;

public class decimalToBinary {
    public static void convertDecimalToBinary(Scanner scanner) {
        Stack<Integer> decimalToBinary = new Stack<>();
        String binary = "";
        System.out.println("Nhập vào một số: ");
        int number = Integer.parseInt(scanner.nextLine());
        do {
            //Chia lấy phần dư để đưa vào Stack, dừng vòng khi phép chưa phần nguyên về = 0
            int mod = number % 2;
            decimalToBinary.push(mod);
            number /= 2;

        } while (number != 0);

        int sizeStack = decimalToBinary.size();
        for (int i = 0; i < sizeStack; i++) {
            // Nối danh sách số dư theo chiều đảo ngược lại sẽ ra giá trị nhị phân
            int numberBin = decimalToBinary.pop();
            binary += numberBin;
        }
        System.out.println("Số nhị phân là: " + binary);
    }
}
