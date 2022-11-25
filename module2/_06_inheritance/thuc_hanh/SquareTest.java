package _06_inheritance.thuc_hanh;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        System.out.println(square);
    }

    public static class Product {
        private int id;
        private String name;
        private double price;
        private int amount;
        private String production;

        public Product() {
        }

        public Product(int id, String name, double price, int amount, String production) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.amount = amount;
            this.production = production;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getProduction() {
            return production;
        }

        public void setProduction(String production) {
            this.production = production;
        }
    }
}
