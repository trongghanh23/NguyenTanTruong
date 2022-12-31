import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Nhập số cần đảo ngược");
        int number=scanner.nextInt();
        StringBuilder reveredNumber = new StringBuilder();
        while (number != 0) {
            int temp = number % 10;
            reveredNumber.append(temp);
            number /= 10;
        }
        System.out.println("số đào ngược là:"+reveredNumber);
    }
}