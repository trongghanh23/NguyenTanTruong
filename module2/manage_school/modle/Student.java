package manage_school.modle;

import java.time.LocalDate;

public class Student extends Persons {
    private String studentCode;
    private double pointMedium;

    public Student() {
    }

    @Override
    public String convertLine() {
        return super.getId() + ","
                + super.getName() + ","
                + super.getGender() + ","
                + super.getBirthday() + ","
                + super.getAddress() + ","
                + this.getStudentCode()+","
                + this.getPointMedium();
    }

    public Student(String studentCode, double pointMedium) {
        this.studentCode = studentCode;
        this.pointMedium = pointMedium;
    }

    public Student(int id, String name, String gender, LocalDate birthday, String address, String studentCode, double pointMedium) {
        super(id, name, gender, birthday, address);
        this.studentCode = studentCode;
        this.pointMedium = pointMedium;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public double getPointMedium() {
        return pointMedium;
    }

    public void setPointMedium(double pointMedium) {
        this.pointMedium = pointMedium;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "studentCode='" + studentCode + '\'' +
                ", pointMedium=" + pointMedium +
                '}';
    }
}
