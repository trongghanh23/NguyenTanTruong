package case_study_furama_resort.model;

import case_study_furama_resort.model.Facility;

public class Villa extends Facility {
    private String roomStandard;
    private double swimmingPoolArea;
    private int numberFloors;

    public Villa() {
    }

    public Villa(String roomStandard, double swimmingPoolArea, int numberFloors) {
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberFloors = numberFloors;
    }

    public Villa(String nameId, String serviceName, double acreage, double rental, int numberPerson, String rentalType, String roomStandard, double swimmingPoolArea, int numberFloors) {
        super(nameId, serviceName, acreage, rental, numberPerson, rentalType);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String convert() {
        return super.getNameId() + ","
                + super.getServiceName() + ","
                + super.getAcreage() + ","
                + super.getRental() + ","
                + super.getNumberPerson() + ","
                + super.getRentalType() + ","
                + this.getRoomStandard() + ","
                + this.getSwimmingPoolArea() + ","
                + this.getNumberFloors();
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", swimmingPoolArea=" + swimmingPoolArea +
                ", numberFloors=" + numberFloors +
                super.toString() +
                '}';
    }
}
