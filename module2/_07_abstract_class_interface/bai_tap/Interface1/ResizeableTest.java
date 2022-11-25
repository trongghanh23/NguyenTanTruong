package _07_abstract_class_interface.bai_tap.Interface1;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3, "red", true);
        shapes[1] = new Square("black", true, 7);
        shapes[2] = new Rectangle("yellow", true, 2, 4);

        System.out.println("Before");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        System.out.println("After");
        double percent = Math.random() * 100;
        System.out.println("increase in size with ratio " + percent);

        for (Shape shape : shapes) {
            shape.resize(percent);
            System.out.println(shape);
        }
    }
}
