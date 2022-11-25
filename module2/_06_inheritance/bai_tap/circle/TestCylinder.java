package _06_inheritance.bai_tap.circle;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(2, "blue", 5);
        System.out.println(cylinder);
        System.out.println("thể tích hình trụ là:" + cylinder.getVolume());
    }
}
