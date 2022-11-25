package _02_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class ShowPicture {
    public static void main(String[] args) {

        int width;
        int height;
        Scanner input = new Scanner(System.in);
        System.out.println("nhập chiều dài hình chữ nhật height");
        height = input.nextInt();
        System.out.println("nhập chiều rộng hình chữ nhật width");
        width = input.nextInt();
        for (int i = 1; i <= width; i++) {
            System.out.println();
            for (int j = 1; j <= height; j++) {
                System.out.print("*");

            }

        }
        System.out.println();
        int height1;
        System.out.println("Nhập chiều cao tam giác height:");
        Scanner input1 = new Scanner(System.in);
        height1 = input1.nextInt();
        for (int i = 0; i <= height1; i++) {
            System.out.println();
            for (int j = 0; j < i; j++) {
                System.out.print("*");

            }

        }
        System.out.println();
        int heightTG;
        System.out.println("nhập vào chiều cao hình tam giác height:");
        Scanner input2 = new Scanner(System.in);
        heightTG = input2.nextInt();
        for (int i = heightTG; i >= 1; i--) {
            System.out.println();
            for (int j = 1; j <= i; j++) {
                System.out.print("*");

            }

        }


    }
}
