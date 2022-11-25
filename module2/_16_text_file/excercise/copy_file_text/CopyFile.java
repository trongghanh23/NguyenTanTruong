package _16_text_file.excercise.copy_file_text;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        File sourceFile = new File("src/_16_text_file/excercise/copy_file_text/Source.csv");
        File targetFile = new File("src/_16_text_file/excercise/copy_file_text/target.csv");
        String line;
        int count = 0;
        try (FileReader fileReader = new FileReader(sourceFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(targetFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                count += line.length();

            }

            System.out.println("số kí tự trong chuỗi: " + count);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File  soruce không đúng hoặc không tồn tại: ");
        }
    }
}





