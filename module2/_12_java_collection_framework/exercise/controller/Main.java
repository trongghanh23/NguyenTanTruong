package _12_java_collection_framework.exercise.controller;

import _12_java_collection_framework.exercise.service.IProductService;
import _12_java_collection_framework.exercise.service.ProductService;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static IProductService productService = new ProductService();

    public static void display() {

        do {
            System.out.println("-------------Product Management------------\n" +
                    "1. Display list Product\n" +
                    "2. Add new Product\n" +
                    "3. Delete Product\n" +
                    "4. Update Product\n" +
                    "5. Search Product\n" +
                    "6. sort Product Price\n" +
                    "7. Exit\n");
            System.out.println("Choose options: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    productService.displayListProduct();
                    break;
                case 2:
                    productService.addNewProduct();
                    break;
                case 3:
                    productService.removeProductById();
                    break;
                case 4:
                    productService.updateProduct();
                    break;
                case 5:
                    productService.findProductByName();
                    break;
                case 6:
                    display1();
                    break;

                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("nhập không đúng id: ");
            }

        }
        while (true);
    }

    public static void display1() {

        System.out.println("1 hiển thị danh sách tăng theo giá sản phẩm");
        System.out.println("2 hiển thị danh sách giảm theo giá sản phẩm ");
        int input = Integer.parseInt(scanner.nextLine());
        if (input == 1) {
            productService.sortAscendingPrice();
        } else if (input == 2) {
            productService.sortDescendingPrice();
        } else {
            System.out.println("nhập lại id sắp xếp ");
        }

    }
}
