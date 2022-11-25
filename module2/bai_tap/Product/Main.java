package bai_tap.Product;

import java.util.Scanner;

public class Main {
    public static Product[] productList=new Product[100];
    public static int count;
    static Scanner scanner =new Scanner(System.in);
     static {
        System.out.println("Block static");
        productList[0]=new Product(1,"iPhone",1000,10,"apple");
        productList[1]=new Product(2,"Samsung",2000,10,"dell");
        productList[2]=new Product(3,"oppo",3000,10,"china");
        productList[3]=new Product(4,"iPhone",4000,10,"apple");
        productList[4]=new Product(5,"iPhone",5000,10,"apple");
        count=5;

    }
    public static void addNewProduct(){
        System.out.println("nhập tên: ");
        String name =scanner.nextLine();
        System.out.println("nhập giá: ");
        double price=Double.parseDouble(scanner.nextLine());
        System.out.println("nhập số lượng:");
        int amount =Integer.parseInt(scanner.nextLine());
        System.out.println("nhập nhà sản xuất:");
        String production =scanner.nextLine();

        Product product= new Product(count+1,name,price,amount,production);
        productList[count]=product;
        count++;
    }
    public static void displayList(){
        for (Product item:productList) {
            if (item!= null){
                System.out.println(item);
            }

        }
    }
    public static void searchProduct() {
        int tempSearch = 0;
        System.out.println("Nhập vào tên hoặc nhà sản xuất muốn tìm: ");
        String inputSearch = scanner.nextLine();
        for (Product item: productList) {
            if (item != null) {
                if (item.getName().contains(inputSearch) || item.getProduction().contains(inputSearch)) {
                    System.out.println(item);
                    tempSearch++;
                }
            }
        }

        if (tempSearch == 0) {
            System.out.println("Không tìm thấy");
        }
    }

    public static void deleteProduct() {
        int tempDelete = 0;
        System.out.println("Nhập vào id muốn xoá: ");
        int inputSearch = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] != null) {
                if (productList[i].getId() == inputSearch) {
                    productList[i] = productList[i + 1];
                    for (int j = i + 1; j < productList.length && productList[j + 1] != null; j++) {
                        productList[j] = productList[j + 1];
                    }
                    System.out.println("Xoá thành công");
                    tempDelete++;
                }
            }
        }
        if (tempDelete == 0) {
            System.out.println("Xoá không thành công");
        }
    }

    public static void updateProduct() {
        int tempUpdate = 0;
        System.out.println("Nhập vào id muốn sửa: ");
        int inputUpdate = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] != null) {
                if (productList[i].getId() == inputUpdate) {
                    System.out.println("Nhập tên");
                    String name = scanner.nextLine();
                    System.out.println("Nhập Giá");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Nhập Số lượng");
                    int amount = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập nhà sản xuất");
                    String production = scanner.nextLine();
                    productList[i] = new Product(i + 1, name, price,amount,production);
                    System.out.println("Sửa thành công");
                    tempUpdate++;
                }
            }
        }
        if (tempUpdate == 0) {
            System.out.println("không tìm thấy");
        }
    }
    public static void main(String[] args) {
        do {
            System.out.println("-------------------Product Management---------------\n"+
                    "1. Display list Product\n" +
                    "2. Add new Product\n" +
                    "3. Search Product\n" +
                    "4. Delete Product\n" +
                    "5. Update Product\n" +
                    "6. Exit\n");
            System.out.print("choose options");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Display list");
                    displayList();
                    break;
                case 2:
                    System.out.println("Add new");
                    addNewProduct();
                    break;
                case 3:
                    System.out.println("Search product");
                    searchProduct();
                    break;
                case 4:
                    System.out.println("Delete product");
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Update product");
                    updateProduct();
                    break;

                case 6:
                    return;
            }

        }
        while (true);
    }

}
