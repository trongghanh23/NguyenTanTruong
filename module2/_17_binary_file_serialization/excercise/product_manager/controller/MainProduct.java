package _17_binary_file_serialization.excercise.product_manager.controller;

import _17_binary_file_serialization.excercise.product_manager.service.IProduct;
import _17_binary_file_serialization.excercise.product_manager.service.ProductIplm;

import java.util.Scanner;

public class MainProduct {
    private  static Scanner scanner=new Scanner(System.in);
   static IProduct iProduct=new ProductIplm();
    public static void display(){
        do {
            System.out.println("************Menu Product*************\n" +
                    "1. display\n" +
                    "2. add\n" +
                    "3. search\n" +
                    "4. exit\n");
            System.out.println("choose function: ");
            int choose=Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    iProduct.displayProduct();
                    break;
                case 2:
                    iProduct.addProduct();
                    break;
                case 3:
                    iProduct.searchProduct();
                    break;
                case 4:

                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời chon lại chức năng: ");
            }
        }while (true);
    }
}
