package case_study_furama_resort.model;

public class Contract {
    private String idContract;
    private double deposit;
    private double totalMoney;
    private String idCustomer;

    public Contract() {
    }

    public Contract(String idContract, double deposit, double totalMoney, String idCustomer) {
        this.idContract = idContract;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.idCustomer = idCustomer;
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract='" + idContract + '\'' +
                ", deposit=" + deposit +
                ", totalMoney=" + totalMoney +
                ", idCustomer='" + idCustomer + '\'' +
                '}';
    }
}
