package _05_access_modifier.bai_tap.circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("bán kính hình tròn" + circle.getRadius());
        System.out.println("diện tích hình tròn" + circle.getArea());
    }
}
