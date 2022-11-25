package _11_stack_queue.exercise.check_bracket;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập biểu thức kiểm tra");
        String character = scanner.nextLine();
        boolean flag = true;
        for (int i = 0; i < character.length(); i++) {
            char sym = character.charAt(i);
            if (sym == '(') {
                stack.push(sym);
            } else if (sym == ')') {
                if (stack.empty()) {
                    flag = false;
                    break;
                }
                stack.pop();
            }

        }
        if (flag && stack.empty()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}
