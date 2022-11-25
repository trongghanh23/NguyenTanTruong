package bai_tap.employee__management.model;

public class DailyWorker extends Person {
    private double numberDay;

    public DailyWorker() {
    }

    public DailyWorker(double numberDay) {
        this.numberDay = numberDay;
    }

    public DailyWorker(String name, int date, String address, double numberDay) {
        super(name, date, address);
        this.numberDay = numberDay;
    }

    public double getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(double numberDay) {
        this.numberDay = numberDay;
    }

    @Override
    public double calculatorSalary() {
        return this.numberDay * 120000;
    }

    @Override
    public String toString() {
        return "DailyWorker{" +
                "numberDay=" + numberDay +
                super.toString() +
                "salary=" + calculatorSalary() +
                '}';
    }
}
