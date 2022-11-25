package _17_binary_file_serialization.excercise.product_manager.utils;


import java.io.*;

public class ReadWrite {
    public static void write(String path, Object obj) {
        File file = new File(path);
        FileOutputStream os = null;
        ObjectOutputStream oos = null;

        try {
            os = new FileOutputStream(file);
            oos = new ObjectOutputStream(os);
            oos.writeObject(obj);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Object read(String path) {

        File file = new File(path);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        Object object = null;

        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            object = objectInputStream.readObject();
            return object;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
