package bai_tap.employee__management.utils;

import bai_tap.employee__management.model.Person;

import java.util.Comparator;


public class SortSalaryNameEmployee implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.calculatorSalary() - o2.calculatorSalary() > 0) {
            return 1;
        } else if (o1.calculatorSalary() - o2.calculatorSalary() < 0) {
            return -1;
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
    /*Để sử dụng được Comparable, ta phải implements interface Comparable cho lớp đối tượng cần được so sánh
    *Để sử dụng Comparator ta không cần phải implements Comparator cho lớp đối tượng cần được so sánh
    *Ta nên sử dụng comparator vì Giả sử ngoài sắp xếp theo một tiêu chí nhất đinh, ta còn muốn sắp xếp theo nhiều các tiêu chí khác nữa
    * Comparator chính là cách giải quyết vấn đề trên.
    * nếu chỉ sử dụng Comparable thì có được Vì sao nó có thể tạo dùng trực tiếp trong class
    * nếu chỉ sử dụng Comparator thì có được Vì nó có thể dùng với nhiều tiêu chí sắp xếp
    * khi nào bắt buộc phải sử dụng Comparator là khi yêu cầu sắp xếp nhiều tiêu chí
    * khi nào chỉ cần dùng Comparable là khi chỉ yêu cầu sắp xếp 1 tiêu chí
    *  khác nhau giữa Comparator và Comparable:
    * Comparable:
    * sử dụng để sắp xếp các đối tượng của lớp do người dùng định nghĩa
    * Giao diện này thuộc về gói java.lang
    * Phương thức compareTo() được sử dụng để so sánh đối tượng hiện tại với đối tượng được chỉ định.
    * Comparator:
    * sử dụng để sắp xếp các đối tượng của lớp do người dùng định nghĩa (user-defined).
    *  Giao diện này thuộc về gói java.util
    * chứa hai phương thức là compare(Object obj1, Object obj2) và equals(Object element):
     */
}
