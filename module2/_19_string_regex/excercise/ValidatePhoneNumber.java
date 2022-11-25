package _19_string_regex.excercise;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    public static void main(String[] args) {

        String regexPhoneNumber = "(\\(\\d{2}\\))-(\\(0\\d{9}\\))";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại kiểm tra: ");
        String phoneNumber = scanner.nextLine();

        boolean chekRegex = Pattern.matches(regexPhoneNumber, phoneNumber);
        if (chekRegex == true) {
            System.out.println("số điện thoại hợp lệ: ");
        } else {
            System.out.println("số điện thoại ko hợp lệ");

        }
    }
}
