package _11_stack_queue.exercise.demerging;

public class Person {
    private String name;
    private Boolean gender;
    private String Date;

    public Person() {
    }

    public Person(String name, Boolean gender, String date) {
        this.name = name;
        this.gender = gender;
        Date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", Date='" + Date + '\'' +
                '}';
    }
}
