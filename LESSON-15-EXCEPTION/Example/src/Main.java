public class Main {
    public static void main(String[] args){
//        try {
//            int result = 10/0;
//        }catch (ArithmeticException e){
//            System.out.println("Error: " + e.getMessage());
//        }

        try {
            int age = -5;
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative"); // throw exception
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // handle exception
        }
    }
}