package _05_access_modifier.bai_tap.student;

public class Student {
    private String name = "john";
    private String classes = "c02";

    public Student() {

    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
