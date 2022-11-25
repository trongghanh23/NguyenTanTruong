package case_study_furama_resort.model;

public abstract class Person {
    private String name;
    private String date;
    private String gender;
    private String idCar;
    private int numberPhone;
    private String email;

    public Person() {
    }

    public Person(String name, String date, String gender, String idCar, int numberPhone, String email) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.idCar = idCar;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String convertLine();


    @Override
    public String toString() {
        return "Person{" +
                "Name='" + name + '\'' +
                ", Date=" + date +
                ", gender=" + gender +
                ", idCar='" + idCar + '\'' +
                ", numberPhone=" + numberPhone +
                ", email='" + email + '\'' +
                '}';
    }
}
