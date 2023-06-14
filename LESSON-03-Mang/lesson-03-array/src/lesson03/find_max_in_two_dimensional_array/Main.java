package lesson03.find_max_in_two_dimensional_array;

import java.util.Scanner;

        public class Main {

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter a size: ");
                int size = sc.nextInt();
                int[][] array = new int[size][size];
                int sum=0;
                int max=array[0][0];

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.println("Enter value of array["+i+"]: ");
                        array[i][j]=sc.nextInt();
                        if(array[i][j]>max) max = array[i][j];
                    }
                }

                System.out.println("Max is: "+max);
            }

        }


