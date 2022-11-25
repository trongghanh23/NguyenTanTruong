package case_study_furama_resort.model;

public class Booking {
    private int idBooking;
    private String dayStart;
    private String dayEnd;
    private String idCustomer;
    private String nameService;
    private String typeService;

    public Booking() {
    }

    public Booking(int idBooking, String dayStart, String dayEnd, String idCustomer, String nameService, String typeService) {
        this.idBooking = idBooking;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.idCustomer = idCustomer;
        this.nameService = nameService;
        this.typeService = typeService;
    }

    public Booking(int id, String starDay, String endDay, Integer customer, String facility) {
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idBooking=" + idBooking +
                ", dayStart=" + dayStart +
                ", dayEnd=" + dayEnd +
                ", idCustomer='" + idCustomer + '\'' +
                ", nameService='" + nameService + '\'' +
                ", typeService='" + typeService + '\'' +
                '}';
    }
}
