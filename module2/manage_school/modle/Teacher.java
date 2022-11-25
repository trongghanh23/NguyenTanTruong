package manage_school.modle;

import java.time.LocalDate;

public class Teacher extends Persons {
    private String teachClass;
    private double hoursSalary;
    private double TeachNumber;

    public Teacher() {
    }

    @Override
    public String convertLine() {
        return super.getId() + ","
                + super.getName() + ","
                + super.getGender() + ","
                + super.getBirthday() + ","
                + super.getAddress() + ","
                + this.getTeachClass()+","
                + this.getHoursSalary()+","
                + this.getTeachNumber();
    }

    public Teacher(String teachClass, double hoursSalary, double teachNumber) {
        this.teachClass = teachClass;
        this.hoursSalary = hoursSalary;
        TeachNumber = teachNumber;
    }

    public Teacher(int id, String name, String gender, LocalDate birthday, String address, String teachClass, double hoursSalary, double teachNumber) {
        super(id, name, gender, birthday, address);
        this.teachClass = teachClass;
        this.hoursSalary = hoursSalary;
        TeachNumber = teachNumber;
    }

    public String getTeachClass() {
        return teachClass;
    }

    public void setTeachClass(String teachClass) {
        this.teachClass = teachClass;
    }

    public double getHoursSalary() {
        return hoursSalary;
    }

    public void setHoursSalary(double hoursSalary) {
        this.hoursSalary = hoursSalary;
    }

    public double getTeachNumber() {
        return TeachNumber;
    }

    public void setTeachNumber(double teachNumber) {
        TeachNumber = teachNumber;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                super.toString()+
                "teachClass='" + teachClass + '\'' +
                ", hoursSalary=" + hoursSalary +
                ", TeachNumber=" + TeachNumber +
                '}';
    }
}
