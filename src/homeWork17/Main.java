package homeWork17;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0)
        );

        Map<String, Double> averagePrice = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println("Average price of products in each category: " + averagePrice);

        Map.Entry<String, Double> maxEntry = Collections.max(averagePrice.entrySet(), Map.Entry.comparingByValue());

        System.out.println("Category with the highest average price: " + maxEntry.getKey() +
                " {" + maxEntry.getValue() + "}");
    }
}
