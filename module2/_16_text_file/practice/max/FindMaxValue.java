package _16_text_file.practice.max;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\module2_c0322G1_nguyen_tan_truong\\nguyentantruong\\src\\_16_text_file\\practice\\max\\read.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\module2_c0322G1_nguyen_tan_truong\\nguyentantruong\\src\\_16_text_file\\practice\\max\\maxread.txt", maxValue);
    }
}
