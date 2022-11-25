package ManageComputer.modle;

import java.time.LocalDate;

public class ProductionStaff extends Employees {
    private int productNumber;
    private double productPrice;
    private String staff;


    public ProductionStaff() {
    }

    @Override
    public String convertLine() {
        return super.getId() + ","
                + super.getEmployeeCode() + ","
                + super.getName() + ","
                + super.getBirthDay() + ","
                + super.getAddress() + ","
                + this.getProductNumber() + ","
                + this.getProductPrice();
    }

    public ProductionStaff(int productNumber, double productPrice) {
        this.productNumber = productNumber;
        this.productPrice = productPrice;
    }

    public ProductionStaff(int id, String employeeCode, String name, LocalDate birthDay, String address, int productNumber, double productPrice) {
        super(id, employeeCode, name, birthDay, address);
        this.productNumber = productNumber;
        this.productPrice = productPrice;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "ManageEmployee{" +
                super.toString() +
                "productNumber=" + productNumber +
                ", productPrice=" + productPrice +
                '}';
    }
}
