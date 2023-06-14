package lesson03.find_min_in_array;



public class Main {

    static int min(int[] array){
        int min=array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]<min) min=array[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size: ");
        size=sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = sc.nextInt();
        }

        System.out.println("Min Array is: "+min(array));
    }

}
