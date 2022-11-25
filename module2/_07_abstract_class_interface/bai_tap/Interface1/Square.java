package _07_abstract_class_interface.bai_tap.Interface1;

import _07_abstract_class_interface.bai_tap.Interface1.Resizeable;
import _07_abstract_class_interface.bai_tap.Interface1.Shape;

public class Square extends Shape implements Resizeable {
    private double edge;

    public Square() {
    }

    public Square(double edge) {
        this.edge = edge;
    }

    public Square(String color, boolean filled, double edge) {
        super(color, filled);
        this.edge = edge;
    }

    public double getArea() {
        return Math.pow(edge, 2);
    }

    public double getPerimeter() {
        return edge * 4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "edge=" + edge +
                super.toString() +
                '}';
    }

    @Override
    public void resize(double percent) {

    }
}
