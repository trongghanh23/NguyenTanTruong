package _11_stack_queue.exercise.element_queue;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String character = input.nextLine();

        TreeMap<String, Integer> countMap = new TreeMap<>();

        int value = 0;
        String[] array = character.toUpperCase().split(" ");

        for (String item : array) {
            if (countMap.containsKey(item)) {
                value = countMap.get(item) + 1;
                countMap.put(item, value);
            } else {
                value = 1;
                countMap.put(item, value);
            }
        }
        Set<String> keySet = countMap.keySet();

        for (String item : keySet) {
            System.out.println("từ: " + item + ": xuất hiênj: " + countMap.get(item) + "lần");
        }
    }
}
