package _14_sort_algorithm.exercise;

import java.util.Scanner;

public class InsertionSort {
    public void insertionSort(int arr[]) {
        int valueToInsert;
        int holePosition;
        int i;

        // lap qua tat ca cac so
        for (i = 1; i < arr.length; i++) {

            // chon mot gia tri de chen
            valueToInsert = arr[i];

            // lua chon vi tri de chen
            holePosition = i;

            // kiem tra xem so lien truoc co lon hon gia tri duoc chen khong
            while (holePosition > 0 && arr[holePosition - 1] > valueToInsert) {
                arr[holePosition] = arr[holePosition - 1];
                holePosition--;
//                di chuyển phẩn tử
            }

            if (holePosition != i) {

                // chen phan tu tai vi tri chen
                arr[holePosition] = valueToInsert;
            }

            display(arr);
        }
    }

    public void display(int arr[]) {
        int i;
        System.out.print("[");

        // Duyet qua tat ca phan tu
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("]\n");
    }

    public static void main(String[] args) {

        int arr[] = {6, 7, 0, 2, 8, 1, 3, 9, 4, 5};

        InsertionSort insertionSort = new InsertionSort();
        System.out.println("Mang du lieu dau vao: ");
        insertionSort.display(arr);

        insertionSort.insertionSort(arr);

        System.out.println("\nMang sau khi da sap xep: ");
        insertionSort.display(arr);
    }


}

