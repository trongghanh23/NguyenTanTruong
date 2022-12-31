import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập số kiểm tra");
        int number = scanner.nextInt();
        boolean flag = true;
        if (number<2){
            flag=false;
        }
        for (int i = 2; i < number; i++) {
            if (number % 2 == 0) {
                flag = false;
            }
        }
        if (flag == true) {
            System.out.printf("số nguyên tố");
        } else {
            System.out.printf("Không phải là số nguyên tố");
        }
    }
}