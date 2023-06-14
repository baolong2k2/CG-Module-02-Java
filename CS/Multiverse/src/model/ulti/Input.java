package model.ulti;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);
    public static int choiceIntegerInput(String request){ // nhận được enter và chỉ nhận được số
        int choice;
        do {
            try {
                System.out.print(request);
                choice = Integer.parseInt(sc.nextLine()); //nextLine nhận được enter chuyển từ chuỗi số thành số,nhập chuỗi chữ sẽ báo lỗi NumberFormatException
                break;
            }catch (NumberFormatException e) { //
                System.out.println("Invalid Input!!! " + e.getMessage() + " . Please try again!");
            }
        }while (true);
        return choice;
    }
    public static String prompt(String request){ //lấy được nút enter và chuỗi
        System.out.println(request);
        return sc.nextLine();
    }
    public static String prompt(String request, String regexPattern) {
        String text;
        do {
            text = prompt(request);
            if (Validation.validate(text, regexPattern)) {
                System.out.println("Invalid Input!!! Wrong format");
            }
        }while (Validation.validate(text, regexPattern));
            return text;
    }

}
