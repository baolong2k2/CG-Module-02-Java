public class Main {
    public static void main(String[] args){
        System.out.println("Prime numbers less than 100: ");

        int n;
        for (n = 2; n < 100; n++){
            boolean checkPrime = true;
            for (int i = 2; i <= Math.sqrt(n); i++){
                if (n % i == 0){
                    checkPrime = false;
                    break;
                }
            }
            if (checkPrime){
                System.out.printf("  " + n);
            }
        }
    }
}