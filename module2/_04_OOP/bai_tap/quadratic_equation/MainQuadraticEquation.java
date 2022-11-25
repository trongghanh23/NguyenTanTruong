package _04_OOP.bai_tap.quadratic_equation;

import java.util.Scanner;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập hệ số a");
        double a = scanner.nextDouble();
        System.out.println("nhập hệ số b");
        double b = scanner.nextDouble();
        System.out.println("nhập hệ số c");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("Nghiệm thứ nhất:" + quadraticEquation.getRoot1() + "\n" + "Nghiệm thứ hai" + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("Phương trình có một nghiêm:" + quadraticEquation.getRoot3());
        } else {
            System.out.println("The equation has no roots");
        }

    }
}
