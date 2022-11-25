package _05_access_modifier.bai_tap.student;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("nguyễn tấn trường");
        student.setClasses("c0322G1");
        System.out.println("tên:" + student.getName());
        System.out.println("Lớp:" + student.getClasses());
    }
}
