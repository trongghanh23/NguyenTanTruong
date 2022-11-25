package ManageComputer.utils;

import java.util.Scanner;

public class Regex {
    public static void main(String[] args) {

        String aStr = "a";
        char aChar = aStr.charAt(0);
        System.out.print(aChar);
        System.out.println('a'.equals(aChar));

    }


    static Scanner scanner = new Scanner(System.in);

    public static String regexData(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (check);
        return temp;
    }
}
