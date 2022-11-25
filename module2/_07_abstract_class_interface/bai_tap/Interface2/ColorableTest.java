package _07_abstract_class_interface.bai_tap.Interface2;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("red", true, 5);
        shapes[1] = new Square("yellow", true);
        shapes[2] = new Rectangle("red", true, 3, 4);
        System.out.println("List Shape: ");
        for (Shape shape : shapes) {
            if (shape instanceof Colorable) {
                System.out.println(shape + "-");
                ((Colorable) shape).howToColor();
            } else {
                System.out.println(shape);
            }
        }

    }
}
