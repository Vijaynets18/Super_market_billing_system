import java.util.ArrayList;
import java.util.Scanner;

public class super_market {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Product> cart = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
    }

    
    private static void showMenu() {
        int choice;
        do {
            System.out.println("\nSupermarket Billing System");
            System.out.println("1. Add Item to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItemToCart();
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    generateBill();
                    break;
                    
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    private static void addItemToCart() {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price per unit: ");
        double price = scanner.nextDouble();

        Product product = new Product(name, quantity, price);
        cart.add(product);
        System.out.println("Item added to cart!");
    }

    private static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("\nCart Items:");
        System.out.println("Name\tQuantity\tPrice");
        for (Product product : cart) {
            System.out.println(product.getName() + "\t" + product.getQuantity() + "\t" + product.getPrice());
        }
    }

    private static void generateBill() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        double subTotal = 0;
        System.out.println("\nBill Details:");
        System.out.println("Name\tQuantity\tPrice\tTotal");
        for (Product product : cart) {
            double total = product.getQuantity() * product.getPrice();
            subTotal += total;
            System.out.println(product.getName() + "\t" + product.getQuantity() + "\t" + product.getPrice() + "\t" + total);
        }

        // Add tax and discount logic here (if needed)
        System.out.println("SubTotal: $" + subTotal);
        System.out.println("*Thank you for shopping!*");
    }
}

class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
