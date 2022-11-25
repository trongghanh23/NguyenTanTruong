package manage_school.service;

import ManageComputer.utils.NotFoundEmployeeException;
import ManageComputer.utils.Regex;
import manage_school.modle.Persons;
import manage_school.modle.Student;
import manage_school.utils.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentIplm implements IPerson {
    Scanner scanner = new Scanner(System.in);
    static List<Student> studentList = new ArrayList<>();
    private static final String PATH_STUDENT = "src/manage_school/data/student.csv";


    public static final String REGEX_TIME = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    private static final String REGEX_INT = "^[1-9]{0,}$";
    private static final String REGEX_POINT = "^[1-9]{0,10}$";
//    private static final String REGEX_AGE = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void display() {
        studentList = ReadAndWrite.readStudent(PATH_STUDENT);
        System.out.println("Danh sách manage employee");
        for (Persons item : studentList) {
            System.out.println(item);

        }

    }

    @Override
    public void addNew() {
        studentList = ReadAndWrite.readStudent(PATH_STUDENT);
        int id = 0;
        int max = 0;
        if (studentList == null) {
            id = 1;
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getId() > max) {
                    max = studentList.get(i).getId();
                }

            }
        }
        id = max + 1;
        System.out.println("Nhập tên học sinh: ");
        String name = CheckException.checkString();

        System.out.println("nhập giới tính: ");
        String gender = CheckException.checkString();

        System.out.println("nhập ngày sinh: ");
        LocalDate birthday = inputDate();

        System.out.println("nhập vào địa chỉ: ");
        String address = CheckException.checkString();

        System.out.println("nhập mã sinh viên: ");
        String studentCode = Regexs.regexData(scanner.nextLine(), REGEX_INT, "8 số không trùng student khác");

        System.out.println("nhập điểm trung binh ");
        double pointMedium = Double.parseDouble(Regexs.regexData(scanner.nextLine(), REGEX_POINT, "điểm trung bình 0-10"));
        Student students = new Student(id, name, gender, birthday, address, studentCode, pointMedium);
        studentList.add(students);
        ReadAndWrite.writeStudent(PATH_STUDENT, studentList);
        System.out.println("thêm thành công: ");


    }

    @Override
    public void remove() {
        studentList = ReadAndWrite.readStudent(PATH_STUDENT);
        System.out.println("Enter id employee you want to remove:");
        String delIdEmployee = scanner.nextLine();

        boolean check = false;
        int index = 0;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentCode().equals(delIdEmployee)) {
                check = true;
                index = i;
                break;
            }
        }

        if (check) {
            System.out.println("Do you want to remove employee ID: " + delIdEmployee);
            System.out.println("Choose yes or no\n" +
                    "1. yes\n" +
                    "2. no\n");
            int result = Integer.parseInt(scanner.nextLine());

            switch (result) {
                case 1:
                    studentList.remove(index);
                    System.out.println("Remove successful.");

                    ReadAndWrite.writeStudent(PATH_STUDENT, studentList);
                    display();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Input wrong!");
            }
        } else {
            try {
                throw new NotFoundEmployeeException("ID employee is not current!");
            } catch (NotFoundEmployeeException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    @Override
    public void sort() {
        studentList.clear();
        studentList = ReadAndWrite.readStudent(PATH_STUDENT);

        System.out.println("1\t Sắp xếp theo tên\n" +
                "2\t Sắp xếp theo ngày sinh\n" +
                "\t Enter your choice\n");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            Collections.sort(studentList, new ComparatorName());
            for (Student item : studentList) {
                System.out.println(item);
            }
        } else if (choice == 2) {
            Collections.sort(studentList, new ComparatorDay());
            for (Student item : studentList) {
                System.out.println(item);
            }
        } else {
            System.out.println("lựa chọn không đúng");
        }

    }

    @Override
    public void edit() {

        studentList.clear();
        studentList = ReadAndWrite.readStudent(PATH_STUDENT);
        System.out.println("nhập học sinh cần edit ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentCode().equals(input)) {

                System.out.println("Nhập tên học sinh: ");
                String name = scanner.nextLine();

                System.out.println("nhập giới tính: ");
                String gender = scanner.nextLine();

                System.out.println("nhập ngày sinh: ");
                LocalDate birthday = inputDate();

                System.out.println("nhập vào địa chỉ: ");
                String address = scanner.nextLine();

                System.out.println("nhập mã sinh viên: ");
                String studentCode = scanner.nextLine();

                System.out.println("nhập điểm trung binh ");
                double pointMedium = Double.parseDouble(scanner.nextLine());
                int id = studentList.get(i).getId();
                Student students = new Student(id, name, gender, birthday, address, studentCode, pointMedium);
                studentList.set(i, students);
                System.out.println("Sửa khách hàng thành công: ");
                ReadAndWrite.writeStudent(PATH_STUDENT, studentList);
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("nhập mã khách hàng sai vui lòng nhập lại");
            edit();
        }

    }

    public LocalDate inputDate() {
        System.out.println("Enter employee date: ");

        LocalDate date = LocalDate.parse(Regexs.regexData(scanner.nextLine(), REGEX_TIME, "Input date wrong. Input again!"), formatter);
        LocalDate now;

        do {
            now = LocalDate.now();
            int current = Period.between(date, now).getYears();
            if (current >= 18) {
                return date;
            } else {
                System.out.println("Date must >= 18 years old! Input again!");
                date = LocalDate.parse(Regexs.regexData(scanner.nextLine(), REGEX_TIME, "Input date wrong. Input again!"), formatter);
            }
        } while (true);
    }
}
