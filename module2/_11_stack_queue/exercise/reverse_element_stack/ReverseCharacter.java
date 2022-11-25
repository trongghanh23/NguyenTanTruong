package _11_stack_queue.exercise.reverse_element_stack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseCharacter {
    public static void main(String[] args) {
        Stack<String> wStack = new Stack<>();
        String mWord = "nguyen van nghia";
        String[] word = mWord.split("");

        for (String item : word) {
            wStack.push(item);
        }
        for (int i = 0; i < word.length; i++) {
            word[i] = wStack.pop();
        }
        System.out.println(Arrays.toString(word));
    }
}
