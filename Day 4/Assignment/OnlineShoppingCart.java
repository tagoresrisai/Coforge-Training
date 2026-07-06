import java.util.ArrayList;

public class OnlineShoppingCart {
    public static void main(String[] args) {
        Customer c1 = new Customer(1, "Karan");
        Product p1 = new Product(101, "Mouse", 500);
        Product p2 = new Product(102, "Keyboard", 800);

        c1.cart.addProduct(p1);
        c1.cart.addProduct(p2);
        c1.cart.removeProduct(p1);
        c1.cart.display();
        System.out.println("Total Bill: " + c1.cart.totalBill());
    }

    static class Product {
        int id;
        String name;
        double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    static class Cart {
        ArrayList<Product> products = new ArrayList<>();

        void addProduct(Product p) {
            products.add(p);
        }

        void removeProduct(Product p) {
            products.remove(p);
        }

        double totalBill() {
            double total = 0;
            for (Product p : products) {
                total = total + p.price;
            }
            return total;
        }

        void display() {
            for (Product p : products) {
                System.out.println(p.name + " - " + p.price);
            }
        }
    }

    static class Customer {
        int id;
        String name;
        Cart cart = new Cart();

        Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
