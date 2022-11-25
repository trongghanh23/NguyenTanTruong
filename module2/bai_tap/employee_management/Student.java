package bai_tap.employee_management;

import bai_tap.employee_management.Person;

public class Student extends Person {
    private double point;

    public Student() {
    }

    public Student(double point) {
        this.point = point;
    }

    public Student(int id, String name, int age, Boolean gender, double point) {
        super(id, name, age, gender);
        this.point = point;
    }

}
