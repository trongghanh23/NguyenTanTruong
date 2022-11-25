package _11_stack_queue.exercise.reverse_element_stack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseNumber {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Integer[] array = {1, 2, 3, 4, 5, 6};
        for (Integer item : array) {
            stack.push(item);

        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        System.out.println(Arrays.toString(array));

    }
}


