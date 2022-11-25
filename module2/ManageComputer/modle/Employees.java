package ManageComputer.modle;

import java.time.LocalDate;

public abstract class Employees {
    private int id;
    private String employeeCode;
    private String name;
    private LocalDate birthDay;
    private String address;


    public Employees() {
    }

    public Employees(int id, String employeeCode, String name, LocalDate birthDay, String address) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract String convertLine();

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", employeeCode='" + employeeCode + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

