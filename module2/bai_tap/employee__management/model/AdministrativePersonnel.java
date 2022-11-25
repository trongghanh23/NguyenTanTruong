package bai_tap.employee__management.model;

public class AdministrativePersonnel extends Person {
    private double salary;
    private double coefficientsSalary;

    public AdministrativePersonnel() {
    }

    public AdministrativePersonnel(double salary, double coefficientsSalary) {
        this.salary = salary;
        this.coefficientsSalary = coefficientsSalary;
    }

    public AdministrativePersonnel(String name, int date, String address, double salary, double coefficientsSalary) {
        super(name, date, address);
        this.salary = salary;
        this.coefficientsSalary = coefficientsSalary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    @Override
    public double calculatorSalary() {
        return this.salary * coefficientsSalary;
    }

    @Override
    public String toString() {
        return "AdministrativePersonnel{" +
                "salary=" + salary +
                ", coefficientsSalary=" + coefficientsSalary +
                "salary=" + calculatorSalary() +
                super.toString() +
                '}';
    }
}
