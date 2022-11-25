package _11_stack_queue.exercise.convert_decimal_binary;

import java.util.Scanner;
import java.util.Stack;

public class ConverseDecimalBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập vào số kiểm tra:");
        int number = scanner.nextInt();

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; number != 0; i++) {
            stack.push(number % 2);
            number /= 2;
        }

        for (int i = 0; !stack.empty(); i++) {
            System.out.print(stack.pop());

        }

    }
}
