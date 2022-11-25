package case_study_furama_resort.model;

import case_study_furama_resort.model.Person;

public class Customer extends Person {
    private String customerId;
    private String customerType;
    private String address;

    public Customer() {
    }

    @Override
    public String convertLine() {
        return super.getName() + ","
                + super.getDate() + ","
                + super.getGender() + ","
                + super.getIdCar() + ","
                + super.getNumberPhone() + ","
                + super.getEmail() + ","
                + this.getCustomerId() + ","
                + this.getCustomerType() + ","
                + this.getAddress();
    }


    public Customer(String idCustomer, String typeCustomer, String address) {
        this.customerId = idCustomer;
        this.customerType = typeCustomer;
        this.address = address;
    }

    public Customer(String name, String date, String gender, String idCar, int numberPhone, String email, String idCustomer, String typeCustomer, String address) {
        super(name, date, gender, idCar, numberPhone, email);
        this.customerId = idCustomer;
        this.customerType = typeCustomer;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + customerId + '\'' +
                ", typeCustomer='" + customerType + '\'' +
                ", address='" + address + '\'' +
                super.toString() +
                '}';
    }
}
