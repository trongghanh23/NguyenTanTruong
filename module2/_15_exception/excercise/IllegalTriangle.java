package _15_exception.excercise;

import java.util.Scanner;

public class IllegalTriangle {
    public static void main(String[] args) {
        boolean check = false;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("nhập cạnh thứ  nhất: ");
                int edge1 = Integer.parseInt(scanner.nextLine());
                System.out.println("nhập cạnh thứ  hai: ");
                int edge2 = Integer.parseInt(scanner.nextLine());
                System.out.println("nhập cạnh thứ  ba: ");
                int edge3 = Integer.parseInt(scanner.nextLine());
                if (edge1 < 0 || edge2 < 0 || edge3 < 0) {
                    throw new IllegalTriangleException("Không được nhập số âm: ");
                } else if ((edge1 + edge2) < edge3 || (edge1 + edge3) < edge2 || (edge2 + edge3) < edge1) {
                    throw new IllegalTriangleException("Tổng 2 cạnh không lớn hơn hai cạnh còn lại");
                }
            } catch (IllegalTriangleException e) {
                System.out.println("Vui lòng nhập lại: ");
                check = true;
            }
        } while (check);

    }

}
