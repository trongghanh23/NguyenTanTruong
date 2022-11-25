package case_study_furama_resort.service;

import case_study_furama_resort.model.Customer;
import case_study_furama_resort.model.Person;
import case_study_furama_resort.service.iextend.ICustomerService;
import case_study_furama_resort.utils.read_and_write_file.ReadAndWriteCharacter;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    public static Scanner scanner = new Scanner(System.in);
    static List<Customer> customerList = new LinkedList<>();

    private static final String PATH_CUSTOMER = "src/case_study_furama_resort/data/customer.csv";


    @Override
    public void display() {
        customerList = ReadAndWriteCharacter.readCustomer(PATH_CUSTOMER);
        System.out.println("danh sách khách hàng: ");
        for (Person tem : customerList) {
            System.out.println(tem);

        }

    }

    @Override
    public void add() {
        customerList = ReadAndWriteCharacter.readCustomer(PATH_CUSTOMER);
        System.out.println("Nhập tên khách hàng cần thêm: ");
        String name = scanner.nextLine();

        System.out.println("Nhập ngày sinh: ");
        String date = scanner.nextLine();

        String gender = genderCustomer();
        System.out.println("nhập cmnd: ");

        String idCar = scanner.nextLine();
        System.out.println("nhập số điện thoại: ");
        int numberPhone = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập email: ");
        String email = scanner.nextLine();

        System.out.println("nhập mã khách hàng: ");
        String idCustomer = scanner.nextLine();

        System.out.println("nhập địa chỉ khách hàng: ");
        String addressCustomer = scanner.nextLine();
        String typerCustomer = menuTypeCustomer();

        Customer customer = new Customer(name, date, gender, idCar, numberPhone, email, idCustomer, typerCustomer, addressCustomer);
        customerList.add(customer);
        ReadAndWriteCharacter.writeCustomer(PATH_CUSTOMER, customerList);

        System.out.println("Đã thêm khách hàng thành công: ");

    }

    public String genderCustomer() {
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

    public String menuTypeCustomer() {
        while (true) {
            System.out.println("chon loại khách hàng: \n" +
                    "1. Diamond\n" +
                    "2. Platinium\n" +
                    "3. Gold\n" +
                    "4. Silver\n" +
                    "5. Member\n");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    return "Diamond";
                case "2":
                    return "Platinium";

                case "3":
                    return "Gold";

                case "4":
                    return "Silver";

                case "5":
                    return "Member";

                default:
                    System.out.println("vui lòng chọn lại");

            }
        }

    }

    @Override
    public void edit() {
        customerList.clear();
        customerList = ReadAndWriteCharacter.readCustomer(PATH_CUSTOMER);
        System.out.println("nhập id khách hàng cần sửa: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerId().equals(input)) {
                System.out.println("Nhập tên khách hàng: ");
                String name = scanner.nextLine();

                System.out.println("Nhập ngày sinh: ");
                String date = scanner.nextLine();

                System.out.println("nhập giới tính: ");
                String gender = scanner.nextLine();

                System.out.println("nhập cmd");
                String idCard = scanner.nextLine();

                System.out.println("nhập số điện thoại: ");
                int numberPhone = Integer.parseInt(scanner.nextLine());

                System.out.println("nhập email: ");
                String email = scanner.nextLine();

                System.out.println("nhập mã khách hàng: ");
                String idCustomer = scanner.nextLine();

                System.out.println("nhập loại khách hàng: ");
                String typeCustomer = scanner.nextLine();

                System.out.println("nhập địa chỉ khách hàng: ");
                String address = scanner.nextLine();

                Customer customer = new Customer(name, date, gender, idCard, numberPhone, email, idCustomer, typeCustomer, address);
                customerList.set(i, customer);
                ReadAndWriteCharacter.writeCustomer(PATH_CUSTOMER, customerList);
                System.out.println("Sửa khách hàng thành công: ");
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("nhập mã khách hàng sai vui lòng nhập lại");
            edit();
        }

    }


}
