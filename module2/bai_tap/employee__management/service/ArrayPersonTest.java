package bai_tap.employee__management.service;

import bai_tap.employee__management.model.AdministrativePersonnel;
import bai_tap.employee__management.model.DailyWorker;
import bai_tap.employee__management.model.Person;
import bai_tap.employee__management.model.ProductionStaff;
import bai_tap.employee__management.utils.SortSalaryNameEmployee;
import bai_tap.employee_management.Teacher;

import java.util.Collections;

public class ArrayPersonTest implements ITimekeep {
    public static Person[] personList = new Person[1000];
    public static int count;

    static {
        personList[0] = new AdministrativePersonnel("nguyễn văn an", 2000, "Đà Nẵng", 26, 1.4);
        personList[1] = new DailyWorker("nguyễn hữa ánh", 1999, "Quảng nam", 26);
        personList[2] = new ProductionStaff("nguyễn ánh", 1998, "Quảng ngãi", 100);
        personList[3] = new AdministrativePersonnel("nguyễn văn tuấn", 2001, "Đà Nẵng", 25, 1.4);
        personList[4] = new DailyWorker("nguyễn anh phong", 1989, "Quảng nam", 24);
        personList[5] = new ProductionStaff("nguyễn ánh", 1998, "Quảng ngãi", 120);

        count = 6;
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

    }

    @Override
    public void sortName() {

    }

    @Override
    public void timeKeep() {

    }
}
/*check khác null để hiển thị các phần tử có giá trị bỏ đi các phần tử bị null
*từ khóa instanceof để kiểm tra kiểu dữ liệu
 *Nếu công ty có 1001 nhân viên thì khi biên dịch sẽ xảy ra lỗi tràn mảng Exception
 * Đa hình lúc runtime thể hiện ở  ghi đè overriding
 * Đa hình lúc compile thể hiện ở  nạp chồng overloading
 */