
package case_study_furama_resort.controller;

import case_study_furama_resort.service.iextend.ICustomerService;
import case_study_furama_resort.service.iextend.IEmployeeService;
import case_study_furama_resort.service.iextend.IFacilityService;
import case_study_furama_resort.service.CustomerServiceImpl;
import case_study_furama_resort.service.EmployeeServiceImpl;
import case_study_furama_resort.service.FacilityServiceImpl;
import case_study_furama_resort.utils.read_and_write_file.CheckException;

import java.util.Scanner;

public class FuramaController {
    static IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    static ICustomerService iCustomerService = new CustomerServiceImpl();
    static IFacilityService iFacilityService = new FacilityServiceImpl();

    public static Scanner scanner = new Scanner(System.in);


    public static void display() {

        do {
            System.out.println("" +
                    "1. Employee Management\n" +
                    "2.Customer Management\n" +
                    "3.Facility Management \n" +
                    "4.Booking Management\n" +
                    "5.Promotion Management\n" +
                    "6.Exit");
            System.out.println("Choose options: ");
            int check = CheckException.checkparseInt();

            switch (check) {
                case 1:
                    displayEmployee();
                    break;
                case 2:
                    displayCustomer();

                    break;
                case 3:
                    displayFacility();

                    break;
                case 4:
                    displayBooking();
                    break;

                case 5:
                    displayPromotion();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Số bạn chọn phải trong khoảng 1-6,Mời chọn lại chức năng: ");
            }

        }
        while (true);

    }

    public static void displayEmployee() {
        System.out.println("" +
                "1. Display list employees\n" +
                "2. Add new employee\n" +
                "3. Edit employee\n" +
                "4. Return main menu\n");
        int inputs = CheckException.checkparseInt();
        switch (inputs) {
            case 1:
                iEmployeeService.display();
                break;
            case 2:
                iEmployeeService.add();
                break;
            case 3:
                iEmployeeService.edit();
                break;
            case 4:
                return;

            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

    public static void displayCustomer() {
        System.out.println("" +
                "1. Display list customers\n" +
                "2. Add new customer\n" +
                "3. Edit customer\n" +
                "4. Return main menu\n");
        int input = CheckException.checkparseInt();
        switch (input) {
            case 1:
                iCustomerService.display();
                break;
            case 2:
                iCustomerService.add();
                break;
            case 3:
                iCustomerService.edit();
                break;
            case 4:
                return;

            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

    public static void displayFacility() {
        System.out.println("" +
                "1. Display list facility\n" +
                "2. Add new facility\n" +
                "3. Display list facility maintenance\n" +
                "4. Return main menu\n");
        int check = CheckException.checkparseInt();
        switch (check) {
            case 1:
                iFacilityService.display();
                break;
            case 2:
                addNewFacility();
                break;
            case 3:
                break;
            case 4:
                return;
            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

    public static void addNewFacility() {
        System.out.println("" +
                "1. add new villa\n" +
                "2. add new house\n" +
                "3. add new room\n" +
                "4. back to menu\n");
        System.out.println("choose");
        int check = CheckException.checkparseInt();
        switch (check) {
            case 1:
                iFacilityService.addNewVilla();
                displayFacility();
                break;
            case 2:
                iFacilityService.addNewHouse();
                displayFacility();
                break;
            case 3:
                iFacilityService.addNewRoom();
                break;
            case 4:
                return;
            default:
                System.out.println("mời nhập lại ");

        }
    }

    public static void displayBooking() {
        System.out.println("" +
                "1. Add new booking\n" +
                "2. Display list booking\n" +
                "3. Create new constracts\n" +
                "4. Display list contracts\n" +
                "5. Edit contracts\n" +
                "6. Return main menu\n");
        int input = CheckException.checkparseInt();
        switch (input) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                return;
            default:
                System.out.println("Mời nhập lại chức năng");
        }
    }

    public static void displayPromotion() {
        System.out.println("" +
                "1.Display list customers use service\n" +
                "2.Display list customers get voucher\n" +
                "3.Return main menu\n");
        int input = CheckException.checkparseInt();
        switch (input) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                return;
            default:
                System.out.println("Mời chọn lại chức năng: ");
        }
    }
}
