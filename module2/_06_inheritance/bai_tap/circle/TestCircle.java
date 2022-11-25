package _06_inheritance.bai_tap.circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(4, "red");
        System.out.println(circle);
        System.out.println("diện tích hình tròn là:" + circle.getArea());

    }
}
