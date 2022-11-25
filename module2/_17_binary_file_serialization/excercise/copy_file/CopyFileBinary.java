package _17_binary_file_serialization.excercise.copy_file;

import java.io.*;

public class CopyFileBinary {
    public static void main(String[] args) {
        File source = new File("src/_17_binary_file_serialization/excercise/copy_file/SourceFile.csv");
        File target = new File("src/_17_binary_file_serialization/excercise/copy_file/TargetFile.csv");
        int count = 0;
        try (FileInputStream inputStream = new FileInputStream(source);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
             FileOutputStream outputStream = new FileOutputStream(target);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = bufferedInputStream.read(buffer)) > 0) {
                bufferedOutputStream.write(buffer, 0, length);
                count++;
            }
            System.out.println("Number of bytes used: " + count + " byte.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

