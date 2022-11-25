package case_study_furama_resort.model;

import case_study_furama_resort.model.Facility;

public class House extends Facility {
    private String roomStandard;

    private int numberFloors;

    public House() {
    }

    public House(String roomStandard, int numberFloors) {
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public House(String nameId, String serviceName, double acreage, double rental, int numberPerson, String rentalType, String roomStandard, int numberFloors) {
        super(nameId, serviceName, acreage, rental, numberPerson, rentalType);
        this.roomStandard = roomStandard;
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
                + this.getNumberFloors();

    }


    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", numberFloors=" + numberFloors +
                super.toString() +
                '}';
    }
}
