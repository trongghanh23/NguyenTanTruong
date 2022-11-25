package manage_school.utils;

import java.util.Scanner;

public class Regexs {
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
