package bai_tap.employee__management.model;

public class ProductionStaff extends Person {
    private int productNumber;

    public ProductionStaff() {
    }

    public ProductionStaff(int productNumber) {
        this.productNumber = productNumber;
    }

    public ProductionStaff(String name, int date, String address, int productNumber) {
        super(name, date, address);
        this.productNumber = productNumber;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    @Override
    public double calculatorSalary() {
        return this.productNumber * 50000;
    }

    @Override
    public String toString() {
        return "ProductionStaff{" +
                "productNumber=" + productNumber +
                super.toString() +
                "salary=" + calculatorSalary() +
                '}';
    }
}
