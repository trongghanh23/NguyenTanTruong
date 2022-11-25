package bai_tap.employee_management;

import bai_tap.employee_management.Person;

public class Teacher extends Person {
    private double salary;

    public Teacher() {
    }

    public Teacher(double salary) {
        this.salary = salary;
    }

    public Teacher(int id, String name, int age, Boolean gender, double salary) {
        super(id, name, age, gender);
        this.salary = salary;
    }
}
