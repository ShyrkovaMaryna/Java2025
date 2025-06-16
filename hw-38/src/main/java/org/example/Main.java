package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Scanner scanner = new Scanner(System.in);

        Cart cart = context.getBean(Cart.class);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Show all products");
            System.out.println("2. Add the product to your cart");
            System.out.println("3. Remove item from cart");
            System.out.println("4. Show what's in your cart");
            System.out.println("5. New shopping cart");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    productRepository.findAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Product ID: ");
                    cart.addProductById(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Product ID: ");
                    cart.removeProductById(scanner.nextInt());
                    break;
                case 4:
                    cart.showCart();
                    break;
                case 5:
                    cart = context.getBean(Cart.class);
                    System.out.println("New cart created.");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Incorrect option.");
            }
        }
    }
}
