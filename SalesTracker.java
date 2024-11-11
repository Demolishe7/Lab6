import java.util.*;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

public class SalesTracker {
    private LinkedList<Product> salesList;

    public SalesTracker() {
        salesList = new LinkedList<>();
    }

    public void addSale(Product product) {
        salesList.add(product);
    }

    public void printSales() {
        for (Product product : salesList) {
            System.out.println(product);
        }
    }

    public double getTotalSales() {
        double total = 0;
        for (Product product : salesList) {
            total += product.price;
        }
        return total;
    }

    public Product getMostPopularProduct() {
        Map<String, Integer> productCount = new HashMap<>();
        for (Product product : salesList) {
            productCount.put(product.name, productCount.getOrDefault(product.name, 0) + 1);
        }

        String mostPopularProductName = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopularProductName = entry.getKey();
            }
        }

        for (Product product : salesList) {
            if (product.name.equals(mostPopularProductName)) {
                return product;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();
        tracker.addSale(new Product("Apple", 1.0));
        tracker.addSale(new Product("Banana", 0.5));
        tracker.addSale(new Product("Apple", 1.0));
        tracker.addSale(new Product("Orange", 0.75));

        System.out.println("Sales List:");
        tracker.printSales();

        System.out.println("Total Sales: $" + tracker.getTotalSales());

        Product mostPopular = tracker.getMostPopularProduct();
        System.out.println("Most Popular Product: " + mostPopular);
    }
}