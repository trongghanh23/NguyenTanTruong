package _16_text_file.practice.sum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExample {
    private void FileExample(String fileText) {
        try {


            File file = new File(fileText);
            if (!file.exists()) {
                throw new FileNotFoundException();

            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println("tổng các số nguyên trong file;");
            System.out.println(" tổng" + sum);


        } catch (Exception e) {
            System.out.println("file không tồn tại hoặc file có lỗi: ");
        }

    }

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.FileExample(path);
    }
}