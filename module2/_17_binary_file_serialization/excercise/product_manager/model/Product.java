package _17_binary_file_serialization.excercise.product_manager.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String idProduct;
    private String nameProduct;
    private String production;
    private double priceProduct;

    public Product() {
    }

    public Product(String idProduct, String nameProduct, String production, double priceProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.production = production;
        this.priceProduct = priceProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", production='" + production + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }
}
