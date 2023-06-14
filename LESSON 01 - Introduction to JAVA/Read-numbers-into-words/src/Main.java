


import java.util.Scanner;

public class Main {
    public static String readNumber (int number) {
        String read = "";
        switch (number) {
            case 0:
                read = "Zero";
                break;
            case 1:
                read = "One";
                break;
            case 2:
                read = "Two";
                break;
            case 3:
                read = "Three";
                break;
            case 4:
                read = "Four";
                break;
            case 5:
                read = "Five";
                break;
            case 6:
                read = "Six";
                break;
            case 7:
                read = "Seven";
                break;
            case 8:
                read = "Eight";
                break;
            case 9:
                read = "Nine";
                break;
            case 10:
                read = "Ten";
        }
        return read;
    }

    public static String readTwoNumber(int number) {
        String readTwoNumber = "";
        switch (number) {
            case 0:
                readTwoNumber = "";
                break;
            case 1:
                readTwoNumber = "One";
                break;
            case 2:
                readTwoNumber = "Twenty";
                break;
            case 3:
                readTwoNumber = "Thirty";
                break;
            case 4:
                readTwoNumber = "Fourty";
                break;
            case 5:
                readTwoNumber = "Fifty";
                break;
            case 6:
                readTwoNumber = "Sixty";
                break;
            case 7:
                readTwoNumber = "Seventy";
                break;
            case 8:
                readTwoNumber = "Eighty";
                break;
            case 9:
                readTwoNumber = "Ninety";
                break;
        }
        return readTwoNumber;
    }

    public static void main(String[] args) {

        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number ");
        number = scanner.nextInt();

        if (number >= 0 && number <= 10) {
            System.out.println(readNumber(number));

        } else if (number >=10 && number < 20) {
            switch (number) {
                case 11:
                    System.out.println("Eleven");
                    break;
                case 12:
                    System.out.println("Twelve");
                    break;
                default:
                    int ten = number/10;
                    System.out.println(readNumber(ten) + "teen");
            }

        } else if (number >= 20 && number < 100) {
            int name = number / 10;
            int unit = number % 10;
            System.out.println(readTwoNumber(name)+ readNumber(unit));

        } else if(number>=100 && number <1000){
            int hundred = number / 100;
            int name = (number % 100) / 10;
            int unit=(number % 100) % 10;

            if(number<=119){
                System.out.println(readNumber(hundred)+" Hundred And " + readNumber(unit)+ "teen");
            }
            else{
                System.out.println(readNumber(hundred)+" Hundred And " + readTwoNumber(name) +" "+ readNumber(unit));
            }
        }
        else{
            System.out.println(" Out of ability ");
        }

    }
}