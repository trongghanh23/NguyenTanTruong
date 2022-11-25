package case_study_furama_resort.model;

import case_study_furama_resort.model.Facility;

public class
Room extends Facility {
    private String service;


    public Room() {
    }

    public Room(String service) {
        this.service = service;
    }

    public Room(String nameId, String serviceName, double acreage, double rental, int numberPerson, String rentalType, String service) {
        super(nameId, serviceName, acreage, rental, numberPerson, rentalType);
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String convert() {
        return super.getNameId() + ","
                + super.getServiceName() + ","
                + super.getAcreage() + ","
                + super.getRental() + ","
                + super.getNumberPerson() + ","
                + super.getRentalType() + ","
                + this.getService();
    }

    @Override
    public String toString() {
        return "Room{" +
                "service='" + service + '\'' +
                super.toString() +
                '}';
    }
}
