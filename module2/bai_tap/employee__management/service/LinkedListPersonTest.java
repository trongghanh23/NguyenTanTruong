package bai_tap.employee__management.service;

import bai_tap.employee__management.model.AdministrativePersonnel;
import bai_tap.employee__management.model.DailyWorker;
import bai_tap.employee__management.model.Person;
import bai_tap.employee__management.model.ProductionStaff;
import bai_tap.employee__management.utils.SortNameEmployee;
import bai_tap.employee__management.utils.SortSalaryNameEmployee;

import java.util.*;

public class LinkedListPersonTest implements ITimekeep {
    public static Scanner scanner = new Scanner(System.in);
    static List<Person> personList = new LinkedList<>();

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
     * Không nên dùng vòng lặp truyền thống (for i = 0 -> size() – 1 => get(i)) để duyệt qua từng phần tử có trong LinkedList.
     * vì fori duyệt mảng từ đầu tới cuối mảng. tốc độ sẽ chậm.
     *
     * Giả sử công ty ABC thay đổi nhân sự liên tục (xóa và thêm nhân viên) thì nên sử dụng LinkedList.
     * vì dùng linked tốc độ xử lí sẽ nhanh hơn arraylist
     *
     * Ưu và nhược điểm của ArrayList và LinkedList.
     * arrayList:
     * cấu trúc dạng mảng động
     * truy xuất phần tử nhanh hơn.
     * chèn, xoá: chậm hơn
     * sử dụng lưu trữ cho danh sách ít thay đổi, thường xuyên truy xuất.
     *
     * LinkedList:
     * cấu trúc dạng liên kết đôi
     * truy xuất phần tử chậm hơn
     * chèn, xoá: nhanh hơn
     * sử dụng lưu trữ cho danh sách thường xuyên thay đổi phần tử.
     * phải tạo ra một interface có phương thức là chấm công rồi cho nhân viên quản lý và nhân viên sản xuất implements lại phương thức này
     *  Vì lớp con sẽ extend phương thức lớp cha
     * nên dùng interface, khi đối tượng có nhiều phương thứu
     * nên dùng abstract class, khi có nhiều đối tượng đều sử dụng phương thứu này
     */
}
