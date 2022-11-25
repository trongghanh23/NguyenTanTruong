package bai_tap.employee__management.controller;

import bai_tap.employee__management.service.ArrayListPersonTest;
import bai_tap.employee__management.service.IPerson;
import bai_tap.employee__management.service.LinkedListPersonTest;

import java.util.Scanner;

public class MainLinkedList {
    private static Scanner scanner = new Scanner(System.in);
    static IPerson person = new LinkedListPersonTest();


    public static void display() {

        do {
            System.out.println("-------------Employee Management------------\n" +
                    "1. Display Display Person company\n" +
                    "2. Display DailyWorker\n" +
                    "3. Display  AdminnstrativePersonnel\n" +
                    "4. Display  ProductionStaff\n" +
                    "5. Display salary ascending\n" +
                    "6. Display Name descending\n" +
                    "7. Exit\n");
            System.out.println("Choose options: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    person.displayPerson();
                    break;
                case 2:
                    person.displayDailyWorker();
                    break;
                case 3:
                    person.displayAdminnstractive();
                    break;
                case 4:
                    person.displayProductStaff();
                    break;
                case 5:
                    person.sortSalaryNameEmployee();
                    break;
                case 6:
                    person.sortName();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("nhập không đúng id: ");
            }

        }
        while (true);
    }
}
