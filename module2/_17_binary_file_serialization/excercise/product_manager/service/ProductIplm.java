package _17_binary_file_serialization.excercise.product_manager.service;

import _17_binary_file_serialization.excercise.product_manager.model.Product;
import _17_binary_file_serialization.excercise.product_manager.utils.ReadWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductIplm implements IProduct {
    public static Scanner scanner = new Scanner(System.in);
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("1", "dell1", "dell", 1000));

    }

    @Override
    public void displayProduct() {
        System.out.println("Danh sách sản phẩm: ");
        productList=(List<Product>) ReadWrite.read("src/_17_binary_file_serialization/excercise/product_manager/data/FileBinary.csv");



        for (Product item : productList) {
            System.out.println(item);

        }

    }

    @Override
    public void addProduct() {

        System.out.println("nhập id cần thêm: ");
        String idProduct = scanner.nextLine();
        System.out.println("nhập tên cần thêm: ");
        String nameProduct = scanner.nextLine();
        System.out.println("nhập nhà sản xuất: ");
        String production = scanner.nextLine();
        System.out.println("nhập giá sản phẩm: ");
        double priceProduct = Double.parseDouble(scanner.nextLine());
        Product product = new Product(idProduct, nameProduct, production, priceProduct);
        productList.add(product);
        ReadWrite.write("src/_17_binary_file_serialization/excercise/product_manager/data/FileBinary.csv", productList);
        System.out.println("Đã thêm thành công: ");
    }

    @Override
    public void searchProduct() {
        System.out.println("nhập tên sản phẩm cần tìm: ");
        String input = scanner.nextLine();
        boolean check = true;
        for (Product id : productList) {
            if (id.getNameProduct().contains(input)) {
                System.out.println(id);
                check = false;
            }

        }
        if (check) {
            System.out.println("tên ko có vui lòng nhập lại: ");
        }

    }
}
