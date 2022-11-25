package ManageComputer.service;

import ManageComputer.modle.ManageEmployee;
import ManageComputer.utils.NotFoundEmployeeException;
import ManageComputer.utils.ReadAndWriteCharacter;
import ManageComputer.utils.Regex;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageEmployeeImpl implements Employee {
    Scanner scanner = new Scanner(System.in);
    static List<ManageEmployee> manageEmployeeList = new ArrayList<>();
    private static final String PATH_MANAGE = "src/ManageComputer/data/manage_employee.csv";

    public static final String REGEX_TIME = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String REGEX_MANAGER = "^NVQL-\\d{3}$";
    public static final String REGEX_PRODUCE = "^NVSX-\\d{3}$";
    public static final String REGEX_POSITIVE_NUMBER = "[1-9][0-9]*";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void display() {
        manageEmployeeList = ReadAndWriteCharacter.readProduction(PATH_MANAGE);
        System.out.println("Danh sách manage employee");
        for (ManageEmployee item : manageEmployeeList) {
            System.out.println(item);

        }

    }

    @Override
    public void add() {
        manageEmployeeList = ReadAndWriteCharacter.readProduction(PATH_MANAGE);
        int id = 0;
        int max = 0;
        if (manageEmployeeList == null) {
            id = 1;
        } else {
            for (int i = 0; i < manageEmployeeList.size(); i++) {
                if (manageEmployeeList.get(i).getId() > max) {
                    max = manageEmployeeList.get(i).getId();
                }

            }
        }
        id = max + 1;
        System.out.println("nhập mã nhân viên: ");
        String employeeCode = Regex.regexData(scanner.nextLine(), REGEX_MANAGER, "ID manager: NVQL-XXX. Input again!");

        System.out.println("nhập tên nhân viên:");
        String name = scanner.nextLine();

        System.out.println("nhập ngày tháng năm sinh: ");
        LocalDate birthday = inputDate();

        System.out.println("nhập vào địa chỉ: ");
        String address = scanner.nextLine();

        System.out.println("nhập lương cơ bản: ");
        double basiSalary = Double.parseDouble(Regex.regexData(scanner.nextLine(), REGEX_POSITIVE_NUMBER, "Base salary must > 0. Input again!"));

        System.out.println("nhập hệ số lương: ");
        double coefficientsSalary = Double.parseDouble(Regex.regexData(scanner.nextLine(), REGEX_POSITIVE_NUMBER, "Factor must > 0. Input again!"));

        ManageEmployee manageEmployee = new ManageEmployee(id, employeeCode, name, birthday, address, basiSalary, coefficientsSalary);
        manageEmployeeList.add(manageEmployee);
        ReadAndWriteCharacter.writeManageEmployee(PATH_MANAGE, manageEmployeeList);

        System.out.println("thêm thành công: ");

    }

    @Override
    public void remove() {
        manageEmployeeList = ReadAndWriteCharacter.readProduction(PATH_MANAGE);

        System.out.println("Enter id employee you want to remove:");
        String delIdEmployee = scanner.nextLine();

        boolean check = false;
        int index = 0;

        for (int i = 0; i < manageEmployeeList.size(); i++) {
            if (manageEmployeeList.get(i).getEmployeeCode().equals(delIdEmployee)) {
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
                    manageEmployeeList.remove(index);
                    System.out.println("Remove successful.");

                    ReadAndWriteCharacter.writeManageEmployee(PATH_MANAGE, manageEmployeeList);
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
    public void search() {
        manageEmployeeList = ReadAndWriteCharacter.readProduction(PATH_MANAGE);
        System.out.println("Enter anything you want to find:");
        String findStr = scanner.nextLine();
        boolean check = false;

        for (ManageEmployee employee : manageEmployeeList) {
            if (employee.getEmployeeCode().contains(findStr) || employee.getName().contains(findStr) || employee.getAddress().contains(findStr)) {
                check = true;
                System.out.println(employee);
            }
        }

        if (!check) {
            System.out.println("Find no result!");
        }
    }

    public LocalDate inputDate() {
        System.out.println("Enter employee date: ");
        LocalDate date = LocalDate.parse(Regex.regexData(scanner.nextLine(), REGEX_TIME, "Input date wrong. Input again!"), formatter);
        LocalDate now;

        do {
            now = LocalDate.now();
            int current = Period.between(date, now).getYears();
            if (current >= 18) {
                return date;
            } else {
                System.out.println("Date must >= 18 years old! Input again!");
                date = LocalDate.parse(Regex.regexData(scanner.nextLine(), REGEX_TIME, "Input date wrong. Input again!"), formatter);
            }
        } while (true);
    }


}
