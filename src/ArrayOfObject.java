import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }}

        public class ArrayOfObject{

    public static List<Product> getAffordableProducts(Product[] products, double budget) {
        List<Product> affordable = new ArrayList<>();
        for (Product product : products) {
            if (product.price <= budget) {
                affordable.add(product);
            }
        }
        return affordable;
    }



    public static void main(String[] args) {
        Product[] products = {
                new Product("Laptop", 1200),
                new Product("Phone", 800),
                new Product("Tablet", 600)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Budget.");
        double budget = scanner.nextDouble();
        List<Product> affordable = getAffordableProducts(products, budget);
        if (affordable.isEmpty()) {
            System.out.println("Sorry You can buy Nothing");
        } else {
            System.out.println("Products you can buy with  " + budget);
            for (Product p : affordable) {
                System.out.println(p.name + " (GHS" + p.price + ")");
            }
        }
    }}
