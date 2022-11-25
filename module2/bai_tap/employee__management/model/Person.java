package bai_tap.employee__management.model;

public abstract class Person {
    private String name;
    private int Date;
    private String address;

    public Person() {
    }

    public Person(String name, int date, String address) {
        this.name = name;
        Date = date;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract double calculatorSalary();

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", Date=" + Date +
                ", address='" + address + '\'' +
                '}';
    }

}
