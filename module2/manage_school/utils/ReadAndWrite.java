package manage_school.utils;

import manage_school.modle.Persons;
import manage_school.modle.Student;
import manage_school.modle.Teacher;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void writeFile(String pathFile, List<String> list) {
        File file = new File(pathFile);

        try (FileWriter fileWriter = new FileWriter(file, false);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String data : list) {
                bufferedWriter.write(data);
                bufferedWriter.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }

    }

    public static void writeStudent(String pathFile, List<Student> manage) {
        List<String> list = new ArrayList<>();
        for (Student e : manage) {
            list.add(e.convertLine());

        }
        writeFile(pathFile, list);
    }
    public static void writeTeacher(String pathFile, List<Teacher> manage) {
        List<String> list = new ArrayList<>();
        for (Teacher e : manage) {
            list.add(e.convertLine());

        }
        writeFile(pathFile, list);
    }
    public static List<String> readFile(String pathFile) {
        File file = new File(pathFile);
        List<String> list = new ArrayList<>();

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
//                String[] arr = line.split(",");
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static List<Student> readStudent(String path) {
        List<String> list = readFile(path);
        List<Student> studentList = new ArrayList<>();
        String[] arr = null;
        for (String str : list) {
            arr = str.split(",");
            studentList.add(new Student(Integer.parseInt(arr[0]), arr[1], arr[2], LocalDate.parse(arr[3]), arr[4],arr[5],Double.parseDouble(arr[6])));
        }
        return studentList;
    }
    public static List<Teacher> readTeacher(String path) {
        List<String> list = readFile(path);
        List<Teacher> teacherList = new ArrayList<>();
        String[] arr = null;
        for (String str : list) {
            arr = str.split(",");
            teacherList.add(new Teacher(Integer.parseInt(arr[0]), arr[1], arr[2], LocalDate.parse(arr[3]), arr[4],arr[5],Double.parseDouble(arr[6]),Double.parseDouble(arr[7])));
        }
        return teacherList;
    }
}
