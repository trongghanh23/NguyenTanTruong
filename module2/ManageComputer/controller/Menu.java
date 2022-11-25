package ManageComputer.controller;

import ManageComputer.service.Employee;
import ManageComputer.service.ManageEmployeeImpl;
import ManageComputer.service.ProductionStaffImpl;

import java.util.Scanner;

public class Menu {
    static Employee IProductionStaff = new ProductionStaffImpl();
    static Employee IManageEmployee = new ManageEmployeeImpl();


    public static Scanner scanner = new Scanner(System.in);


    public static void displayMenu() {

        do {
            System.out.println("" +
                    "1. display\n" +
                    "2. add new\n" +
                    "3. remove \n" +
                    "4. search\n" +
                    "5. Exit");
            System.out.println("Choose options: ");
            int check = Integer.parseInt(scanner.nextLine());

            switch (check) {
                case 1:
                    displayEmployee();

                    break;
                case 2:
                    addEmployee();

                    break;
                case 3:
                    removeEmployee();

                    break;
                case 4:
                    searchEmployee();
                    break;

                case 5:
                    System.exit(0);
                default:
                    System.out.println("Số bạn chọn phải trong khoảng 1-5,Mời chọn lại chức năng: ");
            }

        }
        while (true);

    }

    public static void displayEmployee() {
        System.out.println("" +
                "1. display Manage Employee\n" +
                "2. display Production staff\n" +
                "3. Return main menu\n");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                IManageEmployee.display();
                break;
            case 2:
                IProductionStaff.display();
                break;
            case 3:
                return;

            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

    public static void addEmployee() {
        System.out.println("" +
                "1. add Manage Employee\n" +
                "2. add Production staff\n" +
                "3. Return main menu\n");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                IManageEmployee.add();
                break;
            case 2:
                IProductionStaff.add();
                break;
            case 3:
                return;

            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

    public static void removeEmployee() {
        System.out.println("" +
                "1. remove Manage Employee\n" +
                "2. remove Production staff\n" +
                "3. Return main menu\n");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                IManageEmployee.remove();
                break;
            case 2:
                IProductionStaff.remove();
                break;
            case 3:
                return;

            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

    public static void searchEmployee() {
        System.out.println("" +
                "1. search Manage Employee\n" +
                "2. search Production staff\n" +
                "3. Return main menu\n");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                searchManageEmployee();

                break;
            case 2:
                searchProductionStaff();
                break;
            case 3:
                return;

            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

    public static void searchManageEmployee() {
        System.out.println("" +
                "1. search employee code\n" +
                "2. search name\n" +
                "3. search birthday\n" +
                "4. search địa chỉ\n" +
                "5. Return main menu\n");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
            case 2:
            case 3:
            case 4:
                IManageEmployee.search();
                break;
            case 5:
                return;
            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

    public static void searchProductionStaff() {
        System.out.println("" +
                "1. search employee code\n" +
                "2. search name\n" +
                "3. search birthday\n" +
                "4. search địa chỉ\n" +
                "5. Return main menu\n");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
            case 2:
            case 3:
            case 4:
                IProductionStaff.search();
                break;
            case 5:
                return;
            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

}
