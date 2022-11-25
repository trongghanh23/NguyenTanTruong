package _01_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        System.out.println("nhập vào tiền usd");
        Scanner scanner=new Scanner(System.in);
        int usd=scanner.nextInt();
        double vnd=usd*23000;
        System.out.println("số tiền đổi sang vnd là: "+vnd);

    }
}
