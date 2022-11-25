package _03_ArrayAndMethod.bai_tap;

import java.util.Scanner;

public class Sum2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of the 2-D array:");
        int width = Integer.parseInt(input.nextLine());
        System.out.println("Enter the 2D array width:");
        int height = Integer.parseInt(input.nextLine());

        int[][] array2D = new int[width][];
        for (int i = 0; i < width; i++) {
            array2D[i] = new int[height];
            for (int j = 0; j < height; j++) {
                System.out.print("Enter index " + i + "-" + j + ": ");
                array2D[i][j] = Integer.parseInt(input.nextLine());
            }
        }

        System.out.println("Array 2D");
        for (int[] ints : array2D) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        int sumMainDiagonal = 0;
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                if (i == j) {
                    sumMainDiagonal += array2D[i][j];
                }
            }
        }

        System.out.println( sumMainDiagonal);
    }
}


