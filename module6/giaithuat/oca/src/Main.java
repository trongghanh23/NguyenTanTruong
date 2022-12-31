import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number;
        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhâp số cần chuyển đổi");
        number = scanner.nextInt();

        while (number > 0) {
            result = number % 2 + result;
            number = number / 2;

        }
        System.out.printf("chuyển đổi số:" + number + " sang nhị phân là:" + result);

    }

}
