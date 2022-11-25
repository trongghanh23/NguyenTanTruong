package bai_tap.employee__management.service;

import bai_tap.employee__management.model.AdministrativePersonnel;
import bai_tap.employee__management.model.DailyWorker;
import bai_tap.employee__management.model.Person;
import bai_tap.employee__management.model.ProductionStaff;
import bai_tap.employee__management.utils.SortNameEmployee;
import bai_tap.employee__management.utils.SortSalaryNameEmployee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayListPersonTest implements ITimekeep {
    public static Scanner scanner = new Scanner(System.in);
    static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new AdministrativePersonnel("nguyễn văn an", 2000, "Đà Nẵng", 26, 1.4));
        personList.add(new DailyWorker("nguyễn hữa ánh", 1999, "Quảng nam", 26));
        personList.add(new ProductionStaff("nguyễn ánh", 1998, "Quảng ngãi", 100));
        personList.add(new AdministrativePersonnel("nguyễn văn tuấn", 2001, "Đà Nẵng", 25, 1.4));
        personList.add(new DailyWorker("nguyễn anh phong", 1989, "Quảng nam", 24));
        personList.add(new ProductionStaff("nguyễn ánh", 1998, "Quảng ngãi", 120));

    }


    @Override
    public void displayPerson() {
        for (Person item : personList) {
            if (item != null) {
                System.out.println(item);
            }
        }

    }

    @Override
    public void displayDailyWorker() {
        for (Person item : personList) {
            if (item instanceof DailyWorker) {
                System.out.println(item);
            }
        }

    }

    @Override
    public void displayAdminnstractive() {
        for (Person item : personList) {
            if (item instanceof AdministrativePersonnel) {
                System.out.println(item);
            }
        }

    }

    @Override
    public void displayProductStaff() {
        for (Person item : personList) {
            if (item instanceof ProductionStaff) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void sortSalaryNameEmployee() {
        System.out.println("sắp xếp lương tăng dần: ");
        Collections.sort(personList, new SortSalaryNameEmployee());
        for (Person item : personList) {
            System.out.println(item);
        }

    }

    @Override
    public void sortName() {
        System.out.println("sắp xếp tên giảm dần: ");
        Collections.sort(personList, new SortNameEmployee());
        for (Person item : personList) {
            System.out.println(item);

        }
    }

    @Override
    public void timeKeep() {

    }
    /*
     * Nếu công ty có 1001 nhân viên thì sẽ không vấn đề gì
     * ArrayList không cần khởi tạo 1000 phần tử trước vì
     * mỗi lần thêm phần tử arraylist sẽ tự động tạo ra một mảng mới có kích thước gấp 50% mảng ban đầu
     *
     * ưu và nhược điểm của  Array  so với ArrayList
     * array kích thước cố định
     * chỉ có thuộc tính length
     * chỉ có thể lưu trữ kiểu dữ liệu nguyên thuỷ và đối tượng
     * duyệt mảng nhanh hơn arraylist .
     * arrayList
     *  kích thước mảng có thể thay đổi được
     * cung cấp nhiều method để thao tác
     * chỉ lưu trữ kiểu đối tượng có cơ chế auto boxing
     * duyệt mảng chậm hơn array
     */

}
