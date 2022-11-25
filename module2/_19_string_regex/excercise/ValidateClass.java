package _19_string_regex.excercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    public static void main(String[] args) {
        String regexName = "^(C|A|P)[0-9]{4}(G|H|I|K|L|M)$";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên kiểm tra: ");
        String name = scanner.nextLine();

        boolean chekRegex = Pattern.matches(regexName, name);
        if (chekRegex == true) {
            System.out.println("tên hợp lệ ");
        } else {
            System.out.println("tên không hợp lệ ");
        }
    }
}
