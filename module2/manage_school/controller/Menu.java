package manage_school.controller;

import manage_school.service.IPerson;
import manage_school.service.StudentIplm;
import manage_school.service.TeacherIplm;
import manage_school.utils.CheckException;

import java.util.Scanner;

public class Menu {
    static IPerson iStudent = new StudentIplm();
    static IPerson iTeacher = new TeacherIplm();


    public static Scanner scanner = new Scanner(System.in);


    public static void displayMenu() {

        do {
            System.out.println("" +
                    "1. display\n" +
                    "2. add new\n" +
                    "3. remove \n" +
                    "4. sort\n" +
                    "5. edit\n" +
                    "6. Exit");
            System.out.println("Choose options: ");
            int check = CheckException.checkparseInt();

            switch (check) {
                case 1:
                    displayPerson();

                    break;
                case 2:
                    addPerson();

                    break;
                case 3:
                    removePerson();

                    break;
                case 4:
                    sortPerson();
                    break;
                case 5:
                    editPerson();
                    break;

                case 6:
                    System.exit(0);
                default:
                    System.out.println("Số bạn chọn phải trong khoảng 1-5,Mời chọn lại chức năng: ");
            }

        }
        while (true);

    }
    public static void displayPerson() {
        System.out.println("" +
                "1. display Student\n" +
                "2. display Teacher\n" +
                "3. Return main menu\n");
        int input = CheckException.checkparseInt();
        switch (input) {
            case 1:
                iStudent.display();
                break;
            case 2:
                iTeacher.display();
                break;
            case 3:
                return;

            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }
    public static void addPerson() {
        System.out.println("" +
                "1. add Student\n" +
                "2. add Teacher\n" +
                "3. Return main menu\n");
        int input = CheckException.checkparseInt();
        switch (input) {
            case 1:
                iStudent.addNew();
                break;
            case 2:
                iTeacher.addNew();
                break;
            case 3:
                return;

            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }
    public static void removePerson() {
        System.out.println("" +
                "1. remove Student\n" +
                "2. remove Teacher\n" +
                "3. Return main menu\n");
        int input = CheckException.checkparseInt();
        switch (input) {
            case 1:
                iStudent.remove();
                break;
            case 2:
                iTeacher.remove();
                break;
            case 3:
                return;

            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }
    public static void sortPerson() {
        System.out.println("" +
                "1. sort Student\n" +
                "2. sort Teacher\n" +
                "3. Return main menu\n");
        int input = CheckException.checkparseInt();
        switch (input) {
            case 1:
               iStudent.sort();
                break;
            case 2:
                iTeacher.sort();
                break;
            case 3:
                return;

            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

    public static void editPerson() {
        System.out.println("" +
                "1. edit Student\n" +
                "2. edit Teacher\n" +
                "3. Return main menu\n");
        int input = CheckException.checkparseInt();
        switch (input) {
            case 1:
                iStudent.edit();
                break;
            case 2:
                iTeacher.edit();
                break;
            case 3:
                return;

            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

}
