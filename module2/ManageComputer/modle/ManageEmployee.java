package ManageComputer.modle;

import java.time.LocalDate;

public class ManageEmployee extends Employees {
    private double basicSalary;
    private double coefficientsSalary;
    private String manageEmployee;

    public ManageEmployee() {
    }

    @Override
    public String convertLine() {
        return super.getId() + ","
                + super.getEmployeeCode() + ","
                + super.getName() + ","
                + super.getBirthDay() + ","
                + super.getAddress() + ","
                + this.getBasicSalary() + ","
                + this.getCoefficientsSalary();
    }

    public ManageEmployee(double basicSalary, double coefficientsSalary) {
        this.basicSalary = basicSalary;
        this.coefficientsSalary = coefficientsSalary;
    }

    public ManageEmployee(int id, String employeeCode, String name, LocalDate birthDay, String address, double basicSalary, double coefficientsSalary) {
        super(id, employeeCode, name, birthDay, address);
        this.basicSalary = basicSalary;
        this.coefficientsSalary = coefficientsSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    @Override
    public String toString() {
        return "ManageEmployee{" +
                super.toString()+
                "basicSalary=" + basicSalary +
                ", coefficientsSalary=" + coefficientsSalary +
                '}';
    }
}
