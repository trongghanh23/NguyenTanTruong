package _11_stack_queue.exercise.character_palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String character = "able was i ere i saw elba";
        String[] words = character.split("");

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        for (String item : words) {
            stack.push(item);
            queue.add(item);

        }
        Boolean flag = true;
        for (int i = 0; i < words.length; i++) {

            if (!stack.pop().equals(queue.poll())) {
                System.out.println("đây ko là chuỗi Palindrome: ");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("đây là chuỗi Palindrome: ");
        }

    }
}
