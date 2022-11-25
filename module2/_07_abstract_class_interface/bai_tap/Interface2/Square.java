package _07_abstract_class_interface.bai_tap.Interface2;

public class Square extends Rectangle implements Colorable {
    public Square() {
    }

    public Square(double width, double length) {
        super(width, length);
    }

    public Square(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
    }

    public Square(String color, boolean filled) {
        super(color, filled);
    }

    public Square(double side) {
        super(side, side);
    }

    @Override
    public String toString() {
        return "A Square with side="

                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
