package manage_school.service;

import ManageComputer.utils.NotFoundEmployeeException;
import manage_school.modle.Persons;
import manage_school.modle.Teacher;
import manage_school.utils.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TeacherIplm implements IPerson{
    Scanner scanner = new Scanner(System.in);
    static List<Teacher> teacherList = new ArrayList<>();
    private static final String PATH_TEACHER = "src/manage_school/data/teacher.csv";

    private static final String REGEX_INT = "^[1-9]{0,}$";
    public static final String REGEX_TIME = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Override
    public void display() {
        teacherList= ReadAndWrite.readTeacher(PATH_TEACHER);
        System.out.println("Danh sách manage employee");
        for (Persons item : teacherList) {
            System.out.println(item);

        }
    }

    @Override
    public void addNew() {
        teacherList= ReadAndWrite.readTeacher(PATH_TEACHER);
        int id = 0;
        int max = 0;
        if (teacherList == null) {
            id = 1;
        } else {
            for (int i = 0; i < teacherList.size(); i++) {
                if (teacherList.get(i).getId() > max) {
                    max = teacherList.get(i).getId();
                }

            }
        }
        id = max + 1;
        System.out.println("Nhập tên giáo viên: ");
        String name = CheckException.checkString();

        System.out.println("nhập giới tính: ");
        String gender=CheckException.checkString();

        System.out.println("nhập ngày sinh: ");
        LocalDate birthday = inputDate();

        System.out.println("nhập vào địa chỉ: ");
        String address = CheckException.checkString();

        System.out.println("nhập lớp dạy: ");
        String teachClass= CheckException.checkString();

        System.out.println("nhập lương 1 giờ dạy ");
        double salaryHours=Double.parseDouble(Regexs.regexData(scanner.nextLine(),REGEX_INT,"nhập vào số dương"));

        System.out.println("số giờ dạy");
        double teachNumber=CheckException.checkparseInt();

        Teacher teacher=new Teacher(id,name,gender,birthday,address,teachClass,salaryHours,teachNumber);
        teacherList.add(teacher);
        ReadAndWrite.writeTeacher(PATH_TEACHER,teacherList);
        System.out.println("thêm thành công: ");



    }

    @Override
    public void remove() {
        teacherList= ReadAndWrite.readTeacher(PATH_TEACHER);
        System.out.println("Enter id employee you want to remove:");
        String delIdEmployee = scanner.nextLine();

        boolean check = false;
        int index = 0;

        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getName().equals(delIdEmployee)) {
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
                    teacherList.remove(index);
                    System.out.println("Remove successful.");

                    ReadAndWrite.writeTeacher(PATH_TEACHER,teacherList);
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
        teacherList.clear();
        teacherList = ReadAndWrite.readTeacher(PATH_TEACHER);

        System.out.println("1\t Sắp xếp theo tên\n" +
                "2\t Sắp xếp theo ngày sinh\n" +
                "\t Enter your choice\n");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            Collections.sort(teacherList, new ComparatorName());
            for (Teacher item : teacherList) {
                System.out.println(item);
            }
        } else if (choice == 2) {
            Collections.sort(teacherList, new ComparatorDay());
            for (Teacher item : teacherList) {
                System.out.println(item);
            }
        } else {
            System.out.println("lựa chọn không đúng");
        }


    }

    @Override
    public void edit() {
        teacherList.clear();
        teacherList= ReadAndWrite.readTeacher(PATH_TEACHER);
        System.out.println("nhập giáo viên cần xoá ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getName().equals(input)) {

                System.out.println("Nhập tên giáo viên: ");
                String name = scanner.nextLine();

                System.out.println("nhập giới tính: ");
                String gender=scanner.nextLine();

                System.out.println("nhập ngày sinh: ");
                LocalDate birthday = inputDate();

                System.out.println("nhập vào địa chỉ: ");
                String address = scanner.nextLine();

                System.out.println("nhập lớp dạy: ");
                String teachClass= scanner.nextLine();

                System.out.println("nhập lương 1 giờ dạy ");
                double salaryHours=Double.parseDouble(scanner.nextLine());

                System.out.println("số giờ dạy");
                double teachNumber=Double.parseDouble(scanner.nextLine());

                int id=teacherList.get(i).getId();
                Teacher teacher=new Teacher(id,name,gender,birthday,address,teachClass,salaryHours,teachNumber);
                teacherList.set(i,teacher);
                System.out.println("Sửa khách hàng thành công: ");
                ReadAndWrite.writeTeacher(PATH_TEACHER,teacherList);
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
        LocalDate date = LocalDate.parse(Regexs.regexData(scanner.nextLine(), REGEX_TIME, "Input date wrong. Input again! dd/MM/yyyy"), formatter);
        LocalDate now;

        do {
            now = LocalDate.now();
            int current = Period.between(date, now).getYears();
            if (current >= 18) {
                return date;
            } else {
                System.out.println("Date must >= 18 years old! Input again!");
                date = LocalDate.parse(Regexs.regexData(scanner.nextLine(), REGEX_TIME, "Input date wrong. Input again! dd/MM/yyyy"), formatter);
            }
        } while (true);
    }
}
