package case_study_furama_resort.service;

import case_study_furama_resort.model.Employee;
import case_study_furama_resort.service.iextend.IEmployeeService;
import case_study_furama_resort.utils.read_and_write_file.ReadAndWriteCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    Scanner scanner = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    List<Employee> employeeList = new ArrayList<>();
    private static final String PATH_EMPLOYEE = "src/case_study_furama_resort/data/employee.csv";

    @Override
    public void display() {
        employeeList = ReadAndWriteCharacter.readEmployee(PATH_EMPLOYEE);
        for (Employee item : employeeList) {
            System.out.println(item);

        }
    }

    @Override
    public void add() {
        employeeList = ReadAndWriteCharacter.readEmployee(PATH_EMPLOYEE);
        System.out.println("Nhập tên nhân viên: ");
        String name = input.nextLine();

        System.out.println("nhập ngày tháng năm sinh: ");
        String age = input.nextLine();

        String gender = genderEmployee();
        System.out.println("Mã nhân viên: ");
        String idCard = input.nextLine();

        System.out.println("Nhập số điện thoại: ");
        int numberPhone = Integer.parseInt(input.nextLine());

        System.out.println(" Nhập email: ");
        String email = input.nextLine();

        String level = levelEmployee();
        String location = localEmployee();

        System.out.println("Nhập lương: ");
        double salary = Double.parseDouble(input.nextLine());

        Employee employee = new Employee(name, age, gender, idCard, numberPhone, email, level, location, salary);
        employeeList.add(employee);

        ReadAndWriteCharacter.writeEmployee(PATH_EMPLOYEE, employeeList);
        System.out.println("thêm thành công: ");
    }

    @Override
    public void edit() {

        employeeList.clear();
        employeeList = ReadAndWriteCharacter.readEmployee(PATH_EMPLOYEE);
        System.out.println("Nhập tên nhân viên cần sửa: ");
        String inputEditId = scanner.nextLine();

        boolean check = true;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getName().equals(inputEditId)) {
                System.out.println("Nhập tên nhân viên: ");
                String name = scanner.nextLine();

                System.out.println("nhập ngày tháng năm sinh: ");
                String age = input.nextLine();

                String gender = genderEmployee();
                System.out.println("Mã nhân viên: ");
                String idCard = input.nextLine();

                System.out.println("Nhập số điện thoại: ");
                int numberPhone = Integer.parseInt(input.nextLine());

                System.out.println(" Nhập email: ");
                String email = input.nextLine();
                String level = levelEmployee();
                String location = localEmployee();

                System.out.println("Nhập lương: ");
                double salary = Double.parseDouble(input.nextLine());

                Employee employee = new Employee(name, age, gender, idCard, numberPhone, email, level, location, salary);
                employeeList.set(i, employee);
                System.out.println("Edit nhân viên thành công");
                ReadAndWriteCharacter.writeEmployee(PATH_EMPLOYEE, employeeList);
                check = false;
                break;
            }

        }
        if (check) {
            System.out.println("nhập sai mã vui lòng nhập lại: ");
            edit();
        }

    }

    public String levelEmployee() {
        while (true) {
            System.out.println("chon trình độ: \n" +
                    "1. Trung cấp\n" +
                    "2. Cao đẳng\n" +
                    "3. Đại học \n" +
                    "4. sau đại học \n");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    return "Trung cấp";
                case "2":
                    return "Cao đẳng";
                case "3":
                    return "Đại học";
                case "4":
                    return "sau đại học";
                default:
                    System.out.println("vui lòng chon lại");
            }
        }
    }

    public String localEmployee() {
        while (true) {
            System.out.println("chon vị trí làm việc:  \n" +
                    "1. Lễ tân\n" +
                    "2. phục vụ\n" +
                    "3. chuyên viên\n" +
                    "4. giám sát\n" +
                    "5. quản lý\n" +
                    "5. giám đốc\n");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    return "Lễ tân";
                case "2":
                    return "phục vụ";

                case "3":
                    return "chuyên viên";

                case "4":
                    return "giám sát";

                case "5":
                    return "quản lý";
                case "6":
                    return "giám đốc";

                default:
                    System.out.println("vui lòng chọn lại");

            }
        }

    }

    public String genderEmployee() {
        while (true) {
            System.out.println("chon giới tính: \n" +
                    "1. Nam\n" +
                    "2. Nữ\n");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    return "Nam";
                case "2":
                    return "nữ";
                default:
                    System.out.println("vui lòng chon lại");
            }
        }
    }
}
